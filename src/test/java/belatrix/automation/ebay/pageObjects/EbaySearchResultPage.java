package belatrix.automation.ebay.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import belatrix.automation.ebay.Utilities.Utilities;
import models.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class EbaySearchResultPage extends PageObject {

	private final static Logger LOGGER = Logger.getLogger(EbaySearchResultPage.class.getName());

	private static WebDriver driver;
	private static WebDriverWait wait;
	Actions action;

	public static Product product = new Product();
	public static List<Product> products = new ArrayList<>();

	private static WebElement edtBrandSearch;
	private String edtBrandSearchClass = "x-searchable-list__textbox__aspect-Brand";
	private WebElement chkBrand;
	private WebElement chkSize;
	private String cmbSortByOptionsXpath = "//ul[@class=\"srp-sort__menu\"]/li/a";
	private String cmbSortByXpath = "//div[@class=\"srp-controls--selected-value\"]";
	private String txtProductNameClass = "s-item__title";
	private WebElement txtTotalAmountResults;
	private String txtTotalAmountResultsXpath = "//span[text() = \"shoes\"]/preceding-sibling::span";
	private String txtListOfPricesXpath = "//div[@class = \"s-item__details clearfix\"]/div[1]/span[@class = \"s-item__price\"]";
	private String txtListOfProductsXpath = "//h3[@class = \"s-item__title\"]";

	private String brand;

	public void typeBrandOnSearchbox(String brand) {
		driver = getDriver();
		wait = new WebDriverWait(driver, 10);

		edtBrandSearch = wait.until(ExpectedConditions.elementToBeClickable(By.className(this.edtBrandSearchClass)));
		edtBrandSearch.sendKeys(brand);
		edtBrandSearch.sendKeys(Keys.ENTER);
		this.brand = brand;
	}

	public void selectBrandInCheckbox() {
		this.chkBrand = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[@class=\"cbx x-refine__multi-select-cbx\" and contains(text(),\"" + brand + "\")]")));
		this.chkBrand.click();
	}

	public void selectSizeCheckbox(String size) {
		this.chkSize = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[@class=\"cbx x-refine__multi-select-cbx\" and contains(text(),\"" + size + "\")]")));
		this.chkSize.click();
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
		for (WebElement item : options) {
			if (item.getAttribute("innerHTML").contains(option)) {
				item.click();
				LOGGER.info("Option has been found and it is selected for sorting products");
				break;
			}
		}

	}

	public double[] getFirstFivePrices() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(this.txtProductNameClass)));
		List<WebElement> rawPrices = driver.findElements(By.xpath(this.txtListOfPricesXpath));
		List<WebElement> productsList = driver.findElements(By.xpath(this.txtListOfProductsXpath));
		double firstFivePrices[] = new double[5];
		for (int i = 0; i < firstFivePrices.length; i++) {
			firstFivePrices[i] = Utilities.getFormatedPrice(rawPrices.get(i).getText());
		}
		LOGGER.info("gets first 5 products");
		for (int j = 0; j < rawPrices.size(); j++) {
			products.add(
					new Product(productsList.get(j).getText(), Utilities.getFormatedPrice(rawPrices.get(j).getText())));
		}
		LOGGER.info("fills in the products model");
		return firstFivePrices;
	}

	public void getTheTotalAmountOfResults() {
		this.txtTotalAmountResults = driver.findElement(By.xpath(this.txtTotalAmountResultsXpath));
		String totalAmountResults = this.txtTotalAmountResults.getText();
		product.setTotalAmountResult(totalAmountResults);

	}

}
