package testBase; 

import java.io.File; 
import java.io.FileReader; 
import java.io.IOException; 
import java.net.URL; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Properties; 

import org.openqa.selenium.OutputType; 
import org.openqa.selenium.Platform; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver; 
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.remote.RemoteWebDriver; 
import org.testng.annotations.AfterClass; 
import org.testng.annotations.BeforeClass; 
import org.testng.annotations.Parameters;

public class BaseClass { // Define the BaseClass

    static public WebDriver driver; // Declare a static WebDriver instance
    public Properties p; // Declare a Properties instance

    @BeforeClass // Annotation to run this method before any test methods in the class
    @Parameters({"browser"}) // Define parameters for the method
    public void setup(String br) throws IOException { // Setup method with parameters for OS and browser

        // Loading properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties"); // Create FileReader for properties file
        p = new Properties(); // Initialize Properties object
        p.load(file); // Load properties from file

     
        if (p.getProperty("execution_env").equalsIgnoreCase("local")) { // Check if execution environment is local

            // Initialize local WebDriver based on browser parameter
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver(); 
                    break;
                case "edge":
                    driver = new EdgeDriver(); 
                    break;
                default:
                    System.out.println("Invalid browser name.");
                    return;
            }
        }

        driver.get(p.getProperty("appURL")); // Open application URL
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterClass // Annotation to run this method after all test methods in the class
    public void tearDown() { 
        driver.quit();
    }

    public String captureScreen(String tname) throws IOException { // Method to capture screenshot

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); // Capture screenshot as file

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png"; // Define target file path
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return targetFilePath; // Return target file path
    }
}
