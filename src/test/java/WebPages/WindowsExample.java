package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsExample {

    WebDriver driver;
    @BeforeMethod
    public void windowTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void windowsHandleTests() throws InterruptedException {
        //Click and Confirm new Window Opens

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + oldWindow);


        WebElement openWindow = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        openWindow.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handle size:" + handles.size());

        //first method - using forEach loop
        /*

        for(String newWindow :handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("page tile is: " + driver.getTitle());
        }

        driver.close();

        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean openButtonVisibility = openButton1.isDisplayed();
        System.out.println("Open Button Visibility: " + openButtonVisibility);

         */

        //second method-using switch
        List<String> list = new ArrayList<String>(handles); //converting Set to List
        if(list.size() >1){
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is:" + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);

            WebElement openButton1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
            boolean openButtonVisibility = openButton1.isDisplayed();
            System.out.println("Open Button Visibility: " + openButtonVisibility);


        }

        //Find the number of opened tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiWindowButton.click();
        Thread.sleep(3000);
        Set<String> multiWindows = driver.getWindowHandles();
        int howManyWindows = multiWindows.size();
        System.out.println("No of windows opened: " + howManyWindows);

        //Close all windows except Primary
        WebElement closeWindowButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        closeWindowButton.click();
        Thread.sleep(3000);
        Set<String> newWindowsHandle = driver.getWindowHandles();
        for(String allWindows :newWindowsHandle){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
