package belatrix.automation.ebay.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverUtil {

	private static WebDriver driver;
	
	private static final String DRIVER_PATH = "D:\\Automatizacion\\workspace\\belatrix.automation.ebay\\src\\test\\resources\\drivers\\chromedriver.exe";
	
	public static void IniciarChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);
	}
	
	public static WebDriver getChromeDriver() {
		return driver;
	}
}
