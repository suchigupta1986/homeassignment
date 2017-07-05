package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NikonSearchDefination {

	//WebDriver driver=new FirefoxDriver();
	WebDriver driver=null;
		
	@Given("^Open \"(.*?)\" in Firefox browser$")
	public void open_in_Firefox_browser(String url)throws Throwable {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Suchi\\Downloads\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);  
	}

	@Given("^Enter Nikon in Search bar$")
	public void enter_Nikon_in_Search_bar() throws Throwable {
	 driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Nikon");
	}

	@Given("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();   
	}

	@Given("^select sort results from highest to lowest$")
	public void select_sort_results_from_highest_to_lowest() throws Throwable {
		WebElement address=driver.findElement(By.xpath(".//*[@id='sort']"));
		Select HTL=new Select(address);
		HTL.selectByVisibleText("Price: High to Low");
		Thread.sleep(5000L);  
	}

	@When("^I select the second result for Nikon$")
	public void i_select_the_second_result_for_Nikon() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();  
	}

	@Then("^Product Title should text as Nikon D(\\d+)X$")
	public void product_Title_should_text_as_Nikon_D_X(int arg1) throws Throwable {
		String Productname=driver.findElement(By.xpath(".//*[@id='productTitle']")).getText();
		System.out.println(Productname);
		Assert.assertTrue(Productname.contains("Nikon D3X"));
		System.out.println("Product Matched");   
	}


}
