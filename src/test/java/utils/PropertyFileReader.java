package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
    private Properties properties;
    private String baseUrl = "";
    private String apikey = "";

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
        setBaseUrl();
        setApikey();

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApikey() {
        return apikey;
    }

    private void setBaseUrl() {
        this.baseUrl = properties.getProperty("baseUrl");
    }

    private void setApikey() {
        this.apikey = properties.getProperty("apiKey");
    }
}
