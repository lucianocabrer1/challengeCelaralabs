package Test;

import DriverManager.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginFailedTest extends BaseTest {
    @Test
    public void LoginFailedTest(){
        Map<String, String> user = new HashMap<>();

        user.put("user", "123");
        user.put("pass", "123");
        user.put("loginFlag", "failed");

        lp.Logih(user);

    }

}
