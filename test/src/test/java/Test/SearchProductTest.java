package Test;

import DriverManager.BaseTest;
import Pages.HomePage;
import Pages.SearchPage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SearchProductTest extends BaseTest {
    @Test
    public void SearchProductTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);
        hp = new HomePage(page);
        hp.goToSearch();

        sp = new SearchPage(page);
        sp.searchProduct("Super Pepperoni");
    }

}
