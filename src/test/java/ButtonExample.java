import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;
    @BeforeMethod
    public void buttonTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        //driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void buttonTests(){

        //Click and Confirm title.
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        /*
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual title same as expected");
        }else {
            System.out.println("Actual title is not same as expected");
        }*/
        Assert.assertEquals(actualTitle, expectedTitle, "Title missed matched");
        driver.navigate().back();

        //Confirm if the button is disabled.
        boolean disabled =driver.findElement(By.name("j_idt88:j_idt92")).isEnabled();
        System.out.println("Is Button is enabled:" + disabled);


        //Find the position of the Submit button
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y= xyPoint.getY();
        System.out.println("X position is: " + x + " Y position is: " +y);

        //Find the Save button color
        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("Button colour is: "+ colour);

        //Find the height and width of this button
        WebElement size= driver.findElement(By.id("j_idt88:j_idt98"));
        int height =size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height :" + height + " Width: " + width);


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
