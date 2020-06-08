import java.util.Scanner;
public class TripAdvisor {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String Name = input.nextLine();
        System.out.print("Nice to meet you " + Name + ", where are you travelling to? ");
        String Destination = input.nextLine();
        System.out.println("Great! " + Destination + " sounds like a great trip.");
        Separator();


        System.out.print("How many days are you going to spend travelling? ");
        int DayTrav = input.nextInt(); //Days Travelling
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int MoneyUSD = input.nextInt();
        System.out.print("What is the three currency symbol for your travel destination? ");
        String Symbols = input.next();
        System.out.print("How many " + Symbols + " are there in 1 USD? ");
        double ConversionRate = input.nextDouble();
        Separator();



        System.out.print("If you are travelling for " + DayTrav + " days that is the same as ");
        System.out.println((DayTrav *24) + " hours or " + (DayTrav * 24 * 60) + " minutes.");
        System.out.print("If you are going to spend $" + MoneyUSD + " that means per day you can spend up to");
        System.out.println(MoneyUSD/DayTrav);
        System.out.print("Your total budget for this trip is "+ (MoneyUSD * ConversionRate) + " " + Symbols);
        System.out.println(", which per day is " + (ConversionRate * MoneyUSD/DayTrav) + " " + Symbols);
        Separator();



        System.out.print("What is the time difference, in hours, between your home and your destination?");
        int Timediff = input.nextInt();
        System.out.print("That means that when it is midnight at home it will be " + Timediff + ":00 in your travel destination" );
        System.out.println("and when it is noon at home, it will be " + ((12 + Timediff)%24) + ":00");
        Separator();


        System.out.print("What is the square area of your destination country in km2? ");
        int km2 = input.nextInt();
        double miles2 = (km2/(2.58999));
        System.out.println("in miles2 that is " + miles2);
        Separator();



    }

    public static void Separator(){
        System.out.println("********** \n \n ");
    }

}
