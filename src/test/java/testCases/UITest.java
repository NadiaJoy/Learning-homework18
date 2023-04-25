
package testCases;

import helpers.SetupFunctions;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.*;

public class UITest {

    SetupFunctions setupFunctions = new SetupFunctions();

    String baseUrl = setupFunctions.getBaseUrl();
    String login = setupFunctions.getLogin();
    String password = setupFunctions.getPassword();
    String isikukood = setupFunctions.getIsikukood();
    String phone = setupFunctions.getPhone();


    @BeforeEach
    public void setup() {
        open(baseUrl);

    }

    @AfterEach
    public void setDown() {
        closeWebDriver();
    }

    @Test
    public void correctIdSmartIdTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.clickSmartId();

        loginPage.setIdInputForSmartId(isikukood);
        loginPage.clickLoginSmartId();

        loginPage.checkSmartIdPinVisible();
    }

    @Test
    public void correctPhoneAndIdMobileIdTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.clickMobileId();

        loginPage.setPhoneInput(phone);
        loginPage.setIdInputForMobileId(isikukood);

        loginPage.clickLoginMobileId();
        loginPage.checkMobileIdPinVisible();
    }

    //as I don't know correct login and pass, I check that the required fields become visible
    @Test
    public void openLoginPasswordTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.clickPasswordMethod();

        loginPage.checkUserNameFieldVisible();
        loginPage.checkPasswordFieldVisible();
    }

    @Test
    public void incorrectIdSmartIdTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickSmartId();

        loginPage.setIdInputForSmartId(generateRandomSmartId());
        loginPage.clickLoginSmartId();

        loginPage.checkSmartIdValidationError();

    }

    @Test
    public void emptyLoginPasswordTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.clickPasswordMethod();

        loginPage.clickLoginPasswordMethod();
        loginPage.checkLoginButtonDisabled();
        loginPage.checkPasswordLoginError();

    }

    //Randoms
    public String generateRandomSmartId() {
        return RandomStringUtils.random(8, false, true);
    }
}
