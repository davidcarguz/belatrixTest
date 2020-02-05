package belatrix.automation.ebay.pageObjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;

public class EbayStartPage extends PageObject {

	private final static Logger LOGGER = Logger.getLogger(EbayStartPage.class.getName());
	
	private static WebDriver driver;
	
	private static WebDriverWait wait;
	
	private static WebElement edtSearchBox;
	String edtSearchBoxId = "gh-ac";
	private static WebElement btnBuscar;
	private String btnBuscarId = "gh-btn";
	
	public void OpenBrowserAndGoToEbay() {
		
		driver = getDriver();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, 10);
	}

	public void SearchForShoes() {
		
		edtSearchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id(this.edtSearchBoxId)));
		edtSearchBox.sendKeys("shoes");
		LOGGER.info("search for shoes on searchbox");
		
	}

	public void clickOnSearchButton() {
		
		btnBuscar = driver.findElement(By.id(this.btnBuscarId));
		btnBuscar.click();
		
	}

}
