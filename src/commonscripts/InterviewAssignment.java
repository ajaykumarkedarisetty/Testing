package commonscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class InterviewAssignment extends BrowserMethods {
	public void Assignmentopportunity() throws InterruptedException, AWTException {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_SHIFT);
		robo.keyPress(KeyEvent.VK_N);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_SHIFT);
		robo.keyRelease(KeyEvent.VK_N);

		String current_window = driver.getWindowHandle();
		Thread.sleep(2000);

		Set<String> s1 = driver.getWindowHandles();
		System.out.println(s1.size());

		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String next_window = i1.next();
			if (!current_window.equalsIgnoreCase(next_window)) {
				driver.switchTo().window(next_window);
				System.out.println(driver.getTitle());
			}
		}

		driver.navigate().to("https://qa.eteki.com/account/login");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(InterviewerMail);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("12345678");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@ui-sref='interviewer.notifications']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='pane_header_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='label label-success notification-btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@tabindex='1']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@tabindex='1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='header-user-img']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@ ng-click='logout();']")).click();
		driver.switchTo().window(current_window);
	}
}
