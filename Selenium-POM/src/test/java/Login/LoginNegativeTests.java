package Login;

import Base.LoginBase;
import Pages.Login.LoginPage;
import TestData.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTests extends LoginBase {
    @Test(description = "Test login with locked out username and valid password", dataProvider = "locked-out-user", dataProviderClass = LoginBase.class)
    public void testLoginFailureLockedUser(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        String actualErrorMessage = loginPage.returnLoginErrorMessage();

        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
        Assert.assertEquals(actualErrorMessage, user.getExpectedErrorMessage());
    }

    @Test(description = "Test login with invalid usernames and valid password", dataProvider = "inexistent-username", dataProviderClass = LoginBase.class)
    public void testLoginFailureInvalidUsernames(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        String actualErrorMessage = loginPage.returnLoginErrorMessage();

        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
        Assert.assertEquals(actualErrorMessage, user.getExpectedErrorMessage());
    }

    @Test(description = "Test login with empty username and valid password", dataProvider = "empty-username", dataProviderClass = LoginBase.class)
    public void testLoginFailureWithEmptySpaceUsername(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithUsernameAndPassword(user.getUsername(), user.getPassword());
        String actualErrorMessage = loginPage.returnLoginErrorMessage();

        Assert.assertEquals(driver.getCurrentUrl(), user.getExpectedUrl());
        Assert.assertEquals(actualErrorMessage, user.getExpectedErrorMessage());
    }
}