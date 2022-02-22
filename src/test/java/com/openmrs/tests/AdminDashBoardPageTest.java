package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.pages.AdminDashBoardPage;
import com.openmrs.pages.LoginPage;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDashBoardPageTest extends BaseTest {

    @BeforeClass
    public void goToDashBoard(){
    adminDashBoardPage =
      loginPage.goToAdminPage(prop.getProperty("userid"), prop.getProperty("password"));


    }
    @Test(priority = 1)
    public void verifyLoggedAsAdmin() {
        Assert.assertTrue(adminDashBoardPage.verifyLoggedAsAdmin());
    }
    @Test(priority = 2)
    public void verifySelectedLocationTest(){
        String expectedResult = ("Inpatient Ward");
        System.out.println("my expected location should be : "+ expectedResult);
        String actualResult = adminDashBoardPage.verifySelectedLocation();
        System.out.println("actual location mane returned from test is :" +actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test(priority = 3)
    public void verifyAppsNameList(){
        String expectedResult = Constants.expectedAppsNameList().toString();
        System.out.println(Constants.expectedAppsNameList().size());
        System.out.println("expected appsNameList:" +expectedResult);
        String actualResult = adminDashBoardPage.verifyAppsNameList().toString();
        System.out.println(adminDashBoardPage.verifyAppsNameList().size());
        System.out.println("actual appsNameList :"+actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test(priority = 4)
    public void verifyLogoutFunction(){
       adminDashBoardPage.doLogout();
       Assert.assertTrue(loginPage.verifyLoginBtn());


    }


}
