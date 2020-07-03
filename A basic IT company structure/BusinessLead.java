import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee implements java.lang.reflect.Type{
    private int headcount;
    private static ArrayList<Employee> WorkForce = new ArrayList<Employee>();
    public BusinessLead(String name){
        /*
        Should create a new BusinessLead that is a Manager.
        The BusinessLead's base salary should be twice that of an Accountant. They should start with a head count of 10.
         */
        super(name,2.0);
        this.headcount = 10;
        super.assignManager(this);
    }
    public boolean hasHeadCount(){
        /*
        Should return true if the number of direct reports this manager has is less than their headcount.
         */
        boolean full = true;
        if (WorkForce.size() < this.headcount){
            full = false;
        }
        return full;
    }
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        /*
        Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add
        this employee to their list of direct reports. If the employee is successfully added to the BusinessLead's
        direct reports true should be returned, false should be returned otherwise. Each time a report is added the
        BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary.
        That employee's team they are supporting should be updated to reflect the reference to the TechnicalLead given.
        If the employee is successfully added true should be returned, false otherwise.
         */
        boolean added = false;
        if (e.getClass().getTypeName().equals("Accountant") & this.hasHeadCount()){
            WorkForce.add(e);
            super.IncreaseBudget(e);
            added = true;
            e.supportTeam(supportTeam);
        }
        return added;
    }
    public boolean requestBonus(Employee e, double bonus){
        /*
        Should check if the bonus amount requested would fit in current BusinessLead's budget.
         If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted and
          true should be returned. False should be returned otherwise
         */
        double total = this.getBonusBudget();
        boolean allowed = false;
        for (int i = 0; i < WorkForce.size(); i++){
            total -= WorkForce.get(i).getSalary();
        }
        if (bonus < total){
            allowed = true;
            super.recieveBonus(e,bonus);
            super.decreaseBudget(bonus);
        }
        return allowed;
    }
    public boolean approveBonus(Employee e, double bonus){
        /*
        This function should look through the Accountants the BusinessLead manages, and if any of them are supporting a
        the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be
        consulted to see if the bonus could be afforded. If the team can afford the bonus it should be rewarded and
        true returned, false otherwise
         */
        boolean added = false;
        for (int i = 0; i < WorkForce.size(); i++){
            Employee person= WorkForce.get(i);
            if (person.getTeamSupported() != null){
                double total =((Accountant) person).getBonusBudget();
                if (person.getTeamSupported().getWorkForce().contains(e)){
                    for (int j = 0; j < person.getTeamSupported().getWorkForce().size(); j++){
                        total -= person.getTeamSupported().getWorkForce().get(j).getSalary();
                    }
                    if (bonus < total){
                        super.recieveBonus(e,bonus);
                        ((Accountant)e).decreaseBudget(bonus, (Accountant)e);
                        added = true;
                    }
                    break;
                }
            }
        }
        return added;
    }
    public String getTeamStatus(){
        /*
        Should return a String that gives insight into this Manager and all their direct reports.
        It should return a string that is a combination of the TechnicalLead's employee status followed
        by each of their direct employee's status on subsequent lines. If the TechnicalLead has no reports it should
        print their employee status followed by the text " and no direct reports yet ".
        Example: "10 Kasey has 5 successful check ins and no direct reports yet".
        If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and
         is managing: /n 5 Niky has 2 successful check ins"
         */

        String Message = (super.toString() + "and is managing: \n");
        for (Employee employee : WorkForce) {
            Message = Message + employee.toString() + " \n";
        }
        return Message;
    }
    public ArrayList<Employee> getWorkForce(){
        return WorkForce;
    }

}
