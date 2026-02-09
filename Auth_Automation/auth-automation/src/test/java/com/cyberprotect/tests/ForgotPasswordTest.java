package com.cyberprotect.tests;

import com.cyberprotect.base.BaseTest;
import com.cyberprotect.pages.ForgotPasswordPage;
import com.cyberprotect.pages.LoginPage;
import com.cyberprotect.utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;
public class ForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordFlow() {
        ForgotPasswordPage forgot = new ForgotPasswordPage(driver);
        LoginPage login = new LoginPage(driver);

       
        if(login.isCookieDisplayed()){
            login.closeCookie();
            login.clikcOnSigninLink();
        }
        else{
            login.clikcOnSigninLink();
        }
        //enetred email
        forgot.requestResetEnterEmail(ConfigReader.get("valid.email"));
        login.clikcOnProceedButton();
        forgot.clickLinkForgotPassword();
        forgot.waitForForgetPasswordScreen();
        forgot.enterEmail("mohikhan13@outlook.com");
        forgot.clickOnEmailPasswordResetLinkButton();
        forgot.navigateResetPasswordPage();
        forgot.resetEmailInput("mohikhan13@outlook.com");
        forgot.enterPass("Testingmaniac@123_1");
        forgot.enterConfirmPass("Testingmaniac@123_1");
        forgot.resetPassword();
        // OTP/email verification assumed manual/mock
    }
}
