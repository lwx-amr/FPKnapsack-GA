import java.util.ArrayList;

// To handle selection process
public class Selection {

    // Variables
    private int numOfSelection;
    private ArrayList<ArrayList<Double>> individuals;

    // Constructor
    public Selection(ArrayList<ArrayList<Double>> individuals , int numOfSelection) {
        this.numOfSelection = numOfSelection; // We will change this value later
        this.individuals = individuals;
    }
    
    public static ArrayList<Double> modify(ArrayList<Double> myList){	
		ArrayList<Double> minusOne=new ArrayList<>();
		ArrayList<Double> finalOne=new ArrayList<>();
		double totalError=0 , temp;
		for(int i=0;i<myList.size();i++){
			temp=1-myList.get(i);
			minusOne.add(temp);
			totalError+=temp;
		}
		double x=0;
		finalOne.add(x);
		temp=0;
		for(int i=0;i<minusOne.size();i++){
			temp+=minusOne.get(i)/totalError;
			finalOne.add(temp);
		}
		return finalOne;
	}
    
    // Selection Process
    public ArrayList<ArrayList<Double>> doSelection(ArrayList<Double> fintessValues) {
        ArrayList<ArrayList<Double>> choosenelements = new ArrayList<ArrayList<Double>>();
        double totalFitness = 0;
        for (int i = 0; i < fintessValues.size(); i++) {
            totalFitness += fintessValues.get(i);
        }
        ArrayList<Double>proportion=new ArrayList<>();
		ArrayList<Double>errors=new ArrayList<>();
		double error=0;
		for(int j=0 ;j<individuals.size();j++) {
			error=fintessValues.get(j)/totalFitness;
			errors.add(error);
		}
		proportion=modify(errors);
		for(int i=0; choosenelements.size()!= numOfSelection;i++){
			double prop=Math.random();
			for(int j=0;j<proportion.size()-1;j++){
				if( (prop<proportion.get(j+1) && prop>proportion.get(j)) ||prop==proportion.get(j) ) {
					if(choosenelements.indexOf(individuals.get(j)) == -1) {
						choosenelements.add(individuals.get(j));
					}
				}	
			}
		}
		return choosenelements;
    }
}
