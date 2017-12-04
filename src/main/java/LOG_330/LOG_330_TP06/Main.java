package LOG_330.LOG_330_TP06;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Class Main  implement interaction with client
 * @author Walid
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.print("Veuillez saisir l'emplacement du ficher : ");
		String myFile = sc.nextLine();
		if(myFile == null || myFile.isEmpty()){
			System.out.println("Fichier Path non valide");
			return ;
		}
		
		FileAnalyser fa = new FileAnalyser(myFile);
		try {
			List<Points> myList = fa.loadFile();
			if(myList == null || myList.isEmpty()) {
				System.out.println("Liste de points vide");
				return;
			}
			CalculD c = new CalculD(myList);
			if(c.start()){
				
				System.out.println("Pente  = " + c.calculateSlope());
				System.out.println("Constante  = " + c.calculateCste());
				Double variance = c.calculateVarianceTp06();
				Double ecartType = c.calculateEcartTypeTp06();
				Double avg = c.calculateAverageXi();
				System.out.println("Variance = "+ variance);
				System.out.println("Ecart Type = " + ecartType);
				System.out.println("Somme (Xi-Xmoy)^2 = " + avg);
				System.out.println("Veuillez entrez la valeur à prédire (ex:1119) : ");
				int value = sc.nextInt();

				Double predictedValue = value*c.calculateSlope() + c.calculateCste();
				System.out.println("La valeur predite Yk est = " + predictedValue );
				Double interval90 = c.calculateInterval(value, 1.86);
				Double interval70 = c.calculateInterval(value, 1.108);

				System.out.println("Avec un interval de 90%, on trouve (+ -)  " + interval90);
				System.out.println("*****Limite inférieur 90%  " + (predictedValue - interval90));
				System.out.println("*****Limite supérieur 90%  " + (predictedValue + interval90));

				System.out.println("Avec un interval de 70%, on trouve (+ -) "  + c.calculateInterval(value, 1.108));
				System.out.println("*****Limite inférieur 70%  " + (predictedValue - interval70));
				System.out.println("*****Limite supérieur 70%  " + (predictedValue + interval70));


			}
			else
				System.out.println("erreur lors de traitement de données");

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier nexiste pas");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur survenu lors du traitement du fichier");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Erreur survenu lors de la conversion");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Voulez vous continuer ?(o,n)");
		String myRep = sc.nextLine();
		if(myRep.equals("n")) {
		  break;
		}

		}

	}

}
