package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
