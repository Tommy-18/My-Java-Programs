import java.util.*;
public class TechnicalLead extends TechnicalEmployee implements java.lang.reflect.Type{
    private final int headcount;
    private Accountant TechAccountant;
    private ArrayList <Employee> WorkForce = new ArrayList<Employee>();
    private int DirectReports;
    public TechnicalLead(String name){
        /*
        Should create a new TechnicalLead that is a Manager.
        The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee.
        TechnicalLeads should have a default head count of 4.
         */
        super(name,1.3);
        this.headcount = 4;
        super.assignManager(this);
    }
    public int getHeadcount(){
        return WorkForce.size();
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
    public boolean addReport(SoftwareEngineer e){
        /*
        Should accept the reference to a SoftwareEngineer object, and if the TechnicalLead has head count left should
        add this employee to their list of direct reports. If the employee is successfully added to the
        TechnicalLead's direct reports true should be returned, false should be returned otherwise
         */
        boolean added = false;
        if (WorkForce.size() < this.headcount){
            WorkForce.add(e);
            added = true;
        }
        return added;
    }
    public boolean approveCheckIn(SoftwareEngineer e){
        /*
        Should see if the employee passed in does report to this manager and if their code access is currently set
        to "true". If both those things are true, true is returned, otherwise false is returned
         */
        boolean approved = false;
        if (e.getCodeAccess() & WorkForce.contains(e)){
            approved = true;
            this.DirectReports++;
        }
        return approved;
    }
    public void assignAccountant(Accountant e, TechnicalLead tl){
        tl.TechAccountant = e;
    }
    public boolean requestBonus(Employee e, double bonus){
        /*
        Should check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
        If it is, that employee should get that bonus and true should be returned. False should be returned otherwise
         */
        return this.TechAccountant.getManager().requestBonus(e,bonus);

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

        String Message = (this.toString() + " and is managing: \n");
        for (Employee employee : WorkForce) {
            try{
                Message = Message + ((SoftwareEngineer)employee).employeeStatus() + " \n";
            } catch (Exception e){
                Message = Message + ((Accountant)employee).employeeStatus() + " \n";
            }
        }

        if (this.DirectReports == 0){
            Message = Message + " \n and no direct reports yet!";
        }
        return Message;
    }
    public ArrayList<Employee> getWorkForce(){
        return WorkForce;
    }


}
