package LOG_330.LOG_330_TP06;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IntervalPredictionTest {

public IntervalPredictionTest() {
		
	}
	
	@Test
	public void calculSquareRootTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("tp06.csv");
    	 CalculD c = new CalculD(fa.loadFile());
		 c.start();
		assertEquals(1.26,c.calculateSquareRoot(1119),0.01);
		
	}
	
	@Test
	public void calculSquareIntervalTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("tp06.csv");
    	 CalculD c = new CalculD(fa.loadFile());
		 c.start();
		assertEquals(439.54,c.calculateInterval(1119, 1.86),0.01);
		assertEquals(261.83,c.calculateInterval(1119, 1.108),0.01);

	}
	
	@Test
	public void calculVarianceTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("tp06.csv");
    	 CalculD c = new CalculD(fa.loadFile());
		 c.start();
		assertEquals(34811.25,c.calculateVarianceTp06(),0.01);

	}
	
	@Test
	public void calculEcartTypeTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("tp06.csv");
    	 CalculD c = new CalculD(fa.loadFile());
		 c.start();
		assertEquals(186.57,c.calculateEcartTypeTp06(),0.01);

	}
	

}
