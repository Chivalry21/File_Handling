package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static Properties getEnvProperties (String srcFile){
        Properties properties = new Properties();
        try(FileInputStream file = new FileInputStream(srcFile)){
            properties.load(file);
        } catch (IOException error){
            System.out.println(error.getMessage());
        }
        return properties;
    }
}
