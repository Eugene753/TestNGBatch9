package com.TestNG.class01;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before method");
    }

    @Test
    public void bbbbbbb(){
        System.out.println("I am ddddd test");
    }

    @Test
    public void cccccccccc(){
        System.out.println("I am cccccc test");
    }
    @Test
    public void dddddddd(){
        System.out.println("I am aaaaaaa test");
    }

    @Test
    public void aaaaaaaaaa(){
        System.out.println("I am bbbbbbb test");
    }

}
