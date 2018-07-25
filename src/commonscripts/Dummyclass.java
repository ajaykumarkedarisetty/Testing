package commonscripts;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Dummyclass extends CommonMethodsUsed {
	AdminloginMethod adminlog = new AdminloginMethod();
	CommonMethodsUsed helpmethods = new CommonMethodsUsed();
	CreatejobMethod ct = new CreatejobMethod();
	
	@Test
	public void job() throws InterruptedException, AWTException {
		adminlog.Adminlogin();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='section-nav']/ul[2]/li[3]/a")).click();
		driver.findElement(By.xpath(".//input[@type='text']")).sendKeys("ajaykumar");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@ng-click='filter()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='recruiters']/div[2]/div[1]/div/div/div/div/div[7]/div/button")).click();
		driver.findElement(By.xpath(".//*[@id='recruiters']/div[2]/div[1]/div/div/div/div/div[7]/div/ul/li[5]/a"))
				.click();
		Thread.sleep(2000);
		
		
		RequiredSkills = new String[]{"core java","Qa Automation","Manual Testing","Selenium Webdriver", 
				"Selenium Grid"};
		
		OptionalSkill = new String[]{"HTML","Load Testing","Performance Testing","html5", 
				"Ruby","java script"};
		
		ct.createjob("java arc", "A:\\Selenium WorkSpace\\lib\\candidate resume.txt");
	}
}

