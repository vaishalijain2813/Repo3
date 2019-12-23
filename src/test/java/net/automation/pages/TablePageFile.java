package net.automation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class TablePageFile extends PageObject {
    @FindBy(xpath = "//div[text()='Showing 31 to 32 of 32 entries']")
    WebElementFacade text;

    public void CountEntries() {
        int var = 0;
        for (int i = 1; i <= 10; i++) {
            if (getDriver().findElement(By.xpath("//a[text()='Next']")).isEnabled()) {
                List<WebElement> list = getDriver().findElements(By.xpath("//tbody//tr[@role='row']"));
                System.out.println(list.size());
                var = var + list.size();
                for (int j = 1; j <= list.size(); j++) {
                    Iterator itr = list.iterator();
                    if (itr.hasNext()) {
                        getDriver().findElement(By.xpath("//a[text()='Next']")).click();
                        break;
                    }
                }
                if (var > 31)
                    break;
                continue;
            }
        }
        String str = text.getText().replaceAll("Showing 31 to 32 of 32 entries", "32");
        int vk1 = Integer.valueOf(str);
        System.out.println(vk1);
        Assert.assertEquals(32, vk1);
    }
}
