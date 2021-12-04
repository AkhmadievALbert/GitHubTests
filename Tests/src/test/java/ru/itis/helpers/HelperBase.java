package ru.itis.helpers;

import org.openqa.selenium.*;
import ru.itis.ApplicationManager;

/**
 * created: 12-11-2021 - 21:09
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class HelperBase {

    protected WebDriver driver;

    protected ApplicationManager applicationManager;

    private Boolean acceptNextAlert;

    public HelperBase(ApplicationManager applicationManager) {
        this.driver = applicationManager.getDriver();
        this.applicationManager = applicationManager;
        this.acceptNextAlert = true;
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver
                    .switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
