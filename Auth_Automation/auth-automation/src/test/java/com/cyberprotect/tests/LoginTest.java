package com.cyberprotect.tests;

import com.cyberprotect.base.BaseTest;
import com.cyberprotect.pages.LoginPage;
import com.cyberprotect.utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        if(login.isCookieDisplayed()){
            login.closeCookie();
            login.clikcOnSigninLink();
        }
        else{
            login.clikcOnSigninLink();
        }
        login.login(
                ConfigReader.get("valid.email"),
                ConfigReader.get("valid.password")
        );
        Assert.assertTrue(login.isLoginSuccessful());
    }

    @Test
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        if(login.isCookieDisplayed()){
            login.closeCookie();
            login.clikcOnSigninLink();
        }
        else{
            login.clikcOnSigninLink();
        }
        login.invalLogin("wrong@test.com");
        Assert.assertTrue(login.isErrorDisplayed());
    }


    @Test
    public void emptyEmailValidationCheck() {
        LoginPage login = new LoginPage(driver);
        if(login.isCookieDisplayed()){
            login.closeCookie();
            login.clikcOnSigninLink();
        }
        else{
            login.clikcOnSigninLink();
        }
        login.clikcOnProceedButton();
        Assert.assertTrue(login.isErrorDisplayedForEmptyEmail());
    }

    @Test
    public void incoreectEmailFormatCheck() {
        LoginPage login = new LoginPage(driver);
        if(login.isCookieDisplayed()){
            login.closeCookie();
            login.clikcOnSigninLink();
        }
        else{
            login.clikcOnSigninLink();
        }

        login.invalLogin("mohikhan");
        Assert.assertTrue(login.isErrorDisplayedForIncorrectFormat());
    }


    
}
