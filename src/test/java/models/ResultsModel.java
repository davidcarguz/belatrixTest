package models;

import java.util.List;

public class ResultsModel {

	private String totalAmountResult;
	private List<String> productsName;
	private List<String> productsPrice;

	public ResultsModel() {
	}

	public void setTotalAmountResult(String totalAmountResult) {
		this.totalAmountResult = totalAmountResult;
	}

	public void setProductsName(List<String> productsName) {
		this.productsName = productsName;
	}

	public void setProductsPrice(List<String> productsPrice) {
		this.productsPrice = productsPrice;
	}

	public List<String> getProductsName() {
		return productsName;
	}

	public List<String> getProductsPrice() {
		return productsPrice;
	}

	@Override
	public String toString() {
		return "Total amount of products: " + this.totalAmountResult;
	}

}
