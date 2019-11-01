import java.util.Vector;

// Implementation of algorithm
public class ALGImplementation {

	// Objects
	private FilesController fileController;
	private SolutionsMNG solver;
	private Mutation mutation;
	private Replacement replacer;
	
	
	// Variables 
	private String [] individuals; 
	private Vector<Problem> problems;
	private int numOfInputs, numOfSelection, numOfGenerations, S;
	private int [] benefits, weights; 
	String bestInd;
	
	// Constructor
	public ALGImplementation() {
		this.fileController = new FilesController("input_example.txt");
		this.numOfGenerations = 200;
		this.numOfSelection = 100;
	}
	
    // Execute algorithm repetitive steps
    public void executeProcess(int i) {

        // Call SolutionMNG to evaluate solutions
    	int[] fintessValues = solver.calcAllFintenss();
    	
        // Perform Selection
        Selection selectObj = new Selection(individuals, numOfSelection);
        String[] choosenelements = selectObj.doSelection(fintessValues);
        
        /*System.out.println("\n ------------ Selection ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(choosenelements[j]);
        }*/
        
        // Perform crossover
        Crossover crossObj = new Crossover(choosenelements, solver);
        String[] offSprings = crossObj.performCrossover();
        
        /*System.out.println("\n ------------ Crossover ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(offSprings[j]);
        }*/
        
        
        // Perform mutation
        mutation = new Mutation(offSprings, solver);
        String[] mutatedOffSprings = mutation.performMutation();

        /*System.out.println("\n ------------ Mutation ------------ ");
        for (int j = 0; j < numOfSelection; j++) {
        	System.out.println(mutatedOffSprings[j]);
        }*/
        
        // Perform replacement
        replacer = new Replacement(individuals, mutatedOffSprings, solver);
        individuals = replacer.perfomReplacment();
       
        // Get new best
        bestInd = solver.getBestInd(individuals, bestInd);
    }

    // Perform all Algorithm steps
    public void algTrigger() {

        // File or Screen
    	
    	// Read inputs from file
    	problems = new Vector<Problem>();
    	fileController.	readInputs();
    	problems = fileController.getInputs();
    	
		
		// Solve all problems
    	int numOfProblems = problems.size();
        for ( int j = 0 ; j < numOfProblems; j++) {
        	
    		benefits = problems.elementAt(j).getBenefits();
    		weights = problems.elementAt(j).getWieghts();
    		S = problems.elementAt(j).getSize();
    		numOfInputs = benefits.length;
    		
    		solver = new SolutionsMNG(10, numOfInputs, benefits, weights, S);
    		
    		/*System.out.println(" ----------- Init ------------- ");
    		solver.print();
    		*/
    		individuals = solver.getIndividuals();
    		bestInd = solver.getBestInd(individuals, "");
        	for(int i = 0; i < numOfGenerations; i++ ){
            	executeProcess(j);
            }
            System.out.println("Case: "+(j+1)+" "+ solver.fitnessfunction(bestInd));
        }
    }
    
    public static void main (String args[]) {
    	ALGImplementation obj = new ALGImplementation();
    	obj.algTrigger();
    }
}
