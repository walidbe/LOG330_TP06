package LOG_330.LOG_330_TP06;

/**
* La classe Student contient les chapitre de chaque etudiant
* et la note de lintra.
* @author Walid
*
*/
public class Student {
	private String name;
	private double timeOfRevision1=0;
	private double timeOfRevision2=0;
	private double timeOfRevision3=0;
	private double timeOfRevision4=0;
	private double timeOfRevision5=0;
	private double timeOfRevision6=0;
	private double intra =0;
	public final static int COUNTER = 6;

	public Student(String name, double timeOfRevision1, double timeOfRevision2, double timeOfRevision3, double timeOfRevision4, double timeOfRevision5, double timeOfRevision6, double intra){
		this.name = name;
		this.timeOfRevision1 = timeOfRevision1;
		this.timeOfRevision2 = timeOfRevision2;
		this.timeOfRevision3 = timeOfRevision3;
		this.timeOfRevision4 = timeOfRevision4;
		this.timeOfRevision5 = timeOfRevision5;
		this.timeOfRevision6 = timeOfRevision6;
		this.intra = intra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTimeOfRevision1() {
		return timeOfRevision1;
	}

	public void setTimeOfRevision1(double timeOfRevision1) {
		this.timeOfRevision1 = timeOfRevision1;
	}

	public double getTimeOfRevision2() {
		return timeOfRevision2;
	}

	public void setTimeOfRevision2(double timeOfRevision2) {
		this.timeOfRevision2 = timeOfRevision2;
	}

	public double getTimeOfRevision3() {
		return timeOfRevision3;
	}

	public void setTimeOfRevision3(double timeOfRevision3) {
		this.timeOfRevision3 = timeOfRevision3;
	}

	public double getTimeOfRevision4() {
		return timeOfRevision4;
	}

	public void setTimeOfRevision4(double timeOfRevision4) {
		this.timeOfRevision4 = timeOfRevision4;
	}

	public double getTimeOfRevision5() {
		return timeOfRevision5;
	}

	public void setTimeOfRevision5(double timeOfRevision5) {
		this.timeOfRevision5 = timeOfRevision5;
	}

	public double getTimeOfRevision6() {
		return timeOfRevision6;
	}

	public void setTimeOfRevision6(double timeOfRevision6) {
		this.timeOfRevision6 = timeOfRevision6;
	}

	public double getIntra() {
		return intra;
	}

	public void setIntra(double intra) {
		this.intra = intra;
	}

	public  double getAverage() {
		return (timeOfRevision1+timeOfRevision2+timeOfRevision3+timeOfRevision4
				+timeOfRevision5+timeOfRevision6) / COUNTER;
	}
	
	
}

