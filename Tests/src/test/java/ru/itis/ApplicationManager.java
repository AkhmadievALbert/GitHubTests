package ru.itis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.entities.AccountData;
import ru.itis.helpers.AccountHelper;
import ru.itis.helpers.NavigationHelper;
import ru.itis.helpers.RepositoryHelper;
import ru.itis.settings.Settings;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * created: 12-11-2021 - 21:15
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class ApplicationManager {

    private final static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private final WebDriver driver;
    private final String baseUrl;
    private final StringBuffer verificationErrors = new StringBuffer();

    private final NavigationHelper navigationHelper;
    private final AccountHelper accountHelper;
    private final RepositoryHelper toDoHelper;

    private AccountData accountData;

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "/Users/a.akhmadiev/Desktop/chromedriver");

        driver = new ChromeDriver();
        baseUrl = Settings.baseUrl;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        navigationHelper = new NavigationHelper(this);
        accountHelper = new AccountHelper(this);
        toDoHelper = new RepositoryHelper(this);
    }

    public void stop() {
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void clearAccountData() {
        accountData = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AccountHelper getLoginHelper() {
        return accountHelper;
    }

    public RepositoryHelper getToDoHelper() {
        return toDoHelper;
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigationHelper.openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    public AccountHelper getAccountHelper() {
        return accountHelper;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void setAccountData(AccountData accountData) {
        this.accountData = accountData;
    }
}
