package LOG_330.LOG_330_TP06;
import java.util.List;

/**
 * This class implements all the mathematical logics
 * b
 * @author Walid
 *
 */

public final class CalculD {
	private double variance = 0;
	private double ecartType = 0;
	private double average = 0;
	private double correlation = 0;
	private double slope = 0;
	private double cste = 0;
	private double sumX = 0;
	private double sumY = 0;
	private double sumProduct = 0;
	private double sumXSquare = 0;
	private double sumYSquare = 0;
	private double cnt = 0;
	private double vTotal = 0;
	
	public CalculD(){
	
	}

	/**
	 * Fonction used to filter points and calculate sumX and sumY
	 * @param myList
	 * @return
	 */
	public  boolean start(List<Points> myList){
		
		try{
			sumX = 0;
			sumY = 0;
			cnt=0;
		for(Points element : myList){
			sumX += element.getX();
			sumY += element.getY();
			sumProduct += element.getX() * element.getY();
			sumXSquare += Math.pow(element.getX(), 2);
			sumYSquare += Math.pow(element.getY(), 2);
			cnt +=1;
		}

		}catch(Exception e){return false;}
		return true;
	}
	
	public  boolean oldStart(List<Double> myList){
		vTotal = 0;
		sumX=0;
		cnt=0;
		try{
		for(Double element : myList){
			sumX +=element;
			cnt +=1;
		}
	
		
		for(Double element : myList){
			vTotal += Math.pow(element - calculateAvg(), 2);
		}

		}catch(Exception e){return false;}
		return true;
	}
	
	public Double calculateAvg() {
		average = sumX / cnt;
		checkAvg();
		return average;
	}
	
	public Double calculateVariance() {
		variance = vTotal/(cnt-1);
		checkVariance();
		return variance;
	}
	
	public Double calculateEcartType() {
		calculateVariance();
		ecartType = (double) Math.sqrt(variance);
		checkEcartType();
		return ecartType;
	}
	
	private  void checkAvg() {
		if(average == Double.POSITIVE_INFINITY) {
			average = Double.MAX_VALUE;
		}
		else if(average == Double.NEGATIVE_INFINITY) {
			average = Double.MIN_VALUE;
		}
		
	}
	
	private  void checkVariance() {
		if(variance == Double.POSITIVE_INFINITY) {
			variance = Double.MAX_VALUE;
		}
		else if(variance == Double.NEGATIVE_INFINITY) {
			variance = Double.MIN_VALUE;
		}
	}
	
	private  void checkEcartType() {
		if(ecartType == Double.POSITIVE_INFINITY) {
			ecartType = Double.MAX_VALUE;
		}
		else if(ecartType == Double.NEGATIVE_INFINITY) {
			ecartType = Double.MIN_VALUE;
		}
	}
	
	public  double calculateCorrelation(){
		correlation = (cnt * sumProduct - sumX * sumY) / Math.sqrt((cnt*sumXSquare - Math.pow(sumX, 2)) * (cnt*sumYSquare - Math.pow(sumY, 2)));
		checkCorrelation();
		return correlation;
	}
	private  void checkCorrelation() {
		
		if(correlation == Double.POSITIVE_INFINITY) {
			correlation = Double.MAX_VALUE;
		}
		else if(correlation == Double.NEGATIVE_INFINITY) {
			correlation = Double.MIN_VALUE;
	   }
	}
	
	public double calculateSlope() {
	     slope = (sumProduct - cnt*(sumX/cnt)*(sumY/cnt)) / (sumXSquare - cnt*(Math.pow(sumX/cnt,2)));
	     checkSlope();
	     return slope;
	}
	
	private void checkSlope() {
		if(sumProduct == Double.POSITIVE_INFINITY || slope == Double.NaN) {
			slope = Double.MAX_VALUE;
		}
		else if(sumProduct == Double.NEGATIVE_INFINITY || sumProduct == 0.0 || slope == Double.NaN) {
			slope = Double.MIN_VALUE;
		}	
	}
	private void checkCste() {
		if(sumProduct == Double.POSITIVE_INFINITY || cste == Double.NaN) {
			cste = Double.MAX_VALUE;
		}
		else if(sumProduct == Double.NEGATIVE_INFINITY || sumProduct == 0.0 || cste == Double.NaN) {
			cste = Double.MIN_VALUE;
		}	
	}
	public double calculateCste() {
		System.out.println("Sum Y " + sumY);
		System.out.println("Cnt " + cnt);
		System.out.println("Slope " + slope);
		System.out.println("Sum X " + sumX);


		cste = (sumY/cnt) - slope*(sumX/cnt);
		checkCste();
		return cste;
	}
	
	public double calculateY(double x) {
		return slope*x + cste;
	}
	public double calculateX(double y) {
		return (y-cste)/slope;
	}
	

}
