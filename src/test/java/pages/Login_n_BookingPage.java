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


















//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//
//public class Login_n_BookingPage {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private Actions actions;
//
//    // Locators for Login
//    @FindBy(xpath = "//a[text()='Login']")
//    private WebElement loginDropdown;
//
//    @FindBy(xpath = "(//a[text()='Login'])[2]") // Assuming the second login is the one in the dropdown
//    private WebElement loginButtonInDropdown;
//    
//    @FindBy(id = "txtEmailId")
//    private WebElement emailInput;
//
//    @FindBy(id = "btnGetOtp")
//    private WebElement getOtpButton;
//
//    @FindBy(id = "btnLogin")
//    private WebElement finalLoginButton;
//    
//    @FindBy(xpath = "//span[@class='user-name']") // Locator for verifying login
//    private WebElement loggedInUserName;
//
//    // Locators for Holiday Package Booking
//    @FindBy(xpath = "//a[@title='Holidays']")
//    private WebElement holidaysMenu;
//    
//    @FindBy(xpath = "//a[text()='Australia Tour Packages']")
//    private WebElement australiaTourPackagesLink;
//
//    @FindBy(xpath = "//h3[contains(text(), 'Amazing Australia - Winter')]/ancestor::div[contains(@class,'package-card')]//button")
//    private WebElement amazingAustraliaPackageButton;
//
//    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]/following-sibling::td[1]/a") // Selects the day after today
//    private WebElement travelDate;
//    
//    @FindBy(id = "calculatePrice")
//    private WebElement calculatePriceButton;
//
//    @FindBy(xpath = "//h2[text()='Package Price']") // For verification
//    private WebElement packagePriceHeader;
//
//    @FindBy(xpath = "//button[text()='Continue']")
//    private WebElement continueButton;
//
//    @FindBy(xpath = "//h1[text()='Booking Summary']") // For verification
//    private WebElement bookingSummaryHeader;
//
//    @FindBy(xpath = "//h1[text()='Traveller Details']") // For verification
//    private WebElement travellerDetailsHeader;
//
//    // Locators for Traveller Details Page
//    @FindBy(id = "txtTraveller1FirstName")
//    private WebElement t1FirstName;
//
//    @FindBy(id = "txtTraveller1LastName")
//    private WebElement t1LastName;
//    
//    @FindBy(id = "txtTraveller1Passport")
//    private WebElement t1PassportNo;
//
//    @FindBy(id = "txtTraveller2FirstName")
//    private WebElement t2FirstName;
//
//    @FindBy(id = "txtTraveller2LastName")
//    private WebElement t2LastName;
//
//    @FindBy(id = "txtTraveller2Passport")
//    private WebElement t2PassportNo;
//
//    @FindBy(id = "txtAddressFirstName")
//    private WebElement addrFirstName;
//
//    @FindBy(id = "txtAddressLastName")
//    private WebElement addrLastName;
//
//    @FindBy(id = "txtAddressLine1")
//    private WebElement addressLine1;
//
//    @FindBy(id = "txtAddressPincode")
//    private WebElement pincode;
//
//    @FindBy(id = "chkSameAsTraveller1")
//    private WebElement payerCheckbox;
//
//    @FindBy(id = "txtPanName")
//    private WebElement panName;
//    
//    @FindBy(id = "txtPanDob")
//    private WebElement panDob;
//
//    @FindBy(id = "txtPanNumber")
//    private WebElement panNumber;
//
//    @FindBy(id = "btnVerifyPan")
//    private WebElement verifyPanButton;
//    
//    @FindBy(id = "panErrorMessage") // Example ID for the error message
//    private WebElement panErrorMessage;
//
//
//    public Login_n_BookingPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        this.actions = new Actions(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    public void navigateToLoginPage() {
//        loginDropdown.click();
//        wait.until(ExpectedConditions.visibilityOf(loginButtonInDropdown)).click();
//    }
//
//    public void enterLoginCredentials(String email) {
//        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
//        getOtpButton.click();
//    }
//    
//    public void clickFinalLoginButton() {
//        // In a real scenario, this would wait for OTP entry. Here we just click.
//        finalLoginButton.click();
//    }
//
//    public String getLoggedInUserName() {
//        return wait.until(ExpectedConditions.visibilityOf(loggedInUserName)).getText();
//    }
//
//    public void navigateToAustraliaPackages() {
//        actions.moveToElement(holidaysMenu).perform();
//        wait.until(ExpectedConditions.visibilityOf(australiaTourPackagesLink)).click();
//    }
//
//    public void selectPackage(String packageName) {
//        // This is a simplified version. A real implementation might need to scroll or handle dynamic elements.
//        wait.until(ExpectedConditions.elementToBeClickable(amazingAustraliaPackageButton)).click();
//    }
//
//    public void selectDate() {
//        wait.until(ExpectedConditions.elementToBeClickable(travelDate)).click();
//    }
//
//    public void clickCalculatePrice() {
//        calculatePriceButton.click();
//    }
//
//    public boolean isHeaderVisible(String headerText) {
//        switch (headerText) {
//            case "Package Price":
//                return wait.until(ExpectedConditions.visibilityOf(packagePriceHeader)).isDisplayed();
//            case "Booking Summary":
//                return wait.until(ExpectedConditions.visibilityOf(bookingSummaryHeader)).isDisplayed();
//            case "Traveller Details":
//                return wait.until(ExpectedConditions.visibilityOf(travellerDetailsHeader)).isDisplayed();
//            default:
//                return false;
//        }
//    }
//
//    public void clickContinue() {
//        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
//    }
//    
//    public void fillTraveller1Details(String firstName, String lastName, String passportNo) {
//        wait.until(ExpectedConditions.visibilityOf(t1FirstName)).sendKeys(firstName);
//        t1LastName.sendKeys(lastName);
//        t1PassportNo.sendKeys(passportNo);
//    }
//
//    public void fillTraveller2Details(String firstName, String lastName, String passportNo) {
//        if (firstName != null && !firstName.isEmpty()) {
//            t2FirstName.sendKeys(firstName);
//            t2LastName.sendKeys(lastName);
//            t2PassportNo.sendKeys(passportNo);
//        }
//    }
//    
//    public void fillAddressDetails(String firstName, String lastName, String address, String pin) {
//        addrFirstName.sendKeys(firstName);
//        addrLastName.sendKeys(lastName);
//        addressLine1.sendKeys(address);
//        pincode.sendKeys(pin);
//    }
//
//    public void checkPayerBox() {
//        payerCheckbox.click();
//    }
//
//    public void fillPanDetails(String name, String dob, String number) {
//        if (name != null && !name.isEmpty()) {
//            panName.sendKeys(name);
//            panDob.sendKeys(dob);
//            panNumber.sendKeys(number);
//        }
//    }
//
//    public void clickVerifyPan() {
//        verifyPanButton.click();
//    }
//
//    public String getPanErrorMessage() {
//        return wait.until(ExpectedConditions.visibilityOf(panErrorMessage)).getText();
//    }
//}