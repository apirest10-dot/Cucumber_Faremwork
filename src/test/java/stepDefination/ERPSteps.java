package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ERPSteps {
	WebDriver driver;
	String Exp_Num ="";
	String Act_Num ="";
	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://webapp.qedgetech.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String user, String pass) throws Throwable {
	    driver.findElement(By.name("username")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.name("username")).sendKeys(user);
	    driver.findElement(By.name("password")).clear();
	    Thread.sleep(1000);
	    driver.findElement(By.name("password")).sendKeys(pass);
	        
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() throws Throwable {
		 driver.findElement(By.name("btnsubmit")).click();
		 Thread.sleep(1000);
	}

	@Then("Dashboard should be displayed")
	public void dashboard_should_be_displayed() {
	    if(driver.findElement(By.id("ewPageCaption")).isDisplayed())
	    {
	    	Reporter.log("Dashboard Text Displayed In Home Page",true);
	    }
	}

	@When("user should navigate to add supplier page")
	public void user_should_navigate_to_add_supplier_page() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Suppliers')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-caption='Add'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("Capture Supplier number")
	public void capture_supplier_number() throws Throwable {
	    Exp_Num = driver.findElement(By.name("x_Supplier_Number")).getAttribute("value");
	    Thread.sleep(1000);
	}

	@When("user enter supplier details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enter_supplier_details(String sname, String address, String city,
	String country, String cperson, String pnumber, String email, String mnumber, String notes) {
	    driver.findElement(By.name("x_Supplier_Name")).sendKeys(sname);
	    driver.findElement(By.name("x_Address")).sendKeys(address);
	    driver.findElement(By.name("x_City")).sendKeys(city);
	    driver.findElement(By.name("x_Country")).sendKeys(country);
	    driver.findElement(By.name("x_Contact_Person")).sendKeys(cperson);
	    driver.findElement(By.name("x_Phone_Number")).sendKeys(pnumber);
	    driver.findElement(By.name("x__Email")).sendKeys(email);
	    driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
	    driver.findElement(By.name("x_Notes")).sendKeys(notes);
	      
	}

	@When("user click add button")
	public void user_click_add_button() throws Throwable {
	    driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	}

	@When("user click confirm ok")
	public void user_click_confirm_ok() throws Throwable {
	    driver.findElement(By.xpath("(//button[normalize-space()='OK!'])[1]")).click();
	    Thread.sleep(2000);
	}

	@When("user click alert ok button")
	public void user_click_alert_ok_button() throws Throwable {
		Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[starts-with(text(),'OK')])[6]")).click();
	    Thread.sleep(2000);
	}

	@When("user should search for supplier number")
	public void user_should_search_for_supplier_number() throws Throwable {
	    if(!driver.findElement(By.name("psearch")).isDisplayed())
	    	 Thread.sleep(1000);
	    	driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
	    	driver.findElement(By.name("psearch")).clear();
	    	driver.findElement(By.name("psearch")).sendKeys(Exp_Num);
	    	driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
	    	Thread.sleep(2000);
	}

	@Then("user should validate supplier number in table")
	public void user_should_validate_supplier_number_in_table() {
	    Act_Num = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
	   Reporter.log(Exp_Num+"     "+Act_Num,true);
	   try {
		Assert.assertEquals(Exp_Num, Act_Num,"Supplier Number Not Found In Table");
	} catch (AssertionError	e) {
		Reporter.log(e.getMessage(),true);
	}
	}

	@When("user close browser")
	public void user_close_browser() {
	   driver.quit();
	}

	@When("user should navigate to add customer page")
	public void user_should_navigate_to_add_customer_page() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[starts-with(text(),'Customers')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@data-caption='Add'])[1]")).click();
		Thread.sleep(1000);
	}

	@When("Capture customer number")
	public void capture_customer_number() throws Throwable {
		Exp_Num = driver.findElement(By.name("x_Customer_Number")).getAttribute("value");
	    Thread.sleep(1000);
	}

	@When("user enter customer details {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enter_customer_details(String cname, String address, String city, String country, 
			String cperson, String pnumber, String email, String mnumber, String notes) {
		driver.findElement(By.name("x_Customer_Name")).sendKeys(cname);
	    driver.findElement(By.name("x_Address")).sendKeys(address);
	    driver.findElement(By.name("x_City")).sendKeys(city);
	    driver.findElement(By.name("x_Country")).sendKeys(country);
	    driver.findElement(By.name("x_Contact_Person")).sendKeys(cperson);
	    driver.findElement(By.name("x_Phone_Number")).sendKeys(pnumber);
	    driver.findElement(By.name("x__Email")).sendKeys(email);
	    driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
	    driver.findElement(By.name("x_Notes")).sendKeys(notes);
	}

	@When("user should search for customer number")
	public void user_should_search_for_customer_number() throws Throwable {
		if(!driver.findElement(By.name("psearch")).isDisplayed())
	    	 Thread.sleep(1000);
	    	driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
	    	driver.findElement(By.name("psearch")).clear();
	    	driver.findElement(By.name("psearch")).sendKeys(Exp_Num);
	    	driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
	    	Thread.sleep(2000);
	}

	@Then("user should validate customer number in table")
	public void user_should_validate_customer_number_in_table() {
		 Act_Num = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
		   Reporter.log(Exp_Num+"     "+Act_Num,true);
		   try {
			Assert.assertEquals(Exp_Num, Act_Num,"Customer Number Not Found In Table");
		} catch (AssertionError	e) {
			Reporter.log(e.getMessage(),true);
		}
	}


}
