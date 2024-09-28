package Test;

import DriverManager.BaseTest;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTest extends BaseTest {
    @Test
    public void CheckoutTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);
        hp = new HomePage(page);
        hp.goToCheckout();

        Map<String, String> data = new HashMap<>();
        data.put("nyap", "Luciano Emanuel Cabrera");
        data.put("city", "Buenos Aires");
        data.put("address", "fake street 123");
        data.put("email", "luciano@luciano.com");
        data.put("creditCardName", "Luciano E. Cabrera");
        data.put("creditCardNumber", "1111222233334444");
        data.put("expMonth", "December");
        data.put("expYear", "2026");
        data.put("cvv", "123");
        data.put("state", "Buenos Aires");
        data.put("zip", "1111");
        data.put("shipping", "yes");

        chp = new CheckoutPage(page);
        chp.fillForm(data);
    }

}
