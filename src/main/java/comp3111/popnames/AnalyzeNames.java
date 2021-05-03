package comp3111.popnames;

import java.util.Arrays;

import org.apache.commons.csv.*;
import edu.duke.*;
import javafx.application.Application;
/**
 * Class used for the computation of the results
 */
public class AnalyzeNames{
	/**
	 * Used the parse the file for a given year
	 * @param year The year for analysis
	 */
	public static CSVParser getFileParser(int year) {
		FileResource fr = new FileResource(String.format("dataset/yob%s.csv", year));
		return fr.getCSVParser(false);
	}

	/**
	 * Used the get the summary for a given year
	 * @param year The year for analysis
	 */
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

	/**
	 * 
	 * Returns the number of occurences for a name in a particular year
	 * 
	 * @param year	Year to look for occurences in
	 * @param name	Name of individual to find number of occurence
	 * @param gender	Gender of Name to look for occurences of
	 * @return Number of Occurrences (-1 if occurence not found)
	 */

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

	/**
	 * Used to get the total males for a given year
	 * @param year The year for analysis
	 * @return the total males of a given year 
	 */

	public static int getTotalMales(int year) {	
		int totalBoys = 0;
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
		}
		return totalBoys; 	
	}
	/**
	 * Used to get the total females for a given year
	 * @param year The year for analysis
	 * @return the total males of a given year
	 */

	public static int getTotalFemales(int year) {
		int totalGirls = 0;
		for (CSVRecord rec : getFileParser(year)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (rec.get(1).equals("F")) {
				totalGirls += numBorn;
			}
		}
		return totalGirls; 	
	}
	/**
	 * Used to get the rank for a given year
	 * @param year The year used for analysis
	 * @param name The name for which the rank has to be found 
	 * @param gender 
	 * @return the rank of the name
	 */

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
	/**
	 * Function used to get the Name of a given year, rank and gender
	 * @param year The year used for analysis
	 * @param rank The rank used for analysis
	 * @param gender The gender to be found
	 * @return
	 */

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

	/**
	 * 
	 * Returns a sorted array of the K-th Most Popular Names in a given range of a given gender
	 * 
	 * @param starting_Year		Starting Year of searching range
	 * @param ending_Year		Ending Year of searching range
	 * @param k					Rank of Name to search for
	 * @param gender			Gender of Name to search for
	 * @return Sorted array of T2Names
	 */

	public static T2Names [] getKthPopularNames(int starting_Year, int ending_Year, int k, String gender) {
		String oReport = "";

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
	/**
	 * Used to get the popularity of the names of a given year for the third task	
	 * @param startYear Starting Year of searching range
	 * @param endYear Ending Year of searching range
	 * @param name Rank of Name to search for
	 * @param gender Gender of Name to search for
	 * @return an array of names for the third task
	 */
		
	public static T3Names [] getPopularityOfNames(int startYear, int endYear, String name, String gender) {
		//Compute the popularity of names
		T3Names [] names = new T3Names[endYear-startYear + 1];
		int nameIndex = 0;
		for(int i = startYear; i<=endYear;i++)
		{
			names[nameIndex] = new T3Names(name, 0, "0.0", 0, 0, 0);
			names[nameIndex].name = name;
			if(gender == "M")
			{
				names[nameIndex].birthCount = getTotalMales(i);
			}
			else {
				names[nameIndex].birthCount = getTotalFemales(i);
			}
			
			names[nameIndex].year = i;
			if(getOccurance(i, name, gender) == -1)
			{
				nameIndex++;
				continue;
			}
			names[nameIndex].occurances = getOccurance(i, name, gender);
			names[nameIndex].rank = getRank(i, name, gender);
			names[nameIndex].setPercentage();
			nameIndex++;
		}
		return names;	
	}
	/**
	 * Used to get the names for the 6th task 
	 * @param startYear Starting Year of searching range
	 * @param endYear Ending Year of searching range
	 * @param iMateGender Gender of the soulmate wanted
	 * @param iMateName Name of the soulmate wanted 
	 * @return an array of names for the 6th task
	 */
	
	public static T3Names [] T6getNames(int startYear, int endYear, String iMateGender, String iMateName)
	{
		T3Names [] names = new T3Names[endYear - startYear + 1];
		int nameIndex = 0;
		
		for(int i = startYear; i<=endYear;i++)
		{
			names[nameIndex] = new T3Names(iMateName, 0, "0.0", 0, 0, 0);
			if(iMateGender == "M")
			{
				names[nameIndex].birthCount = getTotalMales(i);
			}
			else {
				names[nameIndex].birthCount = getTotalFemales(i);
			}
			
			names[nameIndex].year = i;
			if(getOccurance(i, iMateName, iMateGender) == -1)
			{
				names[nameIndex].occurances = 0;
				names[nameIndex].rank = 0;
				names[nameIndex].percentage = "0.0";
				nameIndex++;
				continue;
			}
			names[nameIndex].occurances = getOccurance(i, iMateName, iMateGender);
			names[nameIndex].rank = getRank(i, iMateName, iMateGender);
			names[nameIndex].setPercentage();
			nameIndex++;
		}			
		return names;
	}
	/**
	 * Used to get the name for the sixth task
	 * @param iName the name of the person
	 * @param iGender the gender of the person
	 * @param YOB the year of birth of the person
	 * @return an array of T3 names 
	 */
	public static T3Names T6getiName(String iName, String iGender, int YOB)
	{
		int rank = getRank(YOB, iName, iGender);
		int occurances = getOccurance(YOB, iName, iGender) == -1? 0:getOccurance(YOB, iName, iGender);
		int birthCount;
		if(iGender == "M")
		{
			 birthCount = getTotalMales(YOB);
		}
		else {
			birthCount = getTotalFemales(YOB);
		}
		T3Names iname = new T3Names(iName, occurances, "0.0", rank, birthCount, YOB);
		iname.setPercentage();
		return iname;
	 
	}
}
