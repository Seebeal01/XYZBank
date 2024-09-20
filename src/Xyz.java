import java.time.Duration;
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
	Random random = new Random();

	@BeforeTest
	public void mystup() {
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void logINCustumer() {

		WebElement customerLoginButton = driver.findElement(By.cssSelector("button[ng-click='customer()']"));
		customerLoginButton.click();
	}

	@Test(priority = 2)
	public void SelectCustomer() {

		List<WebElement> customerOptions = driver.findElements(By.className("ng-binding"));
		int Customer = customerOptions.size();
		int randomcustomer = random.nextInt(Customer);
		customerOptions.get(randomcustomer).click();
		// Click on Login
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();
	}

	@Test(priority = 3)
	public void Deposit() {
		driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
		int randomnumber = random.nextInt(99999);
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys(String.valueOf(randomnumber));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
