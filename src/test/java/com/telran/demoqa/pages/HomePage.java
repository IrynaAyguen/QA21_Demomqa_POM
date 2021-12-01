package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(xpath = "//div[@class='category-cards'] /div[6]")
    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreApplicationBtn;


    public BookStorePage getBookStore()  {

        //clickWithAction(bookStoreApplicationBtn);
        clickWithJSExecutor(bookStoreApplicationBtn,0,500);
        return new BookStorePage(driver);
    }


}
