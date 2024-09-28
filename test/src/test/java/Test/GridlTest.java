package Test;

import DriverManager.BaseTest;
import Pages.CheckoutPage;
import Pages.GridPage;
import Pages.HomePage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GridlTest extends BaseTest {
    @Test
    public void GridlTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);
        hp = new HomePage(page);
        hp.goToGrid();

        Map<String,String> product = new HashMap<>();
        product.put("product", "Super Pepperoni");
        product.put("price", "$10");
        product.put("position", "7");

        grp = new GridPage(page);
        grp.chechProduct(product);
    }

}
