package AppCombohr.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Register {
    // declaration de web driver: controle et ouverture d'un navigateur chrome
    WebDriver driver = new ChromeDriver();

    @Given("je suis sur la page de connexion combo")
    public void je_suis_sur_la_page_de_connexion_combo() {
        driver.get("https://app.combohr.com/users/sign_in");
        driver.manage().window().maximize();
        // attendre un temps implicite de 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je clique sur le bouton Créer un compte")
    public void jeCliqueSurLeBoutonCréerUnCompte() {
        WebElement BtnCreerCompte = driver.findElement(By.xpath("//a[@data-testid=\"auth-nav-signup-link-button\"]"));
        BtnCreerCompte.click();
    }

    @And("je saisie nom de votre entreprise {string}")
    public void jeSaisieNomDeVotreEntrepriseNomentrperise(String nomentreprise) {
        WebElement NomDeVotreEntrepriseFiled = driver.findElement(By.id("user.company"));
        NomDeVotreEntrepriseFiled.sendKeys(nomentreprise);
    }

    @And("je saisie prénom {string}")
    public void jeSaisiePrénomPrenom(String prenom) {
        WebElement PrenomFiled = driver.findElement(By.id("user_firstname"));
        PrenomFiled.sendKeys(prenom);
    }

    @And("je saisie nom {string}")
    public void jeSaisieNomNom(String nom) {
        WebElement NomFiled = driver.findElement(By.id("user_lastname"));
        NomFiled.sendKeys(nom);
    }

    @And("je saisie téléphone {string}")
    public void jeSaisieTéléphoneTelephone(String telephone) {
        WebElement TelephoneFiled = driver.findElement(By.id("user_phone_number"));
        TelephoneFiled.sendKeys(telephone);
    }

    @And("je saisie email {string}")
    public void jeSaisieEmailEmail(String email) throws InterruptedException {
        WebElement EmailFiled = driver.findElement(By.id("user_email"));
        EmailFiled.sendKeys(email);
        Thread.sleep(3000);
    }

    @And("je saisie password {string}")
    public void jeSaisiePasswordPassword(String password) {
        WebElement PasswordFiled = driver.findElement(By.id("user.password"));
        PasswordFiled.sendKeys(password);
    }

    @And("je saisie confirm_password {string}")
    public void jeSaisieConfirm_passwordConfirm_password(String confirm_password) {
        WebElement Confirm_PasswordFiled = driver.findElement(By.id("user.password_confirmation"));
        Confirm_PasswordFiled.sendKeys(confirm_password);
    }

    @And("je clique sur le bouton Suivant")
    public void jeCliqueSurLeBoutonSuivant() {
        WebElement Suivant = driver.findElement(By.xpath("//button[@data-testid=\"signup-next-button\"]"));
        Suivant.click();
    }

    @Then("redirection vers la page suivante d'inscription")
    public void redirectionVersLaPageSuivanteDInscription() throws InterruptedException {
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        if (url.equals("https://app.combohr.com/users/sign_up_company")) {
            System.out.println("redirection vers la page suivante d'inscription avec succès");
        } else {
            System.out.println("échec redirection vers la page suivante d'inscription");
        }
    }

    @And("je clique sur un nombre d'établissements {string}")
    public void jeCliqueSurUnNombreDÉtablissements(String nb) {
        WebElement RadioBtnO = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[1]/label/div[2]/div/div[1]/label"));
        String RadioO = RadioBtnO.getText();
        WebElement RadioBtn1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[1]/label/div[2]/div/div[2]/label"));
        String Radio1 = RadioBtn1.getText();
        WebElement RadioBtn25 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[1]/label/div[2]/div/div[3]/label"));
        String Radio25 = RadioBtn25.getText();
        WebElement RadioBtn620 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[1]/label/div[2]/div/div[4]/label"));
        String Radio620 = RadioBtn620.getText();
        WebElement RadioBtn20 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[1]/label/div[2]/div/div[5]/label"));
        String Radio20 = RadioBtn20.getText();
        if (RadioO.equals(nb)) {
            RadioBtnO.click();
        }
        if (Radio1.equals(nb)) {
            RadioBtn1.click();
        }
        if (Radio25.equals(nb)) {
            RadioBtn25.click();
        }
        if (Radio620.equals(nb)) {
            RadioBtn620.click();
        }
        if (Radio20.equals(nb)) {
            RadioBtn20.click();
        }
    }

    @And("je clique sur un nombre d'employés {string}")
    public void jeCliqueSurUnNombreDEmployés(String nb) {
        WebElement RadioBtn05 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[1]/label"));
        String Radio05 = RadioBtn05.getText();
        WebElement RadioBtn610 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[2]/label"));
        String Radio610 = RadioBtn610.getText();
        WebElement RadioBtn1115 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[3]/label"));
        String Radio1115 = RadioBtn1115.getText();
        WebElement RadioBtn1630 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[4]/label"));
        String Radio1630 = RadioBtn1630.getText();
        WebElement RadioBtn3180 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[5]/label"));
        String Radio3180 = RadioBtn3180.getText();
        WebElement RadioBtn81 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[2]/label/div[2]/div/div[6]/label"));
        String Radio81 = RadioBtn81.getText();
        if (Radio05.equals(nb)) {
            RadioBtn05.click();
        }
        if (Radio610.equals(nb)) {
            RadioBtn610.click();
        }
        if (Radio1115.equals(nb)) {
            RadioBtn1115.click();
        }
        if (Radio1630.equals(nb)) {
            RadioBtn1630.click();
        }
        if (Radio3180.equals(nb)) {
            RadioBtn3180.click();
        }
        if (Radio81.equals(nb)) {
            RadioBtn81.click();
        }
    }


    @And("je sélectionne intitulé de poste {string}")
    public void jeSélectionneIntituléDePoste(String poste) {
        WebElement InputPoste = driver.findElement(By.xpath("//input[@data-testid=\"signup-company-job-input\"]"));
        InputPoste.click();
        WebElement GP = driver.findElement(By.xpath("//div[@data-testid=\"option-Gérant - Propriétaire\"]"));
        String Gp = GP.getText();
        WebElement RH = driver.findElement(By.xpath("//div[@data-testid=\"option-Ressources Humaines\"]"));
        String Rh = RH.getText();
        WebElement OPERATIONS = driver.findElement(By.xpath("//div[@data-testid=\"option-Opérations\"]"));
        String Operations = OPERATIONS.getText();
        WebElement MANAGER = driver.findElement(By.xpath("//div[@data-testid=\"option-Manager\"]"));
        String Manager = MANAGER.getText();
        WebElement CONSULTANT = driver.findElement(By.xpath("//div[@data-testid=\"option-Consultant\"]"));
        String Consultant = CONSULTANT.getText();
        WebElement ETUDIANT = driver.findElement(By.xpath("//div[@data-testid=\"option-Etudiant\"]"));
        String Etudiant = ETUDIANT.getText();
        WebElement EMPLOYEE = driver.findElement(By.xpath("//div[@data-testid=\"option-Employé\"]"));
        String Employee = EMPLOYEE.getText();
        WebElement AUTRE = driver.findElement(By.xpath("//div[@data-testid=\"option-Autre\"]"));
        String Autre = AUTRE.getText();
        if (Gp.equals(poste)) {
            GP.click();
        }
        if (Rh.equals(poste)) {
            RH.click();
        }
        if (Operations.equals(poste)) {
            OPERATIONS.click();
        }
        if (Manager.equals(poste)) {
            MANAGER.click();
        }
        if (Consultant.equals(poste)) {
            CONSULTANT.click();
        }
        if (Etudiant.equals(poste)) {
            ETUDIANT.click();
        }
        if (Employee.equals(poste)) {
            EMPLOYEE.click();
        }
        if (Autre.equals(poste)) {
            AUTRE.click();
        }
    }

    @And("je sélectionner secteur d'activité {string}")
    public void jeSélectionnerSecteurDActivité(String secteur) {
        WebElement InputSecteur = driver.findElement(By.xpath("//input[@data-testid=\"signup-company-industry-input\"]"));
        InputSecteur.click();
        //option 1
        WebElement RT = driver.findElement(By.xpath("//div[@data-testid=\"option-Restauration traditionnelle\"]"));
        String Rt = RT.getText();
        //option 2
        WebElement RP = driver.findElement(By.xpath("//div[@data-testid=\"option-Restauration rapide\"]"));
        String Rp = RP.getText();
        //option 3
        WebElement HT = driver.findElement(By.xpath("//div[@data-testid=\"option-Hôtellerie\"]"));
        String Ht = HT.getText();
        //option 4
        WebElement BP = driver.findElement(By.xpath("//div[@data-testid=\"option-Boulangerie-pâtisserie\"]"));
        String Bp = BP.getText();
        //option 5
        WebElement ALIMENTAIRE = driver.findElement(By.xpath("//div[@data-testid=\"option-Alimentaire\"]"));
        String Alimentaire = ALIMENTAIRE.getText();
        //option 6
        WebElement SP = driver.findElement(By.xpath("//div[@data-testid=\"option-Santé & Pharmacie\"]"));
        String Sp = SP.getText();
        //option 7
        WebElement RB = driver.findElement(By.xpath("//div[@data-testid=\"option-Retail & boutiques\"]"));
        String Rb = RB.getText();
        //option 8
        WebElement LS = driver.findElement(By.xpath("//div[@data-testid=\"option-Loisirs & Sports\"]"));
        String Ls = LS.getText();
        //option 9
        WebElement SERVICES = driver.findElement(By.xpath("//div[@data-testid=\"option-Services\"]"));
        String Services = SERVICES.getText();
        //option 10
        WebElement AUTRES = driver.findElement(By.xpath("//div[@data-testid=\"option-Autres\"]"));
        String Autres = AUTRES.getText();
        if (Rt.equals(secteur)) {
            RT.click();
        }
        if (Rp.equals(secteur)) {
            RP.click();
        }
        if (Ht.equals(secteur)) {
            HT.click();
        }
        if (Bp.equals(secteur)) {
            BP.click();
        }
        if (Alimentaire.equals(secteur)) {
            ALIMENTAIRE.click();
        }
        if (Sp.equals(secteur)) {
            SP.click();
        }
        if (Rb.equals(secteur)) {
            RB.click();
        }
        if (Ls.equals(secteur)) {
            LS.click();
        }
        if (Services.equals(secteur)) {
            SERVICES.click();
        }
        if (Autres.equals(secteur)) {
            AUTRES.click();
        }
    }

    @And("je clique sur je suis franchisé")
    public void jeCliqueSurJeSuisFranchisé() {
        //WebElement RadioFranchise = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div[2]/div/form/div/div[2]/div/div[5]/label/div[2]/div/div/div"));
        //RadioFranchise.click();
        System.out.println("je clique sur radio button 'Je suis franchisé'");
    }

    @And("je sélectionner un pays {string}")
    public void jeSélectionnerUnPays(String pays) {
        WebElement InputPays = driver.findElement(By.xpath("//input[@data-testid=\"signup-user-country-input\"]"));
        InputPays.click();
        //France
        WebElement FRANCE = driver.findElement(By.xpath("//div[@data-testid=\"option-FR\"]"));
        String France = FRANCE.getText();
        //Espagne
        WebElement ESPAGNE = driver.findElement(By.xpath("//div[@data-testid=\"option-ES\"]"));
        String Espagne = ESPAGNE.getText();
        // Allemagne
        WebElement ALLEMAGNE = driver.findElement(By.xpath("//div[@data-testid=\"option-DE\"]"));
        String Allemagne = ALLEMAGNE.getText();
        // Austriche
        WebElement AUSTRICHE = driver.findElement(By.xpath("//div[@data-testid=\"option-AT\"]"));
        String Austriche = AUSTRICHE.getText();
        // Belgique
        WebElement BELGIQUE = driver.findElement(By.xpath("//div[@data-testid=\"option-BE\"]"));
        String Belgique = BELGIQUE.getText();
        // Italie
        WebElement ITALIE = driver.findElement(By.xpath("//div[@data-testid=\"option-IT\"]"));
        String Italie = ITALIE.getText();
        // Luxembourg
        WebElement LUXEMBOURG = driver.findElement(By.xpath("//div[@data-testid=\"option-LU\"]"));
        String Luxembourg = LUXEMBOURG.getText();
        // Pays-bas
        WebElement PAYSBAS = driver.findElement(By.xpath("//div[@data-testid=\"option-NL\"]"));
        String Paysbas = PAYSBAS.getText();
        // Portugal
        WebElement PORTUGAL = driver.findElement(By.xpath("//div[@data-testid=\"option-PT\"]"));
        String Portugal = PORTUGAL.getText();
        // Suisse
        WebElement SUISSE = driver.findElement(By.xpath("//div[@data-testid=\"option-CH\"]"));
        String Suisse = SUISSE.getText();
        if (France.equals(pays)) {
            FRANCE.click();
        }
        if (Espagne.equals(pays)) {
            ESPAGNE.click();
        }
        if (Allemagne.equals(pays)) {
            ALLEMAGNE.click();
        }
        if (Austriche.equals(pays)) {
            AUSTRICHE.click();
        }
        if (Belgique.equals(pays)) {
            BELGIQUE.click();
        }
        if (Italie.equals(pays)) {
            ITALIE.click();
        }
        if (Luxembourg.equals(pays)) {
            LUXEMBOURG.click();
        }
        if (Paysbas.equals(pays)) {
            PAYSBAS.click();
        }
        if (Portugal.equals(pays)) {
            PORTUGAL.click();
        }
        if (Suisse.equals(pays)) {
            SUISSE.click();
        }
    }

    @And("je clique sur un bouton Créer un compte")
    public void jeCliqueSurUnBoutonCréerUnCompte() {
        WebElement CreerCompte = driver.findElement(By.xpath("//button[@data-testid=\"signup-submit-button\"]"));
        CreerCompte.click();
    }

    @Then("création de compte avec succès")
    public void créationDeCompteAvecSuccès() throws InterruptedException {
        // blocage du programme et attendre un temps de 5s
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        if (url.equals("https://app.combohr.com/")) {
            System.out.println("inscription avec succès");
        } else {
            System.out.println("échec d'inscription et affichage d'un message d'erreur");
        }
    }
}
