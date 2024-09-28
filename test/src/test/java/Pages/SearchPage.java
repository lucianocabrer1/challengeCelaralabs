package Pages;

import com.microsoft.playwright.Page;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPage {
    Page page;
    private String search="//input";
    private String submit="//button";
    private String result="[id='result']";

    public SearchPage(Page page) {
        this.page=page;
    }
    public void searchProduct (String product) {
        String rtdo = "Found one result for " + product;

        if(product.equals("")){
            page.locator(search).fill(product);
            page.locator(submit).click();
            assertThat(page.locator(result)).containsText("Please provide a search word.");
        }else {
            page.locator(search).fill(product);
            page.locator(submit).click();
            assertThat(page.locator(result)).containsText(rtdo);
        }
    }
}
