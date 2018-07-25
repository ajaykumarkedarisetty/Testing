package commonscripts;

import java.awt.AWTException;
import org.openqa.selenium.By;

public class AddCandidateMethod extends CommonMethodsUsed {
	AdminloginMethod Adlogin = new AdminloginMethod();
	CommonMethodsUsed Commethods = new CommonMethodsUsed();

	public void candidateform(String candidatefirstname, String candidatelastname, String candidatemail,
			String fileupload) throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(candidatefirstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(candidatelastname);
		driver.findElement(By.xpath("//input[@ng-model='candidate.email']")).sendKeys(candidatemail);
		driver.findElement(By.xpath("//div[@class='flag-dropdown']")).click();
		Commethods.selectcountry();
		phonenumber = Random_MobileNumber();
		driver.findElement(By.xpath("//input[@ ng-model='phone']")).sendKeys(phonenumber);
		driver.findElement(By.xpath("//button[@filetype='brief_bio_file']")).click();
		Commethods.uploadfile(fileupload);// A:\\Selenium WorkSpace\\lib\\candidate resume.txt
		driver.findElement(By.xpath("//input[@placeholder='Candidate Report Due By']")).click();
		Commethods.CalendarDaymethod(7);
		Commethods.Timezonemethod();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-click='addCandidate()']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@ng-click='$dismiss()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
	}
}
