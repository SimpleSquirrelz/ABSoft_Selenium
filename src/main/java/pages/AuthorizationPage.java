package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage extends BasePage{

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private final By userNameField = By.id("user-name");
    private final By loginField = By.id("password");
    private final By submitButton = By.id("login-button");
    private final By errorMessageContainer = By.className("error-message-container");


    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

    public AuthorizationPage enterUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public AuthorizationPage enterPassword(String password){
        driver.findElement(loginField).sendKeys(password);
        return this;
    }

    public String errorMessageText(){
        return driver.findElement(errorMessageContainer).getText();
    }

    public AuthorizationPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return this;
    }

    @Override
    public AuthorizationPage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
