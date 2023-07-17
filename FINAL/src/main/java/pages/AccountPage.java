package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='WkTCjySeTZVCmsExD5tWL']")
    private WebElement accountPageHeader;

    public String getAccountPageHeaderText(){
        return accountPageHeader.getText();
    }

    public WebElement getAccountPageHeader() {
        return accountPageHeader;
    }
}
