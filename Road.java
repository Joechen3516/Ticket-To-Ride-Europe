
public class Road {
	
	
	private int length;
	private int ferry;
	private TrainColor roadColor;
	private City a;
	private City b;
	private boolean taken = false;
	private PlayerColor owner;
	private boolean mountainous;
	private double[] xs;
	private double[] ys;
	private double[] as;
	public Road(City a, City b, int length, int ferry, TrainColor color, boolean hasMountains, double[] xs,double[] ys,double[] as) { //length means total length: ferry + normal cards = total
		this.a = a;
		this.b = b;
		this.ferry = ferry;
		this.length = length;
		this.roadColor = color;
		this.mountainous = hasMountains;
		this.xs = xs;
		this.ys = ys;
		this.as = as;
	}
	public Road(City a, City b, int length, int ferry, TrainColor color,double[] xs,double[] ys,double[] as) { //length means total length: ferry + normal cards = total
		this.a = a;
		this.b = b;
		this.ferry = ferry;
		this.length = length;
		this.roadColor = color;
		this.mountainous = false;
		this.xs = xs;
		this.ys = ys;
		this.as = as;
	}
	


	public boolean hasMountains() {return mountainous;}
	
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
	
	public City[] getNodeArray() {
		return new City[] {a, b};
	}

	@Override
	public String toString() {
		String ownersubstitute = "nobody";
		if (owner != null) {
			ownersubstitute = owner.name();
		}
		return a.getName() + " to " + b.getName() + " of color " + roadColor.name() + " of length " + getLength()[0] + " including " + getLength()[1] + " ferries and owned by " + ownersubstitute;
	}
	
	public double[] getxs() {
		return xs;
	}
	
	public double[] getys() {
		return ys;
	}
	public double[] getas() {
		return as;
	}
}
