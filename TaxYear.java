public class TaxYear {

    private Family[] taxReturns;
    private int numPersonsFiled;
    private float totalTaxWithheld;
    private float totalTaxOwed;
    private float totalTaxDue;
    private int maxReturns;
    private int numReturnsFiled;
    private float totalTaxCredits;
    
    
    public TaxYear(int max) {

        numPersonsFiled = 0;
        totalTaxWithheld = 0.0;
        totalTaxOwed = 0.0;
        totalTaxDue = 0.0;
        maxReturns = max;
        numReturnsFiled = 0;
        totalTaxCredits = 0.0;
        taxReturns = new Family[maxReturns];
    }
    
    public boolean taxFiling(Family family) {

        if (numReturnsFiled >= maxReturns) {
            return false;
        }
            
        taxReturns[numReturnsFiled] = family;
        numReturnsFiled++;
            
        numPersonsFiled += family.getNumPersons();
        totalTaxWithheld += family.getTaxWithheld();
        totalTaxOwed += family.getTaxOwed();
        totalTaxDue += family.getTaxDue();
        totalTaxCredits += family.getTaxCredits();
            
        return true;

        }    
    
    public float taxWithheld() {
        return totalTaxWithheld;
    }
    
    public float taxOwed() {
        return totalTaxOwed;
    }
    
    public float taxDue() {
        return totalTaxDue;
    }
    
    public float taxCredits() {
        return totalTaxCredits;
    }
    
    public int numberOfReturnsFiled() {
        return numReturnsFiled;
    }
    
    public int numberOfPersonsFiled() {
        return numPersonsFiled;
    }
    
    public Family getTaxReturn(int index) {
        return taxReturns[index];
    }
}

