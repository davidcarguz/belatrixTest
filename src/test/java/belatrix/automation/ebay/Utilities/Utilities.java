package belatrix.automation.ebay.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Utilities {

	
	public static double getFormatedPrice(String rawPrice) {
		
		if(rawPrice.contains("a")) {
			rawPrice = rawPrice.split("a")[0];
		}
		
        String formatedPrice = rawPrice.replaceAll("[\\s C O P $]", "");
        double numericalPrice = Double.parseDouble(formatedPrice);
        return numericalPrice;
	}
	
	public static boolean checkAscendingSorting(double[] prices) {
    	int i=0;
    	boolean good = true;
    	while((i+1)<5) {
    		if(prices[i]>prices[i+1]) {
    			good = false;
    			break;
    		}
    		i++;
    	}
    	return good;
    }
	
	public static List<String> getValuesFromElements(List<WebElement> elementsList){
		
		List<String> values = new ArrayList<>();
		
		for(WebElement item : elementsList) {
			values.add(item.getText());
		}
		return values;
	}
}
