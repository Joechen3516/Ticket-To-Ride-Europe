import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Europe {
	private ArrayList<City> cities;

	public Europe() {
		cities = new ArrayList<>();
		createDefaultCities();
	}

	
	public void addEdge(City a, City b, int length, int ferry, TrainColor c,double[] xs,double[] ys,double[] as) {
		a.getRoads().add(new Road(b, a, length, ferry,c, xs,ys,as));
		b.getRoads().add(new Road(a, b, length, ferry,c, xs,ys,as));
	}
	public void addEdge(City a, City b, int length, int ferry, TrainColor c, Boolean m, double[] xs,double[] ys,double[] as) {
		a.getRoads().add(new Road(b, a, length, ferry,c, m, xs,ys,as));
		b.getRoads().add(new Road(a, b, length, ferry,c, m, xs,ys,as));
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
		addCity(new City("Pamplona")); //done
		addCity(new City("Barcelona")); //done
		addCity(new City("Marseille")); //done
		addCity(new City("Roma")); //done
		addCity(new City("Madrid")); //done
		addCity(new City("Lisboa")); //done
		addCity(new City("Cadiz")); //done
		addCity(new City("Sarajevo")); //done
		addCity(new City("Rica")); //done
		addCity(new City("Budapest")); //done


		cities.sort(null);

		
		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Black,new double[]{0.1013655462184874,0.11292016806722689,0.12394957983193278,0.13445378151260504},new double[]{0.06051873198847262,0.10758885686839577,0.15369836695485112,0.19980787704130643},new double[]{-0.4350345062237482,-0.42323950932954935,-0.4120965596890702,-0.42323950932954935});
		/*
		addEdge(citySearch("Edinburgh"), citySearch("London"), 4, 0, TrainColor.Orange);
		addEdge(citySearch("London"), citySearch("Amsterdam"), 2, 2, TrainColor.Wild);
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.Wild);
		addEdge(citySearch("London"), citySearch("Dieppe"), 2, 1, TrainColor.Wild); //yes, there are two of the same route, this is not a mistake
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
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.Wild);
		addEdge(citySearch("Essen"), citySearch("Kobenhavn"), 3, 1, TrainColor.Wild);
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Kobenhavn"), citySearch("Stockholm"), 3, 0, TrainColor.White);
		addEdge(citySearch("Stockholm"), citySearch("Petrograd"), 8, 0, TrainColor.Wild, true);
		addEdge(citySearch("Petrograd"), citySearch("Rica"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Petrograd"), citySearch("Wilno"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Petrograd"), citySearch("Moskova"), 4, 0, TrainColor.White);
		addEdge(citySearch("Moskova"), citySearch("Smolensk"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Moskova"), citySearch("Kharkov"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Wilno"), citySearch("Kyiv"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Wilno"), citySearch("Warszawa"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Smolensk"), citySearch("Wilno"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Smolensk"), citySearch("Kyiv"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Rica"), citySearch("Wilno"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Kyiv"), citySearch("Warszawa"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Kharkov"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Bucuresti"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Kyiv"), citySearch("Budapest"), 6, 0, TrainColor.Wild, true);
		addEdge(citySearch("Kharkov"), citySearch("Rostov"), 2, 0, TrainColor.Green);
		addEdge(citySearch("Rostov"), citySearch("Sevastopol"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Rostov"), citySearch("Sochi"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Bucuresti"), 4, 0, TrainColor.White);
		addEdge(citySearch("Sevastopol"), citySearch("Constantinople"), 4, 2, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Erzurum"), 4, 2, TrainColor.Wild);
		addEdge(citySearch("Sevastopol"), citySearch("Sochi"), 2, 1, TrainColor.Wild);
		addEdge(citySearch("Sochi"), citySearch("Erzurum"), 3, 0, TrainColor.Red, true);
		addEdge(citySearch("Erzurum"), citySearch("Ancora"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Ancora"), citySearch("Smyrna"), 3, 0, TrainColor.Orange, true);
		addEdge(citySearch("Ancora"), citySearch("Constantinople"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Smyrna"), citySearch("Palermo"), 6, 2, TrainColor.Wild);
		addEdge(citySearch("Smyrna"), citySearch("Athina"), 2, 1, TrainColor.Wild);
		addEdge(citySearch("Smyrna"), citySearch("Constantinople"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Palermo"), citySearch("Brindisi"), 3, 1, TrainColor.Wild);
		addEdge(citySearch("Palermo"), citySearch("Roma"), 4, 1, TrainColor.Wild);
		addEdge(citySearch("Constantinople"), citySearch("Bucuresti"), 3, 0, TrainColor.Yellow);
		addEdge(citySearch("Constantinople"), citySearch("Sofia"), 3, 0, TrainColor.Blue);
		addEdge(citySearch("Bucuresti"), citySearch("Budapest"), 4, 0, TrainColor.Wild, true);
		addEdge(citySearch("Bucuresti"), citySearch("Sofia"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Sofia"), citySearch("Sarajevo"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Sofia"), citySearch("Athina"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Athina"), citySearch("Brindisi"), 4, 1, TrainColor.Wild);
		addEdge(citySearch("Athina"), citySearch("Sarajevo"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Brindisi"), citySearch("Roma"), 2, 0, TrainColor.White);
		addEdge(citySearch("Sarajevo"), citySearch("Zacrad"), 3, 0, TrainColor.Red);
		addEdge(citySearch("Sarajevo"), citySearch("Budapest"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Budapest"), citySearch("Zacrad"), 2, 0, TrainColor.Orange);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.White);
		addEdge(citySearch("Budapest"), citySearch("Wien"), 1, 0, TrainColor.Red);
		addEdge(citySearch("Warszawa"), citySearch("Danzic"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Pink);
		addEdge(citySearch("Warszawa"), citySearch("Berlin"), 4, 0, TrainColor.Yellow);
		addEdge(citySearch("Warszawa"), citySearch("Wien"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Danzic"), citySearch("Rica"), 3, 0, TrainColor.Black);
		addEdge(citySearch("Danzic"), citySearch("Berlin"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Berlin"), citySearch("Wien"), 3, 0, TrainColor.Green);
		addEdge(citySearch("Zacrad"), citySearch("Wien"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Zacrad"), citySearch("Venezia"), 2, 0, TrainColor.Wild);
		addEdge(citySearch("Venezia"), citySearch("Roma"), 2, 0, TrainColor.Black);
		addEdge(citySearch("Venezia"), citySearch("Monchen"), 2, 0, TrainColor.Blue, true);
		addEdge(citySearch("Venezia"), citySearch("Zurich"), 2, 0, TrainColor.Green, true);
		addEdge(citySearch("Wien"), citySearch("Monchen"), 3, 0, TrainColor.Orange);
		addEdge(citySearch("Monchen"), citySearch("Zurich"), 2, 0, TrainColor.Yellow, true);
		addEdge(citySearch("Zurich"), citySearch("Marseille"), 2, 0, TrainColor.Pink, true);
		addEdge(citySearch("Zurich"), citySearch("Paris"), 3, 0, TrainColor.Wild, true);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Green);
		addEdge(citySearch("Paris"), citySearch("Pamplona"), 4, 0, TrainColor.Blue);
		addEdge(citySearch("Paris"), citySearch("Marseille"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Roma"), citySearch("Marseille"), 4, 0, TrainColor.Wild, true);
		addEdge(citySearch("Marseille"), citySearch("Pamplona"), 4, 0, TrainColor.Red);
		addEdge(citySearch("Marseille"), citySearch("Barcelona"), 4, 0, TrainColor.Wild);
		addEdge(citySearch("Barcelona"), citySearch("Madrid"), 2, 0, TrainColor.Yellow);
		addEdge(citySearch("Pamplona"), citySearch("Madrid"), 3, 0, TrainColor.Black, true);
		addEdge(citySearch("Pamplona"), citySearch("Madrid"), 3, 0, TrainColor.White, true);
		addEdge(citySearch("Pamplona"), citySearch("Barcelona"), 2, 0, TrainColor.Wild, true);
		addEdge(citySearch("Madrid"), citySearch("Lisboa"), 3, 0, TrainColor.Pink);
		addEdge(citySearch("Lisboa"), citySearch("Cadiz"), 2, 0, TrainColor.Blue);
		addEdge(citySearch("Cadiz"), citySearch("Madrid"), 3, 0, TrainColor.Orange);

*/

	}

	public City citySearch(String name) {

		int tracker = 0;


		while (name.compareTo(cities.get(tracker).getName()) != 0) {
			tracker++;
		}
		return cities.get(tracker);
	}

	public ArrayList<Road> roadSearch(City a, City b) {
		ArrayList<Road> result = new ArrayList<>();
		for (Road n: a.getRoads()) {
			if (n.getOtherNode(a).getName().equals(b.getName())) {
				result.add(n);
			}
		}

		return result;
	}



}
