package commonscripts;

import java.awt.AWTException;

import org.openqa.selenium.By;

public class CreatejobMethod extends CommonMethodsUsed {
	AdminloginMethod adminlog = new AdminloginMethod();
	CommonMethodsUsed Commethods = new CommonMethodsUsed();
	
	public void createjob(String JobTitle, String UploadResumePath) throws AWTException, InterruptedException {
		// Create job form

		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys(HiringCompanyname);
		driver.findElement(By.xpath("//input[@ng-model='jobDetailsData.title']")).sendKeys(JobTitle);
		driver.findElement(By.xpath("//a[@filetype='jd_file']")).click();
		Commethods.uploadfile(UploadResumePath);
		Thread.sleep(5000);

		for (int i = 0; i < 5; i++) {
			driver.findElement(
					By.xpath("//input[contains(@placeholder,'Select Required Skills (example: java, c, etc)')]"))
					.sendKeys(RequiredSkills[i]);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@ng-bind-html='$highlight($getDisplayText())']")).click();
			
			}
		}
	}

