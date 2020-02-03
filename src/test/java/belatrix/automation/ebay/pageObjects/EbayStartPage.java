package belatrix.automation.ebay.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import belatrix.automation.ebay.Utilities.ChromeDriverUtil;
import net.serenitybdd.core.pages.PageObject;

public class EbayStartPage extends PageObject {

	private static WebDriver driver;
	
	private static WebDriverWait wait;
	
	private static WebElement edtSearchBox;
	String edtSearchBoxId = "gh-ac";
	private static WebElement btnBuscar;
	private String btnBuscarId = "gh-btn";
	
	public void OpenBrowserAndGoToEbay() {
		
//		ChromeDriverUtil.IniciarChromeDriver();
//		driver = ChromeDriverUtil.getChromeDriver();
		driver = getDriver();
		driver.get("https://www.ebay.com/");
		wait = new WebDriverWait(driver, 10);
	}

	public void SearchForShoes() {
		
		edtSearchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id(this.edtSearchBoxId)));
		edtSearchBox.click();
		edtSearchBox.sendKeys("shoes");
		
	}

	public void clickOnSearchButton() {
		
		btnBuscar = driver.findElement(By.id(this.btnBuscarId));
		btnBuscar.click();
		
	}

}
