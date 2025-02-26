package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        // Créer un test pour chaque scénario
        ExtentReportManager.createTest(scenario.getName(), scenario.getId());
        ExtentReportManager.getTest().info("Début du scénario : " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.getTest().fail("Le scénario a échoué : " + scenario.getName());
        } else {
            ExtentReportManager.getTest().pass("Le scénario a réussi : " + scenario.getName());
        }

        // Finaliser le rapport après chaque scénario
        ExtentReportManager.flushReports();
    }
}

