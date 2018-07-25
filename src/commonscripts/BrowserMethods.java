package commonscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods extends Config {
	public static WebDriver driver;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", ChromeBrowser_exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://qa.eteki.com/admin/login");
	}

	public void url(String URL_to_Navigate) {
		driver.get(URL_to_Navigate);
	}
}
