package com.telran.demoqa.tests;

import com.telran.demoqa.data.BookData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest(){
        new BookStorePage(driver).typeInSearchFieldInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }

    @Test
    public void verifyEmptyFieldTest(){
       new BookStorePage(driver).typeInSearchFieldInput("  ");
       Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }
}
