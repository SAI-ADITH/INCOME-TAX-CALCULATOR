public class Person {

	private int id;
	private String name;
	private String birthday;
	private String ssn;
	private float grossIncome;
	
	
	public Person(){
		this.id = id++;
	}
	
	public boolean setName(String name){
		boolean check = true;
		for(int i = 0;i<name.length();i++) {
			char ch = name.charAt(i);
			if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch == ' ') {
				check =  true;
			}else {
				check = false;
				break;
			}
		}
		return check; 	
	}

	public boolean setBirthday(String birthday) {
		
		boolean check1 = true;
		
		if(birthday.charAt(0) >= '0' && birthday.charAt(0) <= '9'
		&& birthday.charAt(1) >= '0' && birthday.charAt(1) <= '9'
		&& birthday.charAt(2) >= '0' && birthday.charAt(2) <= '9'
		&& birthday.charAt(3) >= '0' && birthday.charAt(3) <= '9'
		&& birthday.charAt(4) == '/'
		&& birthday.charAt(5) >= '0' && birthday.charAt(5) <= '9'
		&& birthday.charAt(6) >= '0' && birthday.charAt(6) <= '9'
		&& birthday.charAt(7) == '/'
		&& birthday.charAt(8) >= '0' && birthday.charAt(8) <= '9'
		&& birthday.charAt(9) >= '0' && birthday.charAt(9) <= '9') {
			
			check1 = true;
		}else {
			check1 = false;
		}
		return check1;
	}
	
	public boolean setSSN(String ssn) {
		
		boolean check2 = true;
		
		if(ssn.charAt(0) >= '0' && ssn.charAt(0) <= '9'
		&& ssn.charAt(1) >= '0' && ssn.charAt(1) <= '9'
		&& ssn.charAt(2) >= '0' && ssn.charAt(2) <= '9'
		&& ssn.charAt(3) == '-'
		&& ssn.charAt(4) >= '0' && ssn.charAt(4) <= '9'
		&& ssn.charAt(5) >= '0' && ssn.charAt(5) <= '9'
		&& ssn.charAt(6) == '-'
		&& ssn.charAt(7) >= '0' && ssn.charAt(7) <= '9'
		&& ssn.charAt(8) >= '0' && ssn.charAt(8) <= '9'
		&& ssn.charAt(9) >= '0' && ssn.charAt(9) <= '9'
		&& ssn.charAt(10) >= '0' && ssn.charAt(10) <= '9') {
			
			check2 = true;
		}else {
			check2 = false;
		}
		return check2;
		
	}
	
	public boolean setGrossIncome(float grossIncome) {
		if (grossIncome >= 0) {
            this.grossIncome = grossIncome;
            return true;
        } else {
            return false;
        }
	}
	
	public float getGrossIncome() {
		return grossIncome;
	}
	
	public int getId() {
        return id;
    }
	
	public String toString() {
		return name+" "+ssn+" "+birthday;
	}
	
	public float deduction(Family family) {
        return 0.0f;
    }
	
	
}
