package Test;

import DriverManager.BaseTest;
import Pages.GridPage;
import Pages.HomePage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GridEmptyTest extends BaseTest {
    @Test
    public void GridEmptyTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);
        hp = new HomePage(page);
        hp.goToGrid();

        grp = new GridPage(page);
        grp.checkAllProducts();
    }

}
