public class Family {

	
	private Person[] members;
	private int filingStatus;
    private int numMembers;
	
	public Family(int numMembers,int fillingStatus){
		this.numMembers = numMembers;
        this.filingStatus = filingStatus;
        this.members = new Person[numMembers];
	}
	
	public void addMember(Person memb) {
		for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = memb;
                break;
            }
        }
    }
	
	
	public  int getNumAdults() {
        int x = 0;
		for (Person memb : members) {
            if (memb instanceof Adult) {
                x++;   
            }
        }
        return x;
	}

	public int getNumChildren() {
        int x = 0;
		for (Person memb : members) {
            if (memb instanceof Child) {
                x++;   
            }
        }
        return x;
	}

	
	public int getFilingStatus() {
        return filingStatus;
    }

    public float getTaxableIncome(){
        Adult adult = new Adult();
        Child child = new Child();

        float x = adult.deduction();
        float y = child.deduction();
        float z = x+y;
        return z;
    }
    public float TaxCredit() {

        float taxableIncome = getTaxableIncome();
        Taxation taxation = new Taxation();
        float medianIncomePerCapita = taxation.getMedianIncomePerCapita();
        float low50PercentMedian = medianIncomePerCapita / 2;
        float taxCredit = Math.floor(taxableIncome / 1000) * 30;
        int numChildren = getNumChildren();

        for (int i = 0; i < numMembers; i++) {
            if (members[i] instanceof Child) {
                Child child = (Child) members[i];
                float childCredit = Math.min((float)child.getTuition(), 1000);
                taxCredit += childCredit;}
            }
        if (filingStatus == 3) {
            taxCredit /= 2;}
            taxCredit = Math.min(taxCredit, 2000);
        if (taxableIncome <= low50PercentMedian) {
            return taxCredit;
        } else {
            return 0;
        }
    }


    public float calculateTax() {
        float taxableIncome = getTaxableIncome();
        Taxation taxation = new Taxation();
        Family family = new Family(numMembers, filingStatus);
        float taxBracket = taxation.maxIncomeTaxBracket(family);
        float totalTax = 0;
        for (int i = 1; i < taxBracket; i++) {
            totalTax += taxation.bracketTaxRate(i, filingStatus);
        }
        float taxCredit = calculateTaxCredit();
        float withheldTax = calculateWithheldTax();
        float finalTax = totalTax - taxCredit - withheldTax;
        return finalTax;
    }   

    
	

}