package org.sampleProject;


import org.BaseTestConfig.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    @Test
    public void errorLogInValidation() throws IOException {

       ProductCatalog prodCatlog = loginAction.LoginMethod("manoj.t@gmail.com","Mano@1716");
       Assert.assertEquals( "Incorrect email or password.",loginAction.getErrorMEssage());
    }

    @Test
    public void errorProductValidations() throws IOException {

        String productName = "ZARA COAT 3";
        String countryName = "India";

        ProductCatalog prodCatlog = loginAction.LoginMethod("manoj.t@gmail.com", "Manoj@1716");
        prodCatlog.getProductList();
        prodCatlog.getProductByName(productName);
        prodCatlog.addProductToCart(productName);
        CartPage cartPageList = prodCatlog.cartPageListPage();
        Assert.assertTrue(cartPageList.getMatch(productName));
    }
}
