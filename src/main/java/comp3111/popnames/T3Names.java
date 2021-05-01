package comp3111.popnames;

public class T3Names {

	public String name;
	public int occurances;
	public int rank;
	public String percentage;
	public int birthCount;
		
	public T3Names(String name, int occurances, String percentage, int rank, int birthCount) {
		this.name = name;
		this.occurances = occurances;
		this.birthCount = birthCount;
		this.percentage = percentage;
		this.rank = rank;
	}

	public void addOccurances(int occurances) {
		this.occurances += occurances;
		birthCount += occurances;
	}
	
	public void setPercentage() {
		percentage = String.format("%.1f%%", (float)(occurances *100.0/ birthCount));
	}
}
