import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Xyz {
	WebDriver driver = new EdgeDriver();
	String Url = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";

	@BeforeTest
	public void mystup() {
		driver.manage().window().maximize();
		driver.get(Url);
	}

	@Test(priority = 1)
	public void logINCustumer() throws InterruptedException {
		Thread.sleep(5000);
		WebElement customerLoginButton = driver.findElement(By.cssSelector("button[ng-click='customer()']"));
		customerLoginButton.click();
	}

	@Test(priority = 2)
	public void SelectCustomer() throws InterruptedException {
		Thread.sleep(5000);

		List<WebElement> customerOptions = driver.findElements(By.className("ng-binding"));
		Random random = new Random();
		int Customer = customerOptions.size();
		int randomcustomer = random.nextInt(Customer);
		customerOptions.get(randomcustomer).click();
		// Click on Login
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();
	}
	@Test(priority = 3)
	public void Deposit() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
		
		
	}

}
