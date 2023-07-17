package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenAdidasPage extends BasePage{
    public MenAdidasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='_1hVpqlz']")
    private WebElement mainHeader;

//    @FindBy(xpath = "//button[@type='button']")
//private List<WebElement> addToWishListIcon;
    @FindBy(xpath = "//article[@id='product-24090014']//button[@aria-label='Save for later']")
    private WebElement addToWishListIcon;

    @FindBy(xpath = "//span[@type='heartUnfilled']")
    private WebElement wishListIcon;

    @FindBy(xpath = "//article[@id='product-200909504']")
    private WebElement selectedProduct;

    public String getMainHeader(){
        return mainHeader.getText();
    }

    public void clickOnAddToWishListIcon() {
        addToWishListIcon.click();
    }

    public WebElement getAddToWishListIcon(){
        return addToWishListIcon;
    }

    public void clickOnWishListIcon(){
        wishListIcon.click();
    }

    public void clickOnSelectedProduct(){
        selectedProduct.click();
    }
}
