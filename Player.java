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
	




}