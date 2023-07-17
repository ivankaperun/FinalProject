package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopManPage extends BasePage{
    public ShopManPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")
    private WebElement shoesButton;

    @FindBy(xpath = "//li[@class='_3QF73Dj']")
    private List<WebElement> selectBrand;

    public void selectCategory() {
        actions.moveToElement(shoesButton).perform();
    }

    public WebElement getCategoryList() {
        return selectBrand.get(53);
    }

    public void clickOnSelectedBrand() {
        selectBrand.get(53).click();
    }
}
