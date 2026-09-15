package WebPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsExample {
    WebDriver driver;
    @BeforeMethod
    public void alertTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void alertsTest() throws InterruptedException {
        //Alert (Simple Dialog)
        WebElement alertBox =driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        alertBox.click();
        //driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //Alert (Confirm Dialog)
        WebElement confirmAlert = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        confirmAlert.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        //Alert (Prompt Dialog)
        WebElement promptAlert = driver.findElement(By.id("j_idt88:j_idt104"));
        promptAlert.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert test is: " + alertText);
        alert2.sendKeys("My Name is Test");
        Thread.sleep(3000);
        alert2.accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
