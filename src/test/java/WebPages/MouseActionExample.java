package WebPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActionExample {

    WebDriver driver;
    @BeforeMethod
    public void mouseActionTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void mouseActionsTest1() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

       //1) Move to an element operation");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        /*
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
        Thread.sleep(2000);

         */

        //2) Drag and Drop Operation

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way

        actions.dragAndDrop(from,to).perform(); //2nd way

        //3) Slider Operation
        WebElement sliderPoint1 =driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
        System.out.println("location of slider point 1: " + sliderPoint1.getLocation());

        actions.clickAndHold(sliderPoint1)
                .moveByOffset(50, 0)
                .release()
                .perform();
        //actions.dragAndDropBy(sliderPoint1,50,0).perform();


        System.out.println("After moving location of slider point1:" + sliderPoint1.getLocation());
    }

    @Test
    public void mouseActionsTest2() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        //4) Right Click
       WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

       Actions action1 = new Actions(driver);
       //action1.doubleClick() - for double click
       action1.contextClick(rightClickButton).perform();
       driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert shows the text as: " +alertPop.getText());
        alertPop.accept();


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
