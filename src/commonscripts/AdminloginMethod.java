package commonscripts;

import org.openqa.selenium.By;

public class AdminloginMethod extends CommonMethodsUsed {
	BrowserMethods launch = new BrowserMethods();

	public void Adminlogin() throws InterruptedException {
		//launch.setup();
		launch.url("https://qa.eteki.com/admin/login");
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(AdminEmail);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Pending Candidates
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='header-user-img']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu header-dropdown-menu']//a[@href='/admin/jobs']"))
				.click();
	}
}