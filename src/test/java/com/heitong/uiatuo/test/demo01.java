package com.heitong.uiatuo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

public class demo01 {
    static  WebDriver driver;
    @Test(dataProvider = "driver")
    public  static  void Test(String drivers) throws  Exception{
        if (drivers.equals("chrome"))
            driver=new ChromeDriver();
        else  if (drivers.equals("ie"))
            driver=new FirefoxDriver();
        else  if (drivers.equals("firfox"))
            driver=new InternetExplorerDriver();
        else
            System.out.println("error");
        driver.get("https://www.baidu.com");
    }


    @DataProvider(name="driver")
    public  static Object[][] broswer(){
        return new Object  [] [] {
                {"chrome"},
                //{"ie"},
                //{"firfox"}
        };
    }
    @BeforeTest
    public  static  void openBrowser( ){
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        //System.setProperty("webdriver.firfox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firfox.exe");
        //System.setProperty("wendriver.ie.driver","F:\\WebUiAutoTest\\driver\\IEDriverServer.exe");
    }
}
