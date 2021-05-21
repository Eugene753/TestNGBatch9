package com.TestNG.class01;

import org.testng.annotations.*;

public class ClassTask2 {

   @BeforeClass
    public void beforeClass(){
       System.out.println("I am before class ");
   }
   @Test
   public void testOneClass()
   {
       System.out.println("I am test one");
   }
   @Test
   public void testTwoClass(){
       System.out.println("I am test two");
   }
   @AfterClass
   public void afterClass(){
       System.out.println("I am after class ");
   }
   @BeforeMethod
    public void beforeMethod(){
       System.out.println("I am before method");
   }
   @Test
    public void testThree(){
       System.out.println("I am test three");
   }
   @Test
    public void testForu(){
       System.out.println("I am test four");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
}
