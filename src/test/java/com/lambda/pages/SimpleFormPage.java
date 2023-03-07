package com.lambda.pages;

import com.manual.Commonmethods.ManualMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {

    WebDriver driver;
    ManualMethods manualMethods;

    public SimpleFormPage(WebDriver simplepagedriver)
    {
        this.driver = simplepagedriver;
        PageFactory.initElements(simplepagedriver,this);
        manualMethods= new ManualMethods(simplepagedriver);
    }


    @FindBy(xpath = "//div[text()='Single Input Field']/../div/div/div/ul/following-sibling::p/following-sibling::input[@placeholder='Please enter your Message']")
    WebElement textBoxElement;
    @FindBy(css = "#showInput")
    WebElement getCheckedElement;

    @FindBy(css = "p[id='message']")
   public WebElement yourMessageElement;

    public void enterMessage()
    {

        String message = "Welcome to LambdaTest";
        textBoxElement.sendKeys(message);
        manualMethods.toClickTheElement(getCheckedElement);
    }


}
