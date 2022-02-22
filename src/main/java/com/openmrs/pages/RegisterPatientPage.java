package com.openmrs.pages;

import org.openqa.selenium.By;

public class RegisterPatientPage {
    private By registerAPatientLink = By.xpath("//*[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']/text()");
    private By givenNameInput = By.xpath("//*[@id='fr7676-field']");
    private By familyNameInput = By.xpath("//*[@id='fr552-field']");
    private By unknownPatientCheckbox = By.xpath("//*[@id='checkbox-unknown-patient']");
    private By errorMsgOnGivenName =By.xpath("//*[@id='fr6700']");
    private By errorMsgOnFamilyName = By.xpath("//*[@id='fr7152']");
    private By nextBtn = By.xpath("//*[@id='checkbox-unknown-patient']");
    private By gender = By.xpath("//*[@id='checkbox-unknown-patient']");
    private By birthdate = By.xpath("//*[@id='checkbox-unknown-patient']");
    private By address = By.xpath("//*[@id=checkbox-unknown-patient]");
    private By phoneNumber = By.xpath("//*[@id=\"formBreadcrumb\"]/li[2]/ul/li[2]/span");
    private By male = By.xpath("//option[contains(@value,'M')]");
    private By female = By.xpath("//option[contains(.,'Female')]");
    private By day = By.xpath("//input[contains(@name,'birthdateDay')]");
    private By monthList = By.xpath("//select[@name='birthdateMonth']");
    private By year = By.xpath("//input[contains(@name,'birthdateDay')]");


}
