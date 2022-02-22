package com.openmrs.pages;

import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminDashBoardPage {
    WebDriver driver;
    ElementUtil elementUtil;

    public AdminDashBoardPage(WebDriver driver){
        this. driver = driver;
        elementUtil = new ElementUtil(driver);

    }
    private By myAccountPopupText = By.xpath("//a[@href='/openmrs/adminui/myaccount/myAccount.page'][contains(.,'My Account')]");
    private By selectedLocation = By.xpath("//span[contains(@id,'selected-location')]");
    private By findPatientRecord = By.xpath("//*[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']");
  //  private By activeVisits = By.xpath("//*[@id='org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension']");
    private By registerNewPnt = By.xpath("//*[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']");
    private By captureVitals= By.xpath("//a[contains(.,'Capture Vitals')]");
    private By appoScheduling = By.xpath("//*[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']");
  //  private By reports = By.xpath("//*[@id='reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension']");
  // private By dataManagement = By.xpath("//*[@id='coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension']");
   // private By configureMetadata = By.xpath("//*[@id='org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension']");
    private By systemAdministration = By.xpath("//*[@id='coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension']/i");
    private By logoutBtn = By.linkText("Logout");
    private By adminBtn = By.xpath("//*[@id='navbarSupportedContent']/ul/li[1]");
    private By appsNameList = By.xpath("//div[@id='apps']/a");


    public boolean verifyLoggedAsAdmin()  {
        elementUtil.doClick(adminBtn);
      return  elementUtil.doIsDisplayed(myAccountPopupText);
    }
    public String verifySelectedLocation(){
        return elementUtil.doGetText(selectedLocation);
    }

    public List<String> verifyAppsNameList() {
        List<String> LinkList = new ArrayList<>();
        List<WebElement> appsNameListElement = elementUtil.getElements(appsNameList);
        for(WebElement e:appsNameListElement){
            LinkList.add(e.getText());

        }
        return LinkList;
    }

    public String verifyRegisterNewPnt(){
        return elementUtil.doGetText(registerNewPnt);
    }
    public String verifyCaptureVitals(){
        return elementUtil.doGetText(captureVitals);
    }
    public String verifyAppScheduling(){
        return elementUtil.doGetText(appoScheduling);
    }
    public String verifySystemAdministration(){
        return elementUtil.doGetText(systemAdministration);
    }
    public LoginPage doLogout(){
         driver.findElement(logoutBtn).click();

         return new LoginPage(driver);
    }

}
