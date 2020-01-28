package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

	public static WebDriver driver;
	PageObjects po;

	@Given("^Navigate to Home Page$")
	public void Navigate() {
		System.setProperty("webdriver.chrome.driver", "C:\\NVS UFT\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/");
		po = new PageObjects(driver);
	}

	@When("^user enters the username and password$")
	public void enters() {

		po.signin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
	}

	@Then("^user login successfully")
	public void login() {
		System.out.println("User logged in succesfully");

	}

	@When("^user searches products$")
	public void search(DataTable dt) {
		List<String> pt = dt.asList(String.class);
		for (String s : pt) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
		}
	}

	@Then("^products should be added in a cart if available$")
	public void searchpr() {
		System.out.println("Products added!!");
	}

	@When("^user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void entersunamepwd(String uname, String pwd) {

		po.signin.click();
		po.username.sendKeys(uname);
		po.password.sendKeys(pwd);
		po.login.click();
	}

}
