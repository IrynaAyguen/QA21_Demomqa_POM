package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrokenLinksImagesPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getElementsPage();
    }


    @Test
    public void getAllLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksImagesPage(driver).checkAllUrl();
    }


    @Test
    public void getBrokenLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksImagesPage(driver).selectBrokenLinks();
    }


    @Test
    public void getBrokenImagesTest(){
        new SidePanelPage(driver).selectBrokenLinks();
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}
