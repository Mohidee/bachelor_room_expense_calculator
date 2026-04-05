package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch browser
        WebDriver driver = new ChromeDriver();

        // ✅ ADD IMPLICIT WAIT HERE
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open login page
            driver.get("https://uat.foodenginepos.com/RestaurantApp/");

            // Maximize window
            driver.manage().window().maximize();

            // Enter username
            WebElement username = driver.findElement(By.xpath("//input[@id='emailid']"));
            username.sendKeys("moh@uat.ho");

            // Enter password
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.sendKeys("1234");

            // Click login button
            WebElement loginBtn = driver.findElement(By.xpath("//input[@id='submit']"));
            loginBtn.click();

            // Wait (simple)
            Thread.sleep(3000);

            // Verify login
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("dashboard")) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
