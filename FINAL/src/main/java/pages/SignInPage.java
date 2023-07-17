package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    public void enterEmailIntoEmailField(final String email){
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void enterPasswordIntoPasswordField(final String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }
}
