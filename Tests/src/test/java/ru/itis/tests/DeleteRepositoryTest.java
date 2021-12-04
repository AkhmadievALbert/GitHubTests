package ru.itis.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.itis.entities.RepositoryData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created: 19-11-2021 - 1:13
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
@Order(3)
public class DeleteRepositoryTest extends AuthBase {

    @ParameterizedTest
    @MethodSource("ru.itis.providers.EntityDataProvider#createNewRepositoryData")
    public void removeLastRepositoryData(RepositoryData repositoryData) throws InterruptedException {
        applicationManager.getNavigationHelper().openAllRepositoriesPage();
        int expected = applicationManager.getToDoHelper().getCountOfRepositories() - 1;
        applicationManager.getNavigationHelper().openRepositorySettingsPage(repositoryData.getName());
        applicationManager.getToDoHelper().deleteRepositoryData(repositoryData);
        applicationManager.getNavigationHelper().openAllRepositoriesPage();
        int actual = applicationManager.getToDoHelper().getCountOfRepositories();

        assertEquals(expected, actual);
    }

    @AfterAll
    public static void exit() throws Exception {
        tearDown();
    }

}
