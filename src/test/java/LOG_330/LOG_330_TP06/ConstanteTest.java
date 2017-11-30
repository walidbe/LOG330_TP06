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

public class ConstanteTest {

	
	public ConstanteTest() {
		
	}
	
	@Test
	public void calculCsteTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
		 c.start(fa.loadFile());
		 c.calculateSlope();
		assertEquals(-22.55,c.calculateCste(),0.01);
		
	}
	
	
	@Test
	public void calculCsteMaxTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
    	 List<Points> myList = new ArrayList<Points>();
	     myList.add(new Points(Double.MAX_VALUE, Double.MAX_VALUE));
	     myList.add(new Points(Double.MAX_VALUE, Double.MAX_VALUE));
		 c.start(myList);

		assertEquals(Double.MAX_VALUE,c.calculateCste(),0.01);
		
	}
	
	@Test
	public void calculCsteMinTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		 FileAnalyser fa = new FileAnalyser("data.csv");
    	 CalculD c = new CalculD();
    	 List<Points> myList = new ArrayList<Points>();
	     myList.add(new Points(Double.MIN_VALUE, Double.MIN_VALUE));
	     myList.add(new Points(Double.MIN_VALUE, Double.MIN_VALUE));
		 c.start(myList);
		assertEquals(Double.MIN_VALUE,c.calculateCste(),0.01);
	
	}
	
	@Test(expected = ParseException.class)
	 public void csteTestException() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	   {
	  	  FileAnalyser fa = new FileAnalyser("data2.csv");
	  	  CalculD c = new CalculD();
	  	  c.start(fa.loadFile());
	  	  
	   } 
}
