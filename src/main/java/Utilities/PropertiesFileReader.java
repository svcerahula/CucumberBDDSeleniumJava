package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    private static  PropertiesFileReader propFileInstance;
    public static Properties props = new Properties();
    public static void initializeProperties() throws IOException {
        propFileInstance = new PropertiesFileReader();
        propFileInstance.loadProps();
    }

    private void loadProps() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");
        props.load(fis);
    }

}
