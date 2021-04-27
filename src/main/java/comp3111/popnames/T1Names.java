package comp3111.popnames;

public class T1Names {
	public String name ;
	public int rank; 
	public String percentage ; 
	public int occurences ;
	
	
	T1Names(int rank , String name , int occurences ,String percentage ){
		this.name = name ;
		this.rank = rank ; 
		this.occurences = occurences ;
		this.percentage = percentage ;
	}
	public String getName() {
		return name;
	}
	
	public int getOccurences() {
		return occurences;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getPercentage() {
		return percentage;
	}
}
