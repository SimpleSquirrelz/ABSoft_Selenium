import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest{

    @Test
    public void checkStandardUserAuthorizationWithInvalidCredentials(){
        String userName = "standard_user";
        String password = "123";
        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";

        String actualErrorText = authorizationPage.openPage()
                .enterUserName(userName)
                .enterPassword(password)
                .clickSubmitButton()
                .errorMessageText();
        assertEquals(actualErrorText, expectedErrorText);
    }

    @Test
    public void checkBlockedUserAuthorization(){
        String userName = "locked_out_user";
        String password = "secret_sauce";
        String expectedErrorText = "Epic sadface: Sorry, this user has been locked out.";

        String actualErrorText = authorizationPage.openPage()
                .enterUserName(userName)
                .enterPassword(password)
                .clickSubmitButton()
                .errorMessageText();
        assertEquals(actualErrorText, expectedErrorText);
    }
}
