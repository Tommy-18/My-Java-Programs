public class Employee {
    private String name;
    private double salary;
    private static int TotalEmployees = 0;
    private int id;
    private String status;
    private double bonus;
    private TechnicalLead Supporting;

    public Employee(String name, double baseSalary){
        /*
        Should construct a new employee object and take in two parameters,
         one for the name of the user and one for their base salary
         */
        this.name = name;
        this.salary = baseSalary;
        TotalEmployees += 1;
        this.id = TotalEmployees;
    }
    public double getSalary(){
        return this.salary;
    }
    public TechnicalLead getTeamSupported(){
        /*
        Should return a reference to the TechnicalLead that this Accountant is currently supporting.
        If they have not been assigned a TechnicalLead null should be returned
         */
        return this.Supporting;
    }
    public String getName(){
        return this.name;
    }
    public int getEmployeeID(){
        /*
         Should return the employee's ID. The ID should be issued on behalf of the employee at the
         time they are constructed. The first ever employee should have an ID of "1", the second "2" and so on
         */
        return this.id;
    }
    public boolean equals(Employee other){
        /*
        Should return true if the two employee IDs are the same, false otherwise
         */
        boolean same = false;
        if (this.getEmployeeID() == other.getEmployeeID()){
            same = true;
        }
        return same;
    }
    public String toString(){
        /*
        Should return a String representation of the employee that is a combination of their id followed by their name.
        Example: "1 Kasey"
         */
        return (this.getEmployeeID() + " " + this.getName());
    }
    public String employeesStatus(){
        /*
        Should return a String representation of that Employee's current status.
        This will be different for every subclass of Employee
         */
        return this.status;
    }
    public void getBonus(Employee e, double Bonus){
        e.bonus += Bonus;
    }
}
