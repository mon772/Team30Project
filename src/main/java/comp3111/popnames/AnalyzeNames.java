package comp3111.popnames;

import java.util.Arrays;

import org.apache.commons.csv.*;
import edu.duke.*;
import javafx.application.Application;

public class AnalyzeNames{

	public static CSVParser getFileParser(int year) {
     FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
     return fr.getCSVParser(false);
	}
 
	
	public static String getSummary(int year) {
		String oReport = "";	
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int totalNames = 0;
		int uniqueBoys = 0;
		int uniqueGirls = 0;
		
		oReport = String.format("Summary (Year of %d):\n", year);
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			totalNames += 1;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				uniqueBoys++;
			}
			else {
				totalGirls += numBorn;
				uniqueGirls++;
			}
		}
		
		oReport += String.format("Total Births = %,d\n", totalBirths);
		oReport += String.format("***Baby Girls = %,d\n", totalGirls);
		oReport += String.format("***Baby Boys = %,d\n", totalBoys);
		
		oReport += String.format("Total Number of Unique Names = %,d\n", totalNames);
		oReport += String.format("***Unique Names (baby girls) = %,d\n", uniqueGirls);
		oReport += String.format("***Unique Names (baby boys) = %,d\n", uniqueBoys);
		
		return oReport;
	}
	
	
	 public static int getRank(int year, String name, String gender) {
	     boolean found = false;
	     int oRank = 0;
	 	int rank = 1;
	     for (CSVRecord rec : getFileParser(year)) {
	         // Increment rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Return rank if name matches param
	             if (rec.get(0).equals(name)) {
	             	found = true;
	             	oRank = rank;
	             	break;
	             }
	             rank++;
	         }
	     }
	     if (found)
	     	return oRank;
	     else
	     	return -1;
	 }
	 
	 public static int getOccurance(int year, String name, String gender) {
	     boolean found = false;
	     int occurance = 0;
	     for (CSVRecord rec : getFileParser(year)) {
	         // Increment rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Return rank if name matches param
	             if (rec.get(0).equals(name)) {
	             	found = true;
	             	occurance = Integer.parseInt(rec.get(2));
	             	break;
	             }
	         }
	     }
	     if (found)
	     	return occurance;
	     else
	     	return -1;
	 }
	 
 
	 public static String getName(int year, int rank, String gender) {
	 	boolean found = false;
	     String oName = "";
	     int currentRank = 0;
	     
	     // For every name entry in the CSV file
	     for (CSVRecord rec : getFileParser(year)) {
	         // Get its rank if gender matches param
	         if (rec.get(1).equals(gender)) {
	             // Get the name whose rank matches param
	         	currentRank++;
	            if (currentRank == rank) {
	             	found = true;
	             	oName = rec.get(0);
	                break;
	            }
	         }
	     }     
	     if (found)
	     	return oName;
	     else
	     	return "information on the name at the specified rank is not available";
	 }
	 
		public static T2Names [] getKthPopularNames(int starting_Year, int ending_Year, int k, String gender) {
			String oReport = "";
			
//			int totalGenderBirths = 0;
//			total
			
//			int totalBirths = 0;
//			int totalBoys = 0;
//			int totalGirls = 0;
//			int totalNames = 0;
//			int uniqueBoys = 0;
//			int uniqueGirls = 0;
			
//			String [] names = new String [ending_Year-starting_Year + 1];
//			int [] occurances = new int [ending_Year - starting_Year + 1];
//			int [] count = new int [ending_Year - starting_Year + 1];
			T2Names [] names = new T2Names [ending_Year-starting_Year + 1];
			int namesIndex = 0;
//			oReport = String.format("Summary (Years):\n");
			boolean alreadyOccurred = false;
			for(int year = starting_Year; year<=ending_Year; year++) {
//				oReport+=String.format("Year %d, :", year);
				for(T2Names nam : names) {
					if(nam!=null) {
						if (getName(year, k, gender).contentEquals(nam.getName())) {
//							oReport+=String.format("Name %s Exists\n", nam.getName());
							nam.incrementFrequency();
							nam.addOccurances(getOccurance(year, nam.getName(), gender));
							alreadyOccurred = true;
						}
					}
				}
				if(!alreadyOccurred) {
					String currentName = getName(year, k, gender);
//					oReport+=String.format("Name %s Does not exists\n", currentName);
					int currentOccurance = getOccurance(year, currentName, gender);
					names[namesIndex]= new T2Names(currentName, currentOccurance, 1);
					namesIndex++;
				}
				alreadyOccurred = false;
			}
			Arrays.sort(names,0,namesIndex);
			for(T2Names nam : names) {
				if(nam!=null) {
					nam.setPercentage();
//					oReport+=String.format("Name: %s   Occurances: %,d   Frequency : %,d \n", nam.getName(), nam.getOccurances(), nam.getFrequency());
				}
			}
			
			return names;
		}
		
//		public static String getCompatiblePairT5X1(String iGenderMate, int iYOB){
//			String oReport = "";
//			
//			return oReport;
//		}
 
}