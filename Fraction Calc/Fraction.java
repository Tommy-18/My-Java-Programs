public class Fraction{
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom){
        if (denom != 0){
            if (denom < 0) {
                this.numerator = -num;
                this.denominator = -denom;
            } else if (denom > 0) {
                this.numerator = num;
                this.denominator = denom;
            }
        } else {
            System.out.println("The denominator cannot be equal to zero.");
            throw new IllegalArgumentException();
        }
    }

    public Fraction(int num){
        this.numerator = num;
        this.denominator = 1;
    }
    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    public String toString(){
        return (this.numerator + "/" + this.denominator);
    }
    public double toDouble(){
        return (this.numerator / this.denominator);
    }
    public Fraction add(Fraction other){
        int newNum;
        int newDenom;
        if (this.denominator == other.denominator) {
            newNum = this.numerator + other.numerator;
            newDenom = this.denominator;
        } else{
            newNum = (this.numerator * other.denominator) + (this.denominator * other.numerator);
            newDenom = other.denominator * this.denominator;
        }
        return new Fraction(newNum, newDenom);

    }

    public Fraction subtract(Fraction other){
        int newNum = (this.numerator * other.denominator) - (this.denominator * other.numerator);
        int newDenom = other.denominator * this.denominator;
        return new Fraction(newNum, newDenom);
    }
    public Fraction multiply(Fraction other){
        int newNume = other.numerator * this.numerator;
        int newDeno = other.denominator * this.denominator;
        return new Fraction(newNume, newDeno);

    }
    public Fraction divide(Fraction other){
        int newNume = this.numerator * other.denominator;
        int newDenom = this.denominator * other.numerator;
        return new Fraction(newNume,newDenom);
    }
    public boolean equals(Object other){
        boolean same = false;
        if (other.getClass() == Fraction.class){
            Fraction Other = (Fraction) other;
            if (this.numerator/this.denominator == Other.numerator/Other.denominator){
                same = true;
            }
        }
        return same;
    }
    public void toLowestTerms(){
        for (int i = 1; i < this.denominator; i++){
            if ((this.denominator % i == 0) && (this.numerator % i == 0)){
                    this.numerator = this.numerator / i;
                    this.denominator = this.denominator / i;
                }
            }
    }
    public static int gcd(int num, int den) {
        int GCD = 1;
        if (num < den) {
            for (int i = 1; i < den; i++) {
                if ((num % i == 0) && (den % i == 0)) {
                    GCD = i;
                }
            }
        }else{
            for (int i = 1; i < num; i++) {
                if ((num % i == 0) && (den % i == 0)) {
                    GCD = i;
                }
            }
        }
        return GCD;
    }

}
