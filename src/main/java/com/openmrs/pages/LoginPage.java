package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    WebDriver driver;
    ElementUtil elementUtil;

    private By logo = By.xpath("//*[@id='content']/div[2]/div/header/div/a/img");
    private By loginBtn = By.id("loginButton");
    private By cantLogin = By.linkText("Can't log in?");
    private By locationError = By.id("sessionLocationError");
    private By errorMsg = By.id("error-message");
    private By inputEmail = By.id("username");
    private By inputPassword = By.id("password");
    private By logoutBtn = By.xpath("//a[contains(.,'Logout')]");
    private By locationsList = By.xpath("//ul[@id='sessionLocation']/li");
    private By popUpWindow = By.xpath("//*[@id='cannotLoginPopup']");
    private By OkeyBtn = By.xpath("//*[@id='cannotLoginPopup']/div[2]/button");
    private By ImpatientLocation = By.xpath("//*[@id='Inpatient Ward']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    public boolean verifyLogo(){
        return elementUtil.doIsDisplayed(logo);
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

    public List<String> verifyLocations(){
        List<String> LinkList = new ArrayList<>();
        List<WebElement> locationsListElement = elementUtil.getElements(locationsList);
        for(WebElement e:locationsListElement){
            LinkList.add(e.getText());
        }

        return LinkList;
    }

    public boolean verifyLoginBtn (){
        return elementUtil.isElementEbabled(loginBtn);
    }
    public boolean verifyCantLoginLinkStatus(){
        return elementUtil.isElementEbabled(cantLogin);
    }
    public boolean verifyPopupWindow(){
        elementUtil.doClick(cantLogin);
      boolean worningWindow =  elementUtil.doIsDisplayed(popUpWindow);
        elementUtil.doClick(OkeyBtn);
        return worningWindow;

    }
    public String verifyLocationError(){
        return elementUtil.doGetText(locationError);
    }
    public String verifyErrorMsg(){
        selectLocation();
        elementUtil.doClick(loginBtn);
        return elementUtil.doGetText(errorMsg);
    }

    //public AdminDashBoardPage goToAdminPage(){
    public AdminDashBoardPage goToAdminPage(String userID, String PW){
        elementUtil.ClearText(inputEmail);
        elementUtil.doSendKeys(inputEmail,userID);
        elementUtil.ClearText(inputPassword);
        elementUtil.doSendKeys(inputPassword,PW);
selectLocation();
        driver.findElement(loginBtn).click();
        return new AdminDashBoardPage(driver);
    }

    public void selectLocation(){
         elementUtil.doClick(ImpatientLocation);
    }
    public boolean verifyLogoutBtn(){

        return driver.findElement(logoutBtn).isDisplayed();

    }


}
