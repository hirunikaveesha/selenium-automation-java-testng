import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class KeyboardActionExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardActionTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    @Test
    public void keyboardActionTests1() throws InterruptedException {
        //Handle Keyboard Actions in Selenium WebDriver
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("welcome");

        Actions actions = new Actions(driver);

        //1.select the text
        //1st option
        Action storingBuildOperation = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        storingBuildOperation.perform();


        //2nd option
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);


        //2. To write in capital in a text box

        //1st option
        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys("x")
                .perform();



        //2nd option
        Actions actions1 = new Actions(driver);
        actions1.keyDown(googleSearchTextBox, Keys.SHIFT)
                .sendKeys("learn with Hiruni")
                .perform();
    }


    @Test
    public void keyboardActionTests2() throws InterruptedException {
        //Perform Multi Select Actions in Selenium WebDriver (Working with Selectable)
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is: " + selectable);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();


    }

}