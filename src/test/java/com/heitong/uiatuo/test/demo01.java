package com.heitong.uiatuo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

public class demo01 {
    static  DesiredCapabilities dc;
    @Test(dataProvider = "driver")
    public  static  void Test(String drivers) throws  Exception{
        if (drivers.equals("chrome")){
             dc= DesiredCapabilities.chrome();
        }else if (drivers.equals("ie")){
            dc= DesiredCapabilities.internetExplorer();
        }else if (drivers.equals("firfox")){
            dc= DesiredCapabilities.firefox();
        }

        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.10.6:4444/wd/hub"),dc);

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
        System.setProperty("webdriver.chrome.driver","F:\\WebUiAutoTest\\driver\\chromedriver.exe");
        System.setProperty("webdriver.firfox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firfox.exe");
        System.setProperty("wendriver.ie.driver","F:\\WebUiAutoTest\\driver\\IEDriverServer.exe");
    }
}
