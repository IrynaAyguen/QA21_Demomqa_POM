package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage clickOnOldStyle(String text) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + " is first ");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }


    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement space;


    public SelectMenuPage clickMultiSelectDropDown(String text) {
        clickWithJSExecutor(multiSelectDropDown, 0, 400);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", text)));
        click(element);
        click(space);
        return this;
    }


    @FindBy(css = ".css-xb97g8")
    WebElement deselect;

    public SelectMenuPage deselect() {
        click(deselect);
        return this;
    }


    @FindBy(id = "react-select-4-input")
    WebElement dropDown;

    public SelectMenuPage clickMultiSelectDropDown1(String text, String text1, String text2) {
        dropDown.sendKeys(text);
        dropDown.sendKeys(Keys.ENTER);
        dropDown.sendKeys(text1);
        dropDown.sendKeys(Keys.ENTER);
        dropDown.sendKeys(text2);
        dropDown.sendKeys(Keys.ENTER);
        click(space);

        return this;
    }


    @FindBy(id = "cars")
    WebElement cars;
    public SelectMenuPage clickStandardMultiSelect() {
        Select multi = new Select(cars);
        if(multi.isMultiple()) {
            multi.selectByIndex(0);
            multi.selectByIndex(1);
            multi.selectByIndex(2);
        }
        List<WebElement> selectOpt = multi.getAllSelectedOptions();
        for (WebElement el : selectOpt) {
            System.out.println(el.getText() + "<---multi");
        }
      return this;
    }
}
