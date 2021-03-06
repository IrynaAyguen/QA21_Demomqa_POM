package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.helpers.DataProviders;
import com.telran.demoqa.pages.FormsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {

        new HomePage(driver).getForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void  fillStudentRegistrationTest(){
        new FormsPage(driver).fillPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.E_MAIL,StudentData.PHONE)
                .selectGender(StudentData.GENDER)
              //  .typeOfDate(StudentData.B_DAY)
                .chooseDate("December", "2021", "5")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(StudentData.FILE)
                .typeAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .clickOnSubmitButton();
         Assert.assertTrue(new FormsPage(driver).getTitleFormDialog().contains("Thanks for submitting the form"));
         new FormsPage(driver).closeSuccessDialog();


    }
//domashka:  dataProvider  without file.CSV
    @Test(dataProvider  = "StudentRegistrationForm", dataProviderClass = DataProviders.class)
    public void fillStudentRegistrationFromDataProviderTest(String fName, String lName, String eMail,
                String ph, String gender, String bDay, String subjects, String hobbies, String file
 //           String address, String state, String city
    ) {
        new FormsPage(driver).fillPersonalData(fName, lName, eMail, ph)
                .selectGender(gender)
                .typeOfDate(bDay)
                .addSubjectForDataProvider(subjects)
                .chooseHobbiesForDataProvider(hobbies)
                .uploadFile(file)
//                .typeAddress(address)
//                .inputState(state)
//                .inputCity(city)
//                .clickOnSubmitButton()
        ;
//        Assert.assertTrue(new FormsPage(driver).getTitleFormDialog().contains("Thanks for submitting the form"));
//        new FormsPage(driver).closeSuccessDialog();
    }

    //from Irina:  dataProvider  with file.CSV
    @Test(dataProviderClass = DataProviders.class, dataProvider = "UsingFile")
    public void fillStudentRegFormWithDataProviderTest(String firstName, String lastName, String email,
                String phone, String birthDate, String file) {
        new FormsPage(driver).fillPersonalData(firstName, lastName, email, phone)
                .selectGender(StudentData.GENDER).typeOfDate(birthDate)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(file);
    }

}
