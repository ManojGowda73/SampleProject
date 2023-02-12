package org.sampleProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {

        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        WebElement loginId = driver.findElement(By.id("userEmail"));
        WebElement loginPassword = driver.findElement(By.id("userPassword"));
        WebElement loginButton = driver.findElement(By.id("login"));

        loginId.sendKeys("manoj.t@gmail.com");  //Enter User Email
        loginPassword.sendKeys("Manoj@1716");   //Enter User email password
        loginButton.click();    // Click on Login button
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='mb-3']")));

        List<WebElement> products = driver.findElements(By.cssSelector("[class*='mb-3']"));

       WebElement prod =  products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

       WebElement prod01 = prod.findElement(By.cssSelector("[class='card-body'] button:last-of-type"));
       prod01.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        WebElement cartButton = driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']"));
        cartButton.click();
        List<WebElement> cartProducts = driver.findElements(By.cssSelector("[class='cartSection'] h3"));
        boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equals(productName));
        Assert.assertTrue(match);

          driver.findElement(By.cssSelector("[class='cartSection removeWrap'] button:first-child")).click();
//        driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
//        driver.findElement(By.cssSelector(".totalRow button")).click();
//        checkOutButton.click();

        WebElement country = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
        country.sendKeys("india");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='ta-results list-group ng-star-inserted']"))));

        List<WebElement> countryValues = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));

        for(WebElement countryValue : countryValues){
             if(countryValue.getText().equals("India")){
                countryValue.click();
                break;
            }
        }

//       WebElement countryValue = countryValues.stream().filter(value-> value.getText().contains("india"));
////
//       countryValue.click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='actions']/descendant::a"))));

       driver.findElement(By.xpath("//div[@class='actions']/descendant::a")).click();

    }

}
