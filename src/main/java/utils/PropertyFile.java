package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
    private static PropertyFile propertyFile = new PropertyFile();
    private Properties properties = new Properties();
    private String apikey = null;
    private String accessToken = null;
    private String clientId = null;
    private String clientSecret = null;

    private PropertyFile() {
        readPropertyFile();
    }

    public static PropertyFile getPropertyFile() {
        return propertyFile;
    }

    private void readPropertyFile() {
        File file = new File("src/test/resources/api.properties");
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.apikey = properties.getProperty("apiKey");
        this.accessToken = properties.getProperty("accessToken");
        this.clientId = properties.getProperty("clientId");
        this.clientSecret = properties.getProperty("clientSecret");
    }

    public String getApikey() {
        return apikey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

}
