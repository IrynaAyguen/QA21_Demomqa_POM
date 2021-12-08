package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends PageBase {

    JavascriptExecutor js;

    public ElementsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    public ElementsPage typeUserDataWithJS(String name, String email) {

        if (name != null && email != null) {
            js.executeScript("document.getElementById('userName').value='" + name + "';");
            js.executeScript("document.getElementById('userName').style.border='1px solid red';");

            js.executeScript("document.getElementById('userEmail').value='" + email + "';");

            WebElement element = driver.findElement(By.id("userName"));

            System.out.println(element.getText() + " By text");
            System.out.println(element.getAttribute("value") + " By value");
        }
        return this;
    }



    public ElementsPage clickOnSubmitWithJS() {
        js.executeScript("document.querySelector('#submit').style.backgroundColor='Red';");   //  cherez  cssSelector
        js.executeScript("document.querySelector('footer').style.display='none';");
        pause(2000);
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }
}
