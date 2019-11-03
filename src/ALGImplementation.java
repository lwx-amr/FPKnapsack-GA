import java.util.ArrayList;

// Implementation of algorithm
public class ALGImplementation {

	// Objects
	private FilesController fileController;
	private SolutionsMNG solver;
	private Mutation mutation;
	private Replacement replacer;
	
	
	// Variables 
	private ArrayList<ArrayList<Double>> individuals; 
	private ArrayList<Problem> problems;
	private int numOfSelection, numOfGenerations;
	private ArrayList<Double> bestInd;
	
	// Constructor
	public ALGImplementation() {
		this.fileController = new FilesController("input-2.txt");
		this.numOfGenerations = 10;
		this.numOfSelection = 20;
	}
	
    // Execute algorithm repetitive steps
    public void executeProcess(int i) {

        // Call SolutionMNG to evaluate solutions
    	ArrayList<Double> fintessValues = solver.calcAllFintenss();
    	
        // Perform Selection
        Selection selectObj = new Selection(individuals, numOfSelection);
        ArrayList<ArrayList<Double>> choosenelements = selectObj.doSelection(fintessValues);
        
        
        /*System.out.println("\n ------------ Selection ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(choosenelements.get(j));
        }*/
        
        // Perform crossover
        Crossover crossObj = new Crossover(choosenelements);
        ArrayList<ArrayList<Double>> offSprings = crossObj.performCrossover();
        
        /*System.out.println("\n ------------ Crossover ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(offSprings.get(j));
        }*/
        
        // Perform mutation
        mutation = new Mutation(offSprings, numOfGenerations);
        ArrayList<ArrayList<Double>> mutatedOffSprings = mutation.performMutation(i);
        
        
        /*System.out.println("\n ------------ Mutation ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(mutatedOffSprings.get(j));
        }*/	
        // Perform replacement
        replacer = new Replacement(individuals, mutatedOffSprings, solver);
        individuals = replacer.perfomReplacment();
        	
        /*System.out.println("\n ------------ replacement ------------ ");
        for (int j = 0; j < individuals.size(); j++) {
        	System.out.println(individuals.get(j));
        }*/
        
        // Get new best
        bestInd = solver.getBestInd(individuals);
    }

    // Perform all Algorithm steps
    public void algTrigger() {

        // File or Screen
    	
    	// Read inputs from file
    	problems = fileController.readInputs();
		
		// Solve all problems
    	int numOfProblems = problems.size();
        for ( int j = 0 ; j < numOfProblems; j++) {
    		
    		solver = new SolutionsMNG(40, problems.get(j));
    		
    		/*System.out.println(" ----------- Init ------------- ");
    		solver.print();
    		*/
    		
    		individuals = solver.getIndividuals();
    		bestInd = solver.getBestInd(individuals);
        	for(int i = 0; i < 200; i++ ){
            	executeProcess(i);
            }
        	fileController.writeOutput(bestInd, j, solver.fitnessFunction(bestInd));
        	
        	System.out.println("Case: " + (j+1));
			for(int i = 0; i < bestInd.size(); i++ ){
				System.out.print(bestInd.get(i) + "   ");
	        }
			System.out.println(", Error: " + solver.fitnessFunction(bestInd));
        }
    }
    
    public static void main (String args[]) {
    	ALGImplementation obj = new ALGImplementation();
    	obj.algTrigger();
    }
}
