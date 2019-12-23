package net.automation.pages;
import cucumber.api.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class Automation_page extends PageObject {
    Google google;
    @FindBy(css = "input[name='firstname']")
    WebElementFacade textfield;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElementFacade textfield1;
    @FindBy(xpath = "//input[@id='datepicker']")
    WebElementFacade date;
    @FindBy(xpath = "//input[@id='photo']")
    WebElementFacade chooseFile;
    @FindBy(xpath = "//button[@id='submit']")
    WebElementFacade submit1;
    @FindBy(id = "continents")
    WebElementFacade continents;
    @FindBy(id="continentsmultiple")
    WebElementFacade continentsMulti;
    @FindBy(id = "selenium_commands")
    WebElementFacade seleniumcommand;

    public void fillForm(DataTable dataTable)
    {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        System.out.println(data);
        String str = data.get(0).get("FirstName");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(textfield).sendKeys(str);
        String str1 = data.get(0).get("LastName");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(textfield1).sendKeys(str1);
        String str2 = data.get(0).get("Date");
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(date).sendKeys(str2);
        String gender = data.get(0).get("Gender");
        getDriver().findElement(By.xpath("//input[@value='" + gender + "']")).click();
        String experience = data.get(0).get("YearOfExperience");
        getDriver().findElement(By.xpath("//input[@name='exp' and @value='" + experience + "']")).click();
        String profession = data.get(0).get("Profession");
        getDriver().findElement(By.xpath("//input[@name='profession' and @value='" + profession + "']")).click();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,500)");
        String automationTool = data.get(0).get("AutomationTool");
        getDriver().findElement(By.xpath("//input[@type='checkbox' and @value='"+automationTool+"']")).click();
        String continent = data.get(0).get("Continents");
        Select continentDD=new Select(continents);
        continentDD.selectByVisibleText(continent);
        String continentsMultiple1 = data.get(0).get("ContinentsMultiple");
        Select continentMultipleDD = new Select(continentsMulti);
        continentMultipleDD.selectByVisibleText(continentsMultiple1);
        String SeleniumCommands1 = data.get(0).get("SeleniumCommands");
        Select SeleniumCommandsDD= new Select(seleniumcommand);
        SeleniumCommandsDD.selectByVisibleText(SeleniumCommands1);
    }
    public void uploadProfilePicture()
    {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(chooseFile);
        String filePath=System.getProperty("user.dir");
        chooseFile.sendKeys( filePath+"\\src\\test\\resources\\testData\\foreacherr.png");
    }
    public void submitPage()
    {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(submit1);
        submit1.waitUntilClickable();
        submit1.click();
    }
    public void setUrl()
    {
        google.goToHomePage();
    }

}
