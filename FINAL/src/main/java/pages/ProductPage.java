package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

//    @FindBy(xpath = "//span[contains(text(), 'Add to bag')]")
//    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement selectSizeErrorMessage;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//option[contains(text(), 'EU 38 2/3')]")
    private WebElement sizeOption;

    @FindBy(xpath = "//option[contains(text(), 'EU 34')]")
    private WebElement clothSizeOption;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement miniCartIcon;

//    @FindBy(xpath = "//a[@class='_1TlOB9h _2tvh469 _12h15d-']")
    @FindBy(xpath = "//div[@id='minibag-dropdown']//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement viewCartPopUp;

    @FindBy(xpath = "//a[@class='bag-total-button bag-total-button--checkout bag-total-button--checkout--total']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@id='minibag-dropdown']//span[@class='_1xgEXu7 -rhP1cz gBrrjX4 _2nHArcS']")
    private WebElement closePopup;

    public WebElement getAddToBagButton(){
        return addToBagButton;
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public WebElement getErrorMessage() {
        return selectSizeErrorMessage;
    }

    public String getErrorMessageText(){
        return selectSizeErrorMessage.getText();
    }

    public void clickOnSizeDropdown() {
        selectSizeDropdown.click();
    }

    public void clickOnSize() {
        sizeOption.click();
    }

    public void selectClothSize() {
        clothSizeOption.click();
    }

    public void hoverOnMiniCartIcon() {
        actions.moveToElement(miniCartIcon).perform();
    }

    public WebElement getMiniCartIcon() {
        return miniCartIcon;
    }

    public void clickOnViewBagButton(){
//        actions.moveToElement(viewBagButton).pause(500).click().build().perform();
        viewBagButton.click();
    }

    public WebElement getViewCartPopUp() {
        return viewCartPopUp;
    }

    public void clickClosePopup(){
        closePopup.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
