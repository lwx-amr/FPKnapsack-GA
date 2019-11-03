import java.util.ArrayList;
import java.util.Random;

// Handle everything related to solutions individuals
public class SolutionsMNG {

    // Variables
    private int numOfInd, numOfInputs, indiSize;
    private Problem problem;
    private ArrayList<ArrayList<Double>>  individuals;
    
    // Constructor
    public SolutionsMNG(int numOfInd, Problem problem) {
    	this.numOfInd = numOfInd;
    	this.problem = problem;
    	this.numOfInputs = problem.getPoints().size();
    	this.indiSize = problem.getDegree() + 1;
    	this.individuals = new ArrayList<ArrayList<Double>>();
    	//System.out.println(problem.getDegree());
        this.initialize();
    }


    // Initialize first random solutions
    public void initialize() {
    	ArrayList<Double> currentInd;
        for (int i = 0; i < numOfInd; i++) {
        	currentInd = new ArrayList<Double>();
        	currentInd = generateInd();
        	individuals.add(currentInd);
        }
    }

    // Generate random solution
    public ArrayList<Double> generateInd() {
        ArrayList<Double> currentIndi = new ArrayList<Double>();
        double current;
        //System.out.println(indiSize);
        for (int i=0; i<indiSize;i++) {
        	current = generateRandomD(10.00,-10.00);
        	currentIndi.add(current);
        }
        return currentIndi;
    }

    // To print individuals1
    public void print() {
        for (int i = 0; i < numOfInd; i++) {
        	System.out.println((individuals.get(i)));
        }
    }

    // Evaluate individual fitness
    public double fitnessFunction(ArrayList<Double> indi) {
    	int numOfPoints=problem.getPoints().size();
		ArrayList<Point> points=new ArrayList<Point>();
		points=problem.getPoints();
		double segmaResult=0;
		for(int i=0 ;i <numOfPoints;i++)
		{
			double yAcual=points.get(i).getY();
			double yCalc=calculateY(problem.getPoints().get(i), indi);
			double difference=yCalc-yAcual;
			segmaResult+=Math.pow(difference,2);
		}
		double fraction=1.0/numOfPoints;
		double error=fraction*segmaResult;
		return error;
    }
    
    public static double calculateY(Point myPoint, ArrayList<Double> myCoefficients){
		double xPoint=myPoint.getX();
		double result=myCoefficients.get(0);
		for(int i=1;i<myCoefficients.size();i++){
			result+=myCoefficients.get(i)*Math.pow(xPoint,i);
		}
		return result;
	}
    
    // Calculate fitness function for all individuals
    public ArrayList<Double> calcAllFintenss() {
        ArrayList<Double> fitnessValues = new ArrayList<Double>();
        for (int i = 0; i < numOfInd; i++) {
            fitnessValues.add(fitnessFunction(individuals.get(i)));
        }
        return fitnessValues;
    }
    
    // Get best indivivdual between some of them
    public ArrayList<Double> getBestInd(ArrayList<ArrayList<Double>> inds) {
		ArrayList<Double> best = new ArrayList<Double>();
		double maxFit = Double.MAX_VALUE, currentFit;
		for (int i = 0; i < inds.size(); i++) {
			currentFit = fitnessFunction(inds.get(i));
			//System.out.println("currentFit: " + currentFit + "  maxFit: " +maxFit);
			if( currentFit < maxFit ){
				maxFit = currentFit;
				best = inds.get(i);
			}
        }
		return best;
	}
    
    // To generate random number
    public double generateRandomD(double max , double min) {
    	Random randomNum = new Random();
    	double random = randomNum.nextDouble() * (max-min) + min;
    	return random;
    }
    
    // Get Individuals
    public ArrayList<ArrayList<Double>> getIndividuals(){
    	return individuals;
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
    
}
