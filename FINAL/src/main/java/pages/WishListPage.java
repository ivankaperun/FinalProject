package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='header_2Vu6Z']")
    private WebElement wishListHeader;

    public WebElement getWishListHeaderElement() {
        return wishListHeader;
    }

    public String  getWishListHeader() {
        return wishListHeader.getText();
    }
}
