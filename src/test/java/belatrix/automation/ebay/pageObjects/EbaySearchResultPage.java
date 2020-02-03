package belatrix.automation.ebay.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import belatrix.automation.ebay.Utilities.ChromeDriverUtil;
import belatrix.automation.ebay.Utilities.Utilities;
import models.ResultsModel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class EbaySearchResultPage extends PageObject {

	private static WebDriver driver;
	private static WebDriverWait wait;
	Actions action;
	
	public static ResultsModel resultsData = new ResultsModel();
	
	
	private static WebElement edtBrandSearch;
	private String edtBrandSearchClass = "x-searchable-list__textbox__aspect-Brand";
	private WebElement chkBrand;
	private WebElement chkSize;
	private String cmbSortByOptionsXpath = "//ul[@class=\"srp-sort__menu\"]/li/a";
	private String cmbSortByXpath = "//div[@class=\"srp-controls--selected-value\"]";
	private String txtProductNameClass = "s-item__title";
	private WebElement txtTotalAmountResults;
	private String txtTotalAmountResultsXpath = "//span[text() = \"shoes\"]/preceding-sibling::span";
	private String txtListOfPricesXpath = "//span[@class = \"s-item__price\"]"; 
	private String txtListOfProductsXpath = "//h3[@class = \"s-item__title\"]";
	
	private String brand;

	public void typeBrandOnSearchbox(String brand) {
//		driver = ChromeDriverUtil.getChromeDriver();
		driver = getDriver();
		wait = new WebDriverWait(driver,10);
		
		edtBrandSearch = wait.until(ExpectedConditions.elementToBeClickable(By.className(this.edtBrandSearchClass)));
		edtBrandSearch.sendKeys(brand);
		edtBrandSearch.sendKeys(Keys.ENTER);
		this.brand = brand;
	}

	public void selectBrandInCheckbox() {
		this.chkBrand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"cbx x-refine__multi-select-cbx\" and contains(text(),\""+brand+"\")]")));
		this.chkBrand.click();
	}

	public void selectSizeCheckbox(String size) {
		this.chkSize = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"cbx x-refine__multi-select-cbx\" and contains(text(),\""+size+"\")]")));
		this.chkSize.click();
		waitFor(2).seconds();
		this.action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h3[contains(text(),'Ancho')]"))).perform();
		Serenity.takeScreenshot();
		waitFor(2).seconds();
		
	}

	public void selectMoreExpensiveLast() {
		String option = "Precio + Envío: más bajo primero";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.cmbSortByXpath)));
		List<WebElement> options = driver.findElements(By.xpath(this.cmbSortByOptionsXpath));
		this.action = new Actions(driver);
		WebElement opciones = driver.findElement(By.xpath(this.cmbSortByXpath));
		action.moveToElement(opciones).perform();
		for(WebElement item: options) {
			if(item.getAttribute("innerHTML").contains(option)) {
				item.click();
				break;
			}
		}
		
	}

	public double[] getFirstFivePrices() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(this.txtProductNameClass)));
		List<WebElement> rawPrices = driver.findElements(By.xpath(this.txtListOfPricesXpath));
		List<WebElement> productsList = driver.findElements(By.xpath(this.txtListOfProductsXpath));
		resultsData.setProductsName(Utilities.getValuesFromElements(productsList));
		resultsData.setProductsPrice(Utilities.getValuesFromElements(rawPrices));
		double firstFivePrices[] = new double[5];
		for(int i = 0; i < firstFivePrices.length; i++) {
			firstFivePrices[i] = Utilities.getFormatedPrice(rawPrices.get(i).getText());
		}
		return firstFivePrices;
	}

	public void getTheTotalAmountOfResults() {
		this.txtTotalAmountResults = driver.findElement(By.xpath(this.txtTotalAmountResultsXpath));
		String totalAmountResults = this.txtTotalAmountResults.getText();
		System.out.println("Cantidad de Resultados: "+totalAmountResults);
		resultsData.setTotalAmountResult(totalAmountResults);
		
	}


	
}
