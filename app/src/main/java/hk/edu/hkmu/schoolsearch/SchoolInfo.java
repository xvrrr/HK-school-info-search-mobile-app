package hk.edu.hkmu.schoolsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SchoolInfo {

    public static String NAME = "ENGLISH NAME"; //info show in more button
    public static String NUMBER = "SCHOOL NO"; //info show in more button
    public static String CATEGORY = "ENGLISH CATEGORY"; //info show in more button
    public static String ADDRESS = "ENGLISH ADDRESS"; //info show in more button
    public static String LONGITUDE = "LONGITUDE";
    public static String LATITUDE = "LATITUDE";
    public static String SESSION = "SESSION"; //info show in more button
    public static String WEBSITE = "WEBSITE";
    public static String TELEPHONE = "TELEPHONE";
    public static String RELIGION = "RELIGION"; //info s;how in more button
    public static List schoolnames = new ArrayList();


    public static ArrayList<HashMap<String,String>> schoolList = new ArrayList<>();


    public static void addSchool(String name, String number, String category, String address, String longitude,String latitude, String session, String website, String telephone, String religion) {
        HashMap<String, String> school = new HashMap<>();
        school.put(NAME,name);
        school.put(NUMBER, number);
        school.put(CATEGORY, category);
        school.put(ADDRESS, address);
        school.put(LONGITUDE, longitude);
        school.put(LATITUDE, latitude);
        school.put(SESSION, session);
        school.put(WEBSITE, website);
        school.put(TELEPHONE, telephone);
        school.put(RELIGION, religion);



        schoolList.add(school);
        };
    public static void addName(String name){
        schoolnames.add(name);
    }



}
