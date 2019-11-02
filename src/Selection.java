import java.util.ArrayList;
import java.util.Random;

// To handle selection process
public class Selection {

    // Variables
    private int numOfSelection;
    private ArrayList<ArrayList<Double>> individuals;

    // Constructor
    public Selection(ArrayList<ArrayList<Double>> individuals , int numOfSelection) {
        this.numOfSelection = numOfSelection; // We will change this value later
        this.individuals = individuals;
    }

    // Selection Process
    public ArrayList<ArrayList<Double>> doSelection(ArrayList<Double> fintessValues) {
        double totalFitness = 0;
        ArrayList<ArrayList<Double>> choosenelements = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < fintessValues.size(); i++) {
            totalFitness += fintessValues.get(i);
        }
        Random rg = new Random();
        for (int i = 0 ; i < numOfSelection; i++) {
        	int partialsum=0, random, index = 0, lastAddedIndex = 0;
        	random = rg.nextInt((int) Math.floor(totalFitness - 1));
			while(partialsum < random) {
				partialsum+= fintessValues.get(index);
				lastAddedIndex = index;
                index++;
			}
			System.out.println(lastAddedIndex);
			choosenelements.add(individuals.get(lastAddedIndex));
        }
        return choosenelements;
    }
}
