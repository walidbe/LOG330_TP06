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


public class CorrelationTest {


	 public CorrelationTest() {

		}

		/**
	     * Rigourous Test :-)
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 * @throws ParseException 
		 * @throws NumberFormatException 
	     */
	    @Test
	    public void correlationTest() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	    {
	    	 FileAnalyser fa = new FileAnalyser("data.csv");
	    	 CalculD c = new CalculD();
			 c.start(fa.loadFile());
	    	assertEquals(0.95,c.calculateCorrelation(),0.01);
	    }
	    
	    
	    @Test
	    public void correlationMaxTest() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	    {
	    	FileAnalyser fa = new FileAnalyser("data.csv");
	    	List<Points> myList = new ArrayList<Points>();
	      	myList.add(new Points(22.0, 23.0));
	    	myList.add(new Points(23.0, 24.0));
	    	myList.add(new Points(22.0, 23.0));
	    	CalculD c = new CalculD();
	    	c.start(myList);
	    	assertEquals(1.0,c.calculateCorrelation(),0.01);
	    }
	    
	    @Test
	    public void correlationMinTest() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	    {
	    	FileAnalyser fa = new FileAnalyser("data.csv");
	    	List<Points> myList = new ArrayList<Points>();
	    	myList.add(new Points(-22.0, -23.0));
	    	myList.add(new Points(23.0, -24.0));
	    	myList.add(new Points(-22.0, -23.0));
	    	CalculD c = new CalculD();
	    	c.start(myList);
	    	assertEquals(-1.0,c.calculateCorrelation(),0.01);
	    }
	    
	    
	    @Test(expected = ParseException.class)
	    public void correlationTestException() throws FileNotFoundException, IOException, NumberFormatException, ParseException
	    {
	  	  FileAnalyser fa = new FileAnalyser("data2.csv");
	  	  CalculD c = new CalculD();
	  	  c.start(fa.loadFile());
	  	  
	    } 
	    
		@Test
		public void correlationStudentTest() throws NumberFormatException, FileNotFoundException, IOException, ParseException {
			FileAnalyser fa = new FileAnalyser("dataStudent.csv");
	    	 CalculD c = new CalculD();
			 c.start(fa.tp5LoadFile());
			assertEquals(0.15,c.calculateCorrelation(),0.01);
			
		}
		
	    
	  
}
