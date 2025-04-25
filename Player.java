import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private HashMap<TrainColor,ArrayList<TrainCard>> hand;
	private PlayerColor color;
	//private int score = 0; //score should be calculated by controller i think? not sure.
	private ArrayList<RouteCard> routeCards = new ArrayList<>();
	private int numStations = 3;
	private ArrayList<Road> roads = new ArrayList<>();
	private ArrayList<City> stationLocations = new ArrayList<>();
	private int trainPieces = 45; //double check value later.





	public Player(HashMap<TrainColor,ArrayList<TrainCard>> hand, PlayerColor color) {
		this.hand = hand;
		this.color = color;
	}

		public HashMap<TrainColor,ArrayList<TrainCard>> getHand(){
		return hand;
	}




	@Override
	public String toString() {
		String f = "";

		f += color.toString() + "::";

		for(TrainColor color: hand.keySet()) {
			f+=" ;" + color.toString() + ", "+hand.get(color).size();
		}

		return f;
	}



	public void giveRoute(RouteCard rc) {
		routeCards.add(rc);
		
	}

	public void addTrainCard(TrainCard c) {
		ArrayList<TrainCard> placeholder = hand.get(c.getColor());
		placeholder.add(c);
		hand.put(c.getColor(), placeholder);
	}

	public boolean addRoad(Road r) {
		if (trainPieces - r.getLength()[0] < 0) {
			return false;
		}
		roads.add(r);
		trainPieces -= r.getLength()[0];
		return true;

	}

	public boolean addStation(City c) {
		if (numStations == 0) {
			return false;
		}
		stationLocations.add(c);
		numStations --;
		return true;
	}

	//returns an ArrayList of the route cards the player has completed.
	public ArrayList<RouteCard> getCompletedRoutes() {
		ArrayList<RouteCard> result = new ArrayList<>();
		for (RouteCard n: routeCards) {
			if (isRouteCompleted(n.getCities()[0], n.getCities()[1], new ArrayList<>())) {
				result.add(n);
			}
		}
		return result;
	}

	//returns all the routecards a player owns in an arraylist
	public ArrayList<RouteCard> getRoutes() {
		return routeCards;
	}

	//returns all the roads a player owns
	public ArrayList<Road> getRoads() {return roads;}

	//returns the roads the player owns that are connected to a city a.
	private ArrayList<Road> playerRoadsPerCity(City a) {
		ArrayList<Road> result = new ArrayList<>();
		for (Road n: roads) {
			if (n.getOtherNode(a) != null) {
				result.add(n);
			}
		}
		return result;
	}


	//in theory, this works. it might not.
	//helper function for the getCompletedRoutes method. this method uses a recursive DFS algorithm.
	private Boolean isRouteCompleted(City a, City b, ArrayList<City> visited) {
		visited.add(a);
		for (Road n: playerRoadsPerCity(a)) {
			if (n.getOtherNode(a).equals(b)) {
				return true;
			}
			if (!objectIsInCityList(n.getOtherNode(a), visited)) {
				if (isRouteCompleted(n.getOtherNode(a), b, visited)) {
					return true;
				}
			}

		}
		return false;

	}

	//helper function that sees if a city is in a citylist. this method is used exactly once.
	private Boolean objectIsInCityList(City a, ArrayList<City> list) {
		for (Object m: list) {
			if (a.equals(m)) {
				return true;
			}
		}
		return false;
	}

	//unfinished
	public int getLongestLength() {
		int result = 0;
		for (Road r: roads) {
			for(City n: r.getNodeArray()) {
				if (getLongestLengthCity(n, new ArrayList<City>(), 0) > result) {
//filler filler finish later
				}
			}
		}
		return result;
	}

	//in theory, this works. it might not.
	private int getLongestLengthCity(City a, ArrayList<City> visited, int counter) {
		int longest = 0;
		visited.add(a);
		for (Road n: playerRoadsPerCity(a)) {
			if (!objectIsInCityList(n.getOtherNode(a), visited)) {
				int temp = getLongestLengthCity(n.getOtherNode(a), visited, counter + n.getLength()[0]);
				if (temp > longest) {
					longest = temp;
				}
			}
		}
		return longest;
	}


}
