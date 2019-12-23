package net.automation.steps;
import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.TablePageFile;
import net.automation.utilities.ConfigLoader;

public class TableStep {

    TablePageFile tablePageFile = new TablePageFile();
    static Config config = ConfigLoader.load();

    @Given("^User open the Page$")
    public void userOpenThePage() {

        tablePageFile.openUrl(config.getString("webdriver_base_url3"));
        tablePageFile.getDriver().manage().window().maximize();

    }

    @Then("^Count number of entries and press next then count for next page$")
    public void countNumberOfEntriesInTable() {
        tablePageFile.CountEntries();
    }

}
