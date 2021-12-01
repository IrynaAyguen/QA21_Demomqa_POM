package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage getLoginPage() {
        click(loginBtn);
        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchFieldInput(String text) {
        type(searchInput, text);
        return this;
    }

    public String takeNameOfBook() {
        //pause(500);
        return driver.findElement(By.xpath("//span[@class='mr-2']/a")).getText();
    }

    public String verifyEmptyField() {
        return driver.findElement(By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")).getText();
    }

    
    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public BookStorePage clickByFirstBook() {
        click(nameOfBook);
        return this;
    }
        @FindBy(css = ".text-right.fullButton")
        WebElement addToCollectionButton;


    public BookStorePage addToYourCollection() {
        clickWithJSExecutor(addToCollectionButton,0,600);
        pause(2000);
        driver.switchTo().alert().accept(); //ok

        return this;
    }
}
