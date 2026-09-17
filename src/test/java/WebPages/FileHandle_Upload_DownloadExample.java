package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Driver;
import java.time.Duration;

public class FileHandle_Upload_DownloadExample {
    WebDriver driver;

    @BeforeMethod
    public void openFilesTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void fileDownloadTests() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        WebElement downloadButton = driver.findElement(By.xpath("//button[@id='j_idt93:j_idt95']"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\Naviru\\Downloads");
        File[] totalFiles = file.listFiles();

        Assert.assertNotNull(totalFiles);
        for (File findFile :totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("file is downloaded");
                break;
            }
        }
    }

    @Test
    public void fileUploadTests() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        WebElement uploadFile = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadFile.click();

        //windows control begin
        String data = "C:\\Users\\Naviru\\Downloads\\TestLeaf Logo.png";
        StringSelection selection = new StringSelection(data);
        //copying path to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //2nd way - Using Send Keys (Applicable only element type is file)

        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys("data");
    }
/*
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/


}
