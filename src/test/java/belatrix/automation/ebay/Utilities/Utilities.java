package belatrix.automation.ebay.Utilities;

public class Utilities {

	
	public static double getFormatedPrice(String rawPrice) {
		
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
}
