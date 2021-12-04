package ru.itis.providers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.itis.entities.RepositoryData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * created: 26-11-2021 - 22:23
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
public class EntityDataProvider {

    public static final String FILE = "JsonRepositoryDataSet.json";

    public static Stream<RepositoryData> createNewRepositoryData() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE));

        List<RepositoryData> repositoryDataList = new Gson().fromJson(reader, new TypeToken<List<RepositoryData>>(){}.getType());
        return repositoryDataList.stream();
    }

}
