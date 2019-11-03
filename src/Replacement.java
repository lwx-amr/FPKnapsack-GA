import java.util.ArrayList;
import java.util.Collections;

// Handle replacement process
public class Replacement {

	// Variable
	private ArrayList<ArrayList<Double>> newGeneration, mutatedOffsprings, individuals;;
	private SolutionsMNG sMNG;
	
	// Constructor
	public Replacement(ArrayList<ArrayList<Double>> individuals, ArrayList<ArrayList<Double>> mutatedOffsprings, SolutionsMNG sMNG){
		this.setIndividuals(individuals);
		this.setMutatedOffsprings(mutatedOffsprings);
		this.sMNG = sMNG;
		this.newGeneration = individuals;
	}
	
	// To perform elitism replacement
	public ArrayList<ArrayList<Double>> perfomReplacment(){
		/*System.out.println("\n ------------ before ------------ ");
        for (int j = 0; j < individuals.size(); j++) {
        	System.out.print(sMNG.fitnessFunction(individuals.get(j))+ "  ");
        }*/
		sortASC();
		/*System.out.println("\n ------------ After ------------ ");
		for (int j = 0; j < individuals.size(); j++) {
        	System.out.print(sMNG.fitnessFunction(individuals.get(j))+ "  ");
        }	 
        System.out.println("\n ----------- After Sort ------------- ");
        sMNG.print();
        */
		// Remove lowest
        int index = 0;
		for (int j = newGeneration.size() -1; j > 0 && index < mutatedOffsprings.size() ; j--) {
			newGeneration.remove(j);
			newGeneration.add(mutatedOffsprings.get(index));
			index++;
        }
		
		/*System.out.println("\n ------------ Before Sub ------------ ");
		for (int j = 0; j < newGeneration.size(); j++) {
        	System.out.println(newGeneration.get(j) + "  " + sMNG.fitnessFunction(newGeneration.get(j)));
        }*/
		return newGeneration;
	}

	// Sort individuals DESCENDING
	public void sortASC(){
		int n = individuals.size(); 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (sMNG.fitnessFunction(individuals.get(j)) > sMNG.fitnessFunction(individuals.get(j+1))) {
                	Collections.swap(individuals, j, j+1);
                }
	}
	
	// Setters and getters
	public ArrayList<ArrayList<Double>> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(ArrayList<ArrayList<Double>> individuals2) {
		this.individuals = individuals2;
	}

	public ArrayList<ArrayList<Double>> getMutatedOffsprings() {
		return mutatedOffsprings;
	}

	public void setMutatedOffsprings(ArrayList<ArrayList<Double>> mutatedOffsprings2) {
		this.mutatedOffsprings = mutatedOffsprings2;
	}
}
