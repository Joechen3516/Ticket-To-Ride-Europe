import java.util.ArrayList;
import java.util.HashSet;

public class Europe {
	private HashSet<City> cities;

	public Europe() {
		cities = new HashSet<>();
	}

	public void AddEdge(City a, City b, int length, int ferry, TrainColor c) {
		a.getRoads().add(new Road(b, length, ferry,c));
		b.getRoads().add(new Road(a, length, ferry,c));
	}

	public boolean addCity(City c) {
		return cities.add(c);
	}


	public void printGraph(HashSet<City> x) {
		for (City y:x) {
			ArrayList<Road> roads = y.getRoads();
			System.out.println("\nVertex " + y.getName() + ":");
			for (Road z : roads) {
				System.out.print(" -> " + z.getDest().getName());
			}
			System.out.println();
		}
	}



}
