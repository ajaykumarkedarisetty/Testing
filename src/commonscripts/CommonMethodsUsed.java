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
import org.testng.Reporter;

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

	public void CalendarDay(int DaystoAdd) {
		List<WebElement> calendardates = driver.findElements(By.xpath("(//*[starts-with(@id,'datepicker')])"));
		System.out.println(calendardates.size());

		SimpleDateFormat simpledate = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String Todaydate = simpledate.format(c.getTime());
		Reporter.log(Todaydate);
		int Todaydate_int = Integer.parseInt(Todaydate);

		int AddedDate = Todaydate_int + DaystoAdd;
		datetoselect = "(//td[starts-with(@id,'datepicker')])[" + AddedDate + "]";

		for (WebElement ele : calendardates) {
			String dates = ele.getText();
			Reporter.log(dates);

			if (dates.equalsIgnoreCase(Todaydate)) {
				driver.findElement(By.xpath(datetoselect)).click();
				break;
			}
		}
	}

	public void Timezonemethod() {
		Select zone = new Select(driver.findElement(By.xpath("//select[@name='timezone']")));
		zone.selectByValue("string:Asia/Calcutta");
	}

	public StringBuilder alphanumeric() {
		Aplhanumeric = (letters + letters.toUpperCase() + numbers).toCharArray();
		StringBuilder randnumber = new StringBuilder();
		for (int z = 0; z < 5; z++) {
			randnumber.append(Aplhanumeric[new Random().nextInt(Aplhanumeric.length)]);
		}
		return randnumber;
	}

}
