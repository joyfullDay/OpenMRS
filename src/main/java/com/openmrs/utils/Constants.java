package com.openmrs.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String PAGE_TITLE = "Login";
    public static final String LOCATION_ERROR_MSG = "You must choose a location!";
    public static final String LOGIN_WITHOUT_CREDENTIAL = "Invalid username/password. Please try again.";
    public static final String LOCATION_SELECTION = "Impatient Ward";

    public static List<String> expectedCategoryList(){
        List<String> list = new ArrayList<>();
        list.add("Inpatient Ward");
        list.add("Isolation Ward");
        list.add("Laboratory");
        list.add("Outpatient Clinic");
        list.add("Pharmacy");
        list.add("Registration Desk");
        return list;


    }
    public static List<String> expectedAppsNameList() {
        List<String> list = new ArrayList<>();
        list.add("Find Patient Record");
        list.add("Active Visits");
        list.add("Register a patient");
        list.add("Capture Vitals");
        list.add("Appointment Scheduling");
        list.add("Register a patient");
        list.add("Reports");
        list.add("Data Management");
        list.add("Configure Metadata");
        list.add("System Administration");
        return list;
    }
    public static List<String> monthMenu() {
        List<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");
        return list;
    }


}
