package com.cyberprotect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Keys;


public class ForgotPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.xpath("//input[@id='email' and @placeholder='Email Address']");
    private By submitButton = By.id("resetBtn");
    private By successMsg = By.id("successMsg");
    private By foretPaswwordLink = By.xpath("//a[@href='https://testserver.cyberprotect.io/forgot-password']");
    private By forgetPasswordScreen = By.xpath("//h2[contains(text(),'Forgot your password?  No problem. ')]");
    private By resetPasswordScreen = By.xpath("//h2[contains(text(),'Reset your password from here! ')]");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By emailPasswordResetLinkButton = By.xpath("//button[@type='submit']");
    private By resetEmail = By.xpath("//input[@type='email' and @name='email']");
    private By newPassword = By.xpath("//input[@type='password' and @name='password']");
    private By confirmPassword = By.xpath("//input[@type='password' and @name='password_confirmation']");
    private By resetPasswordButton = By.xpath("//button[@type='submit']");

    private static final String FORGOT_PASSWORD_URL = "https://testserver.cyberprotect.io/reset-password/538171fe628fdebb5fd2fd58935cf2627c83c932ed1884b7243467c207246c24";


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void requestResetEnterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
        .sendKeys(email);
        
    }

    public void clickLinkForgotPassword(){

        wait.until(ExpectedConditions.elementToBeClickable(foretPaswwordLink)).click();
    }


    public boolean isForgotPassScreenDisplayedis() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(forgetPasswordScreen))
                .isDisplayed();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail))
        .sendKeys(email);
        
    }

    public void clickOnEmailPasswordResetLinkButton(){

        wait.until(ExpectedConditions.elementToBeClickable(emailPasswordResetLinkButton)).click();
    }

    // public boolean isResetPasswordScreenDisplayed(){
    //     return 
    // }

    public void resetEmailInput(String email){

        wait.until(ExpectedConditions.visibilityOfElementLocated(resetEmail))
        .sendKeys(email + Keys.TAB);

    }

    public void enterPass(String password){

        wait.until(ExpectedConditions.visibilityOfElementLocated(newPassword))
        .sendKeys(password + Keys.TAB);
    }

    public void enterConfirmPass(String Cpassword){

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword))
        .sendKeys(Cpassword + Keys.TAB);
    }


    public void resetPassword(){

        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton)).click();

    }

    public void navigateResetPasswordPage(){
        driver.get(FORGOT_PASSWORD_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordScreen))
        .isDisplayed();
    }


    public void waitForForgetPasswordScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgetPasswordScreen));

    }

    public void waitForResetPasswordScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordScreen));

    }

    public boolean isResetRequestSuccess() {
        return !driver.findElements(successMsg).isEmpty();
    }


}
