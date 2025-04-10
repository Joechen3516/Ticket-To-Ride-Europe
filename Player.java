import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private HashMap<TrainColor,ArrayList<TrainCard>> hand;
	private PlayerColor color;
	private int score = 0;





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
		// TODO Auto-generated method stub
		
	}

}