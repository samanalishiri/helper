package com.saman.helper.io;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public final class JsonUtils {

    public static JsonObject readObject(String fileName) throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileInputStream(new File(fileName)));
        JsonObject object = reader.readObject();
        reader.close();
        return object;
    }

    public static List<String> toList(JsonArray array) {
        return array.stream().map(val -> val.toString()).collect(Collectors.toList());
    }

    public static List<String> toList(String fileName, String arrayName) throws FileNotFoundException {
        return toList(readObject(fileName).getJsonArray(arrayName));
    }

    public static boolean contain(String fileName, String key) throws FileNotFoundException {
        return readObject(fileName).containsKey(key);
    }
}
