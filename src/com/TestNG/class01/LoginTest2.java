package com.TestNG.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest2 {

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
    @Test
    public void validLogin(){
    /*WebElement usernamefield=driver.findElement(By.id("txtUsername"));
    usernamefield.sendKeys("Admin");   ---- > another option */
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test is valid and Passed");
        }else{
            System.out.println("Test is failed");
        }
    }
    @Test
    public void validationOfTitle(){
        String expectedTitle="Human Management System";
        String actualtitle=driver.getTitle();
        if(expectedTitle.equals(actualtitle)){
            System.out.println("Title passed and same");
        }else{
            System.out.println("Title is failed");
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
