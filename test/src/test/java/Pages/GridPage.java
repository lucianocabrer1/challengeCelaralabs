package Pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.Map;

public class GridPage {
    Page page;
    private String grid="[id='menu']";

    public GridPage(Page page) {
        this.page=page;
    }
    public void chechProduct (Map<String,String> product) {
        int size = page.locator(grid).locator("div").count(),
            position = Integer.parseInt(product.get("position"));

        String gridObject = "//*[@id=\"menu\"]/div[@class=\"item\"]/label[text()=" + position,
                aux1 = "]/following-sibling::p[@id=\"item-price\"]",
                aux2 = "]/following::h4/b[text()=\"Super Pepperoni\"]";

        if(position <= size){
            assertThat(page.locator(gridObject + aux1)).containsText(product.get("price"));
            assertThat(page.locator(gridObject + aux2)).containsText(product.get("product"));
        }

    }

    public void checkAllProducts(){
        int size = page.locator(grid).locator("div").count();
        String gridObject = "//label[@data-test-id='card-number' and text()=",
                aux1 = "]/following-sibling::p[@id=\"item-price\"]",
                aux2 = "]/following-sibling::h4[@data-test-id='item-name']/b",
                aux3 = "]/following-sibling::button[@class=\"btn\"]",
                aux4 = "]/following-sibling::img";

        //label[@data-test-id='card-number' and text()='4']/following-sibling::h4[@data-test-id='item-name']
        for(int i = 1; i <= size; i++){
            /** Price **/
            Assert.assertNotNull(page.locator(gridObject + i + aux1).innerText());
            /** Product **/
            Assert.assertNotNull(page.locator(gridObject + i + aux2).innerText());
            /** Button **/
            Assert.assertNotNull(page.locator(gridObject + i + aux3).innerText());
            /**Image**/
            Assert.assertNotNull(page.locator(gridObject + i + aux4));
        }
    }
}
