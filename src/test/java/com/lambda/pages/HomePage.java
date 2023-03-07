package com.lambda.pages;

import com.lambda.base.BaseClass;
import com.manual.Commonmethods.ManualMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
   ManualMethods manualMethods;
   BaseClass baseClass;

   public HomePage(WebDriver homepageDriver)
   {
       this.driver = homepageDriver;
       PageFactory.initElements(homepageDriver,this);
       manualMethods = new ManualMethods( driver);
   }
    @FindBy(linkText = "Simple Form Demo")
    WebElement simpleFormElement;

   @FindBy(css = "#exit_popup_close")
   WebElement popUpElement;



    public void simpleFormDemo()
    {

        simpleFormElement.click();
//        manualMethods.moveElementUsingAction(popUpElement);

    }




}
