package org.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sampleProject.CartPage;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cartButton;



    public void waitForElementToAppear(By element){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated((element)));
}
    public void waitForElementToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForWebElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public CartPage cartPageListPage()
    {
        cartButton.click();
        return new CartPage(driver);

    }

}
