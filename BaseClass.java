package PomPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;
    PageClaass pageClaass;

    @Before
    public void openUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        pageClaass=new PageClaass(driver);
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void letsKodeit() {
        pageClaass.setAlertBox("Himanshu");
        pageClaass.setAlertButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        pageClaass.setHover();

        String actual = pageClaass.setWebTable();
        Assert.assertThat(actual, Matchers.equalTo("Python Programming Language"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}