import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

//  Handle files work
public class FilesController {

	private static Scanner scanner;
	private BufferedReader input;
	private Vector<Problem> problems;
	
	public FilesController(String path){
		try {
			scanner = new Scanner(new File(path));
			setInput(new BufferedReader(new FileReader(new File(path))));
			problems = new Vector<Problem>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Get file inputs
	public void readInputs() {
		Problem problem;
		int C = 0, N = 0, S = 0;
		int[] weight = null;
		int[] benefit = null;
		C = scanner.nextInt(); // number of test cases
		for (int i = 0; i < C; i++) {
			N = scanner.nextInt();
			S = scanner.nextInt();
			weight = new int[N];
			benefit = new int[N];
			for (int j = 0; j < N; j++) {
				if (scanner.hasNext()) {
					weight[j] = scanner.nextInt();
					benefit[j] = scanner.nextInt();
				}
			}
			problem = new Problem(weight,benefit,S);
			problems.add(problem);
		}
	}
	
	// Return inputs
	public Vector<Problem> getInputs() {
		return this.problems;
	}

	public BufferedReader getInput() {
		return input;
	}

	public void setInput(BufferedReader input) {
		this.input = input;
	}

}
