package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends PageBase {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabBtn;

    public WindowPage clickOnNewTabButton() {
        click(tabBtn);
        //  go to new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleText;

    public String getTextFromNewTab() {
        return sampleText.getText();
    }

    @FindBy(id = "windowButton")
    WebElement windowBtn;

    public WindowPage clickOnNewWindowButton() {
        click(windowBtn);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowBtn;

    public void clickOnNewWindowMessageButton() {
        click(messageWindowBtn);
        List<String> messageWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(messageWindows.get(1));
    }


    @FindBy(xpath = "//body")
    WebElement windowMessage;

    public String getTextFromNewWindowMessage() {
        return windowMessage.getText();
    }
}
