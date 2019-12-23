package net.automation.steps;
import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.automation.pages.ProjectPageFile;
import org.junit.Assert;
import net.automation.utilities.ConfigLoader;

public class ProjectSteps {
    ProjectPageFile projectPageFile = new ProjectPageFile();
    static Config config = ConfigLoader.load();

    @Given("^User on taxonomy login page$")
    public void userOnTaxonomyLoginPage() {
        projectPageFile.getDriver().manage().window().maximize();
        projectPageFile.openUrl(config.getString("webdriver_base_url1"));
    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\" and verify \"([^\"]*)\"$")
    public void userEnterAndAndVerify(String arg0, String arg1, String arg2) {

      projectPageFile.EnterCredentialsAndSignIn( arg0, arg1,arg2);
    }
}