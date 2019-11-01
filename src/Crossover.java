import java.util.Random;

// Perform crossover
public class Crossover {

	// Variables
	private double pc;
	private int firstPointer, numOfInd;
	private String[] individuals, offSprings;
	private SolutionsMNG sMNG;
		
    // Take individuals
    public Crossover(String[] individuals, SolutionsMNG sMNG) {
    	this.pc = 0.7;
    	this.individuals = individuals;
    	this.numOfInd = individuals.length;
    	this.offSprings = individuals;
    	this.sMNG = sMNG;
    }

    // Perform single point crossover process
    public String [] performCrossover() {
    	Random rg = new Random();
    	double firstPointerD = generateRandomD((double)individuals[0].length()-1, 0.00);
    	firstPointer = (int) Math.ceil(firstPointerD);
    	
    	//System.out.println("firstPointer: " + firstPointer);
    	String offSpring1,offSpring2;
    	int e1, e2;

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
    	for(int i = 0; i < numOfInd ; i+=2) {
   			Random rand = new Random();
   			e1 = rand.nextInt((numOfInd - 1) ) + 0;
    		e2 = rand.nextInt((numOfInd - 1) ) + 0;
    		
    		// Check crossover probability
    		if(generateRandomD(1,0) > pc) {
    			offSprings[e1] = individuals[e1];
        		offSprings[e2] = individuals[e2];
        		//System.out.println("No");
        		continue;
    		}
    		while(true) {
        		e1 = rand.nextInt((numOfInd - 1) ) + 0;
        		e2 = rand.nextInt((numOfInd - 1) ) + 0;
    			offSpring1 = individuals[e1].substring(0,firstPointer) + individuals[e2].substring(firstPointer,individuals[e2].length());
        		offSpring2 = individuals[e2].substring(0,firstPointer) + individuals[e1].substring(firstPointer,individuals[e1].length());
        		if(sMNG.isValid(offSpring1) && sMNG.isValid(offSpring2))
        			break;
    		}
			offSprings[e1] = offSpring1;
    		offSprings[e2] = offSpring2;
    	}
    	return offSprings;
    }

    // return Inputs
    public void print() {
    	for(int i = 0; i < numOfInd ; i++) {
    		System.out.println(offSprings[i]);
    	}
    }
    
    // To generate random number
    public double generateRandomD(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }

}
