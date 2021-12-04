package ru.itis.tests;

import org.junit.jupiter.api.Order;
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
@Order(2)
public class CreateRepositoryTest extends AuthBase {

    @ParameterizedTest
    @MethodSource("ru.itis.providers.EntityDataProvider#createNewRepositoryData")
    public void createNewRepositoryData(RepositoryData expected) throws InterruptedException {
        applicationManager.getNavigationHelper().openAllRepositoriesPage();
        String actual = applicationManager.getToDoHelper().createRepository(expected);

        assertEquals(expected.getName(), actual);
    }

}
