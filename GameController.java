import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameController {



    private int turn = 0;
    private Stack<RouteCard> routes = new Stack<>();
    private Stack<TrainCard> deck = new Stack<>();
    private ArrayList<TrainCard> show5 = new ArrayList<>();
    private PlayerState state = PlayerState.DestinationChoosing;
    private ArrayList<Player> players = new ArrayList<>();


    public Player getCurrentPlayer() {
        return players.get(turn);
    }

    public void nextTurn() {
        if(turn < 3) {
            turn++;
        }else {
            turn = 0;
        }
    }


    public void HandleAction() {





    }



    public TrainCard deckDraw() {
        return deck.pop();
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

    public void printPlayers() {
        for(Player p : players) {
            System.out.println(p);
        }
    }



    public <E> void  shuffledeck(List<?> deck) {
        Collections.shuffle(deck);
    }


    public void makeFive() {
        for(int i =0; i<5;i++) {
            show5.add(deckDraw());
        }
    }


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
        System.out.print(deck.size());


    }

}