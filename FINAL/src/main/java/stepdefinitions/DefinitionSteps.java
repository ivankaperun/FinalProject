package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ShopWomanPage shopWomanPage;
    ProductPage productPage;
    ShopManPage shopManPage;
    MenAdidasPage menAdidasPage;
    WishListPage wishListPage;
    CartPage cartPage;
    SignInPage signInPage;
    AccountPage accountPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    ////Scenario 1
    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isSearchInputVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Then("User checks that current url contains {string} text")
    public void checkCurrentUrl(final String text) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    /////Second Scenario

    @And("User checks cart icon visibility")
    public void checkCartIconVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isCartIconVisible();
    }

    @When("User clicks on cart icon")
    public void clickOnCartIcon() {
        homePage.clickOnCartIcon();
    }

    ////Third Scenario
    @Given("User open {string} page")
    public void userOpenShopWomanPagePage(final String url) {
        shopWomanPage = pageFactoryManager.getShopWomanPage();
        shopWomanPage.openShopWomanPage(url);
    }

    @When("User makes search by {string}")
    public void userSearchProductByKeyword(final String searchKey) {
        shopWomanPage.enterTextToSearchField(searchKey);
    }

    @And("User clicks on search button")
    public void clicksOnSearchButton() {
        shopWomanPage.clickOnSearchButton();
    }

    @And("User clicks on product")
    public void clickOnProduct() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.clickOnProduct();
    }

    @And("User click on Add to Bag button")
    public void userClickOnAddToBagButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnAddToBagButton();
    }

    @Then("User checks that error Message is {string}")
    public void userChecksErrorMessage(final String error) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getErrorMessage());
        Assert.assertEquals(productPage.getErrorMessageText(), error);
    }

    ////// Scenario 4

    @Then("User clicks on Sort Button")
    public void userClicksOnSortButton() {
        searchPage.clickOnSortButton();
    }

    @And("User select sort option")
    public void userSelectSortOption() {
        searchPage.clickOnSortOption();
    }

    /////Scenario 5

    @When("User clicks on Man Tab")
    public void userClicksOnManTab() {
        homePage.clickOnManTab();
    }

    @Then("User hover on category")
    public void userHoverOnCategory() {
        shopManPage = pageFactoryManager.getShopMenPage();
        shopManPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shopManPage.selectCategory();
    }

    @And("User clicks on selected category")
    public void userClicksOnSelectedBrand() {
        shopManPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shopManPage.getCategoryList());
        shopManPage.clickOnSelectedBrand();
    }

    @Then("User checks that page contains {string} text")
    public void userChecksThatPageContainsHeaderText(final String header) {
        menAdidasPage = pageFactoryManager.getMenAdidasPage();
        Assert.assertEquals(menAdidasPage.getMainHeader(), header);
    }

    @And("User clicks on wishlist icon")
    public void userClicksOnWishlistIcon() {
        menAdidasPage = pageFactoryManager.getMenAdidasPage();
        menAdidasPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        menAdidasPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        menAdidasPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, menAdidasPage.getAddToWishListIcon());
        menAdidasPage.clickOnAddToWishListIcon();
    }

    @And("User goes to Wishlist page")
    public void userGoesToWishlistPage() {
        menAdidasPage = pageFactoryManager.getMenAdidasPage();
        menAdidasPage.clickOnWishListIcon();
    }

    @Then("User checks that page contains {string}")
    public void userChecksThatWishListContainsProducts(final String wishListHeader) {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getWishListHeaderElement());
        Assert.assertEquals(wishListPage.getWishListHeader(), wishListHeader);
    }

    //////Scenario 6
    @Then("User checks that error message is {string}")
    public void userChecksThatErrorMessageIsErrorMessage(final String errMessage) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(searchPage.getSearchErrorMessage(), errMessage);
    }

    /////Scenario 7
    @And("User select some product")
    public void userSelectSomeProduct() {
        menAdidasPage = pageFactoryManager.getMenAdidasPage();
        menAdidasPage.clickOnSelectedProduct();
    }

    @And("User configure product")
    public void userConfigureProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnSizeDropdown();
        productPage.clickOnSize();
    }

    @And("User add product to cart")
    public void userAddProductToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToBagButton());
        productPage.clickOnAddToBagButton();
    }

    @Then("User check that amounts of products in cart is {string}")
    public void checkAmountInCart(final String amount) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getMiniCartIcon());
        Assert.assertEquals(cartPage.getCartAmount(), amount);

    }

    //////Scenario 8

    @Then("User select and click on product")
    public void userSelectAndClickOnProduct() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.clickOnProductToBuy();
    }

    @And("User select size")
    public void userSelectSize() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnSizeDropdown();
        productPage.selectClothSize();
    }

    @When("User hover on mini cart icon")
    public void userHoverOnMiniCartIcon() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getMiniCartIcon());
        productPage.hoverOnMiniCartIcon();
    }

    @And("User clicks on View Bag button")
    public void userClicksOnViewBagButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getViewCartPopUp());
        productPage.clickOnViewBagButton();

    }


    @Then("User checks that cart contains {string}")
    public void userChecksThatCartContainsHeader(final String cartHeader) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,cartPage.getCartHeader());
        Assert.assertEquals(cartPage.getCartHeaderText(), cartHeader);
    }

    /////Scenario 9
    @When("User hover on Account button")
    public void userHoverOnAccountButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnAccountIcon();
    }

    @And("User clicks on My Account link")
    public void userClicksOnMyAccountLink() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getAccountPopup());
        homePage.clickOnAccountLink();
    }

    //////Scenario 10

    @When("User enter {string} into email field")
    public void userEnterEmailIntoEmailField(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterEmailIntoEmailField(email);
    }

    @And("User enter {string} into password field")
    public void userEnterPasswordIntoPasswordField(final String password) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterPasswordIntoPasswordField(password);
    }

    @And("User clicks Sign In button")
    public void userClicksSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickOnSignInButton();
    }

    @Then("User checks that current page contains {string} header")
    public void userChecksThatCurrentPageContainsMyAccountHeader(final String accountHeader) {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        accountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, accountPage.getAccountPageHeader());
        Assert.assertEquals(accountPage.getAccountPageHeaderText(), accountHeader);
    }

    @After
    public void tearDown() {
        driver.close();
    }



}


