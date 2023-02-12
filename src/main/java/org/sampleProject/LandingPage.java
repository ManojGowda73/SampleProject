package org.sampleProject;

import org.Utilities.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="userEmail")
    WebElement loginId;

    @FindBy(id="userPassword")
    WebElement loginPassword;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(xpath="//div[@id='toast-container']/descendant::div")
    WebElement errorMessage;


    public void goTO(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/client");
    }
    // Login Method
   public ProductCatalog LoginMethod(String username, String password){
       loginId.sendKeys(username);
       loginPassword.sendKeys(password);
       loginButton.click();
       return new ProductCatalog(driver);
   }

   public String getErrorMEssage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
   }


}
