public class Analytics {
    private float povertyThreshold = 27750.0f;
    private TaxYear taxYear;

    public Analytics(TaxYear taxYear) {
        this.taxYear = taxYear;
    }

    public void setPovertyThreshold(float povertyThreshold) {
        this.povertyThreshold = povertyThreshold;
    }

    public float averageFamilyIncome() {
        float totalIncome = 0.0f;      
        int numFamilies = taxYear.numberOfReturnsFiled();
        for (int i = 0; i < numFamilies; i++) {
            totalIncome += taxYear.getTaxReturn(i).getTaxableIncome();
        }

        float ans = totalIncome / numFamilies;
        return ans;
    }

    public float averagePersonIncome() {
        float totalIncome = 0.0f;
        int numPersons = taxYear.numberOfPersonsFiled();
        for (int i = 0; i < numPersons; i++) {
            totalIncome += taxYear.getPerson(i).getTaxableIncome();
        }
        float ans = totalIncome / numPersons;
        return ans;
    }

    public float maxFamilyIncome() {
        float maxIncome = 0.0f;
        int numFamilies = taxYear.numberOfReturnsFiled();
        for (int i = 0; i < numFamilies; i++) {
            float income = taxYear.getTaxReturn(i).getTaxableIncome();
            if (income > maxIncome) {
                maxIncome = income;
            }
        }
        return maxIncome;
    }

    public float maxPersonIncome() {
        float maxIncome = 0.0f;
        int numPersons = taxYear.numberOfPersonsFiled();
        for (int i = 0; i < numPersons; i++) {
            float income = taxYear.getPerson(i).getTaxableIncome();
            if (income > maxIncome) {
                maxIncome = income;
            }
        }
        return maxIncome;
    }

    public int familiesBelowPovertyLimit() {
        int numFamilies = taxYear.numberOfReturnsFiled();
        int numBelowPoverty = 0;
        for (int i = 0; i < numFamilies; i++) {
            float income = taxYear.getTaxReturn(i).getTaxableIncome();
            if (income < povertyThreshold) {
                numBelowPoverty++;
            }
        }
        return numBelowPoverty;
    }

    public int familyRank(Family family) {
        float familyIncome = family.getTaxableIncome();
        int rank = 1;
        int numFamilies = taxYear.numberOfReturnsFiled();
        for (int i = 0; i < numFamilies; i++) {
            float income = taxYear.getTaxReturn(i).getTaxableIncome();
            if (income > familyIncome) {
                rank++;
            }
        }
        return rank;
    }
}
