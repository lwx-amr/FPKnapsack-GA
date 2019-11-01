import java.util.Random;

// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    private int numOfInd, numOfInputs, S;
    private String[] individuals;
    private int[] benefits, weights;
    
    // Constructor
    public SolutionsMNG(int numOfIndividuals, int numOfInputs, int[] benefits, int[] weights, int S) {
        this.numOfInd = numOfIndividuals;
        this.numOfInputs = numOfInputs;
        this.individuals = new String[numOfInd];
        this.benefits = benefits;
        this.weights = weights;
        this.S = S;
        this.initialize();
    }


    // Initialize first random solutions
    public void initialize() {
    	String currentInd;
        for (int i = 0; i < numOfInd; i++) {
        	currentInd = generateInd();
        	while(!isValid(currentInd)) {
        		currentInd = generateInd();
        	}
        	individuals[i] = currentInd;
        }
    }

    // Generate random solution
    public String generateInd() {
        String binary = "";
        int range = (int) Math.pow(2, numOfInputs) - 1;
        Random rg = new Random();
        int n = rg.nextInt(range);
        String binaryrep = toBinary(n);
        if (binaryrep.length() <= numOfInputs) {
            for (int i = 0; i < numOfInputs - binaryrep.length(); i++) {
                binary += "0";
            }
            binary += binaryrep;
        }
        return binary;
    }

    // Encode generated solutions
    public static String toBinary(int rand) {
        String binary = "";
        while (rand > 0) {
            binary = ((rand % 2) == 0 ? "0" : "1") + binary;
            rand = rand / 2;
        }
        return binary;
    }

    // To print individuals
    public void print() {
        for (int i = 0; i < numOfInd; i++) {
            System.out.println(individuals[i]);
        }
    }

    // Evaluate individual fitness
    public int fitnessfunction(String binary) {
        int b = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                b += benefits[i];
            }
        }
        return b;
    }

    // Calculate fitness function for all individuals
    public int[] calcAllFintenss() {
        int[] fitnessValues = new int[numOfInd];
        for (int i = 0; i < numOfInd; i++) {
            fitnessValues[i] = fitnessfunction(individuals[i]);
        }
        return fitnessValues;
    }
    
    // Get best indivivdual between some of them
    public String getBestInd(String [] inds, String currentBest) {
		String best = currentBest;
		int maxBenefit = fitnessfunction(currentBest), currentBenefit;
		for (int i = 0; i < inds.length; i++) {
			if(isValid(inds[i])){
				currentBenefit = fitnessfunction(inds[i]);
				if( currentBenefit > maxBenefit ){
					maxBenefit = currentBenefit;
					best = inds[i];
				}
			}
        }
		return best;
	}
    
    // Check if solution valid 
    public boolean isValid(String binary){
    	int b = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                b += weights[i];
            }
        }
    	return (b<=S);
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


	public void setIndividuals(String[] individuals) {
		this.individuals = individuals;
	}

    public String[] getIndividuals() {
    	return this.individuals;
    }
    
}
