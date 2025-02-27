package AppCombohr.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // constructeur de la classe LoginPage
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // initialisation des tous les web elements pour etre réutilisable dans autre classes
        PageFactory.initElements(driver, this);
    }

    // localisation des web elements de la page login
    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@data-testid=\"signin-submit-button\"]")
    WebElement SeConnecterButton;

    public void SaisirLogin(String email) {
        emailField.sendKeys(email);
    }

    public void SaisirPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSeConnecter() {
        SeConnecterButton.click();
    }
}
