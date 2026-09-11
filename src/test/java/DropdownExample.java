import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExample {
    WebDriver driver;
    @BeforeMethod
    public void dropdownTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(3000);
    }

    @Test
    public void dropdownTests() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml");

        //ways of select values in basic dropdown
        WebElement  dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //get the number of the dropdown options
        //generics
        List<WebElement> listOfOptions =  select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of element in dropdown:" + size);
        for (WebElement element: listOfOptions){
            System.out.println(element.getText());
        }

        //using sendKeys select dropdown values
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //selecting value from bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listOfDropdown = driver.findElements(By.xpath("//ul[@id ='j_idt87:country_items']/li"));
        for (WebElement element2 :listOfDropdown){
            String dropdownValue = element2.getText();
            if (dropdownValue.equals("USA")){
                element2.click();
                break;
            }

        }
    }
    @Test
    public void googleDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        //google search - pick a value from suggestions
        driver.findElement(By.name("q")).sendKeys("Palitha");
        Thread.sleep(3000);
        List<WebElement> googleSearchList =driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d WggQGd']"));
        System.out.println(googleSearchList.size());
        for (WebElement element :googleSearchList){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("Palitha Thewarapperuma")){
                element.click();
                break;
            }

        }
        //handle hidden auto suggestions from dropdown and search using DOM debugger trick




    }


}
