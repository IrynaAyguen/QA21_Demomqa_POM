package com.telran.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormsPage extends PageBase {

    JavascriptExecutor js;

    public FormsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }


    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "userNumber")
    WebElement phone;

    public FormsPage fillPersonalData(String fName, String lName, String eM, String ph) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, eM);
        type(phone, ph);
        return this;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;

    public FormsPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(maleBtn);
        } else if (gender.equals("Female")) {
            click(femaleBtn);
        } else {
            click(otherBtn);
        }
        return this;
    }


    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthBtn;

    public FormsPage typeOfDate(String bDay) {
        click(dateOfBirthBtn);
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);
        if (os.startsWith("Mac")) {
            dateOfBirthBtn.sendKeys(Keys.chord(Keys.COMMAND, "a"));  // for Mac
        } else {
            dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"));  // for Windows  Ctrl+A  = select all
        }
        dateOfBirthBtn.sendKeys(bDay);

        //type(dateOfBirthBtn,bDay);  when without OS  (54-61)
        dateOfBirthBtn.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(css=".react-datepicker__month-select")
    WebElement month;
    @FindBy (css=".react-datepicker__year-select")
    WebElement year;
    public FormsPage chooseDate(String m, String ye,String day){
        clickWithJSExecutor(dateOfBirthBtn,0,300);
        Select select = new Select(month);
        select.selectByVisibleText(m);
        Select select1 = new Select(year);
        select1.selectByVisibleText(ye);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" +day +"']")).click();

        return this;


    }


    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;
    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    public FormsPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                selectInput.click();
            }
        }
        return this;
    }


    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sport;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public FormsPage chooseHobbies(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sport);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement chooseFile;

    public FormsPage uploadFile(String path) {
        chooseFile.sendKeys(path);
        pause(1000);
        return this;
    }


    public FormsPage addSubjectForDataProvider(String subjects) {
        type(subjectsInput, subjects);
        selectInput.click();
        return this;
    }


    public FormsPage chooseHobbiesForDataProvider(String hobbies) {
        if (hobbies.equals("Sports")) {
            click(sport);
        }
        if (hobbies.equals("Reading")) {
            click(reading);
        }
        if (hobbies.equals("Music")) {
            click(music);
        }
        return this;
    }



    @FindBy(id = "currentAddress")
    WebElement add;

    public FormsPage typeAddress(String address) {
        typeWithJSExecutor(add, 0,400, address);

        return this;
    }

    @FindBy(id="state")
    WebElement state;
    @FindBy(id="react-select-3-input")
    WebElement selectState;
    public FormsPage inputState(String st) {
        clickWithJSExecutor(state, 0,400);
        selectState.sendKeys(st);
        selectState.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id="city")
    WebElement city;
    @FindBy(id="react-select-4-input")
    WebElement selectCity;
    public FormsPage inputCity(String c) {
        click(city);
        selectCity.sendKeys(c);
        selectCity.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(id="submit")
    WebElement submit;
    public FormsPage clickOnSubmitButton() {
        click(submit);
        return  this;
    }



    @FindBy(id="example-modal-sizes-title-lg")
    WebElement modalTitle;


    public String getTitleFormDialog() {
        return modalTitle.getText();
    }



    @FindBy(id="closeLargeModal")
    WebElement closeBtn;

    public FormsPage closeSuccessDialog() {
        closeBanner();
        clickWithJSExecutor(closeBtn, 0,400);
        return this;
    }




    public FormsPage checkBoxJS() {
        // to handle checkbox
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");

        return this;
    }

    public FormsPage alertWithJS() {
        // to generate Alert Pop window
        js.executeScript("alert('hello world');");
        //js.executeScript("alert confirm();");  ne rabotaet confirm
        return this;
    }

    public FormsPage refreshBrowserJS() {
        // refresh browser window using JSE
        js.executeScript("history.go(0)");
        return this;
    }

    public FormsPage getTitlePageWithJS() {
        // to get the Title of our page
        pause(2000);
        String text = js.executeScript("return document.title;").toString();
        System.out.println("******************" +"\n" + text);
        return this;
    }

    public FormsPage getUrlWithJS() {
        String text = js.executeScript("return document.URL;").toString();
        System.out.println("URL -> " + text);
        return this;
    }
}
