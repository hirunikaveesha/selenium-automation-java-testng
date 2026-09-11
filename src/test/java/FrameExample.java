import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
         WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
         button1.click();

         String afterClickButtonText = button1.getText();
         System.out.println("After click inside frame button text: " + afterClickButtonText);



    }
}
