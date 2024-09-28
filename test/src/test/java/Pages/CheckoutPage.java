package Pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutPage {
    Page page;
    private String fullName="[id='fname']";
    private String email="[id='email']";
    private String address="[id='adr']";
    private String city="[id='city']";
    private String state="[id='state']";
    private String zip="[id='zip']";
    private String creditCardName="[id='cname']";
    private String creditCardNumber="[id='ccnum']";
    private String expMonth="[id='expmonth']";
    private String expYear="[id='expyear']";
    private String cvv="[id='cvv']";
    private String shipping="[name='sameadr']";
    private String continueCheckout="[class='btn']";
    public CheckoutPage(Page page) {
        this.page=page;
    }
    public void fillForm (Map<String,String> data) {
        if(data.get("shipping").equals("yes")){
            page.locator(fullName).fill(data.get("nyap"));
            page.locator(email).fill(data.get("email"));
            page.locator(address).fill(data.get("address"));
            page.locator(city).fill(data.get("city"));
            page.locator(state).fill(data.get("state"));
            page.locator(zip).fill(data.get("zip"));
            page.locator(creditCardName).fill(data.get("creditCardName"));
            page.locator(creditCardNumber).fill(data.get("creditCardNumber"));
            //page.locator(expMonth).fill(data.get("expMonth"));
            page.locator(expMonth).selectOption(data.get("expMonth"));
            page.locator(expYear).fill(data.get("expYear"));
            page.locator(cvv).fill(data.get("cvv"));
            page.locator(shipping).setChecked(true);
            page.locator(continueCheckout).click();
            String orderNumber = page.locator("//p").innerText().split("Order Number: ")[1];
            Assert.assertNotNull(orderNumber);
        }else {
            page.locator(fullName).fill(data.get("nyap"));
            page.locator(email).fill(data.get("email"));
            page.locator(address).fill(data.get("address"));
            page.locator(city).fill(data.get("city"));
            page.locator(state).fill(data.get("state"));
            page.locator(zip).fill(data.get("zip"));
            page.locator(creditCardName).fill(data.get("creditCardName"));
            page.locator(creditCardNumber).fill(data.get("creditCardNumber"));
            //page.locator(expMonth).fill(data.get("expMonth"));
            page.locator(expMonth).selectOption(data.get("expMonth"));
            page.locator(expYear).fill(data.get("expYear"));
            page.locator(cvv).fill(data.get("cvv"));
            page.locator(shipping).setChecked(false);
            page.locator(continueCheckout).click();
            page.onDialog(dialog -> dialog.accept());
        }
    }

    public void checkPrice(){
        String aux1 = "//*[@class=\"col-25\"]/div[@class=\"container\"]/p",
               aux2 = "/a[text()=\"Product ",
               aux3 = "[text()=\"Total \"]/span[@class='price']",
               aux4 = "\"]/following-sibling::span[@class='price']";

        int price1 = Integer.parseInt(page.locator(aux1 + aux2 + 1 + aux4).innerText().split("\\$")[1]),
            price2 = Integer.parseInt(page.locator(aux1 + aux2 + 2 + aux4).innerText().split("\\$")[1]),
            price3 = Integer.parseInt(page.locator(aux1 + aux2 + 3 + aux4).innerText().split("\\$")[1]),
            price4 = Integer.parseInt(page.locator(aux1 + aux2 + 4 + aux4).innerText().split("\\$")[1]),
            expTotal = Integer.parseInt(page.locator(aux1 + aux3).innerText().split("\\$")[1]);

        int total = price1 + price2 + price3 + price4;

        Assert.assertEquals(total, expTotal);
    }
}
