package ru.itis.app;

import com.google.gson.Gson;
import ru.itis.model.RepositoryData;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * created: 26-11-2021 - 21:50
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
public class RepositoryJsonGenerator implements Generator<RepositoryData> {

    private Random random = new Random();
    @Override
    public void generateToFile(Writer writer, int count) throws IOException {
        Gson gson = new Gson();
        List<RepositoryData> jsons = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            RepositoryData repositoryData = new RepositoryData();
            repositoryData.setName(UUID.randomUUID().toString());
            repositoryData.setCreateReadmeFile(random.nextBoolean());
            jsons.add(repositoryData);
        }

        String json = gson.toJson(jsons);
        writer.write(json);
        writer.flush();
    }
}