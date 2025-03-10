package AppCombohr.stepDefinitions;

import AppCombohr.PageFactory.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExtentReportManager;

import java.time.Duration;

public class Login {
    // declaration de web driver: controle et ouverture d'un navigateur chrome
    WebDriver driver = new ChromeDriver();

    // déclaration d'un objet extent rapports
    ExtentTest test = ExtentReportManager.getTest();

    // déclaration d'une instance de PageFactory LoginPage
    LoginPage loginPage = new LoginPage(driver);

    @Given("je suis sur la page de connexion de combo")
    public void je_suis_sur_la_page_de_connexion_de_combo() {
        driver.get("https://app.combohr.com/users/sign_in");
        driver.manage().window().maximize();
        // attendre un temps implicite de 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je saisie adresse email {string}")
    public void jeSaisieAdresseEmail(String email) {
        loginPage.SaisirLogin(email);
        test.info("je saisie email: " + email);
    }

    @And("je saisie mot de passe {string}")
    public void jeSaisieMotDePasse(String password) {
        loginPage.SaisirPassword(password);
        test.info("je saisie password: " + password);
    }

    @And("je clique sur le bouton Se connecter")
    public void jeCliqueSurLeBoutonSeConnecter() {
        loginPage.clickSeConnecter();
        test.info("je clique sur le bouton Se connecter");
    }

    @Then("connexion avec succès et redirection vers le tableau du board")
    public void connexionAvecSuccèsEtRedirectionVersLeTableauDuBoard() throws InterruptedException {
        // blocage et attendre de chargement de page
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        if (url.equals("https://app.combohr.com/")) {
            test.pass("connexion avec succès et redirection vers le tableau du board");
        } else {
            test.fail("échec de connexion et affichage d'un message d'erreur");
        }

        // fermer le navigateur
        driver.close();
    }
}