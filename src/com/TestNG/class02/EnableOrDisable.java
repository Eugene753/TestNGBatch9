package com.TestNG.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableOrDisable {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // launch the application
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void logoutMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority = 1,enabled = false)
    public void loginMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority = 2,enabled = false)
    public void enterCredentialMethod(){
        System.out.println("This execution should come in the end");
    }

    @Test(priority = 1,enabled = true)
    public void invalidLogin(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement errorField=driver.findElement(By.id("spanMessage"));
        String recievingText=errorField.getText();
        String actualText="Password cannot be empty";

        Assert.assertEquals(recievingText,actualText);
        System.out.println("Test is passed");

        /*if(recievingText.equals(actualText)){
            System.out.println("Test is passed and error is displayed");
        }else{
            System.out.println("Test is failed and error is not available");
        }*/
    }

    @Test
    public void testLogin(){
        /*WebElement userNameField=driver.findElement(By.id("txtUsername"));
        userNameField.sendKeys("");
        userNameField.clear();
        userNameField.click();*/

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.xpath("//a[text()='Welcome Admin']"));

        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test is valid and Passed");
        }else{
            System.out.println("Test failed");
        }
    }

    @Test(priority = 2,enabled = true)
    public void validationOfTitle(){

        String expectedTitle="Human Management System";
        String actualTitle=driver.getTitle();



        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test is final and title is same");
        }else{
            System.out.println("Test is failed");
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
