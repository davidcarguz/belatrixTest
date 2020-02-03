package belatrix.automation.ebay.definitions;

import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import cucumber.api.java.After;

public class Hooks {
	
	@After
	public void afterProcedures() {
		EbaySearchResultPage.resultsData.showResults();
	}
	
}
