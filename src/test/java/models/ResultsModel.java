package models;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

import belatrix.automation.ebay.Utilities.Utilities;

public class ResultsModel {
	
	private String totalAmountResult;
	private List<String> productsName;
	private List<String> productsPrice;
	
	public ResultsModel() {}

	public void setTotalAmountResult(String totalAmountResult) {
		this.totalAmountResult = totalAmountResult;
	}

	public void setProductsName(List<String> productsName) {
		this.productsName = productsName;
	}

	public void setProductsPrice(List<String> productsPrice) {
		this.productsPrice = productsPrice;
	}

	public void showResults() {
		System.out.println("//==================================================================//");
		System.out.println("Total Amount of Results: "+this.totalAmountResult);
		Collections.sort(this.productsName, Collator.getInstance());
	}

	
	

}
