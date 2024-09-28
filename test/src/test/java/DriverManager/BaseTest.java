package DriverManager;

import Pages.*;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Page page;
    protected LoginPage lp;
    protected HomePage hp;
    protected CheckoutPage chp;
    protected GridPage grp;
    protected SearchPage sp;
    PlaywrightFactory play;
    @BeforeClass
    @Parameters({ "appURL", "browserType" })
    public void setUp(String appURL, String browserType) {
        play = new PlaywrightFactory();
        page = play.getPage(appURL, browserType);
        lp = new LoginPage(page);
    }
    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }
}
