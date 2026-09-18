package WebPages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {

    WebDriver driver;

    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openJSExecutorPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecutorTests() throws InterruptedException {

        jsExecutor = (JavascriptExecutor) driver;

        //Get an Alert Box in to Web page using javaScriptExecutor
        jsExecutor.executeScript("alert('My name is Test');");

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert text: " + alert.getText());

        alert.accept();



        //Set an input value in a text box using javascriptExecutor

        // way 1-> set the value using the value property ( common approach)
        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        //jsExecutor.executeScript("arguments[0].value='John';",inputNameTextBox);

        // way 2-> set the value using setAttribute (alternative approach)
        jsExecutor.executeScript("arguments[0].setAttribute('value', 'John');", inputNameTextBox);

        Thread.sleep(4000);


        //Highlight element
        jsExecutor.executeScript(
                "arguments[0].style.border='3px solid red';",
                inputNameTextBox
        );

        jsExecutor.executeScript(
                "arguments[0].style.background='yellow';",
                inputNameTextBox
        );
        Thread.sleep(4000);

        //Click element using javascriptExecutor
        WebElement maleCheckbox = driver.findElement(By.xpath("//input[@id='male']"));

        jsExecutor.executeScript("arguments[0].click();", maleCheckbox);
        Thread.sleep(4000);

        //Get all attributes from a wanted element
        getAllAttributes(inputNameTextBox);

        jsExecutor.executeScript("location.reload();");

        jsExecutor.executeScript("document.body.style.zoom='150%';");


        //Zooming page
        jsExecutor.executeScript("document.body.style.zoom='120%';");
        Thread.sleep(4000);

        //Refresh page using javascriptExecutor
        jsExecutor.executeScript("location.reload();");
        Thread.sleep(4000);

    }
    public void scrollPage() throws InterruptedException {
        //scroll to some position
         jsExecutor.executeScript("window.scrollTo(0,1000)");

         System.out.println("current page Y offset value is: " + jsExecutor.executeScript("window.scrollTo(0,1000)") );

         jsExecutor.executeScript("window.scrollTo(0,-1000)");
         Thread.sleep(4000);

        //scroll to bottom of the page by pixel
        jsExecutor.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
        Thread.sleep(4000);


        //scroll to the top of the page
        jsExecutor.executeScript(
                "window.scrollTo(0, 0);"
        );
        Thread.sleep(4000);

        //scroll the page till element visible
        WebElement genderText = driver.findElement(By.xpath("//label[text()='Gender:']"));

        jsExecutor.executeScript(
                "arguments[0].scrollIntoView(true);",
                genderText
        );
        Thread.sleep(4000);


    }

    public String getAllAttributes(WebElement webElement) {
        Object elementAttributes = jsExecutor.executeScript(
                "var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
                webElement);
        Assert.assertNotNull(elementAttributes);
        System.out.println("All Attribute value are : " + elementAttributes.toString());
        return elementAttributes.toString();
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
