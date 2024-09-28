package Pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.asserts.Assertion;

import java.util.Map;

public class LoginPage {
    Page page;
    private String username="[id='username']";
    private String password="[id='password']";
    private String signIn="[id='signin-button']";
    private String error="[id='message']";
    public LoginPage(Page page) {
        this.page=page;
    }
    public void Logih (Map<String,String> user) {
        switch (user.get("loginFlag")){
            case "passed":
                page.locator(username).fill(user.get("user"));
                page.locator(password).fill(user.get("pass"));
                page.locator(signIn).click();
                assertThat(page).hasURL("http://localhost:3100/home");
                break;
            case "failed":
                page.locator(username).fill(user.get("user"));
                page.locator(password).fill(user.get("pass"));
                page.locator(signIn).click();
                assertThat(page.locator(error)).containsText("Wrong credentials");
                break;
            case "empty":
                page.locator(username).fill(user.get("user"));
                page.locator(password).fill(user.get("pass"));
                page.locator(signIn).click();
                assertThat(page.locator(error)).containsText("Fields can not be empty");
        }

    }
}
