import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Europe {
	private ArrayList<City> cities;

	public Europe() {
		cities = new ArrayList<>();
	}

	public void addEdge(City a, City b, int length, int ferry, TrainColor c) {
		a.getRoads().add(new Road(b, a, length, ferry,c));
		b.getRoads().add(new Road(a, b, length, ferry,c));
	}
	public void addEdge(City a, City b, int length, int ferry, TrainColor c, Boolean m) {
		a.getRoads().add(new Road(b, a, length, ferry,c, m));
		b.getRoads().add(new Road(a, b, length, ferry,c, m));
	}

	public boolean addCity(City c) {
		return cities.add(c);
	}


/** needs reworking
	public void printGraph(HashSet<City> x) {
		for (City y:x) {
			ArrayList<Road> roads = y.getRoads();
			System.out.println("\nVertex " + y.getName() + ":");
			for (Road z : roads) {
				System.out.print(" -> " + z.getOtherNode().getName());
			}
			System.out.println();
		}
	}
**/

	public void createDefaultCities() {

		addCity(new City("Edinburgh")); //done
		addCity(new City("London")); //done
		addCity(new City("Amsterdam")); //done
		addCity(new City("Essen")); //done
		addCity(new City("Berlin")); //done
		addCity(new City("Kobenhavn")); //done
		addCity(new City("Stockholm")); //done
		addCity(new City("Petrograd")); //done
		addCity(new City("Moskova")); //done
		addCity(new City("Smolensk")); //done
		addCity(new City("Wilno")); //done
		addCity(new City("Kyiv")); //done
		addCity(new City("Kharkov")); //done
		addCity(new City("Rostov")); //done
		addCity(new City("Sochi")); //done
		addCity(new City("Erzurum")); //done
		addCity(new City("Ancora")); //done
		addCity(new City("Smyrna")); //done
		addCity(new City("Constantinople")); //done
		addCity(new City("Athina")); //done
		addCity(new City("Palermo")); //done
		addCity(new City("Brindisi")); //done
		addCity(new City("Sofia")); //done
		addCity(new City("Bucuresti")); //done
		addCity(new City("Sevastopol")); //done
		addCity(new City("Warszawa")); //done
		addCity(new City("Danzic")); //done
		addCity(new City("Wien")); //done
		addCity(new City("Zacrad")); //done
		addCity(new City("Venezia")); //done
		addCity(new City("Zurich")); //done
		addCity(new City("Monchen")); //done
		addCity(new City("Frankfurt")); //done
		addCity(new City("Bruxelles")); //done
		addCity(new City("Dieppe")); //done
		addCity(new City("Brest")); //done
		addCity(new City("Paris")); //done
		addCity(new City("Pamplona"));
		addCity(new City("Barcelona"));
		addCity(new City("Marseille"));
		addCity(new City("Roma"));
		addCity(new City("Madrid"));
		addCity(new City("Lisbon"));
		addCity(new City("Cadiz"));
		addCity(new City("Sarajevo")); //done
		addCity(new City("Rica")); //done
		addCity(new City("Budapest")); //done


		cities.sort(null);

		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Black);
		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Orange);
		addEdge(citySearch("London"), citySearch("Amsterdam"), 2, 2, TrainColor.all);
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.all);
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.all); //yes, there are two of the same route, this is not a mistake
		addEdge(citySearch("Dieppe"), citySearch("Brest"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Brest"), citySearch("Paris"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Brest"), citySearch("Pamplona"), 4, 0, TrainColor.Pink);
		addEdge(citySearch("Dieppe"), citySearch("Paris"), 1, 0, TrainColor.Pink);
		addEdge(citySearch("Dieppe"), citySearch("Bruxelles"), 2, 0, TrainColor.Green);
		addEdge(citySearch("Bruxelles"), citySearch("Paris"), 2, 0, TrainColor.Yellow);
		addEdge(citySearch("Bruxelles"), citySearch("Paris"), 2, 0, TrainColor.Red);
		addEdge(citySearch("Bruxelles"), citySearch("Amsterdam"), 1, 0, TrainColor.Black);
		addEdge(citySearch("Bruxelles"), citySearch("Frankfurt"), 2, 0, TrainColor.Blue);
		addEdge(citySearch("Amsterdam"), citySearch("Essen"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Amsterdam"), citySearch("Frankfurt"), 2, 0, TrainColor.White);
		addEdge(citySearch("Frankfurt"), citySearch("Paris"), 3, 0, TrainColor.White);
		addEdge(citySearch("Frankfurt"), citySearch("Paris"), 3, 0, TrainColor.Orange);
		addEdge(citySearch("Frankfurt"), citySearch("Monchen"), 2, 0, TrainColor.Pink);
		addEdge(citySearch("Frankfurt"), citySearch("Berlin"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Frankfurt"), citySearch("Berlin"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Frankfurt"), citySearch("Essen"), 2, 0, TrainColor.Green);
		addEdge(citySearch("Essen"), citySearch("Berlin"), 2, 0, TrainColor.Blue);
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.all);
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.all);
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.White);
		addEdge(citySearch("Stockholm"), citySearch("Petrograd"), 8, 0, TrainColor.all, true);
		addEdge(citySearch("Petrograd"), citySearch("Rica"), 4, 0, TrainColor.all);
		addEdge(citySearch("Petrograd"), citySearch("Wilno"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Petrograd"), citySearch("Moskova"), 4, 0, TrainColor.White);
		addEdge(citySearch("Moskova"), citySearch("Smolensk"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Moskova"), citySearch("Kharkov"), 4, 0, TrainColor.all);
		addEdge(citySearch("Wilno"), citySearch("Kyiv"), 2, 0, TrainColor.all);
		addEdge(citySearch("Wilno"), citySearch("Warszawa"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Smolensk"), citySearch("Wilno"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Smolensk"), citySearch("Kyiv"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Rica"), citySearch("Wilno"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Kyiv"), citySearch("Warszawa"), 4, 0, TrainColor.all);
		addEdge(citySearch("Kyiv"), citySearch("Kharkov"), 4, 0, TrainColor.all);
		addEdge(citySearch("Kyiv"), citySearch("Bucuresti"), 4, 0, TrainColor.all);
		addEdge(citySearch("Kyiv"), citySearch("Budapest"), 6, 0, TrainColor.all, true);
		addEdge(citySearch("Kharkov"), citySearch("Rostov"), 2, 0, TrainColor.Green);
		addEdge(citySearch("Rostov"), citySearch("Sevastopol"), 4, 0, TrainColor.all);
		addEdge(citySearch("Rostov"), citySearch("Sochi"), 2, 0, TrainColor.all);
		addEdge(citySearch("Sevastopol"), citySearch("Bucuresti"), 4, 0, TrainColor.White);
		addEdge(citySearch("Sevastopol"), citySearch("Constantinople"), 4, 2, TrainColor.all);
		addEdge(citySearch("Sevastopol"), citySearch("Erzurum"), 4, 2, TrainColor.all);
		addEdge(citySearch("Sevastopol"), citySearch("Sochi"), 2, 1, TrainColor.all);
		addEdge(citySearch("Sochi"), citySearch("Erzurum"), 3, 0, TrainColor.Red, true);
		addEdge(citySearch("Erzurum"), citySearch("Ancora"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Ancora"), citySearch("Smyrna"), 3, 0, TrainColor.Orange, true);
		addEdge(citySearch("Ancora"), citySearch("Constantinople"), 2, 0, TrainColor.all, true);
		addEdge(citySearch("Smyrna"), citySearch("Palermo"), 6, 2, TrainColor.all);
		addEdge(citySearch("Smyrna"), citySearch("Athina"), 2, 1, TrainColor.all);
		addEdge(citySearch("Smyrna"), citySearch("Constantinople"), 2, 0, TrainColor.all, true);
		addEdge(citySearch("Palermo"), citySearch("Brindisi"), 3, 1, TrainColor.all);
		addEdge(citySearch("Palermo"), citySearch("Roma"), 4, 1, TrainColor.all);
		addEdge(citySearch("Constantinople"), citySearch("Bucuresti"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Constantinople"), citySearch("Sofia"), 3, 0, TrainColor.Blue);
		addEdge(citySearch("Bucuresti"), citySearch("Budapest"), 4, 0, TrainColor.all, true);
		addEdge(citySearch("Bucuresti"), citySearch("Sofia"), 2, 0, TrainColor.all, true);
		addEdge(citySearch("Sofia"), citySearch("Sarajevo"), 2, 0, TrainColor.all, true);
		addEdge(citySearch("Sofia"), citySearch("Athina"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Athina"), citySearch("Brindisi"), 4, 1, TrainColor.all);
		addEdge(citySearch("Athina"), citySearch("Sarajevo"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Brindisi"), citySearch("Roma"), 2, 0, TrainColor.White);
		addEdge(citySearch("Sarajevo"), citySearch("Zacrad"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Sarajevo"), citySearch("Budapest"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Budapest"), citySearch("Zacrad"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.White);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.Red);
		addEdge(citySearch("Warszawa"), citySearch("Danzic"), 2, 0, TrainColor.all);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Pink);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Yellow);
		addEdge(citySearch("Warszawa"), citySearch("Wien"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Danzic"), citySearch("Rica"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Danzic"), citySearch("Berlin"), 4, 0, TrainColor.all);
		addEdge(citySearch("Berlin"), citySearch("Wien"), 3, 0, TrainColor.Green);
		addEdge(citySearch("Zacrad"), citySearch("Wien"), 2, 0, TrainColor.all);
		addEdge(citySearch("Zacrad"), citySearch("Venezia"), 2, 0, TrainColor.all);
		addEdge(citySearch("Venezia"), citySearch("Roma"), 2, 0, TrainColor.Black);
		addEdge(citySearch("Venezia"), citySearch("Monchen"), 2, 0, TrainColor.Blue, true);
		addEdge(citySearch("Venezia"), citySearch("Zurich"), 2, 0, TrainColor.Green, true);
		addEdge(citySearch("Wien"), citySearch("Monchen"), 3, 0, TrainColor.Orange);
		addEdge(citySearch("Monchen"), citySearch("Zurich"), 2, 0, TrainColor.Yellow, true);
		addEdge(citySearch("Zurich"), citySearch("Marseille"), 2, 0, TrainColor.Pink, true);
		addEdge(citySearch("Zurich"), citySearch("Paris"), 3, 0, TrainColor.all, true);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Paris"), citySearch("Marseille"), 4, 0, TrainColor.all);





		addEdge(citySearch(""), citySearch(""), , 0, TrainColor.);




	}

	public City citySearch(String name) {

		int tracker = 0;


		while (name.compareTo(cities.get(tracker).getName()) != 0) {
			tracker++;
		}
		return cities.get(tracker);
	}

	public String getDouble() {

	}


}
