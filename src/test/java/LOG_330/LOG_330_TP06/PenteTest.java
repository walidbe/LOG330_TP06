package LOG_330.LOG_330_TP06;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import LOG_330.LOG_330_TP06.CalculD;
import LOG_330.LOG_330_TP06.FileAnalyser;
import LOG_330.LOG_330_TP06.Points;

public class PenteTest {

	
	public PenteTest() {
		
	}
	
	
	@Test
	public void calculPenteTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
		 c.start(fa.loadFile());
		assertEquals(1.72,c.calculateSlope(),0.01);
		
	}
	
	@Test
	public void calculPenteMaxTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
    	 List<Points> myList = new ArrayList<Points>();
	     myList.add(new Points(5.0, Double.MAX_VALUE));
	     myList.add(new Points(Double.MAX_VALUE, 6.0));
		 c.start(myList);

	
		assertEquals(Double.MAX_VALUE,c.calculateSlope(),0.01);
		
	}
	
	@Test
	public void calculPenteMinTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
    	 List<Points> myList = new ArrayList<Points>();
	     myList.add(new Points(Double.MIN_VALUE, Double.MIN_VALUE));
	     myList.add(new Points(Double.MIN_VALUE, Double.MIN_VALUE));
		 c.start(myList);
		assertEquals(Double.MIN_VALUE,c.calculateSlope(),0.01);
	
	}
	
	@Test(expected = ParseException.class)
	 public void penteTestException() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	   {
	  	  FileAnalyser fa = new FileAnalyser("data2.csv");
	  	  CalculD c = new CalculD();
	  	  c.start(fa.loadFile());
	  	  
	   } 
}
