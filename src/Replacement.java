// Handle replacement process
public class Replacement {

	// Variable
	private String [] newGeneration, mutatedOffsprings, individuals;;
	private SolutionsMNG sMNG;
	
	// Constructor
	public Replacement(String[] individuals, String[] mutatedOffsprings, SolutionsMNG sMNG){
		this.setIndividuals(individuals);
		this.setMutatedOffsprings(mutatedOffsprings);
		this.sMNG = sMNG;
		this.newGeneration = individuals;
	}
	
	// To perform elitism replacement
	public String [] perfomReplacment(){
		/*System.out.println("\n ------------ before ------------ ");
        for (int j = 0; j < individuals.length; j++) {
        	System.out.print(sMNG.fitnessfunction(individuals[j], benefits) + "  ");
        }*/
		sortDESC();
		/*System.out.println("\n ------------ After ------------ ");
		for (int j = 0; j < individuals.length; j++) {
        	System.out.print(sMNG.fitnessfunction(individuals[j], benefits) + "  ");
        }*/
		 
        /*System.out.println("\n ----------- After Sort ------------- ");
        sMNG.print();
        */
		// Remove lowest
        int index = 0;
		for (int j = newGeneration.length -1; j > 0 && index < mutatedOffsprings.length ; j--) {
			newGeneration[j] = mutatedOffsprings[index];
			index++;
        }
		
		/*System.out.println("\n ------------ Before Sub ------------ ");
		for (int j = 0; j < newGeneration.length; j++) {
        	System.out.println(newGeneration[j] + "  " + sMNG.fitnessfunction(newGeneration[j], benefits));
        }*/
		return newGeneration;
	}

	// Sort individuals DESCENDING
	public void sortDESC(){
		int n = individuals.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (sMNG.fitnessfunction(individuals[j]) < sMNG.fitnessfunction(individuals[j+1])) {
                    String tempS = individuals[j]; 
                    individuals[j] = individuals[j+1]; 
                    individuals[j+1] = tempS;   
                }
	}
	
	// Setters and getters
	public String [] getIndividuals() {
		return individuals;
	}

	public void setIndividuals(String [] individuals) {
		this.individuals = individuals;
	}

	public String [] getMutatedOffsprings() {
		return mutatedOffsprings;
	}

	public void setMutatedOffsprings(String [] mutatedOffsprings) {
		this.mutatedOffsprings = mutatedOffsprings;
	}
}
