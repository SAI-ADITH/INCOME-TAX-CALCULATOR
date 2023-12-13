import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Taxation {
	
	private float socialSecurityRate = (float) 12.4; 
	private float socialSecurityIncomeLimit = (float) 137700.0; 
	private float medicareRate = (float) 2.9; 
	private float adultBaseExemption = (float) 3000.0; 
	private float childBaseExemption = (float) 2000.0;
	private float medianIncomePerCapita = (float) 31099.0;

    public void loadParameters(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] x = scanner.nextLine().split(" ");
                String name = x[0];
                float val = Float.parseFloat(x[1]);
                if (name.equals("socialSecurityRate")) {socialSecurityRate = val;}
                else if (name.equals("socialSecurityIncomeLimit")) {socialSecurityIncomeLimit = val;}
                else if (name.equals("medicareRate")) {medicareRate = val;}
                else if (name.equals("adultBaseExemption")) {adultBaseExemption = val;}
                else if (name.equals("childBaseExemption")) {childBaseExemption = val;}
                else if (name.equals("medianIncomePerCapita")) {medianIncomePerCapita = val;}
            }
        }
    }

    public float getAdultBaseExemptiion(){
        return adultBaseExemption;
    }

    public float getChildBaseExemptiion(){
        return childBaseExemption;
    }

    
    public void incomeBracket(){

    }

    public void taxRate(){

    }
	
	public float getNumTxBrackets() {
		
	}
	public float maxIncomeTaxBracket(Family) {
		
	}
	public float bracketTaxRate(Family,float b) {
		
	}
	public float bracketTaxRate(Float b, float f) {
		
	}
}