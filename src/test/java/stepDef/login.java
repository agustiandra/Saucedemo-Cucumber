package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User open saucedemo website")
    public void User_open_saucedemo_website() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("User input valid username and password")
    public void User_input_valid_username_and_password () throws Exception{
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }

    @And("User click login button")
    public void User_click_login_button () throws Exception{
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @Then("Dashboard Success Login Page is Displayed")
    public void Dashboard_Success_Login_Page_is_Displayed () {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login as valid username");
        System.out.println("If Success Login, You Can See Title Name " + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
}
