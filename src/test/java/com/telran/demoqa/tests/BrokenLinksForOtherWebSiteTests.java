package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksForOtherWebSiteTests {
    public static EventFiringWebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.hessen-tourismus.de/de/wellness/wellnesshotels/");
        driver.register(new MyListener());
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }



    @Test
    public void getBrokenLinksForOtherWebSiteTest()  {
        selectBrokenLinksForOtherWebSite();
    }

    public void selectBrokenLinksForOtherWebSite() {

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the web page: " + allLinks.size()); // quantity of links on the website page

        String urlText = "";
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {            // print of text of all links
            urlText = iterator.next().getText();
            System.out.println(urlText);
        }

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");  //http of  link(i)
            verifyLinks(url);
        }
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
            httpURL.setConnectTimeout(5000);
            httpURL.connect();
            if (httpURL.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURL.getResponseMessage() + " is  a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURL.getResponseMessage());   //code<400
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " ************ broken link");
        }
    }




    @AfterMethod(enabled = false)
    public void  tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()){
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        }else{
            logger.error("FAILED: test method " + result.getMethod().getMethodName());

            new PageBase(driver).takeScreenshot();
        }
        logger.info("==========================");
    }
}
