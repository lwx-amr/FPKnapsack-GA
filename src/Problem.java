import java.util.ArrayList;

// To save problem
public class Problem {

	// Variables
	private int size, degree;
	private ArrayList<Point> points;
	
	// Constructor
	public Problem(int d, ArrayList<Point> points){
		this.setDegree(d);
		this.points = points;
		this.size = points.size();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
}
