package Test;

import DriverManager.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginEmptyTest extends BaseTest {
    @Test
    public void LoginEmptyTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "");
        user.put("pass", "");
        user.put("loginFlag", "empty");

        lp.Logih(user);

    }

}
