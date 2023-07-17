package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='bag-total-button bag-total-button--checkout bag-total-button--checkout--total']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement miniCartIcon;

    @FindBy(xpath = "//h1[contains(text(), 'MY BAG')]")
    private WebElement cartHeader;

    public boolean isCheckoutButtonVisible(){
        return checkoutButton.isDisplayed();
    }

    public WebElement getMiniCartIcon(){
        return miniCartIcon;
    }

    public String getCartAmount() {
        return miniCartIcon.getText();
    }

    public String getCartHeaderText(){
        return cartHeader.getText();
    }

    public WebElement getCartHeader() {
        return cartHeader;
    }
}
