package com.TestNG.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest1 {
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
    public void validLogin(){
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

    @Test
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
