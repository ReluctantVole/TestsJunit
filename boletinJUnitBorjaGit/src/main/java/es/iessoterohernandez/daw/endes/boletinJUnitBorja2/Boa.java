package es.iessoterohernandez.daw.endes.boletinJUnitBorja2;

public class Boa {
	private String name;
	private int length; // the length of the boa, in feet
	private String favoriteFood;
	
	public Boa (String name, int length, String favoriteFood){
		this.name = name;
		this.length = length;
		this.favoriteFood = favoriteFood;
	}
	// returns true if this boa constrictor is healthy
	public boolean isHealthy(){
		return this.favoriteFood.equals("granola bars");
	}
	// returns true if the length of this boa constrictor is
	// less than the given cage length
	public boolean fitsInCage(int cageLength){
		return this.length < cageLength;
	}
}