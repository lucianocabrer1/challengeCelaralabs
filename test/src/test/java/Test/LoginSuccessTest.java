package Test;

import DriverManager.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginSuccessTest extends BaseTest {
    @Test
    public void LoginSuccessTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "johndoe19");
        user.put("pass", "supersecret");
        user.put("loginFlag", "passed");

        lp.Logih(user);

    }

}
