package belatrix.automation.ebay.definitions;

import belatrix.automation.ebay.steps.EbaySearchSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EbaySearchDefinitions {

	@Steps
	EbaySearchSteps ebaySearchSteps;
	
	@Given("^user enters to Ebay WebPage$")
	public void userEntersToEbayWebPage() {
	    ebaySearchSteps.openBrowserAndGoToEbay();
	}


	@When("^looks for shoes in searchbox$")
	public void looksForShoesInSearchbox() {
	    ebaySearchSteps.searchForShoes();
	}

	@When("^filters by brand \"([^\"]*)\"$")
	public void filtersByBrand(String brand) {
	    ebaySearchSteps.filterByBrand(brand);
	}

	@When("^filters by size \"([^\"]*)\"$")
	public void filtersBySize(String size) {
	    ebaySearchSteps.filterBySize(size);
	}

	@When("^sort results by price in ascendant order$")
	public void sortResultsByPriceInAscendantOrder() {
	    ebaySearchSteps.sortResultsInAscendantOrder();
	}

	@Then("^validate that product are sort in ascendant order by price$")
	public void validateThatProductAreSortInAscendantOrderByPrice() {
	    ebaySearchSteps.validateAscendantSortingOrder();
	}
}
