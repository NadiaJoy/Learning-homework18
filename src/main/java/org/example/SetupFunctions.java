package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetupFunctions {

    String baseUrl;
    String login;
    String isikukood;
    String password;
    String phone;


    public SetupFunctions() {
        try (InputStream input = new FileInputStream("settings.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            baseUrl = properties.getProperty("baseUrl");
            login = properties.getProperty("login");
            isikukood = properties.getProperty("isikukood");
            password = properties.getProperty("password");
            phone = properties.getProperty("phone");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}

