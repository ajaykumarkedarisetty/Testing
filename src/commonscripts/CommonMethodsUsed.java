package commonscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethodsUsed extends BrowserMethods {

	public String Random_MobileNumber() {
		Random rand = new Random();
		int num = rand.nextInt(900000000) + 100000000;
		String firstdigit = "08";
		String mobileNumber = firstdigit += num;
		System.out.println(mobileNumber);
		return mobileNumber;
	}

	public void selectcountry() {
		List<WebElement> countryflag = driver.findElements(By.xpath("//span[@ class='dial-code']"));
		countryflag.size();
		String RequiredCountrycode = "+91";
		for (int i = 0; i < countryflag.size(); i++) {
			dialcodes = countryflag.get(i).getText();
			if (dialcodes.equalsIgnoreCase(RequiredCountrycode)) {
				countryflag.get(i).click();
			}
		}
	}

	public void uploadfile(String FileLocation) throws AWTException {
		Robot r = new Robot();
		StringSelection ss = new StringSelection(FileLocation);// "D:/Test/Test1.docx"
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void CalendarDaymethod(int DaysToAdd) {
		// Date picker- calendar
		List<WebElement> displayeddates = driver.findElements(By.xpath("(//*[starts-with(@id,'datepicker')])"));
		System.out.println(displayeddates.size());
		for (WebElement ele : displayeddates) {
			String date = ele.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DATE, DaysToAdd); // Adding days
			String output = sdf.format(c.getTime());
			if (date.equalsIgnoreCase(output)) {
				ele.click();
				break;
			}
		}
	}

	public void Timezonemethod() {
		Select zone = new Select(driver.findElement(By.xpath("//select[@name='timezone']")));
		zone.selectByValue("string:Asia/Calcutta");
	}
}
