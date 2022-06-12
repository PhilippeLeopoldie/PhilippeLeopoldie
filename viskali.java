
/*I want to find the identical or the closest exam name from a local exam database(2035 items) to a national exam database (5768 items).
So for each local exam name I have evaluated how much this name is identical to every national exam name by determinate a matching rate.
According to the outcomes either only one national exam name will obtain the highest rate or several exams name will obtain the same highest matching rate.
In the first case a file will be created to collect only the lonely matches and in the second case an other file will be created to collect the other matches.*/

import java.util.*;
import java.util.List;
import java.io.*;
import java.util.ArrayList.*;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class viskali{
	public static void main(String[] args){
		try {
			String ExportBib="ACP.csv";//export BIB (export from local data base)
			String ReconnaissanceTop="ACP_top_viskali.csv";//top score rating file
			String ReconnaissanceFlop="ACP.csv";//no top score rating file
			String Collegiale="RefBio_nettoyage_ok.csv";//export from the national exam Library
			BufferedReader Prefichier1 = new BufferedReader(new FileReader(ExportBib));
			int compte=0;
		
			while((Prefichier1.readLine())!=null){
				compte++;// counting of "fichier1" lines
			}
		
			Prefichier1.close();
			System.out.println(compte);
			BufferedReader fichier1 = new BufferedReader(new FileReader(ExportBib));//reading of BIB extraction (fichier1: example: id BIB_local name of exam)
			BufferedWriter ecritureTop = new BufferedWriter(new FileWriter(new File(ReconnaissanceTop)));//writing of a csv file  
			ecritureTop.write("code_examen_BIB;Score(min=0 max=1);examen_collegiale_aphp;code_collegiale_aphp;validation: O/N;A creer: O/N;commentaire");
			ecritureTop.newLine();
			BufferedWriter ecritureFlop = new BufferedWriter(new FileWriter(new File(ReconnaissanceFlop)));
			ecritureFlop.write("code_examen_BIB;Score(min=0 max=1);examen_collegiale_aphp;code_collegiale_aphp;validation: O/N;A creer: O/N;commentaire");
			ecritureFlop.newLine();
			String line01;
		
			for(int j=0;j<compte;j++){//through the file 'fichier1' the goal is to determinate for each line of fichier1 its rate of words matching through the file ficher2 by comparing every line from fichier2
				line01=fichier1.readLine();//every line from "fichier1" is saved in "line01"
				tring [] temp01=line01.split("_"); //array with  underscore as separator
				String line11=temp01[1];// String following "_"
				String [] temp11=line11.split(" ");//array of words with space as separator
				ArrayList<String> mots1 = new ArrayList<String>();
			
				for(int i=0;i<temp11.length;i++){
					if(!temp11[i].equals("")){// for every contents other than a space I'm saving them in an array list "mots1"
					mots1.add(temp11[i]);
					}
				}
			
				BufferedReader fichier2 = new BufferedReader(new FileReader(Collegiale));//reading of the national data base in fichier2 (id_national name of exam)
				ArrayList<Integer> nombres = new ArrayList<Integer>();
				ArrayList<String> ListCodesTaux=new ArrayList<String>();
				ArrayList<Float>ListTaux = new ArrayList<Float>();
				String line02;
				int binaire; // save binary numbers (0,1)
				int somme=0;// sum of the binary numbers
				int stock=0;
				float taux;//  matching words rate between ficher1 and fichier2
				String CodesTaux;// ID of the national exam library with the corresponding rate
				String compare1;
				String compare2;
				String motFinal;
				int compteur=0;
		
				while((line02=fichier2.readLine())!=null){//for each line from "fichier2 and as long as there is no empty line
					for(int i=0; i<temp11.length;i++){
						if(line02.indexOf(mots1.get(i))!= -1){//we will compare each word from each exam label from the local library with each word from the national library for each exam label 
						//so every positif match of word we will stock the value "1" from the binaire variable in the arrayList "nombres" or else we stock "0"
				
						binaire=1;
						nombres.add(binaire);// save the differente values of "binaire" in the "nombres" arrayList
				
						}
						else{
						binaire=0;
						nombres.add(binaire);
						}
				
					}
				
					for(int i=0;i<nombres.size();i++){	
						somme=somme+nombres.get(i);//sum of all "nombres" element  for one line 
					}
				
					taux=((float)somme)/nombres.size();//rate = "somme"/count of binary  numbers( equivalent as the count of words for an biological exam label)
					String [] temp02=line02.split("_");// line02 element: national library ID_National biological exam label, we want to take the first part before the underscore symbol
					CodesTaux=temp02[0]+"_"+taux;// concatenation of the national ID and the rate
					ListCodesTaux.add(temp02[1]+";"+temp02[0]+"_"+taux);//add to the ListCodesTaux arrayList  each rate associated to the National ID corresponding an its exam label
					ListTaux.add(taux);// float arrayList
					somme=0;
					nombres.clear();
				}
	
				Collections.sort(ListTaux, Collections.reverseOrder());// after collecting all the rate associate to every local exam label, we sort the float array list "ListTaux" in descending
		
				compare1=Float.toString(ListTaux.get(0));
				compare2=Float.toString(ListTaux.get(1));
				if(compare1.equals( compare2)){ //if the two first rates of ListTaux(sorted previously) are equal then we will insert the five first higher rate of the list into "ecritureFolp" export file or else the lonely higher one will be insert into "ecritureTop" export file
				
					for(int i=0; i<ListCodesTaux.size();i++){
						if(compteur<6){
							if(Pattern.matches(".*_"+(compare1),ListCodesTaux.get(i))){//we want to retrieve not more than five lines from "ListCodesTaux" <String arrayList> which are corresponding to "compare1".
								String [] Code=ListCodesTaux.get(i).split("_");//extraction of the code from ListCodesTaux
								motFinal=line01+";"+ListTaux.get(0)+";"+Code[0];//concatenation of line01(ID from the local exam label_local exam label) with the top matching rate (ListTaux.get(0)) , the national exam label and the national exam code(code)
								ecritureFlop.write(motFinal);//writing of "motFinal" into the file "ReconnaissanceFlop"
								ecritureFlop.newLine();//go to the next line for the next writing
								compteur++;
							}
						}
					}		
				}
				else{
					for(int i=0; i<ListCodesTaux.size();i++){
						if(Pattern.matches(".*_"+(compare1),ListCodesTaux.get(i))){//we want to retrieve the lonely line from "ListCodesTaux" <float arrayList> which is corresponding to "compare1".
							String [] Code=ListCodesTaux.get(i).split("_");
							motFinal=line01+";"+ListTaux.get(0)+";"+Code[0];
							ecritureTop.write(motFinal);//writing of "motFinal" into the file "ReconnaissanceTop"
							ecritureTop.newLine();
						}
					}
				}
				fichier2.close();
			}
			ecritureTop.close();
			ecritureFlop.close();
			fichier1.close();
			System.out.println("FIN!");
		}
		catch(Exception e) {
		System.out.println("erreur d'execution");
		}		
	}
}
