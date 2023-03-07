package com.lambda.pages;

import com.lambda.base.BaseClass;
import com.manual.Commonmethods.ManualMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropRangeSliderPage {

    WebDriver driver;
    ManualMethods manualMethods;
    BaseClass baseClass;

    public DragDropRangeSliderPage(WebDriver fliedemodriver)
    {
        this.driver = fliedemodriver;
        PageFactory.initElements(fliedemodriver,this);
        manualMethods = new ManualMethods(fliedemodriver);
        baseClass = new BaseClass();

    }


    @FindBy(linkText = "Drag & Drop Sliders")
    WebElement dragAndDropElement;

    @FindBy(xpath = "//div[@id='slider3']/div/input[@type='range']")
    WebElement sliderElement;


    public  void dragAndDrop()
    {
        baseClass = new BaseClass();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        manualMethods.toClickTheElement(dragAndDropElement);
    }

    public void greenSliderValue()
    {

        for (int slide=15; slide<95;slide++)
        {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
    }





}
