package comp3111.popnames;

public class T2Names implements Comparable<T2Names> {
	private String name;
	private int occurances;
	private int frequency;
	private String percentage;
	private static int birthCount;
	
	

	public T2Names (String name, int occurances, int frequency) {
		this.name = name;
		this.occurances = occurances;
		this.frequency = frequency;
//		this.percentage = 0;
		birthCount+=occurances;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOccurances() {
		return occurances;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public String getPercentage() {
		return percentage;
	}
	
	public static int getbirthCount() {
		return birthCount;
	}
	
	public static void resetbirthCount() {
		birthCount=0;
	}
	
	public void incrementFrequency() {
		frequency++;
	}
	
	public void addOccurances(int occurances) {
		this.occurances += occurances;
		birthCount += occurances;
	}
	
	public void setPercentage() {
		percentage = String.format("%.1f%%", (float)(occurances *100.0/ birthCount));
//		percentage = birthCount;
	}
	
	public int compareTo(T2Names secondName) {
		if(getOccurances() < secondName.getOccurances()) {
			return 1;
		}
		else if(getOccurances() > secondName.getOccurances()) {
			return -1;
		} else {
			//equals case
			if(getName().compareTo(secondName.getName()) <0) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
}
