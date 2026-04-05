import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

    public static void main(String[] args) {

        // Set path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Launch browser
        WebDriver driver = new ChromeDriver();

        // Open login page
        driver.get("https://bachelor-room.vercel.app/login");

        // Maximize window
        driver.manage().window().maximize();

        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("testuser");

        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("test123");

        // Click login button
        WebElement loginBtn = driver.findElement(By.id("loginBtn"));
        loginBtn.click();

        // Validate login (example: check dashboard URL)
        if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        // Close browser
        driver.quit();
    }
}