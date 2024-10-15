package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;

    public ConfigLoader(String propertiesFilePath) {
        properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        // Get the property value from the properties file
        String value = properties.getProperty(key);

        // If the property is null, try to get it from environment variables
        if (value == null) {
            value = System.getenv(key);
        }

        return value;
    }

}
