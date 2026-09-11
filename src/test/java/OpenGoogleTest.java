//import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OpenGoogleTest {



    @Test
    public void GoogleTest() throws AWTException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String originalWindow = driver.getWindowHandle();
        driver.navigate().to("https://selenium.dev");


        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.navigate().refresh();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(originalWindow);

        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        System.out.println(size.getHeight());
        System.out.println(size.getWidth());
        int width1 = (int) size.getWidth();
        int height1 = (int) size.getHeight();

        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        Point position = driver.manage().window().getPosition();
        //int x1 = position.getX();
        //int y1 = position.getY();

        driver.manage().window().setPosition(new Point(500, 500));

        driver.manage().window().maximize();

        driver.manage().window().minimize();

        driver.manage().window().fullscreen();

        // Take a screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "web_page.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        Robot robot = new Robot();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);

        BufferedImage screenshot = robot.createScreenCapture(rectangle);

        File screenshotFile = new File(
                System.getProperty("user.dir") + "\\ScreenShot\\web_page1.png"
        );

        try {
            ImageIO.write(screenshot, "png", screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        driver.quit();

    }
}
