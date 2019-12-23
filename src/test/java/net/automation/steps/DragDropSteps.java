package net.automation.steps;
import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.automation.pages.DragDropPage;
import net.automation.utilities.ConfigLoader;

import java.awt.*;

public class DragDropSteps
{
    DragDropPage dragDropPage = new DragDropPage();
    static Config config = ConfigLoader.load();

    @Given("^User open the link$")
    public void userOpenTheLink()
    {
        dragDropPage.openUrl(config.getString("webdriver_base_url2"));
        dragDropPage.getDriver().manage().window().maximize();
    }

    @Then("^Drag and Drop the item$")
    public void dragAndDropTheItem() throws AWTException {
        dragDropPage.DragDropItem();
    }

    @Then("^Verify dropped item List$")
    public void verifyDroppedItemList() {
        dragDropPage.Verify();
    }
}
