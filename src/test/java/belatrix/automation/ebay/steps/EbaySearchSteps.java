package belatrix.automation.ebay.steps;

import static org.junit.Assert.assertTrue;

import belatrix.automation.ebay.Utilities.Utilities;
import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import belatrix.automation.ebay.pageObjects.EbayStartPage;
import net.thucydides.core.annotations.Step;

public class EbaySearchSteps {

	EbayStartPage ebayStartPage;
	EbaySearchResultPage ebaySearchResultPage;
	
	@Step
	public void openBrowserAndGoToEbay() {
		ebayStartPage.OpenBrowserAndGoToEbay();
		
	}

	@Step
	public void searchForShoes() {
		ebayStartPage.SearchForShoes();
		ebayStartPage.clickOnSearchButton();
		
	}

	@Step
	public void filterByBrand(String brand) {
		ebaySearchResultPage.typeBrandOnSearchbox(brand);
		ebaySearchResultPage.selectBrandInCheckbox();
		
	}

	@Step
	public void filterBySize(String size) {
		ebaySearchResultPage.selectSizeCheckbox(size);
		
	}

	@Step
	public void sortResultsInAscendantOrder() {
		ebaySearchResultPage.selectMoreExpensiveLast();
		
	}

	@Step
	public void validateAscendantSortingOrder() {
		double prices[] = ebaySearchResultPage.getFirstFivePrices();
		assertTrue(Utilities.checkAscendingSorting(prices));
		
	}

}
