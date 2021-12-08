package com.telran.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksImagesPage extends PageBase {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public BrokenLinksImagesPage checkAllUrl() {
        String url = "";
        System.out.println("Total links on the web page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }

        return this;
    }

    public BrokenLinksImagesPage selectBrokenLinks() {

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);

        }
        return this;
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
                System.out.println(linkUrl + " - " + httpURL.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " ************ broken link");
        }
    }


    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksImagesPage checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");

        for (int index = 0; index < images.size(); index++) {
            WebElement img = images.get(index);
            String imageURL = img.getAttribute("src");
            System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);
            verifyLinks(imageURL);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", img);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("***********************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("***********************");
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }


        return this;
    }
}
