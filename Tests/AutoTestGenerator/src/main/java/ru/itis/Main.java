package ru.itis;

import ru.itis.app.Generator;
import ru.itis.app.RepositoryJsonGenerator;
import ru.itis.model.RepositoryData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * created: 26-11-2021 - 21:50
 * project: AutoTests2
 *
 * @author Alba
 * @version v0.1
 */
public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Path to file: ");
        String path = SCANNER.nextLine();
        System.out.print("count of jsons: ");
        int count = SCANNER.nextInt();

        Generator<RepositoryData> repositoryDataGenerator = new RepositoryJsonGenerator();

        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        repositoryDataGenerator.generateToFile(writer, count);
        writer.close();
    }

}
