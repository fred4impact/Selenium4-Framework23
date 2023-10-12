package org.techskillshub.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

      // import the properties class
        private final Properties properties;


        public ConfigReader() {
            properties = new Properties();
            try {
                FileInputStream inputStream = new FileInputStream("./resources/config.properties");
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getProperty(String key) {
            return properties.getProperty(key);
        }


}

