package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopWomanPage extends BasePage{
    public ShopWomanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;


    public void openShopWomanPage(String url) {
        driver.get(url);
    }

    public void enterTextToSearchField(final String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }


}
