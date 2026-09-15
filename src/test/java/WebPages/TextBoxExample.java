package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;
    @BeforeMethod
    public void textboxTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){
        //Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Test123");

        //Append Country to this City.
        WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("India");

        //Verify if text box is disabled
        boolean enabled =driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Txt Box enabled:" + enabled);

        //Clear the typed text.
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed text.
        WebElement textRetrieve = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textRetrieve.getAttribute("value");
        System.out.println(value);

        //Type email and Tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("test123@gmail.com" + Keys.TAB + "Confirm control moved to next element");



    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
