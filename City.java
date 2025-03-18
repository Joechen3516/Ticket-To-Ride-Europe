import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList<Road> roadlist = new ArrayList<>();
	private boolean station = false;
	private PlayerColor owner; 
	private boolean isDouble = false;
	
	public City(String name) {
		this.name = name;
	}
	
	public City(String name, boolean d) {
		this.name = name;
		this.isDouble = d;
	}
	
	public void built(PlayerColor c) {
		owner = c;
		station = true;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Road> getRoads() {
		return roadlist;
	}
}
