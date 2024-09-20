import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Xyz {
	WebDriver driver = new ChromeDriver();
	String Url = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";
	Random random = new Random();
	int randomnumber = random.nextInt(99999);

	@BeforeTest
	public void mystup() {
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	public void DepositAndWithdrawl() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();

		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys(String.valueOf(randomnumber));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
		Thread.sleep(10000);
		WebElement Withdrawl = driver.findElement(By.xpath("//input[@placeholder='amount']"));
		Withdrawl.sendKeys(String.valueOf(randomnumber));
		driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();

	}

	@Test(priority = 4)
	public void Assert() {
		WebElement ass = driver.findElement(By.xpath("//div[@ng-hide='noAccount']//strong[2]"));
		int finalBalance = Integer.parseInt(ass.getText());
		Assert.assertEquals(finalBalance, 0, "Balance should be 0 after withdrawing the deposited amount");
	}
	@Test(priority=5)
	public void addnewcudtomer() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("seebeal");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("abulila");
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
}
