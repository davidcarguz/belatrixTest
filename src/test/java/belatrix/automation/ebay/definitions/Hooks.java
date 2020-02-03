package belatrix.automation.ebay.definitions;

import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import cucumber.api.java.After;
import models.Product;

import java.util.Comparator;

public class Hooks {
	
	@After
	public void afterProcedures() {
		EbaySearchResultPage.resultsData.showResults();
		System.out.println("//--------------First 5 Results--------------//");
		for(int i = 0; i < 5; i++) {
			System.out.println((i+1)+". "+EbaySearchResultPage.products.get(i).toString());
		}
		EbaySearchResultPage.products.sort(Comparator.comparing(Product::getPrice));
		System.out.println("//--------------Products sort by price descendant--------------//");
		for(int j=EbaySearchResultPage.products.size()-1; j >= 0;j--) {
			System.out.println(EbaySearchResultPage.products.get(j).toString());
		}
		
	}
}
