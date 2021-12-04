package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.itis.ApplicationManager;
import ru.itis.entities.RepositoryData;
import ru.itis.entities.RepositoryData;

import java.util.Comparator;
import java.util.List;

/**
 * created: 12-11-2021 - 21:31
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class RepositoryHelper extends HelperBase {

    public RepositoryHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public String createRepository(RepositoryData repositoryData) throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='js-pjax-container']/div[2]/div/div[2]/div[2]/div/div/div/div/a")).click();
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(repositoryData.getName());
        if (repositoryData.isCreateReadmeFile()) {
            driver.findElement(By.id("repository_description")).click();
        }
        driver.findElement(By.xpath("//form[@id='new_repository']/div[4]/div[4]/div/label")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//form[@id='new_repository']/div[4]/button")).click();
        return   driver.findElement(By.xpath("//*[@id=\"repository-container-header\"]/div[1]/div/h1/strong/a")).getText();
    }

    public void deleteRepositoryData(RepositoryData repositoryData) {
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/summary")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/details-dialog/div[3]/p[2]")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).clear();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys("Alba22052001/" + repositoryData.getName());
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(Keys.ENTER);
    }

    public int getCountOfRepositories() {
        return driver.findElements((By.xpath("//*[@id=\"user-repositories-list\"]/ul/li"))).size();
    }
}
