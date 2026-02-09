package com.cyberprotect.utils;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static void set(String key, String value) {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("/Users/mohd.khan/Documents/Auth_Automation/auth-automation/src/test/resources/config.properties");
            props.load(fis);
            fis.close();
    
            props.setProperty(key, value);
    
            FileOutputStream fos = new FileOutputStream("/Users/mohd.khan/Documents/Auth_Automation/auth-automation/src/test/resources/config.properties");
            props.store(fos, null);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to update config", e);
        }
    }
    
}

