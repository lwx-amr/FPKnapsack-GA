import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
	
	
	// Write output in file
	public void writeOutput(ArrayList<Double> bestInd, int j, double fitValue){
	    try {
	    	BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt" ,true));
			bw.write("Case: " + (j+1));
			bw.newLine();
			for(int i = 0; i < bestInd.size(); i++ ){
				bw.write(bestInd.get(i).toString() + "   ");
	        }
			bw.write(", Error: " + fitValue);
			bw.newLine();
			bw.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
}
