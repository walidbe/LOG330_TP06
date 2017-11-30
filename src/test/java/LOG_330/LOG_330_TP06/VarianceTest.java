package LOG_330.LOG_330_TP06;


import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import LOG_330.LOG_330_TP06.CalculD;
import LOG_330.LOG_330_TP06.FileAnalyser;

public class VarianceTest  {
	
	



    public VarianceTest() throws FileNotFoundException, IOException {

	}

    
    @Test
    public void varianceMinTest() throws FileNotFoundException, IOException
    {
  	  FileAnalyser fa = new FileAnalyser("oldData.csv");
  	//  List<Double> listElement = fa.loadFile();
  	 List<Double> listElement = new ArrayList<Double>();
  	  listElement.add(Double.MIN_VALUE);
  	  listElement.add(Double.MIN_VALUE);
  	  CalculD c = new CalculD();
  	  c.oldStart(listElement);
  	  assertEquals(0.0,c.calculateVariance(),0.1);
  	  
    } 
    

    @Test
    public void varianceMaxTest() throws FileNotFoundException, IOException
    {
  	  FileAnalyser fa = new FileAnalyser("oldData.csv");
  	  List<Double> listElement = fa.oldLoadFile();
  	  listElement.add(Double.MAX_VALUE);
  	  listElement.add(Double.MAX_VALUE);

  	  listElement.add(Double.MAX_VALUE);
  	  listElement.add(Double.MAX_VALUE);

  	  CalculD c = new CalculD();
	  c.oldStart(listElement);
  	  assertEquals(1.7976931348623157E308,c.calculateVariance(),0.1);
  	  
    } 
    
    @Test(expected = NumberFormatException.class)
    public void varianceTestException() throws FileNotFoundException, IOException
    {
  	  FileAnalyser fa = new FileAnalyser("data2.csv");
  	  List<Double> listElement = fa.oldLoadFile();
  	  CalculD c = new CalculD();
	  c.oldStart(listElement);
  	  
    } 
    
    
  /**
     * Rigourous Test :-)
   * @throws IOException 
   * @throws FileNotFoundException 
     */
    @Test
    public void varianceTest() throws FileNotFoundException, IOException
    {
  	  FileAnalyser fa = new FileAnalyser("oldData.csv");
  	  List<Double> listElement = fa.oldLoadFile();
  	 CalculD c = new CalculD();
	  c.oldStart(listElement);
  	  assertEquals(391417.9,c.calculateVariance(),0.1);
  	  
    } 
    

}
