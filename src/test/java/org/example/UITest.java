
package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

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

    @Test
    public void correctIdSmartIdTest() {

        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        SelenideElement idInput = $(By.xpath("//*[@data-cy='smart-id-input']/div/input"));

        idInput.setValue(isikukood);
        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();
        $(By.xpath("//*[@data-cy='smart-id-polling-pin']"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void correctPhoneAndIdMobileIdTest() {
        $(By.xpath("//*[@data-cy='method-mobile-id']")).click();

        SelenideElement phoneInput = $(By.xpath("//*[@data-cy='mobile-id-phone-input']/div/input"));
        SelenideElement idInput = $(By.xpath("//*[@data-cy='mobile-id-id-input']/div/input"));

        phoneInput.setValue(phone);
        idInput.setValue(isikukood);

        $(By.xpath("//*[@data-cy='mobile-id-login-button']")).click();
        $(By.xpath("//*[@data-cy='mobile-id-polling-pin']"))
                .shouldBe(Condition.visible);
    }

    //as I don't know correct login and pass, I check that the required fields become visible
    @Test
    public void openLoginPasswordTest() {
        $(By.xpath("//*[@data-cy='method-password']")).click();

        $(By.xpath("//*[@data-cy='username-input']"))
                .shouldBe(Condition.visible);
        $(By.xpath("//*[@data-cy='password-input']"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void incorrectIdSmartIdTest() {
        $(By.xpath("//*[@data-cy='method-smart-id']")).click();

        SelenideElement idInput = $(By.xpath("//*[@data-cy='smart-id-input']/div/input"));

        idInput.setValue("bhbjkndlk123");
        $(By.xpath("//*[@data-cy='smart-id-login-button']")).click();
        $(By.xpath("//*[@data-cy='smart-id-validation-error']"))
                .shouldBe(Condition.visible);

    }

    @Test
    public void emptyLoginPasswordTest() {
        $(By.xpath("//*[@data-cy='method-password']")).click();


        $(By.xpath("//*[@data-cy='password-login-button']")).click();

        $(By.xpath("//*[@data-cy='password-login-button']"))
                .shouldBe(Condition.disabled);
        $(By.xpath("//*[@data-cy='password-login-error']"))
                .shouldBe(Condition.visible);

    }
    @AfterEach
    public void setDown() {
        closeWebDriver();
    }

}
