// To save problem
public class Problem {

	// Variables
	private int size;
	private int[] wieghts,benefits;
	
	// Constructor
	public Problem(int [] wieghts, int [] benefits, int s){
		this.setWieghts(wieghts);
		this.setBenefits(benefits);
		this.setSize(s);
	}

	// Setters and Getters
	public int[] getBenefits() {
		return benefits;
	}

	public int[] getWieghts() {
		return wieghts;
	}

	public void setBenefits(int[] benefits) {
		this.benefits = benefits;
	}
	

	public void setWieghts(int[] wieghts) {
		this.wieghts = wieghts;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
