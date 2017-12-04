package LOG_330.LOG_330_TP06;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This class upload and parse files
 * with different strategies
 * @author Walid
 *
 */
public class FileAnalyser {

	private final static String SPLIT = ";";
	private final static String SPLIT_COMMA = ",";
	private String myFile;
	public FileAnalyser(String myFile){
		this.myFile = myFile;
	}
	
	/**
	 * this function is used to format data
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public List<Points> tp5LoadFile() throws FileNotFoundException, IOException, NumberFormatException, ParseException{
		String line = null;
		List<Points> numberList = new ArrayList<Points>();
	
		BufferedReader bfr = new BufferedReader(new FileReader(myFile));
		bfr.readLine();
		bfr.readLine();
		while((line = bfr.readLine()) != null) {
			String[] splitLine = line.split(SPLIT_COMMA);
			if(!checkNumberOfColumnsValidity(splitLine)) {
				System.out.println("Nombre de colomne pas valide");
				return numberList;
			}
			Student s = new Student(splitLine[0],Double.parseDouble(splitLine[1]),Double.parseDouble(splitLine[2]),
					Double.parseDouble(splitLine[3]),Double.parseDouble(splitLine[4]),Double.parseDouble(splitLine[5]),
					Double.parseDouble(splitLine[6]),Double.parseDouble(splitLine[7]));
			numberList.add(new Points(s.getAverage(),s.getIntra()));
		}
		bfr.close();
		return numberList;
	}
	
	private Boolean checkNumberOfColumnsValidity(String[] content) {
		if(content.length == 8) {
			return true;
		}
		return false;
	}
	
	/**
	 * this function is used for TP2
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public List<Points> loadFile() throws FileNotFoundException, IOException, NumberFormatException, ParseException{
		String elementInList = null;
		List<Points> numberList = new ArrayList<Points>();
	
		BufferedReader bfr = new BufferedReader(new FileReader(myFile));
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		while((elementInList = bfr.readLine()) != null) {
			String[] splitLine = elementInList.split(SPLIT);
			numberList.add(new Points(format.parse(splitLine[0]).doubleValue(),format.parse(splitLine[1]).doubleValue()));
		}
		bfr.close();
		return numberList;
	}
	
	/**
	 * This function was used for TP1
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Double> oldLoadFile() throws FileNotFoundException, IOException{
		String line = null;
		List<Double> numberList = new ArrayList<Double>();
	
		BufferedReader bfr = new BufferedReader(new FileReader(myFile));
		while((line = bfr.readLine()) != null) {
			numberList.add(Double.parseDouble(line));
		}
		bfr.close();
		return numberList;
		
	}
	
}
