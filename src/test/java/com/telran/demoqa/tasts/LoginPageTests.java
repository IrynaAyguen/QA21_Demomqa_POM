package com.telran.demoqa.tasts;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){

        new HomePage(driver).clickBookStoreItem();
        new BookStorePage(driver).clickLoginBtn();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login("IrynaAyguen","Iryna1510!")
                .verifyUserName("IrynaAyguen").logout();
    }
}
