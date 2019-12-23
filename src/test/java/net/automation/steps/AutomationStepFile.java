package net.automation.steps;
import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.Automation_page;
import net.automation.utilities.ConfigLoader;

public class AutomationStepFile {
    Automation_page automation_page = new Automation_page();
    static Config config = ConfigLoader.load();

    @Given("^user go to practice form$")
    public void userGoToPracticeForm() {
        automation_page.openUrl(config.getString("webdriver_base_url"));
        automation_page.getDriver().manage().window().maximize();
    }

    @And("^fill up the new account form with the following data$")
    public void fillUpTheNewAccountFormWithTheFollowingData(DataTable dataTable) {
        automation_page.fillForm(dataTable);
    }

    @Then("^User choose File To Upload$")
    public void chooseFileToUpload() {
        automation_page.uploadProfilePicture();
    }

    @Then("^User Submit Form$")
    public void submitForm() {
        automation_page.submitPage();

    }
}
