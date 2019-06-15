import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestClass {


    static WebDriver driver;


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().fullscreen();

        String url = "http://the-internet.herokuapp.com/";

        driver.get(url);

        WebElement fileUpload = driver.findElement(By.linkText("File Upload"));

        fileUpload.click();

        //MAC=Control+tab will switch the window in intellij
        //WIndows= Alt+tab

        //MAC=Command+tab will switch application to application
        //Windows=Cntrl+tab

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys("/Users/admin/Desktop/fileUploadSelenium.png");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));

        uploadButton.click();

        // Write the code if file name is matching print true,
        // if it is not matching print false.

        String expectedMessage = "fileUploadSelenium";


    }

}
