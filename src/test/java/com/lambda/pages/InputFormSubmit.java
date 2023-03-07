package com.lambda.pages;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lambda.base.BaseClass;
import com.manual.Commonmethods.ManualMethods;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class InputFormSubmit {


    WebDriver driver;
    BaseClass baseClass;
    ManualMethods manualMethods;

    public String actualErrorMessage;
    Actions actions;

    public InputFormSubmit(WebDriver inputformdriver)
    {
        this.driver = inputformdriver;
        PageFactory.initElements(inputformdriver,this);
        manualMethods =new ManualMethods(inputformdriver);
    }

    @FindBy(linkText = "Input Form Submit")
    WebElement inputFormElement;

    @FindBy(xpath = "//form[@id='seleniumform']/div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/button[@type='submit']")
    WebElement submitButtonElement;

    @FindBy(xpath= "//input[@placeholder='Name']")
    WebElement nameTextBoxElement;

    @FindBy(css = "input[placeholder='Email']")
    WebElement emailTextBoxElement;

    @FindBy(css="input[placeholder='Password']")
    WebElement passwordTextBoxElement;

    @FindBy(css = "input[placeholder='Company']")
    WebElement companyTextBoxElement;

    @FindBy(css = "input[placeholder='Website']")
    WebElement websiteTextBoxElement;

    @FindBy(css = "input[placeholder='City']")
    WebElement cityTextBoxElement;

    @FindBy(css = "input[placeholder='Address 1']")
    WebElement addressOneTextBoxElement;

    @FindBy(xpath = "//input[@placeholder='Address 2']")
    WebElement addressTwoTextBoxElement;

    @FindBy(css = "input[placeholder='State']")
    WebElement stateTextBoxElement;

    @FindBy(xpath = "//label[@for='inputZip']/following-sibling::input[@type='text']")
    WebElement zipCodeTextBoxElement;

    @FindBy(css = "select[name='country']")
    WebElement countryDragAndDropElement;

    @FindBy(xpath = "//p[contains(text(),'Thanks for contacting us, we will get back to you shortly.')]")
   public WebElement thanksMessageElement;

    @FindBy(xpath = "//div[@id='exit_popup_dismissed']/div/h2/span")
    WebElement popUpElement;

    public String  formSubmittingWithOutFilling()
    {
        baseClass = new BaseClass();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        manualMethods.toClickTheElement(inputFormElement);

//    Submitting without filling in any information in the form.
        manualMethods.toClickTheElement(submitButtonElement);

//        Assert “Please fill in the fields” error message.

//        List<String> list = new ArrayList<>();
//        list.add("This is a required field");
//        list.add("Please fill in the fields");
        actualErrorMessage = nameTextBoxElement.getAttribute("validationMessage");
        return actualErrorMessage;


    }


    public void formFilling() throws FileNotFoundException, InterruptedException {

//       Reading the Data from the Json File  to fill the Form....
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader("src/main/java/com/testdata/UserDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject jsonObject = (JsonObject) obj;

        String name = jsonObject.get("Name").getAsString().toString();
        String email = jsonObject.get("Email").getAsString().toString();
        String password = jsonObject.get("Password").getAsString().toString();
        String company = jsonObject.get("Company").getAsString().toString();
        String website= jsonObject.get("Website").getAsString().toString();
        String city= jsonObject.get("City").getAsString().toString();
        String addressOne= jsonObject.get("AddressOne").getAsString().toString();
        String addressTwo= jsonObject.get("AddressTwo").getAsString().toString();
        String state= jsonObject.get("State").getAsString().toString();
        String zipCode= jsonObject.get("ZipCode").getAsString().toString();



        manualMethods.enterTheInputTextField(nameTextBoxElement,name);
        manualMethods.enterTheInputTextField(emailTextBoxElement,email);
        manualMethods.enterTheInputTextField(passwordTextBoxElement,password);
        manualMethods.enterTheInputTextField(companyTextBoxElement,company);
        manualMethods.enterTheInputTextField(websiteTextBoxElement,website);
        manualMethods.enterTheInputTextField(cityTextBoxElement,city);
        manualMethods.enterTheInputTextField(addressOneTextBoxElement,addressOne);
        manualMethods.enterTheInputTextField(addressTwoTextBoxElement,addressTwo);
        manualMethods.enterTheInputTextField(stateTextBoxElement,state);
        manualMethods.enterTheInputTextField(zipCodeTextBoxElement,zipCode);

        Select select = new Select(countryDragAndDropElement);
        select.selectByVisibleText("United States");

        try {
             actions = new Actions(driver);
            actions.moveToElement(popUpElement).click().build().perform();

            }
        catch (ElementNotInteractableException ene){
            submitButtonElement.click();

        }
        finally {

            submitButtonElement.click();
        }

    }



}
