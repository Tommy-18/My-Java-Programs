import java.util.*;
public class TechnicalEmployee extends Employee{
    private static TechnicalLead manager;
    private int checkins = 0;
    public TechnicalEmployee(String name){
        super(name,75000);
    }
    public TechnicalEmployee(String name, double multiply){
        super(name,(75000*multiply));
    }
    public String employeeStatus(){
        /*
        Should return a String representation of this TechnicalEmployee that includes their ID, name and
         how many successful check ins they have had. Example: "1 Kasey has 10 successful check ins"
         */
        return (super.getEmployeeID() + " " + super.getName() + " has " + this.checkins + " successful check ins");
    }
    public void assignManager(TechnicalLead Manager) {
        this.manager = Manager;
    }
    public TechnicalLead getManager(){
        return this.manager;
    }

    public int getSuccessfulCheckIns(){
        /*
        Should return the current count of how many times this SoftwareEngineer has successfully checked in code
         */
        return this.checkins;
    }
    public void addCheckIns(int num){
        this.checkins += num;
    }
}
