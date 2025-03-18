
public class Road {
	
	
	private int length;
	private int ferry;
	private TrainColor roadColor;
	private City destination;
	private boolean taken = false;
	private PlayerColor owner;
	
	public Road(City dest,int length, int ferry, TrainColor color) {
		this.destination = dest;
		this.ferry = ferry;
		this.length = length;
		this.roadColor = color;
	}
	
	
	public int[] getLength() {
		return new int[] {length,ferry};
	}
	
	public TrainColor getColor(){
		return roadColor;
	}
	
	public City getDest() {
		return destination;
	}
	
	public void bulit(PlayerColor c){
		taken = true;
		owner = c;
	}
	
}
