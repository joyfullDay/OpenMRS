package com.openmrs.utils;

import com.openmrs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;


    public ElementUtil(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }
    public boolean isElementEbabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);

    }

    public void doClick(By locator) {
        getElement(locator).click();
    }
    public void ClearText(By locator) {
        getElement(locator).clear();
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    public void waitFor(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String randomString(int length) {
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }

    public List<WebElement> getAllDropdownOptions(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> options = select.getOptions();
        return options;

    }
}