package com.cyberprotect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators

    
    private By loginTitle = By.xpath("//h2[contains(@class,'text-2xl') and contains(text(),'Digital security')]");
    private By emailField = By.xpath("//input[@id='email' and @placeholder='Email Address']");
    private By passwordField = By.xpath("//input[@id='password' and @label='Password']");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@class='mt-3 text-sm font-medium text-red-500 dark:text-red-400']");
    private By errorMsgEmptyEmail = By.xpath("//div[@class='mt-3 text-sm font-medium text-red-500 dark:text-red-400']");
    private By errorMsgInvalidEmailFormat = By.xpath("//div[@class='mt-3 text-sm font-medium text-red-500 dark:text-red-400']");
    private By dashboard = By.xpath("//h1[contains(text(),'Good')]");
    private By SigninLink = By.xpath("//span[contains(text(),'Sign in')]");
    private By closeCookie = By.xpath("//button[@type='submit' and @class='cookiesBtn__link']//span[contains(text(),'Accept')]");
   // private By proceedButton = By.xpath("//span[contains(text(),Pro)]");
    private By proceedButton = By.xpath("//button[@data-flux-button='data-flux-button']");
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clikcOnSigninLink(){
        wait.until(ExpectedConditions.elementToBeClickable(SigninLink)).click();
    }

    public void closeCookie(){
        wait.until(ExpectedConditions.elementToBeClickable(closeCookie)).click();
    }

    public void clikcOnProceedButton(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }

    //valid login Action method
    public void login(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
        .sendKeys(email);

         wait.until(ExpectedConditions.elementToBeClickable(proceedButton))
         .click();

wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
        .sendKeys(password);

wait.until(ExpectedConditions.elementToBeClickable(loginButton))
        .click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard))
                .isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .isDisplayed();

    }

    public boolean isErrorDisplayedForEmptyEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgEmptyEmail))
                .isDisplayed();

    }

    public boolean isErrorDisplayedForIncorrectFormat() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgInvalidEmailFormat))
                .isDisplayed();

    }

    public boolean isCookieDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeCookie))
                .isDisplayed();
    }


    public boolean isLoginScreenDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginTitle))
                .isDisplayed();

    }

    //invalid login action method

    public void invalLogin(String email){

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
        .sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(proceedButton))
         .click();



    }


}
