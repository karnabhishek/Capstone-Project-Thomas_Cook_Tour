package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.TestHooks;
import pages.Login_n_BookingPage;
import utilities.ExcelUtils;

public class Login_n_BookingSteps {

    WebDriver driver;
    Login_n_BookingPage page;

    @Given("the user has launched the Thomas Cook website")
    public void launchWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.thomascook.in/");
        page = new Login_n_BookingPage(driver);
    }

    @When("User clicks on {string} dropdown and then the {string} button")
    public void clickLogin(String dropdown, String button) {
        page.clickLoginDropdown();
        page.clickLoginButton();
    }

    @And("user enters email {string} and clicks on {string} button")
    public void enterEmail(String email, String button) {
        page.enterEmail(email);
        page.clickGetOtp();
        try {
            Thread.sleep(25000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("User clicks the final {string} button")
    public void finalLogin(String button) {
        page.clickFinalLogin();
    }
}

//    @And("the system should show the {string} on the page")
//    public void verifyLogin(String expected) {
//        System.out.println("Expected: " + expected); 
//        // Add assertion using Assert from TestNG/JUnit
//    }

    // ================= END-TO-END BOOKING =================

//    @Given("the user is logged in and on the homepage")
//    public void loggedInHomePage() {
//        // Assume login is already done
//        driver.get("https://www.thomascook.in/");
//    }

//    @And("User hovers the cursor to {string} and clicks on {string}")
//    public void selectAustraliaPackage(String menu, String subMenu) {
//        page.goToAustraliaPackage();
//    }
//
//    @And("User selects a specific {string} package")
//    public void selectPackage(String packageName) {
//        page.selectPackage();
//    }
//
//    @And("User selects a travel date")
//    public void selectDate() {
//        page.selectTravelDate("2025-09-10");
//    }
//
//    @And("User clicks on {string}")
//    public void calculatePrice(String btn) {
//        page.calculatePrice();
//    }
//
//    @And("the system should respond with the {string} page")
//    public void verifyPage(String pageName) {
//        System.out.println("Expected Page: " + pageName);
//        // add assertion on page title/url
//    }
//
//    @And("User reviews the package price and clicks on continue")
//    public void reviewPriceAndContinue() {
//        page.clickContinue();
//    }
//
//    @And("User reviews the Booking Summary and clicks {string} twice")
//    public void reviewBookingSummary(String btn) {
//        page.clickContinue();
//        page.clickContinue();
//    }
//
//    @And("the system should take the user to the {string} page")
//    public void goToTravellerPage(String pageName) {
//        System.out.println("Expected Page: " + pageName);
//    }
//
//    @And("user enters Traveller1 details: {string} {string} and {string}")
//    public void traveller1(String fname, String lname, String passport) {
//        page.enterTravellerDetails(fname, lname, passport);
//    }
//
//    @And("user enters Traveller2 details: {string} {string} and {string}")
//    public void traveller2(String fname, String lname, String passport) {
//        page.enterTravellerDetails(fname, lname, passport);
//    }
//
//    @And("user enters Address for communication: {string} {string} {string} {string}")
//    public void enterAddress(String fname, String lname, String addr, String pin) {
//        page.enterAddress(fname, lname, addr, pin);
//    }
//
//    @And("user checks the box to add this passenger as a payer")
//    public void checkPayer() {
//        page.checkPayer();
//    }
//
//    @And("user enters PAN details: {string} {string} {string}")
//    public void enterPan(String name, String dob, String number) {
//        page.enterPanDetails(name, dob, number);
//    }
//
//    @And("user clicks on {string}")
//    public void clickVerify(String btn) {
//        page.clickVerify();
//    }
//
//    @Then("the system should respond with the message {string}")
//    public void verifyPanMessage(String msg) {
//        System.out.println("Expected PAN validation: " + msg);
//    }
//}
