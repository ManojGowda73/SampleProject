package org.sampleProject;

import org.Utilities.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends AbstractComponents {

    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
    List<WebElement> countryValues;

    @FindBy(xpath = "//div[@class='actions']/descendant::a")
    WebElement placeorderButton;

    By listOfCountry = By.cssSelector("[class='ta-results list-group ng-star-inserted']");


    public void selectCountry(String countryName){
          country.sendKeys("ind");
          waitForElementToAppear(listOfCountry);
          for(WebElement countryValue : countryValues){
              if(countryValue.getText().equals(countryName)){
                  countryValue.click();
                  break;
              }
          }
      }

      public void placeOrder(){
      waitForElementToClickable(placeorderButton);
      placeorderButton.click();

      }

}
