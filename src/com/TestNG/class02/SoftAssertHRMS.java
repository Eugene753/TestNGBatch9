package com.TestNG.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertHRMS {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLanchApp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginAndValidateTitle(){
        String title="Human Resource Management System";
        String actualTitle=driver.getTitle();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualTitle,title);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.xpath("//a[text()='Welcome Admin']"));

        String receiveValue=welcomeAttribute.getText();
        String existedvalue="Welcome Admin12345";

        soft.assertEquals(receiveValue,existedvalue);
        System.out.println("My test case is not working according to the user story");
        soft.assertAll();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
