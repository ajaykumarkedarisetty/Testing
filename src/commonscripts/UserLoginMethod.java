package commonscripts;

import org.openqa.selenium.By;

public class UserLoginMethod extends BrowserMethods {
		
	BrowserMethods browsermethod = new BrowserMethods();
		
		
		public void userlogin(String usermail, String userpassword) throws InterruptedException {
			//BrowsereMethods.setup();
			browsermethod.url("https://qa.eteki.com/account/login");
			driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys(usermail);
			driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			Boolean ROIpopupispresent = driver.findElements(By.xpath("//button[contains(text(),'Remind Me Later')]")).size() >0;
			if(ROIpopupispresent== true) {
				driver.findElement(By.xpath("//button[contains(text(),'Remind Me Later')]")).click();
			}else if(ROIpopupispresent== false){
				System.out.println("Login success");
			}
		}
	}

