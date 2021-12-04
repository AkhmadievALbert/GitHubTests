package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;

/**
 * created: 12-11-2021 - 21:07
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class NavigationHelper extends HelperBase {

    private final String baseUrl;
    private String currentUrl;

    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.baseUrl = applicationManager.getBaseUrl();
    }

    public void openHomePage() {
        currentUrl = baseUrl;
        driver.get(baseUrl);
    }
    public void openLoginPage() {
        currentUrl = baseUrl + "login";
        driver.get(currentUrl);
    }
    public void openAllRepositoriesPage() {
        currentUrl = baseUrl + "Alba22052001?tab=repositories";
        driver.get(currentUrl);
    }
    public void openRepositoryPage(String name) {
        currentUrl = baseUrl + "Alba22052001/" + name;
        driver.get(currentUrl);
    }
    public void openRepositorySettingsPage(String name) {
        currentUrl = baseUrl + "Alba22052001/" + name + "/settings";
        driver.get(currentUrl);
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
