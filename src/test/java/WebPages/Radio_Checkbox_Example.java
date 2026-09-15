package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_Checkbox_Example {

    WebDriver driver;
    @BeforeMethod
    public void radio_checkboxTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(3000);
    }
    @Test
    public void radioTests(){
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeRadioOption){
            String chromeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is: " + chromeTest);
        } else if (firefoxRadioOption) {
            String firefoxTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is: " + firefoxTest);
        } else if (safariRadioOption) {
            String safariTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is: " + safariTest);
        }else if (edgeRadioOption){
            String edgeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is: " + edgeTest);
        }

        //Select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            //myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for ='j_idt87:age:0']")).click();
        }

    }

    @Test
    public void checkBoxTests(){
        //<<<<CheckBox>>>>
        // select wanted checkboxes and verifying those checkboxes selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element:checkBoxList){
            if (!(element.getText().equals("Others"))){
                element.click();
            }

        }

        for (int i =1; i<= checkBoxList.size();i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("CheckBox " +i+ " Selected status is: " + checkBoxStatus);

        }



    }
}
