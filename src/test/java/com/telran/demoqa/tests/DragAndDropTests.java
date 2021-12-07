package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DragAndDropPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getInteractions();
        new SidePanelPage(driver).selectDroppable();
    }

    @Test
    public void droppableTest(){
        new DragAndDropPage(driver).actionDragMe();

    }

    @Test
    public void droppableByTest(){

        new DragAndDropPage(driver).dragAndDropBy();
    }


    @Test
    public void dropByTest(){
        new DragAndDropPage(driver).dragAndDropBy100();
    }


    @Test
    public void dropAcceptTest(){
        new DragAndDropPage(driver).clickOnAcceptTab();
        new DragAndDropPage(driver).dragAndDropOfNotAcceptable();
        new DragAndDropPage(driver).dragAndDropOfAcceptable();

    }
}
