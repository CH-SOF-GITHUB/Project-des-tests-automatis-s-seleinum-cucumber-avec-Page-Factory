package AppCombohr.stepDefinitions;

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

    @Given("je suis sur la page de connexion de combo")
    public void je_suis_sur_la_page_de_connexion_de_combo() {
        driver.get("https://app.combohr.com/users/sign_in");
        driver.manage().window().maximize();
        // attendre un temps implicite de 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je saisie adresse email {string}")
    public void jeSaisieAdresseEmail(String email) {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);
        test.info("je saisie email: " + email);
    }

    @And("je saisie mot de passe {string}")
    public void jeSaisieMotDePasse(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        test.info("je saisie password: " + password);
    }

    @And("je clique sur le bouton Se connecter")
    public void jeCliqueSurLeBoutonSeConnecter() {
        WebElement button = driver.findElement(By.xpath("//button[@data-testid=\"signin-submit-button\"]"));
        button.click();
    }

    @Then("connexion avec succès et redirection vers le tableau du board")
    public void connexionAvecSuccèsEtRedirectionVersLeTableauDuBoard() throws InterruptedException {
        // blocage et attendre de chargement de page
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        //String errorMsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/form/div/div[1]/div[1]/div/div[2]")).getText();
        //String errorMsgRequis = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/form/div/div[1]/div[2]/div[2]/div[2]/span")).getText();

        if (url.equals("https://app.combohr.com/")) {
            test.pass("connexion avec succès et redirection vers le tableau du board");
        } else {
            test.fail("échec de connexion et affichage d'un message d'erreur");
        }

        // fermer le navigateur
        driver.close();
    }
}