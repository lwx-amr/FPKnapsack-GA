import java.util.ArrayList;
import java.util.Random;
// Perform mutation
public class Mutation {
	
	// Variables
	private ArrayList<ArrayList<Double>> individuals;
	private int numOfGenerations;
	// Constructor 
	public Mutation(ArrayList<ArrayList<Double>> individuals, int numOfGenerations){
		this.individuals = individuals;
		this.numOfGenerations = numOfGenerations;
	}
	  
    // Return inputs after mutation process
    public ArrayList<ArrayList<Double>> getInputs() {
    	return individuals;
    }
    
    //Mutate One individual
    public ArrayList<Double> nonUniFormMutation(ArrayList<Double> chromosome, double generationNum) {
        ArrayList<Double> mutatedChromosome = new ArrayList<>();
        for (int i = 0; i < chromosome.size(); i++) {
            Random rd = new Random(); // creating Random object
            double ri1 = rd.nextDouble(); // displaying a random double value between 0.0 & 1.0
            double gene = chromosome.get(i);
            double delta = clucDelta(0.05, 0.07, gene, ri1);
            double mutatedGene=0;
            if (ri1 <= 0.5) {
                 mutatedGene = gene - mutationValue(generationNum, delta);
            }else{
                 mutatedGene = gene + mutationValue(generationNum, delta);
            }
            mutatedChromosome.add(mutatedGene);
        }
        return mutatedChromosome;
    }

    // Calculation of delta
    public double clucDelta(double lB, double uB, double gene, double ri1) {
        double delta = 0;
        if (ri1 <= 0.5) {
            delta = uB - gene;
        } else {
            delta = gene - lB;
        }
        return delta;
    }

    // Calculation new mutation value
    public double mutationValue(double generationNum, double delta) {
        double resOfMut = 0;
        Random rd = new Random(); // creating Random object
        double r = rd.nextDouble();
        double b = getRandomIntegerBetweenRange(1, 5);
        resOfMut = delta * r * (Math.pow(1 - (generationNum / numOfGenerations), b));
        return resOfMut;
    }
    
    public double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
    
    // Do Mutation for all offsprings
    public ArrayList<ArrayList<Double>> performMutation(int generationNum) {
    	ArrayList<ArrayList<Double>> mutatedIndi = new ArrayList<ArrayList<Double>>();
    	for (int i = 0; i < individuals.size(); i++) {
    		mutatedIndi.add(nonUniFormMutation(individuals.get(i), generationNum));
    	}
    	return mutatedIndi;
    }
}