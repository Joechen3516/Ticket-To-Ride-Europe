
public class Road {
	
	
	private int length;
	private int ferry;
	private TrainColor roadColor;
	private City a;
	private City b;
	private boolean taken = false;
	private PlayerColor owner;
	
	public Road(City a, City b, int length, int ferry, TrainColor color) { //length means total length: ferry + normal cards = total
		this.a = a;
		this.b = b;
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
	
	public City getOtherNode(City n) {
		if (n.compare(a) == 0) {
			return b;
		}
		if (n.compare(b) == 0) {
			return a;
		}
		return null;
	}
	
	public void bulit(PlayerColor c){
		taken = true;
		owner = c;
	}

	@Override
	public String toString() {
		return a.getName() + " to " + b.getName() + " of length " + getLength().toString() + " owned by ";
	}
}
