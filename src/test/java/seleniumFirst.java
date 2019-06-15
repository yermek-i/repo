import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class seleniumFirst {

    static WebDriver driver;

    public static void main(String[] args) throws Exception{


        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().fullscreen();

        String expectedURL="http://the-internet.herokuapp.com/";

        driver.get(expectedURL);


        String actualUrl=driver.getCurrentUrl();

        if(expectedURL.equals(actualUrl)){

            System.out.println("the expected and actual url is matching");
        }else{

            System.out.println("test cases is failed. Expected url is "+expectedURL+"\nactual url is "+actualUrl);
        }


        WebElement forgotPass=driver.findElement(By.linkText("Forgot Password"));
        forgotPass.click();

        String expectedafterForgotPass="http://the-internet.herokuapp.com/forgot_password";

        String afterForgotPass=driver.getCurrentUrl();


        if(expectedafterForgotPass.equals(afterForgotPass)){

            System.out.println("The expected and actual url is mathcing. After clicking forgot password");

        }else{

            System.out.println("Actual and expected url is not mathcing after clicking forgot password. ");
        }

        driver.findElement(By.id("email")).sendKeys("muammerturan@gmail.com");

        driver.findElement(By.id("form_submit")).click();

        //always for expected condions is coming from business requirement.
        //1- DO not ask the developer
        //2- Do not copy from application itself


        //possible scenario to get the business requirement
        //1- You can ask your scrum master
        //2- You can ask the Business Analyst
        //3- You can ask the Product owner
        //4- You can find under user story
        //5- You can find on confluence page

        String expectedURL1="http://the-internet.herokuapp.com/email_sent";

        String actualURL1=driver.getCurrentUrl();

        if(expectedURL1.equals(actualURL1)){

            System.out.println("Expected and actual url is matching-- PASSED");
        }else{

            System.out.println("FAILED");

            throw new Exception();
        }


        WebElement message=driver.findElement(By.id("content"));

        String expectedMessage="Your e-mail's been sent!";

        String actualMessage=message.getText();


        if(expectedMessage.equals(actualMessage)){

            System.out.println("TRUE");
        }else{

            System.out.println("FALSE");
        }


        driver.navigate().back();

        driver.navigate().forward();


        driver.navigate().refresh();


        driver.get("http://the-internet.herokuapp.com/");

        //return type for findElements is List of WebElement

        List<WebElement> link=driver.findElements(By.xpath("//li//a"));

        for(int i=0;i<link.size();i++){

            System.out.println(link.get(i).getText());
        }



    }


}


