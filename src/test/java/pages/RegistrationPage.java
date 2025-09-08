package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.messages.types.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;  // <-- use this one


public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;


    

	// Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    

    // Locators
    private By loginBtn = By.id("loginRegisterDropdown");
    private By gotoregisterBtn = By.xpath("//a[@class='show_register_form' and text()='Register']");
    //private By titleDropdown = By.cssSelector("select[name='title']");
    private By firstName = By.id("registerFName");
    private By lastName = By.id("registerLName");
    private By email = By.id("registerEmailId");
    private By password = By.id("registerPwd");
    private By confirmPassword = By.id("registerConfirmPwd");
    private By mobile = By.id("registerMobileNo");
    private By termsCheckbox = By.id("tandc");
    private By registerBtn = By.id("registerButton");
    
    
    
    // Actions
    public void navigateToRegistrationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(gotoregisterBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
    }

    
//    public void selectTitle(String title) {
//        driver.findElement(titleDropdown).sendKeys(title);
//    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void confirmPassword(String cpwd) {
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void enterMobile(String mob) {
        driver.findElement(mobile).sendKeys(mob);
    }

    public void acceptTerms() {
        driver.findElement(termsCheckbox).click();
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }
    
 // Success message locator (adjust as per actual HTML)
 // Add this new locator at top of RegistrationPage.java
    private By myAccountLink = By.id("LoginLogoutToggel");

    // Add this method in RegistrationPage.java
    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLink));
            return true;
        } catch (Exception e) {
            return false;
        }
        finally {
            driver.quit(); // Always executed
        }
    }
    
    private By mobileErrorMessage = By.xpath("//*[normalize-space(text())='Please enter valid contact number']");

    public boolean getMobileErrorMessage() {
        try {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(mobileErrorMessage));
        	return true;
        } catch (Exception e) {
            return false;
        }
        finally {
            driver.quit(); // Always executed
        }
    }



}
