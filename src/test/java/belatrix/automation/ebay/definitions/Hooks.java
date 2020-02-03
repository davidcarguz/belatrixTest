package belatrix.automation.ebay.definitions;

import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import cucumber.api.java.After;

public class Hooks {

	EbaySearchResultPage ebaySearchResultPage;
	
	@After
	public void afterProcedures() {
		ebaySearchResultPage.closeBrowser();
	}
	
}
