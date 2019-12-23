package net.automation.pages;

import net.automation.utilities.CommonMethods;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

public class DragDropPage extends PageObject
{
    int outputVariable = CommonMethods.getRandomDoubleBetweenRange(1, 4);

    public void DragDropItem() throws AWTException
    {
        System.out.println("random component=" + CommonMethods.getRandomDoubleBetweenRange(1, 4));
        WebElement Drag = getDriver().findElement(By.xpath("//span[text()='Draggable " + outputVariable + "']"));
        Actions act = new Actions(getDriver());
        Point dragLoc = Drag.getLocation();
        Robot robot = new Robot();
        robot.mouseMove(dragLoc.getX() + 50, dragLoc.getY() + 150);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        waitABit(1000);
        robot.mouseMove(590, 560);
        waitABit(2000);
        act.click().perform();
        try
        {
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e)
        {
            waitABit(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        waitABit(5000);
    }

    public void Verify()
    {
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@id='droppedlist']//span[text()='Draggable " + outputVariable + "']")).isDisplayed());
    }
}