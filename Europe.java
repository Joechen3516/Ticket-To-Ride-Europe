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

	public void createDefaultCities() {

		addCity(new City("Edinburgh"));
		addCity(new City("London"));
		addCity(new City("Amsterdam"));
		addCity(new City("Essen"));
		addCity(new City("Berlin"));
		addCity(new City("Kobenhavn"));
		addCity(new City("Stockholm"));
		addCity(new City("Petrograd"));
		addCity(new City("Moskova"));
		addCity(new City("Smolensk"));
		addCity(new City("Wilno"));
		addCity(new City("Kyiv"));
		addCity(new City("Kharakov"));
		addCity(new City("Rostov"));
		addCity(new City("Sochi"));
		addCity(new City("Erzurum"));
		addCity(new City("Ancora"));
		addCity(new City("Smyrna"));
		addCity(new City("Constantinople"));
		addCity(new City("Athina"));
		addCity(new City("Palermo"));
		addCity(new City("Brindisi"));
		addCity(new City("Sofia"));
		addCity(new City("Buceresti"));
		addCity(new City("Sevastopol"));
		addCity(new City("Warszawa"));
		addCity(new City("Danzic"));
		addCity(new City("Berlin"));
		addCity(new City("Wien"));
		addCity(new City("Zacrad"));
		addCity(new City("Venezia"));
		addCity(new City("Zurich"));
		addCity(new City("Monchen"));
		addCity(new City("Frankfurt"));
		addCity(new City("Bruxelles"));
		addCity(new City("Dieppe"));
		addCity(new City("Brest"));
		addCity(new City("Paris"));
		addCity(new City("Pamplona"));
		addCity(new City("Barcelona"));
		addCity(new City("Marseille"));
		addCity(new City("Roma"));
		addCity(new City("Madrid"));
		addCity(new City("Lisbon"));
		addCity(new City("Cadiz"));
		addCity(new City("Sarajevo"));
	}

}
