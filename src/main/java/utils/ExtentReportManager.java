package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Méthode pour initialiser ExtentReports
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/reports/testRapport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "Chaker Ben Said");
            extent.setSystemInfo("Environnement", "Test");
        }
        return extent;
    }

    // Méthode pour créer un test
    public static ExtentTest createTest(String testName, String description) {
        test = getExtentReports().createTest(testName, description);
        return test;
    }

    // Méthode pour finaliser le rapport
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Obtenir le test actuel
    public static ExtentTest getTest() {
        return test;
    }
}