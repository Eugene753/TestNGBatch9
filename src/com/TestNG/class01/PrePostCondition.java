package com.TestNG.class01;

import org.testng.annotations.*;
@Test
public class PrePostCondition {

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before test method");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("I am after test test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method function which will execute before every test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method function which will execute before every test");
    }

    @Test
    public void firstFunction(){
        System.out.println("I am bbbbbbb test");
    }
    @Test
    public void secondFunction(){
        System.out.println("I am cccccc test");
    }
    @Test
    public void aaaaaaaaaa(){
        System.out.println("I am bbbbbbb test");
    }
}
