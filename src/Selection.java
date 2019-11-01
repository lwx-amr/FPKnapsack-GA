import java.util.Random;

// To handle selection process
public class Selection {

    // Variables
    private int numOfSelection;
    private String[] binary;

    // Constructor
    public Selection(String[] binary , int numOfSelection) {
        this.numOfSelection = numOfSelection; // We will change this value later
        this.binary = binary;
    }

    // Selection Process
    public String [] doSelection(int[] fitnessValues) {
        int totalweight = 0;
        String[] choosenelements = new String[numOfSelection];
        for (int i = 0; i < fitnessValues.length; i++) {
            totalweight += fitnessValues[i];
        }
        Random rg = new Random();
        for (int i = 0 ; i < numOfSelection; i++) {
        	int partialsum=0, random, index = 0, lastAddedIndex = 0;
        	random = rg.nextInt(totalweight - 1);
			while(partialsum < random) {
				partialsum+= fitnessValues[index];
				lastAddedIndex = index;
                index++;
			}
			choosenelements[i]=binary[lastAddedIndex];
        }
        return choosenelements;
    }
}
