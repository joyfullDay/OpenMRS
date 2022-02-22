package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.pages.AdminDashBoardPage;
import com.openmrs.pages.LoginPage;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test(priority = 1)
    public void verifyLogoTest(){
        Assert.assertTrue(loginPage.verifyLogo());
    }
    @Test(priority = 2)
    public void verifyPageTitleTest(){
        Assert.assertEquals(loginPage.getPageTitle(),"Login");
    }
    @Test(priority = 3)
    public void verifyCantLoginLinkTest() {
        Assert.assertTrue(loginPage.verifyCantLoginLinkStatus());
    }
    @Test(priority = 4)
    public void verifyPopupWindowTest(){
        Assert.assertTrue(loginPage.verifyPopupWindow());
    }

    @Test(priority = 5)
    public void verifyLoginBtn(){
        Assert.assertTrue(loginPage.verifyLoginBtn());
    }
    @Test(priority =6 )
    public void verifyLocationList(){
        String actualResult = loginPage.verifyLocations().toString();
       String expectedResult =  Constants.expectedCategoryList().toString();
        //Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority =7 )
    public void verifyLoginErrorMsg() {
        String actualResult = loginPage.verifyErrorMsg();
        String expectedResult = Constants.LOGIN_WITHOUT_CREDENTIAL;
        System.out.println(actualResult);
        System.out.println(expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority =8 )
    public void verifyLocationError(){
        loginPage.goToAdminPage(prop.getProperty("userid"), prop.getProperty("password"));
        String actualMsg = loginPage.verifyLocationError();
        Assert.assertEquals(actualMsg, Constants.LOCATION_ERROR_MSG);
    }
    @Test(priority =9 )
    public void doLogin(){
          loginPage.selectLocation();
        loginPage.goToAdminPage(prop.getProperty("userid"), prop.getProperty("password"));
         Assert.assertTrue(loginPage.verifyLogoutBtn());
    }
}
