package LOG_330.LOG_330_TP06;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import LOG_330.LOG_330_TP06.CalculD;
import LOG_330.LOG_330_TP06.FileAnalyser;

public class EcartTypeTest {
	
	


	
    public EcartTypeTest() {

	}

	/**
     * Rigourous Test :-)
	 * @throws IOException 
	 * @throws FileNotFoundException 
     */
    @Test
    public void ecartTypeTest() throws FileNotFoundException, IOException
    {
    	FileAnalyser fa = new FileAnalyser("oldData.csv");
  	  	List<Double> listElement = fa.oldLoadFile();
  	  	CalculD c = new CalculD();
  	  	c.oldStart(listElement);
  	  	
  	  	assertEquals(625.63,c.calculateEcartType(),0.2);
  	  
    }
    
    
    @Test
    public void ecartTypeMinTest() throws FileNotFoundException, IOException
    {
    	FileAnalyser fa = new FileAnalyser("oldData.csv");
  	  	List<Double> listElement = new ArrayList<Double>();
  	  	listElement.add(Double.MIN_VALUE);
  	  	listElement.add(Double.MIN_VALUE);

  		CalculD c = new CalculD();
  	  	c.oldStart(listElement);
    	assertEquals(0.0,c.calculateEcartType(),0.1);
    }
    
    @Test
    public void ecartTypeMaxTest() throws FileNotFoundException, IOException
    {
    	FileAnalyser fa = new FileAnalyser("oldData.csv");
  	  	List<Double> listElement = fa.oldLoadFile();
  	  	listElement.add(Double.MAX_VALUE);

  	  	CalculD c = new CalculD();
	  	c.oldStart(listElement);
    	assertEquals(1.3407807929942596E154,c.calculateEcartType(),0.1);
    }
    
    @Test(expected = NumberFormatException.class)
    public void ecartTypeTestException() throws FileNotFoundException, IOException
    {
  	  FileAnalyser fa = new FileAnalyser("data2.csv");
  	  List<Double> listElement = fa.oldLoadFile();
  	  CalculD c = new CalculD();
  	  c.oldStart(listElement);
  	  
    } 
}
