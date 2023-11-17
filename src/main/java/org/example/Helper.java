package org.example;

import org.example.Models.Advertisement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void driverInit(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Advertisement.driver = driver;
        Advertisement.wait = wait;
    }
}
