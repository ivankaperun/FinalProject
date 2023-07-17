package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public ShopWomanPage getShopWomanPage() {
        return new ShopWomanPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public ShopManPage getShopMenPage() {
        return new ShopManPage(driver);
    }

    public MenAdidasPage getMenAdidasPage() {
        return new MenAdidasPage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver);
    }
}
