package main.java.helperinstrument;


public class EnviromentHelper {

    private static String prestaUrl = System.getProperty("prestaUrl");
    private static String prestaKey = System.getProperty("prestaKey");
    private static String macDriver = System.getProperty("macDriver");
    private static String winDriver = System.getProperty("winDriver");
    private static String masterPass = System.getProperty("masterPass");
    private static String mariaEmail = System.getProperty("mariaEmail");
    private static String petroEmail = System.getProperty("petroEmail");
    private static String adminEmail = System.getProperty("adminEmail");
    private static String uniqueTest = System.getProperty("uniqueTest");
    private static String uniqueGmail = System.getProperty("uniqueGmail");

    public EnviromentHelper() {

    }

    public static String getPrestaUrl() {
        return prestaUrl;
    }

    public static String getPrestaKey() {
        return prestaKey;
    }


    public static String getMacDriver() {
        return macDriver;
    }

    public static String getWinDriver() {
        return winDriver;
    }

    public static String getMasterPass() {
        return masterPass;
    }

    public static String getMariaEmail() {
        return mariaEmail;
    }

    public static String getPetroEmail() {
        return petroEmail;
    }

    public static String getAdminEmail() {
        return adminEmail;
    }

    public static String getUniqueTest() {
        return uniqueTest;
    }

    public static String getUniqueGmail() {
        return uniqueGmail;
    }

}
