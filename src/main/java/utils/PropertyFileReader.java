package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
    private Properties properties;
    private String apikey = "";
    private String accessToken = "";

    public PropertyFileReader() {
        this.properties = new Properties();
        readPropertyFile();
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
}
