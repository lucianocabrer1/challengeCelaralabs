package Pages;

import com.microsoft.playwright.Page;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    Page page;
    private String checkout ="//a[@href=\"/checkout\"]";
    private String grid ="//a[@href=\"/grid\"]";
    private String search ="//a[@href=\"/search\"]";
    public HomePage(Page page) {
        this.page=page;
    }
    public void goToCheckout(){
        page.locator(checkout).click();
        assertThat(page).hasURL("http://localhost:3100/checkout");
    }
    public void goToGrid(){
        page.locator(grid).click();
        assertThat(page).hasURL("http://localhost:3100/grid");
    }
    public void goToSearch(){
        page.locator(search).click();
        assertThat(page).hasURL("http://localhost:3100/search");
    }
}
