import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class linkExample{

    WebDriver driver;
    @BeforeMethod
    public void openLinkListPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.google.com/");
        driver.get("https://www.leafground.com/link.xhtml");
        //driver.navigate().to("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){

        // 1)Take me to the dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //2) find my destination

        WebElement  whereTogo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereTogo.getAttribute("href");
        System.out.println("This link is going to:" + path);

        //3) Am i broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This is a broken link");
        }else {
            System.out.println("This is not a  broken link");

        }
        driver.navigate().back();

        //4) Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //5) count page links
        List<WebElement> countPageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countPageLinks.size();
        System.out.println("Count of full page links:" + pageLinkCount);


        //count layout Links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks =layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links:" + countOfLayoutLinks.size());












    }
}
