package ru.itis.settings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Map;

/**
 * created: 02-12-2021 - 22:35
 * project: Tests
 *
 * @author Alba
 * @version v0.1
 */

public class Settings {

    public static final String FILE = "settings.json";

    public static String baseUrl;
    public static String email;
    public static String password;
    public static JsonParser jsonParser;

    static {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            jsonParser = new JsonParser();
            JsonObject json = jsonParser.parse(bufferedReader).getAsJsonObject();

            email = json.get("email").getAsString();
            password = json.get("password").getAsString();
            baseUrl = json.get("baseUrl").getAsString();

        } catch (IOException e) {
            throw new IllegalArgumentException("Problem: settings file not found: " + FILE, e);
        }
    }

}
