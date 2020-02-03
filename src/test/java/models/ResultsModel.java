package models;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

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
		double pricesList[] = new double[this.productsPrice.size()];
		System.out.println("//==================================================================//");
		System.out.println("Total Amount of Results: "+this.totalAmountResult);
		java.util.Collections.sort(this.productsName, Collator.getInstance());
		int limit = this.productsName.size();
//		System.out.format("%-4s%-120s%30s","#","Product Name","Product Price (COP)\n");
		for(int i = 0; i < limit ; i++) {
			System.out.println(this.productsName.get(i));				
//			//System.out.println(i+". Product Name: "+this.productsName.get(i)+"\t Price (COP): $"+Utilities.getFormatedPrice(this.productsPrice.get(i)));
			System.out.format("%-4s%-120s%30s",(i+1)+". ", this.productsName.get(i),this.productsPrice.get(i).replaceAll("[\\s C O P]", "")+System.lineSeparator());
		}
		java.util.Arrays.sort(pricesList);
		for(int i = 0; i < limit ; i++) {
		}
		System.out.println("//==================================================================//");
	}

	
	

}
