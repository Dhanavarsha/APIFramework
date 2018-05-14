package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
    private static PropertyFile propertyFile = new PropertyFile();
    private Properties properties = new Properties();
    private String apikey = "";
    private String accessToken = "";
    private String clientId = "";
    private String clientSecret = "";

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
        setApikey();
        setAccessToken();
        setClientId();
        setClientSecret();
    }

    public String getApikey() {
        return apikey;
    }

    private void setApikey() {
        this.apikey = properties.getProperty("apiKey");
    }

    public String getAccessToken() {
        return accessToken;
    }

    private void setAccessToken() {
        this.accessToken = properties.getProperty("accessToken");
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId() {
        this.clientId = properties.getProperty("clientId");
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret() {
        this.clientSecret = properties.getProperty("clientSecret");
    }
}
