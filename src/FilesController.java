import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

//  Handle files work
public class FilesController {

	private static Scanner scanner;
	private BufferedReader input;
	public ArrayList<Problem> problems;
	
	public FilesController(String path){
		try {
			scanner = new Scanner(new File(path));
			setInput(new BufferedReader(new FileReader(new File(path))));
			problems = new ArrayList<Problem>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Get file inputs
	public ArrayList<Problem> readInputs() {
		int C = 0, N = 0, D=0;
		float x = 0, y = 0;
		Problem problem;
		Point point;
		ArrayList<Point> points;
		C = scanner.nextInt(); // number of test cases
		for (int i = 0; i < C; i++) {
			N = scanner.nextInt(); // Number of elements
			D = scanner.nextInt(); // Degree of polynomial
			points = new ArrayList<Point>();
			for (int j = 0; j < N; j++) {
				if (scanner.hasNext()) {
					x = scanner.nextFloat();
					y = scanner.nextFloat();
				}
				point = new Point(x,y);
				points.add(point);
			}
			problem = new Problem(D, points);
			problems.add(problem);
		}
		return problems;
	}
	
	// Return inputs
	public ArrayList<Problem> getInputs() {
		return this.problems;
	}

	public BufferedReader getInput() {
		return input;
	}

	public void setInput(BufferedReader input) {
		this.input = input;
	}

	public static void main (String args[]) {
		FilesController obj = new FilesController("input-2.txt");
		obj.readInputs();
		for (int i=0; i < obj.problems.size(); i++) {
			System.out.println("Size: " + obj.problems.get(i).getSize() + "  Degree: " + obj.problems.get(i).getDegree() + "  Elements: " + obj.problems.get(i).getPoints().size());
		}
		/*for (int i=0; i < obj.problems.elementAt(0).getPoints().size(); i++) {
			System.out.println("X: " + obj.problems.elementAt(0).getPoints().elementAt(i).getX() + "  Y: " + obj.problems.elementAt(0).getPoints().elementAt(i).getY());
		}*/
	}
	
}
