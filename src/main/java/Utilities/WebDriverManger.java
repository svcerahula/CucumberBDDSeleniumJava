package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Utilities.PropertiesFileReader.props;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManger {
    public static WebDriver driver = null;
    public static WebDriver initializeDriver() throws IOException {
        PropertiesFileReader.initializeProperties();
        if(props.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        return driver;
    }



}
