package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;
    @BeforeMethod
    public void frameTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/frame.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void frameTest(){
         driver.switchTo().frame(0);
         WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
         button1.click();

         String afterClickButtonText = button1.getText();
         System.out.println("After click inside frame button text: " + afterClickButtonText);

        //Click Me (Inside Nested frame) **interview point-we can't switch between frame in selenium. first need to switchback to default page (main html page
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After click inside Nested frame button text: " + afterClickNestedFrameButtonText);

        //How many frames in this page?
        driver.switchTo().defaultContent();
        List<WebElement> getFrameTagCount = driver.findElements(By.tagName("iframe"));
        int size = getFrameTagCount.size();
        System.out.println("iFrame tag count: " + size);







    }
}
