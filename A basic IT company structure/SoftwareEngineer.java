public class SoftwareEngineer extends TechnicalEmployee{
    private boolean CodeAccess;
    public SoftwareEngineer(String name){
        /*
        Should start without access to code and with 0 code check ins
         */
        super(name);
        this.CodeAccess = false;
    }
    public boolean getCodeAccess(){
        /*
        Should return whether or not this SoftwareEngineer has access to make changes to the code base
         */
        return this.CodeAccess;
    }
    public void setCodeAccess(boolean access){
        /*
        Should allow an external piece of code to update the SoftwareEngieer's code privileges to either true or false
         */
        this.CodeAccess = access;
    }
    public boolean checkInCode(){
        /*
        Should check if this SoftwareEngineer's manager approves of their check in. If the check in is approved their
        successful checkin count should be increased and the method should return "true". If the manager does not
        approve the check in the SoftwareEngineer's code access should be changed to false and the method should return
         "false"
        */
        if(super.getManager().approveCheckIn(this)== true){
            this.addCheckIns(1);
        }
        return super.getManager().approveCheckIn(this);
    }

}
