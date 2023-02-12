package org.sampleProject;

import org.Utilities.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cartButton;

    @FindBy(css = "[class='cartSection'] h3")
    List<WebElement> cartProducts;

    @FindBy(css = "[class='cartSection removeWrap'] button:first-child")
    WebElement buyButton;


//     driver.findElement(By.xpath("//div[@class='actions']/descendant::a")).click();
// New line


    public boolean getMatch(String productName){
//        List<WebElement> cartProductsNew = cartProducts;
        boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equals(productName));
        return match;
    }

    public CheckOutPage clickOnBuyButton(){
        buyButton.click();
        return new CheckOutPage(driver);
    }

}
