package com.saman.helper.internationalization;

import com.saman.helper.io.FileUtils;
import com.saman.helper.logger.Logger;
import com.saman.helper.logger.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Message {
    private final Logger logger = LoggerFactory.create(Message.class);

    private static Message ourInstance = new Message();

    public static Message getInstance() {
        return ourInstance;
    }

    private ResourceBundle message;


    private Message() {

        LocalHolder localHolder = LocalHolder.USA;
        try {
            Properties appProperties = FileUtils.properties("src/main/resources/app.properties");
            localHolder = LocalHolder.valueOf(appProperties.getProperty("local").toUpperCase());
        } catch (IOException e) {
            logger.log(e);
        }
        message = ResourceBundle.getBundle("message", localHolder.getLocal());
    }

    public String getMessage(String key) {
        return message.getString(key);
    }
}
