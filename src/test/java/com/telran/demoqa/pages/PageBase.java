package com.telran.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element,String text){
        if (text!=null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void closeBanner(){
        driver.findElement(By.id("close-fixedban")).click();
    }

    public void clickWithAction(WebElement element) {
        Actions actions = new Actions(driver);  // jump down
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        element.click();
    }

    public void clickWithJSExecutor(WebElement element, int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }


    public void pause(int millis){
        try {
            Thread.sleep(millis);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}
