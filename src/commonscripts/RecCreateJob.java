package commonscripts;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class RecCreateJob extends CommonMethodsUsed {
	CommonMethodsUsed help = new CommonMethodsUsed();
	
	public void createjobfromrec(String JobTitle, String JdFilepath) throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//input[@name='companyname']")).sendKeys(HiringCompanyname);
		Reporter.log(HiringCompanyname);

		RequisitionNumber = alphanumeric();
		driver.findElement(By.xpath("//input[@name='job_code']")).sendKeys(RequisitionNumber);
		driver.findElement(By.xpath("//input[@ng-model='jobData.title']")).sendKeys(JobTitle);
		Reporter.log(JobTitle);
		driver.findElement(By.xpath("//textarea[@placeholder='Job Description']")).sendKeys(JobdescriptionContent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@filetype='jd_file']")).click();
		help.uploadfile(JdFilepath);
		Thread.sleep(2000);

		for (int i = 0; i < 5; i++) {
			driver.findElement(
					By.xpath("//input[contains(@placeholder,'Select Required Skills (example: java, c, etc)')]"))
					.sendKeys(RequiredSkills[i]);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@ng-bind-html='$highlight($getDisplayText())']")).click();
		}

		for (int j = 0; j < OptionalSkill.length; j++) {
			driver.findElement(By.xpath("//input[@placeholder='Select Optional Skills (example: java, c, etc)']"))
					.sendKeys(OptionalSkill[j]);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@ng-bind-html='$highlight($getDisplayText())']")).click();
		}

		driver.findElement(By.xpath("//input[@ng-model='jobData.experience_required']")).sendKeys(YearsofExperience);
		Reporter.log(YearsofExperience);

		driver.findElement(By.xpath("//input[@placeholder='Job Closing Date']")).click();
		help.CalendarDay(10);

		Codingsamples = driver.findElement(By.xpath("(//input[@ng-model='jobData.coding_required'])[2]"))
				.isSelected();
		if (Codingsamples == true) {
			System.out.println("Coding not required option is selected");
		} else {
			driver.findElement(By.xpath("(//input[@ng-model='jobData.coding_required'])[2]")).click();
		}

		Whiteboardsamples = driver.findElement(By.xpath("(//input[@name='whiteboard_required'])[2]")).isSelected();
		if (Whiteboardsamples == true) {
			System.out.println("Whiteboardsamples not required option is selected");
		} else {
			driver.findElement(By.xpath("(//input[@name='whiteboard_required'])[2]")).click();
		}

		Select LocationPreference = new Select(driver.findElement(By.id("interviewer_location_preference")));
		LocationPreference.selectByVisibleText("India");

		Select LanguagePreference = new Select(driver.findElement(By.id("interviewer_language_preference")));
		LanguagePreference.selectByVisibleText("English");

		driver.findElement(By.id("number_of_prospects")).sendKeys(NumberofCandidates);
		Reporter.log(NumberofCandidates);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='save_and_exit']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@ng-if='skipBtnShow']")).click();
	}
}
