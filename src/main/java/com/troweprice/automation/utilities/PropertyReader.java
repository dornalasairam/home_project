package com.troweprice.automation.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;
    private static InputStream inputStream;

    public static String getPropertyValue(String propertyName) {
        return getPropertyValue(propertyName, false);
    }

    public static String getPropertyValue(String propertyName, boolean isUrlProperty) {
        try {
            properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputStream = classLoader.getResourceAsStream("application.properties");
            properties.load(inputStream);
            String value = properties.get(propertyName).toString();
            if (isUrlProperty) {
                return properties.get("baseurl").toString() + value;
            } else {
                return value;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getPropertyValueFromFile(String fileName, String propertyName) {
        try {
            properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputStream = classLoader.getResourceAsStream(fileName);
            properties.load(inputStream);
            return properties.get(propertyName).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
