
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class GameController {



	private int turn = -4;
	private Stack<RouteCard> routes = new Stack<>();
	private Stack<RouteCard> lRoutes = new Stack<>();
	private Stack<TrainCard> deck = new Stack<>();
	private Stack<TrainCard> discardDeck = new Stack<>();
	private ArrayList<TrainCard> show5 = new ArrayList<>();
	private ArrayList<Player> players = new ArrayList<>();
	private List<GameListener> listeners = new ArrayList<>();
	private String currentScreen = "dest";
	private Europe europe = new Europe();
	private Map<String,SwitchablePanel> panels = new HashMap<>();
	private ArrayList<TrainCard> selectedTrainCards = new ArrayList<TrainCard>();
	private boolean wait;
	private TrainCard j;



	//FLAGS
	//DONT RESET THESE
	private boolean initalChooseFlag = true;


	//RESET THESE
	private GuiState guiState = GuiState.nothing;
	private ArrayList<String> currentCities = new ArrayList<>();
	private int currentDrawnTrain = 0;
	private int cardTurn = 0;


	// Inital Setup
	public GameController() {
		makeDecks();
		createPlayers();
	}

	public void addPanelSwitch(String name,SwitchablePanel p) {
		panels.put(name,p);
	}

	public void notifyPanel() {
		panels.get(currentScreen).OnSwitchedTo();
	}

	public void addListener(GameListener l) {
		listeners.add(l);
	}

	private void notifyScreenChange() {
		for(GameListener l : listeners) {
			l.onScreenChange(currentScreen);
		}
		notifyPanel();
	}

	public void switchScreen(String newScreen) {
		this.currentScreen = newScreen;
		notifyScreenChange();
	}

	public Player getCurrentPlayer() {
		if(turn<0) {
			return players.get(turn+4);
		}

		return players.get(turn-1);
	}

	public ArrayList<Player> getPlayers(){
		return players;
	}

	public int getCurrentPlayerNumber() {
		if(turn<0) {
			return turn+4;
		}
		return turn;
	}

	public void nextTurn() {
		if(turn < 4) {
			turn++;
		}else {
			turn = 1;
		}

		currentCities.clear();
		guiState = GuiState.nothing;
		cardTurn = 0;
		currentDrawnTrain = 0;
	}

	public ArrayList<String> getCurrentCities(){
		return currentCities;
	}

	public int getCurrentCitiesSize() {
		return currentCities.size();
	}

	public void chooseDestinations() {
		if(turn < 0) {




		}else if(turn >= 0) {



		}



	}
	
	public void HandleAction(ActionEvents x) {
		if(x.equals(ActionEvents.Start)) {
			switchScreen("Destination");
		}

		if(x.equals(ActionEvents.CardScreenConfirm)) {

			if(initalChooseFlag) {
				if(turn < 0) {	
					nextTurn();
					notifyPanel();
				}
				if(turn == 0) {
					switchScreen("Game");
					initalChooseFlag = false;
					nextTurn();
				}
			}
			if(!initalChooseFlag) {
				switchScreen("Game");
				System.out.println(initalChooseFlag);
				//turn logic being done in cardscreen
			}


		}

		if(x.equals(ActionEvents.RouteButton)) {
			switchScreen("Destination");
		}

		if(x.equals(ActionEvents.TrainCard)) {
			if(currentCities.size() < 2) {
				if(currentDrawnTrain != -1) {
					if(show5.get(currentDrawnTrain).getColor() == TrainColor.Wild && cardTurn == 0) {
						getCurrentPlayer().addTrainCard(show5.get(currentDrawnTrain));
						deleteOne(currentDrawnTrain);
						currentDrawnTrain = -1;
						cardTurn += 2;
					}else if(show5.get(currentDrawnTrain).getColor() != TrainColor.Wild){
						getCurrentPlayer().addTrainCard(show5.get(currentDrawnTrain));
						deleteOne(currentDrawnTrain);
						currentDrawnTrain = -1;
						cardTurn++;
					}

				}	
				if(cardTurn == 2) {
					cardTurn = 0;
					currentDrawnTrain = -1;
					nextTurn();
				}

			}
		}




		if(x.equals(ActionEvents.placeStation)) {
			this.guiState = GuiState.stationPurchasePanel;
		}

		if(x.equals(ActionEvents.purchaseRoad)) {
			if(cardTurn == 0) {
				ArrayList<City> adj = europe.getAvailableAdjacentCities(europe.citySearch(currentCities.get(0)));


				if(currentCities.size() == 2 && adj.contains(europe.citySearch(currentCities.get(1)))) {
					this.guiState = GuiState.roadPurchasePanel;
					for(Road r : getCurrentPlayer().getRoads()) {
						System.out.print(r);
					}
				}else if(currentCities.size() == 2) {
					currentCities.clear();
				}
			}
		}
		if(x.equals(ActionEvents.TrainDeck)) {
			j = deckDraw();
			
			wait = true; 
			
			

		}
		if(x.equals(ActionEvents.LimboCard)) {
			if(!wait) {
				getCurrentPlayer().addTrainCard(j);
				cardTurn += 1;
				if(cardTurn == 2) {
					cardTurn = 0;
					
					nextTurn();
				}
			}
		}
	}
	
	public void HandleAction(ActionEvents x, TrainColor trainColor) {
		Road road = europe.roadSearch(europe.citySearch(currentCities.get(0)), europe.citySearch(currentCities.get(1))).get(0);
		if(road.hasMountains()) {
			
		}
		else if(road.getLength()[1] > 0) {
			
		}
		else {
			if(x.equals(ActionEvents.addedTrainCard)) {
				if(road.getColor() == trainColor) {
					selectedTrainCards.add(getCurrentPlayer().getHand().get(trainColor).removeLast());
				}
				else if(trainColor == TrainColor.Wild) {
					selectedTrainCards.add(getCurrentPlayer().getHand().get(TrainColor.Wild).removeLast());
				}
			}
		}
	}
	
	public ArrayList<TrainCard> getSelectedTrainCards(){
		return selectedTrainCards;
	}
	public boolean getWait() {
		return wait; 
	}
	public void waitToFalse() {
		wait = false; 
	}
	public void waitToTrue() {
		wait = true; 
	}
	
	public int getCardTurn() {
		return cardTurn; 
	}
	public TrainCard getj() {
		return j;
	}
	public boolean checkThree() {
		int x = 0; 
		for(int i = 0; i < show5.size(); i++) {
			if (show5.get(i).getColor() == TrainColor.Wild) {
				x++;
			}
		}
		if (x>2) {
			discardDeck.addAll(show5);
			return true;
		}
		return false; 
	}
	public void replaceFive() {
		for(int i = 0; i < show5.size(); i++) {
			show5.set(i, deck.pop());
		}
	}
	
	public void giveCity(String c) {
		if(!currentCities.isEmpty()){
			if(!c.equals(currentCities.get(0))) {
				currentCities.add(c);
			}
		}else {
			currentCities.add(c);
		}
	}

	public GuiState getGuiState() {
		return guiState;
	}

	public void which5 (int tc) {
		currentDrawnTrain = tc; 
	}


	public TrainCard deckDraw() {
		return deck.pop();
	}

	public RouteCard routeDraw() {
		return routes.pop();	
	}

	public void createPlayers() {
		for(PlayerColor x : PlayerColor.values()) {
			players.add(new Player(makeHand(),x));
		}
	}

	private HashMap<TrainColor,ArrayList<TrainCard>> makeHand(){
		HashMap<TrainColor,ArrayList<TrainCard>> hand = new HashMap<>();

		for(TrainColor x : TrainColor.values()) {
			hand.put(x, new ArrayList<TrainCard>());
		}

		for(int j = 0; j < 5;j++) {
			TrainCard z = deckDraw();
			hand.compute(z.getColor(), (key, oldValue) -> {
				oldValue.add(z);
				return oldValue;
			});
		}
		return hand;
	}


	public HashMap addToHand() {
		return null;

	}

	public void makeFive() {
		for(int i =0; i<5;i++) {
			show5.add(deckDraw());
		}
	}
	public void deleteOne(int x) {
		show5.set(x, deck.pop());


	}

	public ArrayList<TrainCard> getShow5(){
		return show5;
	}

	public ArrayList<RouteCard> getDrawnRoutes(){
		ArrayList<RouteCard> r = new ArrayList<>();
		if(turn < 0) {
			for(int i = 0; i < 4;i++) {
				r.add(routes.pop());
			}
			r.add(lRoutes.pop());
		}else {
			for(int i=0;i<3;i++) {
				r.add(routes.pop());
			}
		}
		System.out.print(r.size()+"::");
		System.out.print(routes.size()+"::");
		System.out.print(lRoutes.size()+"::");
		return r;
	}


	public void addPlayerRoutes(ArrayList<RouteCard> r) {
		Player current = getCurrentPlayer();
		for(RouteCard rc:r) {
			current.giveRoute(rc);
			System.out.print(rc + "::::");
		}
	}


	public int getMinSelection() {
		if(turn < 0) {
			return 2;
		}else {
			return 1;
		}
	}
	public int getTurn() {
		return turn; 
	}







	// INTIAL DECK CREATION
	public void makeDecks() {
		for(TrainColor color : TrainColor.values()) {
			if(color != TrainColor.Wild) {
				for(int i = 0; i <12;i++) {
					deck.add(new TrainCard(color));
				}
			}else {
				for(int z = 0; z< 14;z++) {
					deck.add(new TrainCard(color));
				}
			}
		}
		shuffledeck(deck);

		try {
			createDefaultRoutes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		shuffledeck(routes);
		shuffledeck(lRoutes);

		makeFive();

	}
	public void createDefaultRoutes() throws IOException {

		addRoute(new RouteCard(europe.citySearch("Amsterdam"), europe.citySearch("Pamplona"), 7, false, ImageIO.read(getClass().getResource("/routes/Amsterdam-Pamplona7.png"))));
		addRoute(new RouteCard(europe.citySearch("Amsterdam"), europe.citySearch("Wilno"), 12, false, ImageIO.read(getClass().getResource("/routes/Amsterdam-Wilno12.png"))));
		addRoute(new RouteCard(europe.citySearch("Ancora"), europe.citySearch("Kharkov"), 10, false, ImageIO.read(getClass().getResource("/routes/Ancora-Kharkov10.png"))));
		addRoute(new RouteCard(europe.citySearch("Athina"), europe.citySearch("Ancora"), 5, false, ImageIO.read(getClass().getResource("/routes/Athina-Ancora5.png"))));
		addRoute(new RouteCard(europe.citySearch("Athina"), europe.citySearch("Wilno"), 11, false, ImageIO.read(getClass().getResource("/routes/Athina-Wilno11.png"))));
		addRoute(new RouteCard(europe.citySearch("Barcelona"), europe.citySearch("Bruxelles"), 8, false, ImageIO.read(getClass().getResource("/routes/Barcelona-Bruxelles8.png"))));
		addRoute(new RouteCard(europe.citySearch("Barcelona"), europe.citySearch("Monchen"), 8, false, ImageIO.read(getClass().getResource("/routes/Barcelona-Munchen8.png"))));
		addRoute(new RouteCard(europe.citySearch("Berlin"), europe.citySearch("Bucuresti"), 8, false, ImageIO.read(getClass().getResource("/routes/Berlin-Bucuresti8.png"))));
		addRoute(new RouteCard(europe.citySearch("Berlin"), europe.citySearch("Moskova"), 12, false, ImageIO.read(getClass().getResource("/routes/Berlin-Moskva12.png"))));
		addRoute(new RouteCard(europe.citySearch("Berlin"), europe.citySearch("Roma"), 9, false, ImageIO.read(getClass().getResource("/routes/Berlin-Roma9.png"))));
		addRoute(new RouteCard(europe.citySearch("Brest"), europe.citySearch("Marseille"), 7, false, ImageIO.read(getClass().getResource("/routes/Brest-Marseille7.png"))));
		addRoute(new RouteCard(europe.citySearch("Brest"), europe.citySearch("Petrograd"), 20, true, ImageIO.read(getClass().getResource("/routes/Brest-Petrograd20.png"))));
		addRoute(new RouteCard(europe.citySearch("Brest"), europe.citySearch("Venezia"), 8, false, ImageIO.read(getClass().getResource("/routes/Brest-Venezia8.png"))));
		addRoute(new RouteCard(europe.citySearch("Bruxelles"), europe.citySearch("Danzic"), 9, false, ImageIO.read(getClass().getResource("/routes/Bruxelles-Danzic9.png"))));
		addRoute(new RouteCard(europe.citySearch("Budapest"), europe.citySearch("Sofia"), 5, false, ImageIO.read(getClass().getResource("/routes/Budapest-Sofia5.png"))));
		addRoute(new RouteCard(europe.citySearch("Cadiz"), europe.citySearch("Stockholm"), 21, true, ImageIO.read(getClass().getResource("/routes/Cadiz-Stockholm21.png"))));
		addRoute(new RouteCard(europe.citySearch("Edinburgh"), europe.citySearch("Athina"), 21, true, ImageIO.read(getClass().getResource("/routes/Edinburgh-Athina21.png"))));
		addRoute(new RouteCard(europe.citySearch("Edinburgh"), europe.citySearch("Paris"), 7, false, ImageIO.read(getClass().getResource("/routes/Edinburch-Paris7.png"))));
		addRoute(new RouteCard(europe.citySearch("Erzurum"), europe.citySearch("Rostov"), 5, false, ImageIO.read(getClass().getResource("/routes/Erzurm-Rostov5.png"))));
		addRoute(new RouteCard(europe.citySearch("Essen"), europe.citySearch("Kyiv"), 10, false, ImageIO.read(getClass().getResource("/routes/Essen-Kyiv10.png"))));
		addRoute(new RouteCard(europe.citySearch("Frankfurt"), europe.citySearch("Kobenhavn"), 5, false, ImageIO.read(getClass().getResource("/routes/Frankfurt-Kobenhavn5.png"))));
		addRoute(new RouteCard(europe.citySearch("Frankfurt"), europe.citySearch("Smolensk"), 13, false, ImageIO.read(getClass().getResource("/routes/Frankkfurt-Smolense13.png"))));
		addRoute(new RouteCard(europe.citySearch("Kobenhavn"), europe.citySearch("Erzurum"), 21, true, ImageIO.read(getClass().getResource("/routes/Kobenhavn-Erzurum21.png"))));
		addRoute(new RouteCard(europe.citySearch("Kyiv"), europe.citySearch("Petrograd"), 6, false, ImageIO.read(getClass().getResource("/routes/Kyiv-Petrocrad6.png"))));
		addRoute(new RouteCard(europe.citySearch("Kyiv"), europe.citySearch("Sochi"), 8, false, ImageIO.read(getClass().getResource("/routes/Kyiv-Sochi8.png"))));
		addRoute(new RouteCard(europe.citySearch("Lisboa"), europe.citySearch("Danzic"), 20, true, ImageIO.read(getClass().getResource("/routes/Lisboa-Danzic20.png"))));
		addRoute(new RouteCard(europe.citySearch("London"), europe.citySearch("Berlin"), 7, false, ImageIO.read(getClass().getResource("/routes/London-Berlin7.png"))));
		addRoute(new RouteCard(europe.citySearch("London"), europe.citySearch("Wien"), 10, false, ImageIO.read(getClass().getResource("/routes/London-Wien10.png"))));
		addRoute(new RouteCard(europe.citySearch("Madrid"), europe.citySearch("Dieppe"), 8, false, ImageIO.read(getClass().getResource("/routes/Madrid-Dieppe8.png"))));
		addRoute(new RouteCard(europe.citySearch("Madrid"), europe.citySearch("Zurich"), 8, false, ImageIO.read(getClass().getResource("/routes/Madrid-Zurich8.png"))));
		addRoute(new RouteCard(europe.citySearch("Marseille"), europe.citySearch("Essen"), 8, false, ImageIO.read(getClass().getResource("/routes/Marseille-Essen8.png"))));
		addRoute(new RouteCard(europe.citySearch("Palermo"), europe.citySearch("Constantinople"), 8, false, ImageIO.read(getClass().getResource("/routes/Palermo-Constantinople8.png"))));
		addRoute(new RouteCard(europe.citySearch("Palermo"), europe.citySearch("Moskova"), 20, true, ImageIO.read(getClass().getResource("/routes/Palermo-Moskva20.png"))));
		addRoute(new RouteCard(europe.citySearch("Paris"), europe.citySearch("Wien"), 8, false, ImageIO.read(getClass().getResource("/routes/Paris-Wien8.png"))));
		addRoute(new RouteCard(europe.citySearch("Paris"), europe.citySearch("Zacrad"), 7, false, ImageIO.read(getClass().getResource("/routes/Paris-Zacrad7.png"))));
		addRoute(new RouteCard(europe.citySearch("Rica"), europe.citySearch("Bucuresti"), 10, false, ImageIO.read(getClass().getResource("/routes/Rica-Bucuresti10.png"))));
		addRoute(new RouteCard(europe.citySearch("Roma"), europe.citySearch("Smyrna"), 8, false, ImageIO.read(getClass().getResource("/routes/Roma-Smyrna8.png"))));
		addRoute(new RouteCard(europe.citySearch("Sarajevo"), europe.citySearch("Sevastopol"), 8, false, ImageIO.read(getClass().getResource("/routes/Sarajevo-Sevastopol8.png"))));
		addRoute(new RouteCard(europe.citySearch("Smolensk"), europe.citySearch("Rostov"), 8, false, ImageIO.read(getClass().getResource("/routes/Smolensk-Rostov8.png"))));
		addRoute(new RouteCard(europe.citySearch("Sofia"), europe.citySearch("Smyrna"), 5, false, ImageIO.read(getClass().getResource("/routes/Sofia-Smyrna5.png"))));
		addRoute(new RouteCard(europe.citySearch("Stockholm"), europe.citySearch("Wien"), 11, false, ImageIO.read(getClass().getResource("/routes/Stockholm-Wien11.png"))));
		addRoute(new RouteCard(europe.citySearch("Venezia"), europe.citySearch("Constantinople"), 10, false, ImageIO.read(getClass().getResource("/routes/Venezia-Constantinople10.png"))));
		addRoute(new RouteCard(europe.citySearch("Warszawa"), europe.citySearch("Smolensk"), 6, false, ImageIO.read(getClass().getResource("/routes/Warszawa-Smolensk6.png"))));
		addRoute(new RouteCard(europe.citySearch("Zacrad"), europe.citySearch("Brindisi"), 6, false, ImageIO.read(getClass().getResource("/routes/Zacrab-Brindisi6.png"))));
		addRoute(new RouteCard(europe.citySearch("Zurich"), europe.citySearch("Brindisi"), 6, false, ImageIO.read(getClass().getResource("/routes/Zurich-Brindisi6.png"))));
		addRoute(new RouteCard(europe.citySearch("Zurich"), europe.citySearch("Budapest"), 6, false, ImageIO.read(getClass().getResource("/routes/Zurich-Budapest6.png"))));
	}	

	public boolean addRoute(RouteCard r) {
		if (r == null) {
			throw new IllegalArgumentException("RouteCard cannot be null");
		} else if (r.isLong()) {
			return lRoutes.add(r);
		} else {
			return routes.add(r);
		}

	}

	public <E> void  shuffledeck(List<?> deck) {
		Collections.shuffle(deck);
	}

	public Europe getEurope() {
		return europe;
	}

}
