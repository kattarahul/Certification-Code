package com.manual.Commonmethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ManualMethods {

    WebDriver driver;
    public ManualMethods(WebDriver driver)
    {
        this.driver= driver;

    }


    public boolean moveElementUsingAction(WebElement element)
    {
        Actions act = new Actions(driver);
        boolean flag = false;

        try{
            act.moveToElement(element).build().perform();
//                act.click().build().perform();

            flag =true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
            flag= false;

        }
        catch (ElementNotInteractableException eni)
        {
            flag=false;
        }
        return flag;
    }





    public  boolean enterTheInputTextField(WebElement element,String key)
    {
        boolean flag = false;

        try{

            element.sendKeys(key);
            flag =true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
            flag= false;

        }
        return flag;
    }




    public  boolean toClickTheElement(WebElement element)
    {
        boolean flag = false;

        try{

            element.click();
            flag =true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
            flag= false;

        }
        return flag;

    }



    public boolean WaitandClickElement(WebElement element) {
        boolean flag = false;
        try {
//            seleniumWaits.waitForElementToClick(element).click();
            flag= true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
            flag= false;

        }
        return flag;

    }





}
