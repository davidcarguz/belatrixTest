package belatrix.automation.ebay.definitions;

import belatrix.automation.ebay.pageObjects.EbaySearchResultPage;
import cucumber.api.java.After;
import models.Product;

import java.util.Comparator;

public class Hooks {
		
	
	@After
	public void afterProcedures() {
		
		System.out.println("\n//--------------Total Amount of Results--------------//\n");
		System.out.println(EbaySearchResultPage.resultsData.toString());
		
		System.out.println("\n//--------------First 5 Results--------------//\n");
		for(int i = 0; i < 5; i++) {
			System.out.println((i+1)+". "+EbaySearchResultPage.products.get(i).toString());
		}
		
		EbaySearchResultPage.products.sort(Comparator.comparing(Product::getName));
		System.out.println("\n//--------------Products Sort by Name Ascendant--------------//\n");
		for(int j=0; j < EbaySearchResultPage.products.size();j++) {
			System.out.println(EbaySearchResultPage.products.get(j).getName());
		}
		
		EbaySearchResultPage.products.sort(Comparator.comparing(Product::getPrice));
		System.out.println("\n//--------------Products Sort by Price Descendant--------------//\n");
		for(int k=EbaySearchResultPage.products.size()-1; k >= 0;k--) {
			System.out.println(EbaySearchResultPage.products.get(k).toString());
		}
		
	}
}
