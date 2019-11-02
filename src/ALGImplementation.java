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
	String bestInd;
	
	// Constructor
	public ALGImplementation() {
		this.fileController = new FilesController("input-2.txt");
		this.numOfGenerations = 200;
		this.numOfSelection = 4;
	}
	
    // Execute algorithm repetitive steps
    public void executeProcess(int i) {

        // Call SolutionMNG to evaluate solutions
    	//ArrayList<Double> fintessValues = solver.calcAllFintenss();
    	ArrayList<Double> fintessValues = new ArrayList<Double>();
    	fintessValues.add(20.5);
    	fintessValues.add(30.5);
    	fintessValues.add(10.5);
    	fintessValues.add(15.5);
    	fintessValues.add(22.5);
    	fintessValues.add(5.5);
    	
        // Perform Selection
        Selection selectObj = new Selection(individuals, numOfSelection);
        //ArrayList<ArrayList<Double>> choosenelements = selectObj.doSelection(fintessValues);
        
        
       /* System.out.println("\n ------------ Selection ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(choosenelements.get(i));
        }*/

        ArrayList<ArrayList<Double>> choosenelements = new ArrayList<ArrayList<Double>>();
        choosenelements.addAll(individuals.subList(0, 4));
        
        // Perform crossover
        Crossover crossObj = new Crossover(choosenelements);
        ArrayList<ArrayList<Double>> offSprings = crossObj.performCrossover();
        
        System.out.println("\n ------------ Crossover ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(offSprings.get(j));
        }
        
        // Perform mutation
        mutation = new Mutation(offSprings, numOfGenerations);
        ArrayList<ArrayList<Double>> mutatedOffSprings = mutation.performMutation(i);

        System.out.println("\n ------------ Mutation ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(mutatedOffSprings.get(j));
        }
        
        // Perform replacement
        replacer = new Replacement(individuals, mutatedOffSprings, solver);
        individuals = replacer.perfomReplacment();
       
        System.out.println("\n ------------ replacement ------------ ");
        for (int j = 0; j < individuals.size(); j++) {
        	System.out.println(individuals.get(i));
        }
        
        // Get new best
        //bestInd = solver.getBestInd(individuals, bestInd);
    }

    // Perform all Algorithm steps
    public void algTrigger() {

        // File or Screen
    	
    	// Read inputs from file
    	problems = fileController.readInputs();
		
		// Solve all problems
    	int numOfProblems = problems.size();
        for ( int j = 0 ; j < 1; j++) {
    		
    		solver = new SolutionsMNG(6, problems.get(0));
    		
    		System.out.println(" ----------- Init ------------- ");
    		solver.print();
    		
    		individuals = solver.getIndividuals();
    		/*bestInd = solver.getBestInd(individuals, "");
        	*/
        	for(int i = 0; i < 1; i++ ){
            	executeProcess(i);
            }
            //System.out.println("Case: "+(j+1)+" "+ solver.fitnessfunction(bestInd));
        }
    }
    
    public static void main (String args[]) {
    	ALGImplementation obj = new ALGImplementation();
    	obj.algTrigger();
    }
}
