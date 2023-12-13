public class Adult extends Person{

	private String employer;
	
	public Adult(String name,String birthday,String ssn,float grossIncome, String employer){
    
		super(name, birthday, ssn, grossIncome);
		this.employer = employer;
		
		
	}
	public String toString() {
		
		return super.toString()+" "+getGrossIncome();
	}

    
	
	public float adjustedIncome() {
		
        float GI = getGrossIncome();
        Taxation tax = new Taxation();	
		float a = tax.socialSecurityRate();
		float b = tax.socialSecurityIncomeLimit();
		float c = tax.medicareRate();
		float tax1 = 0;
		if(GI<b) {
			tax1 = GI*(a/100);
		}else {
            tax1 = (float)0;
        }
		
		float tax2 = GI*(c/100);
		float totalAns = (tax2 + tax1)/2;
        return totalAns;
	}
	
    public float taxWithheld() {
        float GI = getGrossIncome();
        float ans = 0;
        float rate1 = 0.1;
        float rate2 = 0.15;
        float rate3 = 0.2;
        
        if (GI > 150000) {
            ans += (GI - 150000) * rate3;
            GI = 150000;
        }
        
        if (GI > 50000) {
            ans += (GI - 50000) * rate2;
            GI = 50000;
        }
        
        ans += GI * rate1;
        return ans;
    }
	
	public float deduction(Family family) {
        float adult = family.getNumAdults();
		Taxation taxation = new Taxation();
        float exemption = taxation.getAdultBaseExemptiion();
        return 0;
	}
	
	public String getEmployer() {
		return employer;
	}

}