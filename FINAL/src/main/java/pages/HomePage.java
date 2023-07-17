package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement accountIcon;

    @FindBy(xpath = "//a[@class='yPAUReS IAtMKef _2LRr-ij CjZA9Ep']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement manTab;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/ASOS/']")
    private WebElement facebookIcon;

    @FindBy(xpath = "//a[@href='https://www.instagram.com/asos/']")
    private WebElement instagramIcon;

    @FindBy(xpath = "//a[@href='https://www.snapchat.com/add/asosfashion']")
    private WebElement snapchatIcon;

    @FindBy(xpath = "//div[@class='_3hSCfS2']")
    private WebElement accountPopup;

    public void openHomePage(String url) {
        driver.get(url);
    }

   public void isSearchInputVisible() {
        searchInput.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickOnManTab() {
        manTab.click();
    }

    public void clickOnAccountIcon() {
        actions.moveToElement(accountIcon).perform();
    }

    public WebElement getAccountPopup(){
        return accountPopup;
    }

    public void clickOnAccountLink(){
        myAccountLink.click();
    }
}
