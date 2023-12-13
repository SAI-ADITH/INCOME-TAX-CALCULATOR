public class Child extends Person{

	private String school;
	private float tuition;
	
	 public Child(String name, String birthday, String ssn, float grossIncome, String school, float tuition) {
	    super(name, birthday, ssn, grossIncome);
	    this.school = school;
	    this.tuition = tuition;
	    }
	 
	public String toString() {
		return super.toString() + " " + school;
	}
	
	public float getTuition() {
		return tuition;
	}
	
	public float deduction(Family family) {
		Taxation taxation = new Taxation();
		float children = family.getNumChildren();
		float exemption = taxation.getChildBaseExemption();
		
		if (children > 2) {
			exemption *=  Math.min(0.05 * (children - 2), 0.5);
		}
		float ans = Math.min(exemption, getGrossIncome());
		return ans;
	}	                     
}

