package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Task {
	WebDriver driver;

	@Given("user launches browser")
	public void user_launches_browser() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}

	@When("user acces the homepage")
	public void user_acces_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.get("https://www.bausparen.at/de/bausparen.html");
		 if(driver.findElement(By.id("onetrust-reject-all-handler")).isDisplayed())
	   	 {
	   		driver.findElement(By.id("onetrust-reject-all-handler")).click();
	   	 }
	   	 else
	   	 {
	   		 System.out.println("pop not shown");
	   	 }
	}

	@When("user click on {string} and  verify the respective {string}")
	public void user_click_on_and_verify_the_respective(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]")).click();
		Thread.sleep(3000);
System.out.println(driver.getCurrentUrl());
		  Assert.assertTrue(driver.getTitle().contains(string2));
	}

	@When("user click on {string}")
	public void user_click_on(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]")).click();

	}

	@Then("user click on download file")
	public void user_click_on_download_file() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[text()='Download Produktinfos']//parent::a")).click();
	}
	@Then("user click on emi calculator")
	public void user_click_on_emi_calculator() {
		driver.findElement(By.xpath("(//span[text()='Jetzt starten']//parent::a)[1]")).click();

	}

	@Given("search {string}")
	public void search(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("search--input-header")).sendKeys("Immobilie bewerten");
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();

	}

	@Then("Observe the data")
	public void observe_the_data() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.findElement(By.xpath("(//p[text()='Ihr Suchbegriff ergab keine Treffer.'])[4]")).isDisplayed());
	}
	@Then("^menu links should display$")
	public void menu_links_should_display(DataTable dt) throws Throwable {

List<String> data=dt.asList(String.class);
for(int i=0;i<data.size();i++)
{
	driver.findElement(By.xpath("//a[contains(text(),'"+data.get(i)+"')]")).isDisplayed();
}
		
	}
}
