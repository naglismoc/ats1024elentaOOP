import org.example.Helper;
import org.example.Models.Advertisement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

    public class AdTests {
    public static WebDriver driver;

        @Test
        public void adPositiveTest(){
            Advertisement ad = new Advertisement("title","description","0","Palanga","+37065878945","email@tvar.com","caring-for-your-new-kitten.jpg");
            ad.fillAd();
            Assert.assertEquals("","");
        }

        @Test
        public void adNoTitleTest(){
            Advertisement ad = new Advertisement("","description","0","Palanga","+37065878945","email@tvar.com","cleanPlant2.jpg");
            ad.fillAd();
            Assert.assertEquals("","");
        }

        @Test
        public void adPNoDescriptionTest(){
            Advertisement ad = new Advertisement("pavadinimukas","","0","Palanga","+37065878945","email@tvar.com","cleanPlant2.jpg");
            ad.fillAd();

            Assert.assertEquals("","");
        }

    @BeforeClass
    public void beforeClass(){
        Helper.driverInit();
        driver = Helper.driver;
        acceptCookies();
    }

    public void acceptCookies(){
        driver.get("https://elenta.lt");
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @AfterClass
    public void afterClass(){
      //  driver.quit();
    }
}
