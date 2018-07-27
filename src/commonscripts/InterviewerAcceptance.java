package commonscripts;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class InterviewerAcceptance extends BrowserMethods {
	InterviewAssignment interviewopportunity = new InterviewAssignment();

	public void InterviewerAcceptancetoJob() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@style='']//div[@class='panel-heading']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h5[@interviewer-details='interviewer'])[1]")).click();
		Thread.sleep(3000);
		InterviewerDisplayName = driver.findElement(By.xpath("(//dl[@class='dl-horizontal']//dd)[1]")).getText();
		InterviewerMail = driver.findElement(By.xpath("(//dl[@class='dl-horizontal']//dd)[2]")).getText();
		Reporter.log(InterviewerDisplayName);
		Reporter.log(InterviewerMail);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-click='$close()']")).click();
		Thread.sleep(3000);
		InterviewerStatustoJob = driver.findElement(By.xpath(
				"(//li[@style='word-break: break-all;'])[1]//div[@class='col-md-1 col-sm-12 col-xs-12 text-center']"))
				.getText();
		System.out.println(InterviewerStatustoJob);
		Reporter.log(InterviewerStatustoJob);
		if (InterviewerStatustoJob.equals("New")) {
			driver.findElement(By.xpath(
					"(//div[@class='interviewers-scroll']//div[@class='row int-row'])[1]//button[@ng-click='sendNotification(interviewer)']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
			Thread.sleep(1000);
			interviewopportunity.Assignmentopportunity();

		} else if (InterviewerStatustoJob.equals("Pending")) {
			driver.findElement(By.xpath(
					"(//div[@class='interviewers-scroll']//div[@class='row int-row'])[1]//button[@ng-click='acceptRequest(interviewer)']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
		} else if (InterviewerStatustoJob.equalsIgnoreCase("Declined")) {
			driver.findElement(By.xpath(
					"(//div[@class='interviewers-scroll']//div[@class='row int-row'])[1]//button[@ng-click='acceptRequest(interviewer)']"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@tabindex='1']")).click();
		} else {
			System.out.println("Interviewer already Accepted/Selected to job");
		}

	}

}
