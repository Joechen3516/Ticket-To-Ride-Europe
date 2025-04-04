import java.util.*;

public class Player {
    private HashMap<TrainColor, ArrayList<TrainCard>> hand;
    private PlayerColor color;
    private int score = 0;
    private ArrayList<RouteCard> routeCards = new ArrayList<>();
    private ArrayList<RouteCard> completedRoutes = new ArrayList<>();

    public Player(HashMap<TrainColor, ArrayList<TrainCard>> hand, PlayerColor color) {
        this.hand = hand;
        this.color = color;
    }

    // Add new route cards to player's collection
    public void addRouteCard(RouteCard route) {
        routeCards.add(route);
    }

    // Add multiple route cards at once
    public void addRouteCards(Collection<RouteCard> routes) {
        routeCards.addAll(routes);
    }

    // Mark a route as completed (and calculate score)
    public boolean completeRoute(RouteCard route) {
        if (routeCards.contains(route)) {
            routeCards.remove(route);
            completedRoutes.add(route);
            score += route.getPoints();
            return true;
        }
        return false;
    }

    // Get all route cards (both completed and uncompleted)
    public List<RouteCard> getAllRouteCards() {
        List<RouteCard> allRoutes = new ArrayList<>(routeCards);
        allRoutes.addAll(completedRoutes);
        return allRoutes;
    }

    // Get only uncompleted route cards
    public List<RouteCard> getUncompletedRoutes() {
        return new ArrayList<>(routeCards);
    }

    // Get only completed route cards
    public List<RouteCard> getCompletedRoutes() {
        return new ArrayList<>(completedRoutes);
    }

    // Check if player has a specific route
    public boolean hasRoute(RouteCard route) {
        return routeCards.contains(route) || completedRoutes.contains(route);
    }

    // Discard a route card
    public boolean discardRoute(RouteCard route) {
        return routeCards.remove(route);
    }

    // Calculate current score including completed routes
    public int getScore() {
        return score;
    }

    // Get player color
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(color.toString()).append(" Player\n");
        sb.append("Score: ").append(score).append("\n");
        sb.append("Train Cards: ");
        for (TrainColor color : hand.keySet()) {
            sb.append(color.toString()).append(":").append(hand.get(color).size()).append(" ");
        }
        sb.append("\nActive Routes: ");
        for (RouteCard route : routeCards) {
            sb.append(route.getCityA()).append("-").append(route.getCityB()).append(" ");
        }
        sb.append("\nCompleted Routes: ");
        for (RouteCard route : completedRoutes) {
            sb.append(route.getCityA()).append("-").append(route.getCityB()).append(" ");
        }
        return sb.toString();
    }
}