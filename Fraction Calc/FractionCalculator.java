import java.util.*;
public class FractionCalculator {
    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add,subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("PLease enter your fractions in the form a/b, where a and b are integers.");
        separator();
        String op = getOperation();
        Fraction f1 = getFraction();
        Fraction f2 = getFraction();
        Fraction total = doOperation(f1, f2, op);

    }

    public static void separator() {
        System.out.println("--------------------------------------------");
    }
    public static String getOperation(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please an operation (+, -, /, *, = or Q to quit) : ");
        String o = input.nextLine();
        boolean valid = (o.equals("+") || o.equals("-") || o.equals("/") || o.equals("*") || o.equals("=") || o.equals("Q") || o.equals("q"));
        while (!valid){
            System.out.print("That is an invalid input, enter (+, -, /, *, = or Q to quit) :");
            o = input.nextLine();
            valid = (o.equals("+") || o.equals("-") || o.equals("/") || o.equals("*") || o.equals("=") || o.equals("Q") || o.equals("q"));
        }
        if (o.equals("q") || o.equals("Q")){
            EndProgram();
        }
        return o;
    }
    public static void EndProgram(){
        System.exit(0);
    }

    public static Fraction getFraction(){
        Scanner input = new Scanner(System.in);
        boolean valid1 = false;
        String str1 = null;
        Fraction frac;
        while (!valid1){
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            str1 = input.nextLine();
            valid1 = validFraction(str1);
        }
        if (str1.contains("/")){
            String str2 = str1.substring(str1.indexOf("/") + 1);
            str1 = str1.substring(0, str1.indexOf("/"));
            frac = new Fraction(Integer.parseInt(str1),Integer.parseInt(str2));
        } else{
            frac = new Fraction(Integer.parseInt(str1));
        }
        return frac;
    }

    public static Boolean validFraction(String str1){
        boolean valid1 = false;
        try {
            if (str1.contains("/")) {
                String str2 = str1.substring(str1.indexOf("/") + 1);
                str1 = str1.substring(0, (str1.indexOf("/")));
                if (Integer.parseInt(str1) >= 0 || Integer.parseInt(str1) <= 0) {
                    if (Integer.parseInt(str2) >= 0 || Integer.parseInt(str2) <= 0) {
                        valid1 = true;
                    }
                }
            }
            if (Integer.parseInt(str1) >= 0 || Integer.parseInt(str1) <= 0) {
                valid1 = true;
            }
        } catch (Exception e){

        }
        return valid1;

    }
    public static Fraction doOperation(Fraction f1, Fraction f2,String op){
        Fraction newFraction = new Fraction();
        if (!op.equals("=") && !op.equals("Q") && !op.equals("q")){
            System.out.print(f1.getNumerator() + "/" + f1.getDenominator());
            System.out.print(" "+ op + " " + f2.getNumerator() + "/" + f2.getDenominator() + " = ");
            if (op.equals("+")){
                newFraction = f1.add(f2);
            }
            if (op.equals("-")){
                newFraction = f1.subtract(f2);
            }
            if (op.equals("/")){
                newFraction = f1.divide(f2);
            }
            if (op.equals("*")) {
                newFraction = f1.multiply(f2);
            }
            newFraction.toLowestTerms();
            System.out.print(newFraction.getNumerator() + "/" + newFraction.getDenominator());

        } else {
            if (op.equals("=")) {
                System.out.print(f1.getNumerator() + "/" + f1.getDenominator() + " = ");
                boolean val = f1.equals(f2);
                System.out.print(f2.getNumerator() + "/" + f2.getDenominator() + " is " + Boolean.toString(val));
            }
            if (op.equals("q") || op.equals("Q")) {
                EndProgram();
            }
        }
        return newFraction;
    }
}


