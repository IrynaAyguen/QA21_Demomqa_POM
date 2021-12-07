package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="draggable")
    WebElement dragMe;
    @FindBy(id="droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragMe,dropHere).build().perform();

        String text = dropHere.getText();

        if (text.equals("Dropped!")) {
            System.out.println("Pass: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        Actions actions = new Actions(driver);
        pause(2000);
        int x = dragMe.getLocation().getX(); //location
        int y = dragMe.getLocation().getY();
        System.out.println("x -->" + x + "y-->" + y);

        int xOffSet = dropHere.getLocation().getX();  //smeshenie
        int yOffSet = dropHere.getLocation().getY();
        System.out.println("xOffSet -->" + xOffSet + "yOffSet-->" + yOffSet);

        xOffSet = (xOffSet - x) + 50;
        yOffSet = (yOffSet - y) +100;
        pause(1000);
        actions.dragAndDropBy(dragMe,xOffSet,yOffSet).build().perform();

        String text = dropHere.getText();

        if (text.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

    return this;
    }

    public DragAndDropPage dragAndDropBy100() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragMe,100,100).build().perform();
        return this;
    }


    @FindBy(id="droppableExample-tab-accept")
    WebElement acceptTab;

    public DragAndDropPage clickOnAcceptTab() {
        click(acceptTab);

        return this;
    }


    @FindBy(id="notAcceptable")
    WebElement dragNotAcceptable;

    @FindBy(xpath="//div[@id='acceptDropContainer'] / div[2]")
    WebElement dropHereAcc;

    public DragAndDropPage dragAndDropOfNotAcceptable() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragNotAcceptable,350,10).build().perform();

        String text = dropHereAcc.getText();
        System.out.println(text);  // for check

        if(text.equals("Drop here")){
            System.out.println("*****NotAcceptable source is dropped and Acceptable source is not dropped to target");
        }else {
            System.out.println("*****Acceptable source is already dropped to target");
        }
        return this;
    }


    @FindBy(id="acceptable")
    WebElement dragAcceptable;

    public DragAndDropPage dragAndDropOfAcceptable() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragAcceptable,350,20).build().perform();

        String text = dropHereAcc.getText();
        System.out.println(text);  // for check
        if(text.equals("Dropped!")){
            System.out.println("*****Acceptable source is dropped to target");
        }else {
            System.out.println("*****Acceptable source couldn't be dropped to target");
        }
        return this;
    }

}
