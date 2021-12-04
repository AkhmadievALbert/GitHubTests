package ru.itis.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.itis.entities.AccountData;
import ru.itis.settings.Settings;

/**
 * created: 02-12-2021 - 22:30
 * project: Tests
 *
 * @author Alba
 * @version v0.1
 */
public class AuthBase extends TestBase {

    @BeforeEach
    public void SetupTest() throws InterruptedException {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(new AccountData(Settings.email, Settings.password));
    }

}
