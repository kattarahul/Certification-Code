package com.lambda.test;

import com.lambda.base.BaseClass;
import com.lambda.pages.DragDropRangeSliderPage;
import com.lambda.pages.HomePage;
import com.lambda.pages.InputFormSubmit;
import com.lambda.pages.SimpleFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestClass extends BaseClass {


    HomePage homePage;
    SimpleFormPage simpleFormPage;
    DragDropRangeSliderPage dragDropRangeSliderPage;

    InputFormSubmit inputFormSubmit;


    @BeforeClass
    public void initialization()
    {
        homePage = new HomePage(driver);
        simpleFormPage = new SimpleFormPage(driver);
        dragDropRangeSliderPage = new DragDropRangeSliderPage(driver);
        inputFormSubmit = new InputFormSubmit( driver);
    }

    @Test(priority = 1)
    public void moduleInputForms()
    {
     // TestScenarios 1  Starts here ............................................................................
        homePage.simpleFormDemo();

        //Validating URL
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("simple-form-demo"));

        simpleFormPage.enterMessage();

        // variable for a string value
        String messageValidate = simpleFormPage.yourMessageElement.getText();

        //Validating Text Message...
        Assert.assertTrue(messageValidate.contains("Welcome to LambdaTest"));

//        End of TestScenario 1.........................................................................................

    }
    @Test(priority = 2)
    public void RangeSlider()
    {
        // TestScenarios 2  Starts here ............................................................................

        dragDropRangeSliderPage.dragAndDrop();
        dragDropRangeSliderPage.greenSliderValue();

        //        End of TestScenario 2.........................................................................................

    }




    @Test(priority = 3)
    public void inputFormValidation() throws FileNotFoundException, InterruptedException {
        // TestScenarios 2  Starts here ............................................................................

        // calling the method before filling form..
        inputFormSubmit.formSubmittingWithOutFilling();
//        Assert “Please fill in the fields” error message.
        ArrayList<String> expectedMessages = new ArrayList<>();
        expectedMessages.add("This is a required field");
        expectedMessages.add("Please fill out this field.");
        String  message =inputFormSubmit.actualErrorMessage;
        Assert.assertTrue(expectedMessages.contains(message));


//        Fill in Name, Email, and other fields....
        inputFormSubmit.formFilling();

//        validating the success message “Thanks for contacting us, we will get back to you shortly.” on the screen.
        String actualMessage= inputFormSubmit.thanksMessageElement.getText();
        String expectedMessageForThanksPage = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertTrue(expectedMessageForThanksPage.contains(actualMessage));

        //       End of TestScenario 2.........................................................................................

    }



}
