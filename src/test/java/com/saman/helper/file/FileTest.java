package com.saman.helper.file;

import com.saman.helper.BaseTest;
import com.saman.helper.internationalization.LocalHolder;
import com.saman.helper.internationalization.Message;
import com.saman.helper.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

@RunWith(JUnit4.class)
public class FileTest extends BaseTest {

    @Test
    public void readFile() {
        try {
            BufferedReader reader = FileUtils.read("src/test/resources/test.json");

            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(line -> builder.append(line));
            logger.log(builder.toString());

        } catch (IOException e) {
            logger.log(e);
        }
    }

    @Test
    public void readProperties() {
        try {
            Properties properties = FileUtils.properties("src/test/resources/test.properties");
            properties.entrySet()
                    .stream()
                    .forEach(entry -> logger.log(entry.getKey() + "=" + properties.get(entry.getKey())));

        } catch (IOException e) {
            logger.log(e);
        }
    }

    @Test
    public void localization() {
        ResourceBundle message = ResourceBundle.getBundle("test_message", LocalHolder.IRAN.getLocal());
        boolean contains = message.containsKey("test");
        System.out.println("contains = " + contains);
    }

}
