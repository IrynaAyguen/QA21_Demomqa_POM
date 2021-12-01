package com.telran.demoqa.tests;

import com.telran.demoqa.data.BookData;
import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).getLoginPage();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);

    }

    @Test
    public void addBookToCollectionPositiveTest(){

        new BookStorePage(driver).typeInSearchFieldInput(BookData.BOOK_NAME)
                .clickByFirstBook().addToYourCollection();

        new SidePanelPage(driver).selectProfile();

        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook()
                .contains(BookData.BOOK_NAME));

    }
}
