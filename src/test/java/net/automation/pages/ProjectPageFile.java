package net.automation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ProjectPageFile extends PageObject {

    @FindBy(id = "okta-signin-username")
    WebElementFacade userName;
    @FindBy(id = "okta-signin-password")
    WebElementFacade passWord;
    @FindBy(id = "okta-signin-submit")
    WebElementFacade signIn1;
    @FindBy(xpath = "//p[text()='Sign in failed!']")
    WebElementFacade ErrorMessage;
    @FindBy(xpath = "//p[text()='We found some errors. Please review the form and make corrections.']")
    WebElementFacade ErrorMessage1;

    public void EnterCredentialsAndSignIn(String arg0, String arg1, String arg2) {
        userName.withTimeoutOf(10, TimeUnit.SECONDS).sendKeys(arg0);
        passWord.withTimeoutOf(10, TimeUnit.SECONDS).sendKeys(arg1);
        signIn1.withTimeoutOf(10, TimeUnit.SECONDS).click();
        if (!arg2.equalsIgnoreCase("We found some errors. Please review the form and make corrections.")) {
            String str = ErrorMessage.getText();
            Assert.assertEquals(arg2, str);
        } else {
            String str2 = ErrorMessage1.getText();
            Assert.assertEquals(arg2, str2);
        }

    }
}

