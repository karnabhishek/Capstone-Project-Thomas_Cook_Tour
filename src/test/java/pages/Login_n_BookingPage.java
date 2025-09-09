package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_n_BookingPage {
	
    WebDriver driver;
    Actions actions;

    By loginDropdown = By.id("LoginLogoutToggel"); 
    By loginButton = By.id("mainLogIn");        
    By emailInput = By.id("loginId");         
    By getOtpButton = By.id("sendOTP");      
    By finalLoginBtn = By.id("loginButton"); 

    By holidaysMenu = By.xpath("//*[@id='navbarDropdown']");   
    By australiaTour = By.linkText("Australia Tour Packages");
    By packageLink = By.partialLinkText("Amazing Australia - Winter");
    By travelDate = By.id("tavelDate");       
    By calculatePriceBtn = By.partialLinkText("Package");

    By continueBtn = By.linkText("Continue"); 
    By nxtcontinueBtn = By.id("pre-continueBtn");
    By nxtnxtcontinueBtn = By.linkText("Continue");
    By traveller1FirstName = By.id("room1_adultFName1"); 
    By traveller1LastName = By.id("room1_adultLName1");   
    By traveller1DOB = By.id("room1_adultDOB1");
    By traveller1passportNo = By.id("room1_adultPassportNo1");
    By traveller1passportexpiry = By.id("room1_adultPassportExpiry1");  
    
    By traveller2FirstName = By.id("room1_adultFName2"); 
    By traveller2LastName = By.id("room1_adultLName2");  
    By traveller2DOB = By.id("room1_adultDOB2");
    By traveller2passportNo = By.id("room1_adultPassportNo2");
    By traveller2passportexpiry = By.id("room1_adultPassportExpiry2");  
    
    By addressFirstName = By.id("fName-address");
    By addressLastName = By.id("lName-address");
    By state = By.id("gstState");
    By address = By.linkText("Address");
    By city = By.id("city");
    By pincode = By.id("pincode");
    By payerCheckbox = By.id("payer1_1");
    By panName = By.id("pancardname1_1");
    By panDOB = By.id("dateOfBirth1_1");
    By panNumber = By.id("pancardnumber1_1");
    By verifyBtn = By.id("1_1");

    // Constructor
    public Login_n_BookingPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    
    public void clickLoginDropdown() {
        driver.findElement(loginDropdown).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickGetOtp() {
        driver.findElement(getOtpButton).click();
    }

    public void clickFinalLogin() {
        driver.findElement(finalLoginBtn).click();
        
    }
    
    public void goToAustraliaPackage() {
    	//driver.findElement(By.id("loginButton")).click();

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(holidaysMenu));
        actions.moveToElement(driver.findElement(holidaysMenu)).perform();
        driver.findElement(australiaTour).click();
    }

    public void selectPackage() {
        driver.findElement(packageLink).click();
        
    }

    public void selectTravelDate(String date) {
        driver.findElement(travelDate).sendKeys(date);
    }

    public void calculatePrice() {
        driver.findElement(calculatePriceBtn).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void enterTravellerDetails(String firstName, String lastName, String passport) {
        driver.findElement(traveller1FirstName).sendKeys(firstName);
        driver.findElement(traveller1LastName).sendKeys(lastName);
        driver.findElement(traveller1passportNo).sendKeys(passport);
    }

    public void enterAddress(String fname, String lname, String addr, String pin) {
        driver.findElement(addressFirstName).sendKeys(fname);
        driver.findElement(addressLastName).sendKeys(lname);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(pincode).sendKeys(pin);
    }

    public void checkPayer() {
        driver.findElement(payerCheckbox).click();
    }

    public void enterPanDetails(String name, String dob, String number) {
        driver.findElement(panName).sendKeys(name);
        driver.findElement(panDOB).sendKeys(dob);
        driver.findElement(panNumber).sendKeys(number);
    }

    public void clickVerify() {
        driver.findElement(verifyBtn).click();
    }
}

