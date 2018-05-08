package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
    private Properties properties;
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
        setApikey();
    }


    public String getApikey() {
        return apikey;
    }

    private void setApikey() {
        this.apikey = properties.getProperty("apiKey");
    }
}
