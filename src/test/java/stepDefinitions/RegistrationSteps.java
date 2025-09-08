package stepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;
import utilities.ExcelUtils;



import org.testng.Assert;

import hooks.TestHooks;



//import static org.testng.Assert.assertEquals;

import java.time.Duration;


public class RegistrationSteps {

    WebDriver driver;
    RegistrationPage regPage;
    Workbook workbook;
    Sheet sheet;
    Scenario scenario;

    @Given("user is on registration page")
    public void user_is_on_registration_page() throws InterruptedException {
    	
    	//ChromeOptions options = new ChromeOptions();
    	//options.addArguments("--incognito");
    	
    	
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.thomascook.in/");        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        regPage = new RegistrationPage(driver);
        System.out.println("reached login");
        regPage.navigateToRegistrationPage();
        Thread.sleep(4000);
        System.out.println("reached register page");
    }

    @When("user loads registration data from Excel {string} of sheet {string} row {int}")
    public void user_enters_registration_details_from_excel_row(String fileName, String sheetName, Integer rowIndex) throws Exception {
        // Load Excel file
    	System.out.println("load excel file");
        ExcelUtils.loadExcel("src/test/resources/testData/RegistrationData.xlsx");

        // Read data row-wise
        //String title = ExcelUtil.getCellData("Sheet1", rowIndex, 0);
        System.out.println("starts filling form");
        String fname = ExcelUtils.readExcelData("Sheet1", rowIndex, 0);
        String lname = ExcelUtils.readExcelData("Sheet1", rowIndex, 1);
        String email = ExcelUtils.readExcelData("Sheet1", rowIndex, 2);
        String pwd = ExcelUtils.readExcelData("Sheet1", rowIndex, 3);
        String cpwd = ExcelUtils.readExcelData("Sheet1", rowIndex, 4);
        String mob = ExcelUtils.readExcelData("Sheet1", rowIndex, 5);
        System.out.println("filling form ends");
        
        // Fill form
        //regPage.selectTitle(title);
        regPage.enterFirstName(fname);
        regPage.enterLastName(lname);
        regPage.enterEmail(email);
        regPage.enterPassword(pwd);
        regPage.confirmPassword(cpwd);
        regPage.enterMobile(mob);
        //regPage.acceptTerms();
    }

    @And("user click on Register button")
    public void user_clicks_register() {
        regPage.clickRegister();
    }
    
    @Then("registration should be successful")
    public void registration_success() {
        boolean success = regPage.isUserLoggedIn();
        Assert.assertTrue(success, "✅ Registration was successful");
        System.out.println("❌ Registration failed – success message not found!"); 
        try {
            Thread.sleep(4000); // wait for 4 seconds before taking screenshot
			TestHooks.tearDown(scenario);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.quit();
    }
    
    @Then("user must see an error message {string}")
    public void the_user_should_see_an_error_message(String err_m) {
    	boolean success = regPage.getMobileErrorMessage();
        Assert.assertTrue(success, err_m);
        System.out.println("✅ Registration was successful");        
        try {
            Thread.sleep(4000); // wait for 4 seconds before taking screenshot
			TestHooks.tearDown(scenario);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.quit();
    }

}



