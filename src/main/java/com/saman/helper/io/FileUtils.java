package com.saman.helper.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public final class FileUtils {

    public static BufferedWriter create(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
    }

    public static BufferedWriter open(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static BufferedReader read(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    public static Properties properties(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(FileUtils.read(fileName));
        return properties;
    }

    public static boolean isExist(String fileName) {
        return Files.exists(Paths.get(fileName));
    }

    public static void write(BufferedWriter writer, String str) throws IOException {
        writer.write(str);
        writer.newLine();
        writer.flush();
        writer.close();
    }

}
