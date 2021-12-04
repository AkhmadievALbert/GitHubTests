package ru.itis.tests;

import org.junit.jupiter.api.*;
import ru.itis.entities.AccountData;
import ru.itis.settings.Settings;

/**
 * created: 19-11-2021 - 1:12
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
@Order(1)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends TestBase {

    @BeforeEach
    public void logout() {
        applicationManager.getAccountHelper().logout();
    }

    @Test
    public void login_with_ValidData() throws InterruptedException {
        AccountData accountData = new AccountData(Settings.email, Settings.password);
        applicationManager.getNavigationHelper().openLoginPage();
        Assertions.assertTrue(applicationManager.getLoginHelper().login(accountData));
    }

    @Test
    public void login_with_InvalidData() throws InterruptedException {
        AccountData accountData = new AccountData("invalidLogin", "invalidPassword");
        applicationManager.getNavigationHelper().openLoginPage();
        Assertions.assertFalse(applicationManager.getLoginHelper().login(accountData));
    }

}
