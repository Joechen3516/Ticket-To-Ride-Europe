import java.util.ArrayList;

public class City implements Comparable{
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
	



	
	public String getName() {
		return name;
	}
	
	public ArrayList<Road> getRoads() {
		return roadlist;
	}

	public String toString() {
		return name;
	}
	public void addStation(Player p) {
		station = true;
		owner = p.getPlayerColor();
	}

	@Override
	public int compareTo(Object o) {
		return this.getName().compareTo(o.toString());
	}
	public int compare(City o) {
		return this.getName().compareTo(o.toString());
	}
}
