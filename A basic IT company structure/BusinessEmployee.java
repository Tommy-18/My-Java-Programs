import java.util.ArrayList;

public class BusinessEmployee extends Employee{
    private static BusinessLead manager;
    private double Bonusbudget;
    private static ArrayList<Employee> DirectReports = new ArrayList<Employee>();
    public BusinessEmployee(String name){
        super(name,50000);

    }
    public BusinessEmployee(String name, double multiplier){
        super(name,50000 * multiplier);

    }
    public double getBonusBudget(){
        /*
        Should establish a running tally of the remaining bonusBudget for the team this employee supports.
        How that budget is determined will depend on which type of Business Employee it is
         */
        return this.Bonusbudget;
    }
    public void IncreaseBudget(Accountant e){
        this.Bonusbudget = e.getSalary() * 1.1;

    }
    public void recieveBonus(Employee e, double bonus ){
        super.getBonus(e,bonus);
    }
    public void decreaseBudget(double bonus){
        this.Bonusbudget -= bonus;
    }

    public String employeeStatus(){
        /*
        Should return a String representation of this BusinessEmployee that includes their ID, name and
         the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
         */
        return(super.toString() + " with a budget of " + this.getBonusBudget());
    }
    public void assignManager(BusinessLead Manager){
        this.manager = manager;
    }
    public ArrayList<Employee> getDirectReports(){
        return DirectReports;
    }
    public BusinessLead getManager(){
        return this.manager;
    }

}
