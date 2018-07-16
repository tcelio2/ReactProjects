package com.ibm.att.spa01.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionDAOProperties {

    
    private static final String PROPERTIES_FILE = "config.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

//        if (propertiesFile == null) {
//            throw new DAOConfigurationException(
//                "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
//        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
           // throw new DAOConfigurationException(
            //    "Cannot load properties file '" + PROPERTIES_FILE + "'.", e);
        }
    }

    
    
}

