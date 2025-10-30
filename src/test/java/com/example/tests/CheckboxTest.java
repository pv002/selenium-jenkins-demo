package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    
    @Test
    public void testCheckboxes() {
        // Navigate to Checkboxes page
        driver.findElement(By.linkText("Checkboxes")).click();
        
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));
        
        // Test checkbox 1
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        
        // Test checkbox 2
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected());
    }
}