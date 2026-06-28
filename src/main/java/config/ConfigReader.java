package config;

import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

    private static Properties properties = new Properties();

    private ConfigReader() {
    }

    static {

        try {

            // Load config.properties
            FileInputStream configStream =
                    new FileInputStream("src/main/resources/" + FrameworkConstants.CONFIG_FILE);

            Properties config = new Properties();
            config.load(configStream);

            String env = config.getProperty("environment").toLowerCase();

            String envFile = switch (env) {

                case "qa" -> FrameworkConstants.QA_FILE;

                case "uat" -> FrameworkConstants.UAT_FILE;

                case "prod" -> FrameworkConstants.PROD_FILE;

                default -> throw new RuntimeException("Invalid Environment : " + env);

            };

            FileInputStream envStream =
                    new FileInputStream("src/main/resources/" + envFile);

            properties.load(envStream);

        }

        catch (IOException e) {

            throw new RuntimeException("Unable to load property file", e);

        }

    }

    public static String get(String key) {

        return properties.getProperty(key);

    }

}
