package com.lambda.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BaseClass {

    public WebDriver driver;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    FirefoxOptions firefoxOptions;
    InternetExplorerOptions internetExplorerOptions;

    private String username="rahulkatta72";
    private String accesskey ="MnK5oIQ2n8iFNb5B45IUV9YF46vmHjkjel2O9lyb0jZHyAe3cB";
    private String hub ="@hub.lambdatest.com/wd/hub";

    @Parameters({"browser","version","Platform"})
    @BeforeTest
    public void initializeDriver(String browser,String version, String Platform) throws MalformedURLException {
        HashMap<String, Object> ltoptions = new HashMap<String, Object>();
        ltoptions.put("username", username);
        ltoptions.put("accessKey", accesskey);
        ltoptions.put("build","LambdaTestApp1");
        ltoptions.put("project","Selenium_Java_101");
        ltoptions.put("w3c",true);
        switch(browser.toLowerCase()) {
            case "chrome":
                chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(Platform);
                chromeOptions.setBrowserVersion(version);
                chromeOptions.setCapability("LT:Options",ltoptions);
                driver = new RemoteWebDriver(new URL("https://" +username+":"+accesskey+hub),chromeOptions);
                // driver.manage().window().setSize(new Dimension(0,500));
                break;
            case "edge":
                edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(Platform);
                edgeOptions.setBrowserVersion(version);
                edgeOptions.setCapability("LT:Options",ltoptions);
                driver = new RemoteWebDriver(new URL("https://"+username+":"+accesskey+hub),edgeOptions);
                break;


            case "firefox":
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(Platform);
                firefoxOptions.setBrowserVersion(version);
                firefoxOptions.setCapability("LT:Options",ltoptions);
                driver = new RemoteWebDriver(new URL("https://"+username+":"+accesskey+hub),firefoxOptions);
                break;

            case "internet explorer":
                internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setPlatformName(Platform);
                internetExplorerOptions.setBrowserVersion(version);
                internetExplorerOptions.setCapability("LT:Options",ltoptions);
                driver = new RemoteWebDriver(new URL("https://"+username+":"+accesskey+hub),internetExplorerOptions);
                break;

            default	:
                System.out.println("Browser name is invalid");
                break;
        }
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void launchApp(){
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterTest
    public void closeApp()
    {
        driver.quit();

    }




}
