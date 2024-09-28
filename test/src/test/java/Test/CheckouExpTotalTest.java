package Test;

import DriverManager.BaseTest;
import Pages.CheckoutPage;
import Pages.HomePage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckouExpTotalTest extends BaseTest {
    @Test
    public void CheckouExpTotalTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);
        hp = new HomePage(page);
        hp.goToCheckout();

        chp = new CheckoutPage(page);
        chp.checkPrice();
    }

}
