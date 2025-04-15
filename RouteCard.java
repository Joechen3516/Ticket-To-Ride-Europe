import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

public class RouteCard {
	private int points;
	private City a;
	private City b; 
	private boolean longRoute = false;
	private BufferedImage image; 
	
	
	
	public RouteCard(City a, City b, int points, boolean longRoute, BufferedImage image) { 
		this.a = a;
		this.b = b;
		this.points = points;
		this.longRoute = longRoute;
		this.image = image; 
	}
	public RouteCard(City a, City b, int points, BufferedImage image) { 
		this.a = a;
		this.b = b;
		this.points = points;
		this.image = image; 
		
	}
	public boolean isLong() {
		
		return longRoute;
	}
	public int getPoints() {
		return points; 
		
	}
	
	public BufferedImage getImage() {
		return image; 
	}
	
	public String toString() {
		return a.getName() + "<->" + b.getName(); 
	}

	public City[] getCities() {
		return new City[] {a,b};
	}
	

}
