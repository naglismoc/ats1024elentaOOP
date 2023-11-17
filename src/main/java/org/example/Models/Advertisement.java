package org.example.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Advertisement {
    public String title;
    public String description;
    public String price;
    public String city;
    public String phoNo;
    public String email;
    public String imageUrl;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public Advertisement(String title, String description, String price, String city, String phoNo, String email,String imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.city = city;
        this.phoNo = phoNo;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public void fillAd(){
        fillAdPage1();
        fillAdPage2();
      //  fillAdPage3();
    }
    public void fillAdPage1(){
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Technika_BuitineTechnika&actionId=Siulo&returnurl=%2Fisiminti-skelbimai");
        driver.findElement(By.id("title")).sendKeys(this.title);
        driver.findElement(By.id("text")).sendKeys(this.description);
        driver.findElement(By.id("price")).sendKeys(this.price);
        driver.findElement(By.id("location-search-box")).sendKeys(this.city);
        driver.findElement(By.id("phone")).sendKeys(this.phoNo);
        driver.findElement(By.id("email")).sendKeys(this.email);
        driver.findElement(By.id("submit-button")).click();
    }
    public void fillAdPage2(){
        File resourceFile = new File("images/"+this.imageUrl);
        driver.findElement(By.id("inputfile")).sendKeys(resourceFile.getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("photo-1")));
        driver.findElement(By.id("forward-button")).click();
    }
    public void fillAdPage3(){
        driver.findElement(By.id("forward-button")).click();
    }
}
