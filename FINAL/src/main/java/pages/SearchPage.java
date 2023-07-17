package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//article[@id='product-201438032']")
    private WebElement productFromSearch;

    @FindBy(xpath = "//div[@class='_2pwX7b9']")
    private WebElement sortButton;

    @FindBy(xpath = "//li[@id='plp_web_sort_whats_new']")
    private WebElement sortOption;

    @FindBy(xpath = "//h2[contains(text(),'NOTHING MATCHES YOUR SEARCH')]")
    private WebElement searchError;

    @FindBy(xpath = "//article[@id='product-23448855']")
    private WebElement productToBuy;

    public void clickOnProduct() {
        productFromSearch.click();
    }

    public void clickOnSortButton() {
        sortButton.click();
    }

    public void clickOnSortOption() {
        sortOption.click();
    }

    public String getSearchErrorMessage() {
        return searchError.getText();
    }

    public void clickOnProductToBuy() {
        productToBuy.click();
    }
}
