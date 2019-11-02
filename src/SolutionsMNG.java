import java.util.ArrayList;
import java.util.Random;

// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    private int numOfInd, numOfInputs, indiSize;
    private Problem problem;
    private ArrayList<ArrayList<Double>>  individuals;
    
    // Constructor
    public SolutionsMNG(int numOfInd, Problem problem) {
    	this.numOfInd = numOfInd;
    	this.problem = problem;
    	this.numOfInputs = problem.getPoints().size();
    	this.indiSize = problem.getDegree() + 1;
    	this.individuals = new ArrayList<ArrayList<Double>>();
    	//System.out.println(problem.getDegree());
        this.initialize();
    }


    // Initialize first random solutions
    public void initialize() {
    	ArrayList<Double> currentInd;
        for (int i = 0; i < numOfInd; i++) {
        	currentInd = new ArrayList<Double>();
        	currentInd = generateInd();
        	individuals.add(currentInd);
        }
    }

    // Generate random solution
    public ArrayList<Double> generateInd() {
        ArrayList<Double> currentIndi = new ArrayList<Double>();
        double current;
        //System.out.println(indiSize);
        for (int i=0; i<indiSize;i++) {
        	current = generateRandomD(10.00,-10.00);
        	currentIndi.add(current);
        }
        return currentIndi;
    }

    // To print individuals1
    public void print() {
        for (int i = 0; i < numOfInd; i++) {
        	System.out.println((individuals.get(i)));
        }
    }

    // Evaluate individual fitness
    public double fitnessFunction(ArrayList<Double> indi) {
        double fitness = 0;
        
        return fitness;
    }
    
    // Calculate fitness function for all individuals
    public ArrayList<Double> calcAllFintenss() {
        ArrayList<Double> fitnessValues = new ArrayList<Double>();
        for (int i = 0; i < numOfInd; i++) {
            fitnessValues.add(fitnessFunction(individuals.get(i)));
        }
        return fitnessValues;
    }
    
    // Get best indivivdual between some of them
    public ArrayList<Double> getBestInd(ArrayList<ArrayList<Double>> inds, ArrayList<Double> currentBest) {
		ArrayList<Double> best = currentBest;
		double maxFit = fitnessFunction(currentBest), currentFit;
		for (int i = 0; i < inds.size(); i++) {
			currentFit = fitnessFunction(inds.get(i));
			if( currentFit > maxFit ){
				maxFit = currentFit;
				best = inds.get(i);
			}
        }
		return best;
	}
    
    // To generate random number
    public double generateRandomD(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }
    
    // Get Individuals
    public ArrayList<ArrayList<Double>> getIndividuals(){
    	return individuals;
    }
    
    // Setters and Getters
    public int getNumOfInd() {
		return numOfInd;
	}


	public void setNumOfInd(int numOfInd) {
		this.numOfInd = numOfInd;
	}


	public int getNumOfInputs() {
		return numOfInputs;
	}


	public void setNumOfInputs(int numOfInputs) {
		this.numOfInputs = numOfInputs;
	}
    
}
