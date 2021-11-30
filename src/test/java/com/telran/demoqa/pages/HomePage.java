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

    @FindBy(xpath = "//div[@class='category-cards'] /div[6]")
    WebElement bookStoreAppItem;

    public BookStorePage clickBookStoreItem(){

        Actions actions = new Actions(driver);  // jump down
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        bookStoreAppItem.click();
        return new BookStorePage(driver);
    }
}
