package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void testSuccessfulLogin() {
        // Navigate to Login Page
        driver.findElement(By.linkText("Form Authentication")).click();
        
        // Login with valid credentials
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        // Verify successful login
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"));
    }
    
    @Test
    public void testFailedLogin() {
        // Navigate to Login Page
        driver.findElement(By.linkText("Form Authentication")).click();
        
        // Login with invalid credentials
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        // Verify error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
    }
}