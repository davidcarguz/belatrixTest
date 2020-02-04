package belatrix.automation.ebay.steps;

import static org.junit.Assert.assertTrue;

import belatrix.automation.ebay.Utilities.Utilities;
import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import belatrix.automation.ebay.pageObjects.EbayStartPage;
import net.thucydides.core.annotations.Step;

public class EbaySearchSteps {

	EbayStartPage ebayStartPage;
	EbaySearchResultPage ebaySearchResultPage;
	
	@Step("Open Browser and goes to www.ebay.com")
	public void openBrowserAndGoToEbay() {
		ebayStartPage.OpenBrowserAndGoToEbay();
		
	}

	@Step("Search for shoes")
	public void searchForShoes() {
		ebayStartPage.SearchForShoes();
		ebayStartPage.clickOnSearchButton();
		
	}

	@Step("Selects brand Puma from brand filter")
	public void filterByBrand(String brand) {
		ebaySearchResultPage.typeBrandOnSearchbox(brand);
		ebaySearchResultPage.selectBrandInCheckbox();
		
	}

	@Step("Selects size 10 from size filter")
	public void filterBySize(String size) {
		ebaySearchResultPage.selectSizeCheckbox(size);
		ebaySearchResultPage.getTheTotalAmountOfResults();
		
	}

	@Step("Sorts the results from cheaper to most expensive")
	public void sortResultsInAscendantOrder() {
		ebaySearchResultPage.selectMoreExpensiveLast();
		
	}

	@Step("Validates the sorting with first 5 products")
	public void validateAscendantSortingOrder() {
		double prices[] = ebaySearchResultPage.getFirstFivePrices();
		assertTrue(Utilities.checkAscendingSorting(prices));
		
	}

}
