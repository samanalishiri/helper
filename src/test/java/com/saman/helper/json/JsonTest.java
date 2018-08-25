package com.saman.helper.json;

import com.saman.helper.BaseTest;
import com.saman.helper.io.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

@RunWith(JUnit4.class)
public class JsonTest extends BaseTest {

    @Test
    public void jsonProcess() {
        try {
            List<String> firstNames = JsonUtils.toList("src/test/resources/test.json", "data");
            firstNames.stream().forEach(el -> logger.log(el));

        } catch (IOException e) {
            logger.log(e);
        }
    }
}
