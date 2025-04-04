import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

public class Europe {
    private final List<City> cities;
    private final List<RouteCard> routes;
    
    public Europe() {
        cities = Collections.synchronizedList(new ArrayList<>());
        routes = Collections.synchronizedList(new ArrayList<>());
        initializeCities();
    }
    
    public static void main(String[] args) {
        Europe europe = new Europe();
        try {
            europe.createDefaultRoutes();
        } catch (IOException e) {
            System.err.println("Failed to create default routes: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void initializeCities() {
        // Create all cities first
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
        addCity(new City("Kharkov"));
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
        addCity(new City("Bucuresti"));
        addCity(new City("Sevastopol"));
        addCity(new City("Warszawa"));
        addCity(new City("Danzic"));
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
        addCity(new City("Lisboa"));
        addCity(new City("Cadiz"));
        addCity(new City("Sarajevo"));
        addCity(new City("Rica"));
        addCity(new City("Budapest"));
        
        // Sort cities for binary search
        Collections.sort(cities);
        
        // Create all connections
        createCityConnections();
    }
    
    private void createCityConnections() {
        addEdge("Edinburgh", "London", 4, 0, TrainColor.Black);
        addEdge("Edinburgh", "London", 4, 0, TrainColor.Orange);
        addEdge("London", "Amsterdam", 2, 2, TrainColor.Wild);
        addEdge("London", "Dieppe", 2, 1, TrainColor.Wild);
        addEdge("London", "Dieppe", 2, 1, TrainColor.Wild);
        addEdge("Dieppe", "Brest", 2, 0, TrainColor.Orange);
        addEdge("Brest", "Paris", 3, 0, TrainColor.Black);
        addEdge("Brest", "Pamplona", 4, 0, TrainColor.Pink);
        addEdge("Dieppe", "Paris", 1, 0, TrainColor.Pink);
        addEdge("Dieppe", "Bruxelles", 2, 0, TrainColor.Green);
        addEdge("Bruxelles", "Paris", 2, 0, TrainColor.Yellow);
        addEdge("Bruxelles", "Paris", 2, 0, TrainColor.Red);
        addEdge("Bruxelles", "Amsterdam", 1, 0, TrainColor.Black);
        addEdge("Bruxelles", "Frankfurt", 2, 0, TrainColor.Blue);
        addEdge("Amsterdam", "Essen", 3, 0, TrainColor.Yellow);
        addEdge("Amsterdam", "Frankfurt", 2, 0, TrainColor.White);
        addEdge("Frankfurt", "Paris", 3, 0, TrainColor.White);
        addEdge("Frankfurt", "Paris", 3, 0, TrainColor.Orange);
        addEdge("Frankfurt", "Monchen", 2, 0, TrainColor.Pink);
        addEdge("Frankfurt", "Berlin", 3, 0, TrainColor.Black);
        addEdge("Frankfurt", "Berlin", 3, 0, TrainColor.Red);
        addEdge("Frankfurt", "Essen", 2, 0, TrainColor.Green);
        addEdge("Essen", "Berlin", 2, 0, TrainColor.Blue);
        addEdge("Essen", "Kobenhavn", 3, 1, TrainColor.Wild);
        addEdge("Essen", "Kobenhavn", 3, 1, TrainColor.Wild);
        addEdge("Kobenhavn", "Stockholm", 3, 0, TrainColor.Yellow);
        addEdge("Kobenhavn", "Stockholm", 3, 0, TrainColor.White);
        addEdge("Stockholm", "Petrograd", 8, 0, TrainColor.Wild, true);
        addEdge("Petrograd", "Rica", 4, 0, TrainColor.Wild);
        addEdge("Petrograd", "Wilno", 4, 0, TrainColor.Blue);
        addEdge("Petrograd", "Moskova", 4, 0, TrainColor.White);
        addEdge("Moskova", "Smolensk", 2, 0, TrainColor.Orange);
        addEdge("Moskova", "Kharkov", 4, 0, TrainColor.Wild);
        addEdge("Wilno", "Kyiv", 2, 0, TrainColor.Wild);
        addEdge("Wilno", "Warszawa", 3, 0, TrainColor.Red);
        addEdge("Smolensk", "Wilno", 3, 0, TrainColor.Yellow);
        addEdge("Smolensk", "Kyiv", 3, 0, TrainColor.Red);
        addEdge("Rica", "Wilno", 4, 0, TrainColor.Green);
        addEdge("Kyiv", "Warszawa", 4, 0, TrainColor.Wild);
        addEdge("Kyiv", "Kharkov", 4, 0, TrainColor.Wild);
        addEdge("Kyiv", "Bucuresti", 4, 0, TrainColor.Wild);
        addEdge("Kyiv", "Budapest", 6, 0, TrainColor.Wild, true);
        addEdge("Kharkov", "Rostov", 2, 0, TrainColor.Green);
        addEdge("Rostov", "Sevastopol", 4, 0, TrainColor.Wild);
        addEdge("Rostov", "Sochi", 2, 0, TrainColor.Wild);
        addEdge("Sevastopol", "Bucuresti", 4, 0, TrainColor.White);
        addEdge("Sevastopol", "Constantinople", 4, 2, TrainColor.Wild);
        addEdge("Sevastopol", "Erzurum", 4, 2, TrainColor.Wild);
        addEdge("Sevastopol", "Sochi", 2, 1, TrainColor.Wild);
        addEdge("Sochi", "Erzurum", 3, 0, TrainColor.Red, true);
        addEdge("Erzurum", "Ancora", 3, 0, TrainColor.Black);
        addEdge("Ancora", "Smyrna", 3, 0, TrainColor.Orange, true);
        addEdge("Ancora", "Constantinople", 2, 0, TrainColor.Wild, true);
        addEdge("Smyrna", "Palermo", 6, 2, TrainColor.Wild);
        addEdge("Smyrna", "Athina", 2, 1, TrainColor.Wild);
        addEdge("Smyrna", "Constantinople", 2, 0, TrainColor.Wild, true);
        addEdge("Palermo", "Brindisi", 3, 1, TrainColor.Wild);
        addEdge("Palermo", "Roma", 4, 1, TrainColor.Wild);
        addEdge("Constantinople", "Bucuresti", 3, 0, TrainColor.Yellow);
        addEdge("Constantinople", "Sofia", 3, 0, TrainColor.Blue);
        addEdge("Bucuresti", "Budapest", 4, 0, TrainColor.Wild, true);
        addEdge("Bucuresti", "Sofia", 2, 0, TrainColor.Wild, true);
        addEdge("Sofia", "Sarajevo", 2, 0, TrainColor.Wild, true);
        addEdge("Sofia", "Athina", 3, 0, TrainColor.Pink);
        addEdge("Athina", "Brindisi", 4, 1, TrainColor.Wild);
        addEdge("Athina", "Sarajevo", 4, 0, TrainColor.Green);
        addEdge("Brindisi", "Roma", 2, 0, TrainColor.White);
        addEdge("Sarajevo", "Zacrad", 3, 0, TrainColor.Red);
        addEdge("Sarajevo", "Budapest", 3, 0, TrainColor.Pink);
        addEdge("Budapest", "Zacrad", 2, 0, TrainColor.Orange);
        addEdge("Budapest", "Wien", 1, 0, TrainColor.White);
        addEdge("Budapest", "Wien", 1, 0, TrainColor.Red);
        addEdge("Warszawa", "Danzic", 2, 0, TrainColor.Wild);
        addEdge("Warszawa", "Berlin", 4, 0, TrainColor.Pink);
        addEdge("Warszawa", "Berlin", 4, 0, TrainColor.Yellow);
        addEdge("Warszawa", "Wien", 4, 0, TrainColor.Blue);
        addEdge("Danzic", "Rica", 3, 0, TrainColor.Black);
        addEdge("Danzic", "Berlin", 4, 0, TrainColor.Wild);
        addEdge("Berlin", "Wien", 3, 0, TrainColor.Green);
        addEdge("Zacrad", "Wien", 2, 0, TrainColor.Wild);
        addEdge("Zacrad", "Venezia", 2, 0, TrainColor.Wild);
        addEdge("Venezia", "Roma", 2, 0, TrainColor.Black);
        addEdge("Venezia", "Monchen", 2, 0, TrainColor.Blue, true);
        addEdge("Venezia", "Zurich", 2, 0, TrainColor.Green, true);
        addEdge("Wien", "Monchen", 3, 0, TrainColor.Orange);
        addEdge("Monchen", "Zurich", 2, 0, TrainColor.Yellow, true);
        addEdge("Zurich", "Marseille", 2, 0, TrainColor.Pink, true);
        addEdge("Zurich", "Paris", 3, 0, TrainColor.Wild, true);
        addEdge("Paris", "Pamplona", 4, 0, TrainColor.Green);
        addEdge("Paris", "Pamplona", 4, 0, TrainColor.Blue);
        addEdge("Paris", "Marseille", 4, 0, TrainColor.Wild);
        addEdge("Roma", "Marseille", 4, 0, TrainColor.Wild, true);
        addEdge("Marseille", "Pamplona", 4, 0, TrainColor.Red);
        addEdge("Marseille", "Barcelona", 4, 0, TrainColor.Wild);
        addEdge("Barcelona", "Madrid", 2, 0, TrainColor.Yellow);
        addEdge("Pamplona", "Madrid", 3, 0, TrainColor.Black, true);
        addEdge("Pamplona", "Madrid", 3, 0, TrainColor.White, true);
        addEdge("Pamplona", "Barcelona", 2, 0, TrainColor.Wild, true);
        addEdge("Madrid", "Lisboa", 3, 0, TrainColor.Pink);
        addEdge("Lisboa", "Cadiz", 2, 0, TrainColor.Blue);
        addEdge("Cadiz", "Madrid", 3, 0, TrainColor.Orange);
    }
    
    private void addEdge(String city1, String city2, int length, int ferry, TrainColor color) {
        addEdge(city1, city2, length, ferry, color, false);
    }
    
    private void addEdge(String city1, String city2, int length, int ferry, TrainColor color, boolean mountain) {
        City c1 = citySearch(city1);
        City c2 = citySearch(city2);
        
        if (c1 == null || c2 == null) {
            throw new IllegalArgumentException("One or both cities not found: " + city1 + ", " + city2);
        }
        
        c1.getRoads().add(new Road(c2, c1, length, ferry, color, mountain));
        c2.getRoads().add(new Road(c1, c2, length, ferry, color, mountain));
    }
    
    public synchronized boolean addCity(City c) {
        if (c == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        return cities.add(c);
    }
    
    public synchronized boolean addRoute(RouteCard r) {
        if (r == null) {
            throw new IllegalArgumentException("RouteCard cannot be null");
        }
        return routes.add(r);
    }
    
    public synchronized List<RouteCard> getRoutes() {
        return new ArrayList<>(routes); // Return a copy for thread safety
    }
    
    public void createDefaultRoutes() throws IOException {
        
        addRoute(new RouteCard(citySearch("Amsterdam"), citySearch("Pamplona"), 7, false, ImageIO.read(getClass().getResource("/routes/Amsterdam-Pamplona7.png"))));
        addRoute(new RouteCard(citySearch("Amsterdam"), citySearch("Wilno"), 12, false, ImageIO.read(getClass().getResource("/routes/Amsterdam-Wilno12.png"))));
        addRoute(new RouteCard(citySearch("Ancora"), citySearch("Kharkov"), 10, false, ImageIO.read(getClass().getResource("/routes/Ancora-Kharkov10.png"))));
        addRoute(new RouteCard(citySearch("Athina"), citySearch("Ancora"), 5, false, ImageIO.read(getClass().getResource("/routes/Athina-Ancora5.png"))));
        addRoute(new RouteCard(citySearch("Athina"), citySearch("Wilno"), 11, false, ImageIO.read(getClass().getResource("/routes/Athina-Wilno11.png"))));
        addRoute(new RouteCard(citySearch("Barcelona"), citySearch("Bruxelles"), 8, false, ImageIO.read(getClass().getResource("/routes/Barcelona-Bruxelles8.png"))));
        addRoute(new RouteCard(citySearch("Barcelona"), citySearch("Monchen"), 8, false, ImageIO.read(getClass().getResource("/routes/Barcelona-Munchen8.png"))));
        addRoute(new RouteCard(citySearch("Berlin"), citySearch("Bucuresti"), 8, false, ImageIO.read(getClass().getResource("/routes/Berlin-Bucuresti8.png"))));
        addRoute(new RouteCard(citySearch("Berlin"), citySearch("Moskova"), 12, false, ImageIO.read(getClass().getResource("/routes/Berlin-Moskva12.png"))));
        addRoute(new RouteCard(citySearch("Berlin"), citySearch("Roma"), 9, false, ImageIO.read(getClass().getResource("/routes/Berlin-Roma9.png"))));
        addRoute(new RouteCard(citySearch("Brest"), citySearch("Marseille"), 7, false, ImageIO.read(getClass().getResource("/routes/Brest-Marseille7.png"))));
        addRoute(new RouteCard(citySearch("Brest"), citySearch("Petrograd"), 20, true, ImageIO.read(getClass().getResource("/routes/Brest-Petrograd20.png"))));
        addRoute(new RouteCard(citySearch("Brest"), citySearch("Venezia"), 8, false, ImageIO.read(getClass().getResource("/routes/Brest-Venezia8.png"))));
        addRoute(new RouteCard(citySearch("Bruxelles"), citySearch("Danzic"), 9, false, ImageIO.read(getClass().getResource("/routes/Bruxelles-Danzic9.png"))));
        addRoute(new RouteCard(citySearch("Budapest"), citySearch("Sofia"), 5, false, ImageIO.read(getClass().getResource("/routes/Budapest-Sofia5.png"))));
        addRoute(new RouteCard(citySearch("Cadiz"), citySearch("Stockholm"), 21, true, ImageIO.read(getClass().getResource("/routes/Cadiz-Stockholm21.png"))));
        addRoute(new RouteCard(citySearch("Edinburgh"), citySearch("Athina"), 21, true, ImageIO.read(getClass().getResource("/routes/Edinburgh-Athina21.png"))));
        addRoute(new RouteCard(citySearch("Edinburgh"), citySearch("Paris"), 7, false, ImageIO.read(getClass().getResource("/routes/Edinburch-Paris7.png"))));
        addRoute(new RouteCard(citySearch("Erzurum"), citySearch("Rostov"), 5, false, ImageIO.read(getClass().getResource("/routes/Erzurm-Rostov5.png"))));
        addRoute(new RouteCard(citySearch("Essen"), citySearch("Kyiv"), 10, false, ImageIO.read(getClass().getResource("/routes/Essen-Kyiv10.png"))));
        addRoute(new RouteCard(citySearch("Frankfurt"), citySearch("Kobenhavn"), 5, false, ImageIO.read(getClass().getResource("/routes/Frankfurt-Kobenhavn5.png"))));
        addRoute(new RouteCard(citySearch("Frankfurt"), citySearch("Smolensk"), 13, false, ImageIO.read(getClass().getResource("/routes/Frankkfurt-Smolense13.png"))));
        addRoute(new RouteCard(citySearch("Kobenhavn"), citySearch("Erzurum"), 21, true, ImageIO.read(getClass().getResource("/routes/Kobenhavn-Erzurum21.png"))));
        addRoute(new RouteCard(citySearch("Kyiv"), citySearch("Petrograd"), 6, false, ImageIO.read(getClass().getResource("/routes/Kyiv-Petrocrad6.png"))));
        addRoute(new RouteCard(citySearch("Kyiv"), citySearch("Sochi"), 8, false, ImageIO.read(getClass().getResource("/routes/Kyiv-Sochi8.png"))));
        addRoute(new RouteCard(citySearch("Lisboa"), citySearch("Danzic"), 20, true, ImageIO.read(getClass().getResource("/routes/Lisboa-Danzic20.png"))));
        addRoute(new RouteCard(citySearch("London"), citySearch("Berlin"), 7, false, ImageIO.read(getClass().getResource("/routes/London-Berlin7.png"))));
        addRoute(new RouteCard(citySearch("London"), citySearch("Wien"), 10, false, ImageIO.read(getClass().getResource("/routes/London-Wien10.png"))));
        addRoute(new RouteCard(citySearch("Madrid"), citySearch("Dieppe"), 8, false, ImageIO.read(getClass().getResource("/routes/Madrid-Dieppe8.png"))));
        addRoute(new RouteCard(citySearch("Madrid"), citySearch("Zurich"), 8, false, ImageIO.read(getClass().getResource("/routes/Madrid-Zurich8.png"))));
        addRoute(new RouteCard(citySearch("Marseille"), citySearch("Essen"), 8, false, ImageIO.read(getClass().getResource("/routes/Marseille-Essen8.png"))));
        addRoute(new RouteCard(citySearch("Palermo"), citySearch("Constantinople"), 8, false, ImageIO.read(getClass().getResource("/routes/Palermo-Constantinople8.png"))));
        addRoute(new RouteCard(citySearch("Palermo"), citySearch("Moskova"), 20, true, ImageIO.read(getClass().getResource("/routes/Palermo-Moskva20.png"))));
        addRoute(new RouteCard(citySearch("Paris"), citySearch("Wien"), 8, false, ImageIO.read(getClass().getResource("/routes/Paris-Wien8.png"))));
        addRoute(new RouteCard(citySearch("Paris"), citySearch("Zacrad"), 7, false, ImageIO.read(getClass().getResource("/routes/Paris-Zacrad7.png"))));
        addRoute(new RouteCard(citySearch("Rica"), citySearch("Bucuresti"), 10, false, ImageIO.read(getClass().getResource("/routes/Rica-Bucuresti10.png"))));
        addRoute(new RouteCard(citySearch("Roma"), citySearch("Smyrna"), 8, false, ImageIO.read(getClass().getResource("/routes/Roma-Smyrna8.png"))));
        addRoute(new RouteCard(citySearch("Sarajevo"), citySearch("Sevastopol"), 8, false, ImageIO.read(getClass().getResource("/routes/Sarajevo-Sevastopol8.png"))));
        addRoute(new RouteCard(citySearch("Smolensk"), citySearch("Rostov"), 8, false, ImageIO.read(getClass().getResource("/routes/Smolensk-Rostov8.png"))));
        addRoute(new RouteCard(citySearch("Sofia"), citySearch("Smyrna"), 5, false, ImageIO.read(getClass().getResource("/routes/Sofia-Smyrna5.png"))));
        addRoute(new RouteCard(citySearch("Stockholm"), citySearch("Wien"), 11, false, ImageIO.read(getClass().getResource("/routes/Stockholm-Wien11.png"))));
        addRoute(new RouteCard(citySearch("Venezia"), citySearch("Constantinople"), 10, false, ImageIO.read(getClass().getResource("/routes/Venezia-Constantinople10.png"))));
        addRoute(new RouteCard(citySearch("Warszawa"), citySearch("Smolensk"), 6, false, ImageIO.read(getClass().getResource("/routes/Warszawa-Smolensk6.png"))));
        addRoute(new RouteCard(citySearch("Zacrad"), citySearch("Brindisi"), 6, false, ImageIO.read(getClass().getResource("/routes/Zacrab-Brindisi6.png"))));
        addRoute(new RouteCard(citySearch("Zurich"), citySearch("Brindisi"), 6, false, ImageIO.read(getClass().getResource("/routes/Zurich-Brindisi6.png"))));
        addRoute(new RouteCard(citySearch("Zurich"), citySearch("Budapest"), 6, false, ImageIO.read(getClass().getResource("/routes/Zurich-Budapest6.png"))));
    }
    
    
    
    public City citySearch(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        
        // Use binary search since cities are sorted
        int index = Collections.binarySearch(cities, new City(name), 
                (c1, c2) -> c1.getName().compareTo(c2.getName()));
        
        return index >= 0 ? cities.get(index) : null;
    }
}