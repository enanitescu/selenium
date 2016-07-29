package com.endava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

/**
 * Created by amnitescu on 7/29/2016.
 */
public class GmailTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {

        webDriver = new FirefoxDriver();
        webDriver.get("https://gmail.com");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }

    @Test
    public void testGmail() {

        //get the email field
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("endavaselenium");

        //get the next button
        WebElement nextButton = webDriver.findElement(By.xpath("//input[@id='next']"));
        nextButton.click();

        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("endavaqa");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton.click();

        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();

        WebElement toField = webDriver.findElement(By.xpath("//textarea[@name='to']"));
        toField.sendKeys("endavaselenium@gmail.com");
        toField.sendKeys(Keys.ENTER);

        WebElement subjectField = webDriver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Ana");

        WebElement messageBox = webDriver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        messageBox.sendKeys("Ana");

        WebElement sendButton = webDriver.findElement(By.xpath("//*[contains(@aria-label,'Send')]"));
        sendButton.click();


    }

    @AfterClass
    public static void tearDown() {

        webDriver.close();

    }

}
