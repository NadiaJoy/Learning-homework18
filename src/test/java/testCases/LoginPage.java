package testCases;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // SmartId
    public void clickSmartId() {

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();
    }

    public void setIdInputForSmartId(String isikukood) {
        SelenideElement idInput = $(By.xpath("//*[@data-cy='smart-id-input']/div/input"));
        idInput.setValue(isikukood);
    }

    public void clickLoginSmartId() {
        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();
    }

    public void checkSmartIdPinVisible() {
        $(By.xpath("//*[@data-cy='smart-id-polling-pin']"))
                .shouldBe(Condition.visible);
    }

    public void checkSmartIdValidationError() {
        $(By.xpath("//*[@data-cy='smart-id-validation-error']"))
                .shouldBe(Condition.visible);
    }

    //MobileId
    public void clickMobileId() {

        $(By.xpath("//*[@data-cy='method-mobile-id']")).click();
    }

    public void setPhoneInput(String phone) {
        SelenideElement phoneInput = $(By.xpath("//*[@data-cy='mobile-id-phone-input']/div/input"));
        phoneInput.setValue(phone);
    }

    public void setIdInputForMobileId(String isikukood) {
        SelenideElement idInput = $(By.xpath("//*[@data-cy='mobile-id-id-input']/div/input"));
        idInput.setValue(isikukood);
    }

    public void clickLoginMobileId() {
        $(By.xpath("//*[@data-cy='mobile-id-login-button']")).click();
    }

    public void checkMobileIdPinVisible() {
        $(By.xpath("//*[@data-cy='mobile-id-polling-pin']"))
                .shouldBe(Condition.visible);
    }

    //Login-Password
    public void clickPasswordMethod() {

        $(By.xpath("//*[@data-cy='method-password']")).click();
    }

    public void clickLoginPasswordMethod() {
        $(By.xpath("//*[@data-cy='password-login-button']")).click();
    }

    public void checkUserNameFieldVisible() {
        $(By.xpath("//*[@data-cy='username-input']"))
                .shouldBe(Condition.visible);
    }

    public void checkPasswordFieldVisible() {
        $(By.xpath("//*[@data-cy='password-input']"))
                .shouldBe(Condition.visible);
    }

    public void checkLoginButtonDisabled () {
        $(By.xpath("//*[@data-cy='password-login-button']"))
                .shouldBe(Condition.disabled);}
        public void checkPasswordLoginError () {
            $(By.xpath("//*[@data-cy='password-login-error']"))
                    .shouldBe(Condition.visible);
    }
}
