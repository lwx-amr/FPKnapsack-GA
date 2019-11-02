import java.util.ArrayList;
import java.util.Random;

// Perform crossover
public class Crossover {

	// Variables
	private double pc;
	private int firstPointer, numOfInd;
	private ArrayList<ArrayList<Double>> individuals, offSprings;
		
    // Take individuals
    public Crossover(ArrayList<ArrayList<Double>> individuals) {
    	this.pc = 0.7;
    	this.individuals = individuals;
    	this.numOfInd = individuals.size();
    	this.offSprings = individuals;
    }

    // Perform single point crossover process
    public ArrayList<ArrayList<Double>> performCrossover() {
    	Random rg = new Random();
    	double firstPointerD = generateRandomD((double)individuals.get(0).size()-1, 0.00);
    	firstPointer = (int) Math.ceil(firstPointerD);
    	
    	//System.out.println("firstPointer: " + firstPointer);
    	ArrayList<Double> offSpring1 = new ArrayList<Double>();
    	ArrayList<Double> offSpring2 = new ArrayList<Double>();
    	
    	int e1, e2;

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
    	for(int i = 0; i < numOfInd ; i+=2) {
   			Random rand = new Random();
   			e1 = rand.nextInt((individuals.get(0).size() - 1) ) + 0;
    		e2 = rand.nextInt((individuals.get(0).size() - 1) ) + 0;
    		
    		// Check crossover probability
    		if(generateRandomD(1,0) > pc) {
    			offSprings.add(e1, individuals.get(e1));
        		offSprings.add(e2, individuals.get(e2));
        		//System.out.println("No");
        		continue;
    		}
    		e1 = rand.nextInt((numOfInd - 1) ) + 0;
    		e2 = rand.nextInt((numOfInd - 1) ) + 0;
    		
    		//System.out.println("E1: " + e1 + "  E2: " + e2);
    		//System.out.println(individuals.get(e1).subList(0,firstPointer));
			offSpring1.addAll(individuals.get(e1).subList(0,firstPointer));
			offSpring1.addAll(individuals.get(e2).subList(firstPointer,individuals.get(e2).size()));
		
			offSpring2.addAll(individuals.get(e2).subList(0,firstPointer));
			offSpring2.addAll(individuals.get(e1).subList(firstPointer,individuals.get(e1).size()));
    	
			offSprings.add(e1,offSpring1);
    		offSprings.add(e2,offSpring2);
    	}
    	return offSprings;
    }

    // return Inputs
    public void print() {
    	for (int i = 0; i < numOfInd; i++) {
        	System.out.println(individuals.get(i).toString());
        }
    }
    
    // To generate random number
    public double generateRandomD(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }

   /* public static void main (String args[]){
    	ArrayList<String> array1 = new ArrayList<String>();
    	ArrayList<String> array2 = new ArrayList<String>();
    	array1.add("A"); 
    	array1.add("B"); 
    	array1.add("C"); 
    	array1.add("D"); 
    	array1.add("E"); 
    	array2.addAll(array1.subList(0, 3));
    	array2.addAll(array1.subList(2, 4));
    	System.out.println(array2);
    */
    
}
