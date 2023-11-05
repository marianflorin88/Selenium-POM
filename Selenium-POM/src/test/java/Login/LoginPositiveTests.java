package Login;

import Pages.Login.LoginPage;
import TestData.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.*;

public class LoginPositiveTests extends LoginBase {
    @Test(priority = -1, description = "Test login with valid username and valid password.", dataProvider = "valid-accounts", dataProviderClass = LoginBase.class)
    public void testLoginSuccessWithValidUsernames(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
    }
}