package ru.itis.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.itis.ApplicationManager;

/**
 * created: 30-10-2021 - 12:11
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class TestBase {

    protected static ApplicationManager applicationManager;

    @BeforeEach
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.getInstance();
    }

    public static void tearDown() throws Exception {
        applicationManager.stop();
    }
}
