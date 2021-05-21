package com.TestNG.class02;

import org.testng.annotations.Test;

public class PriorityBatch9 {

    @Test(priority = 2)
    public void logoutMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority = 1)
    public void loginMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority = 2)
    public void enterCredentialMethod(){
        System.out.println("This execution should come in the end");
    }

    @Test(priority = 4)
    public void enterInvalidCredentials(){
        System.out.println("This execution should come at number 4");
    }

    @Test(priority = 5)
    public void anotherTestMethod(){
        System.out.println("This execution should come at number 5");
    }
}
