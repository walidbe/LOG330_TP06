package LOG_330.LOG_330_TP06;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;





import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import LOG_330.LOG_330_TP06.CalculD;
import LOG_330.LOG_330_TP06.FileAnalyser;



public class MoyenneTest {

  public MoyenneTest() {
	
	}

  
  @Test
  public void avgTestMin() throws FileNotFoundException, IOException, NumberFormatException, ParseException
  {
	  FileAnalyser fa = new FileAnalyser("oldData.csv");
	  List<Double> listElement = new ArrayList<Double>();
	  listElement.add(Double.MIN_VALUE);
	  listElement.add(Double.MIN_VALUE);


	  CalculD c = new CalculD();
	  c.oldStart(listElement);
	  assertEquals(4.9E-324,c.calculateAvg(),0.1);
	  
  } 
  

  @Test
  public void avgTestMax() throws FileNotFoundException, IOException
  {
	  FileAnalyser fa = new FileAnalyser("oldData.csv");
	  List<Double> listElement = new ArrayList<Double>();
	  listElement.add(Double.MAX_VALUE);
	  listElement.add(Double.MAX_VALUE);

	  CalculD c = new CalculD();
	  c.oldStart(listElement);
	  assertEquals(Double.MAX_VALUE,c.calculateAvg(),0.1);
	  
  } 
  
  @Test(expected = NumberFormatException.class)
  public void avgTestException() throws FileNotFoundException, IOException
  {
	  FileAnalyser fa = new FileAnalyser("data2.csv");
	  List<Double> listElement = fa.oldLoadFile();
	  CalculD c = new CalculD();
	  c.calculateAvg();
	  
  } 
  
  
/**
   * Rigourous Test :-)
 * @throws IOException 
 * @throws FileNotFoundException 
   */
  @Test
  public void avgTest() throws FileNotFoundException, IOException
  {
	  FileAnalyser fa = new FileAnalyser("oldData.csv");
	  List<Double> listElement = fa.oldLoadFile();
	  CalculD c = new CalculD();
	  c.oldStart(listElement);
	  assertEquals(638.9,c.calculateAvg(),0.1);
	  
  } 

}
