package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName-value")
    WebElement user;

    @FindBy(id = "submit")
    WebElement logoutBtn;

    public ProfilePage verifyUserName(String uName){
        if (user.getText().equalsIgnoreCase(uName)){
            System.out.println("Correct user name: " + user.getText());
        }else {
            System.out.println("Incorrect user  name: " + user.getText());
        }
        return this;
    }

    public LoginPage logout(){
        System.out.println("Let´s out from profile!");
        logoutBtn.click();
        return new LoginPage(driver);
    }
}
