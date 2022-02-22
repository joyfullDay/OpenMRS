package com.openmrs.base;
import com.openmrs.pages.AdminDashBoardPage;
import com.openmrs.pages.LoginPage;
import com.openmrs.pages.PatientPage;
import com.openmrs.pages.RegisterPatientPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public BasePage basePage;
    public Properties prop;
    //public LoginPage homePage;
    public LoginPage loginPage;
    public AdminDashBoardPage adminDashBoardPage;
    public RegisterPatientPage registerPatientPage;
    public PatientPage patientPage;
    //@BeforeTest
    @BeforeTest
    public void setup(){
        basePage = new BasePage();
        prop = basePage.init_prop();
        String browserType = prop.getProperty("browser");
        driver = basePage.init_driver(browserType);
        loginPage = new LoginPage(driver);
        adminDashBoardPage = new AdminDashBoardPage(driver);

        driver.get(prop.getProperty("url"));

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}

