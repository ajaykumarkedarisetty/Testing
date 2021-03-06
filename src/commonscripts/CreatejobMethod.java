package commonscripts;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CreatejobMethod extends CommonMethodsUsed {
	CommonMethodsUsed Commethods = new CommonMethodsUsed();
	
	public void createjob(String JobTitle, String UploadResumePath) throws AWTException, InterruptedException {
		// Create job form

		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys(HiringCompanyname);
		RequisitionNumber = alphanumeric();
		driver.findElement(By.xpath("//input[@name='job_code']")).sendKeys(RequisitionNumber);
		driver.findElement(By.xpath("//input[@ng-model='jobDetailsData.title']")).sendKeys(JobTitle);
		Reporter.log(JobTitle);
		driver.findElement(By.xpath("//a[@filetype='jd_file']")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(JobdescriptionContent);
		Commethods.uploadfile(UploadResumePath);
		Thread.sleep(2000);

		for (int i = 0; i < 5; i++) {
			driver.findElement(
					By.xpath("//input[contains(@placeholder,'Select Required Skills (example: java, c, etc)')]"))
					.sendKeys(RequiredSkills[i]);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@ng-bind-html='$highlight($getDisplayText())']")).click();
		}

		for (int j = 0; j < OptionalSkill.length; j++) {
			driver.findElement(By.xpath("//input[@placeholder='Select Optional Skills (example: java, c, etc)']"))
					.sendKeys(OptionalSkill[j]);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@ng-bind-html='$highlight($getDisplayText())']")).click();
		}

		driver.findElement(By.xpath("//input[@placeholder='Relevant Experience']")).sendKeys(YearsofExperience);
		Reporter.log(YearsofExperience);

		driver.findElement(By.xpath("//input[@placeholder='Job Closing Date']")).click();
		Thread.sleep(2000);
		Commethods.CalendarDay(10);

		Codingsamples = driver.findElement(By.xpath("(//input[@ng-model='jobDetailsData.coding_required'])[2]"))
				.isSelected();
		if (Codingsamples == true) {
			System.out.println("Coding not required option is selected");
		} else {
			driver.findElement(By.xpath("(//input[@ng-model='jobDetailsData.coding_required'])[2]")).click();
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

		SelectedInterviewer = driver.findElement(By.xpath("(//input[@name='selected_interviewers'])[2]")).isSelected();
		if (Whiteboardsamples == true) {
			System.out.println("Selected Interviewer not required option is selected");
		} else {
			driver.findElement(By.xpath("(//input[@name='selected_interviewers'])[2]")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-click='jobCreate()']")).click();
		Thread.sleep(13000);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
	}
}
