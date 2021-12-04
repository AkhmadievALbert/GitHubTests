package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.itis.ApplicationManager;
import ru.itis.entities.AccountData;

/**
 * created: 12-11-2021 - 21:10
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class AccountHelper extends HelperBase {

    public AccountHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public boolean login(AccountData user) throws InterruptedException {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getEmail())) {
                return true;
            }
            logout();
        }
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(user.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if (driver.getCurrentUrl().equals(applicationManager.getNavigationHelper().getBaseUrl())) {
            applicationManager.setAccountData(user);
            return true;
        }
        return false;
    }


    public void logout() {
        if (applicationManager.getAccountData() != null) {
            driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
            driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button")).click();

            applicationManager.clearAccountData();
        }
    }

    public boolean isLoggedIn() {
        return applicationManager.getAccountData() != null;
    }


    public boolean isLoggedIn(String email) {
        return applicationManager.getAccountData().getEmail().equals(email);
    }



}
