package org.sampleProject;


import org.BaseTestConfig.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MainTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String,String> input) throws IOException {

        String productName = "ZARA COAT 3";
        String countryName = "India";

//      ProductCatalog prodCatlog = new ProductCatalog(driver);  Instead of creating object for eah class, we're returning the object from previous page
//        CartPage cartPageList = new CartPage(driver);
//       CheckOutPage checkOutPageList = new CheckOutPage(driver);


       ProductCatalog prodCatlog = loginAction.LoginMethod(input.get("email"), input.get("password"));
       prodCatlog.getProductList();
       prodCatlog.getProductByName(input.get("product"));
       prodCatlog.addProductToCart(input.get("product"));
       CartPage cartPageList = prodCatlog.cartPageListPage();
       Assert.assertTrue(cartPageList.getMatch(input.get("product")));
       CheckOutPage checkOutPageList = cartPageList.clickOnBuyButton();
       checkOutPageList.selectCountry(countryName);
//       checkOutPageList.placeOrder();
    }
    @DataProvider
    public Object[][] getData() throws IOException
    {


        List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\Manoj.t\\IdeaProjects\\untitled1\\src\\main\\java\\org\\Resources\\DataProviderTest.json");
        return new Object[][]  {{data.get(0)}, {data.get(1) } };

    }




//	 @DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//
//	  }
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "anshika@gmail.com");
//	map.put("password", "Iamking@000");
//	map.put("product", "ZARA COAT 3");
//
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");

}
