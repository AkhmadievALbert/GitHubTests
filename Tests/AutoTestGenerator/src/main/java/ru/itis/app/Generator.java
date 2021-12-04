package ru.itis.app;

import java.io.IOException;
import java.io.Writer;

/**
 * created: 26-11-2021 - 21:49
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
public interface Generator<T> {

    void generateToFile(Writer writer, int count) throws IOException;

}
