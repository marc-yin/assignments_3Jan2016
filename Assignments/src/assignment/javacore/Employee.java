package assignment.javacore;

import assignment.javacore.exception.SalaryException;
import assignment.javacore.exception.WorkingHoursException;

public class Employee{
    public static final double MAX_WEEKLY_HOURS = 60.0;
    public static final double MIN_HOURLY_RATE = 8.0;
    public static final double THRESHOLD_HOURS = 40.0;
    public static final double OVERWORK_FACTOR = 1.5;
    
    private static int nextID = 1;
    private int employeeID;
    private double payBase;
    private double hoursWorked;
    
    public Employee(double payBase, double hoursWorked){
        employeeID = nextID;
        this.payBase = payBase;
        this.hoursWorked = hoursWorked;
        setID();
    }
    
    public double calculatePayment() throws SalaryException, WorkingHoursException {
        double salary = 0.0;
        
        if(payBase < MIN_HOURLY_RATE)
        {
        	throw new SalaryException("Province of Quebec requires that hourly employees be paid at least $8.00 an hour.");
        } 
        else if(hoursWorked > MAX_WEEKLY_HOURS)
        {
            throw new WorkingHoursException("Company requires that an employee not work more than 60 hours in a week.");
        } 
        else if(hoursWorked > THRESHOLD_HOURS)
        {
            double overworkedHours = hoursWorked - THRESHOLD_HOURS;
            salary = THRESHOLD_HOURS * payBase + overworkedHours * payBase * OVERWORK_FACTOR;
            System.out.println("Employee " + employeeID + "'s total pay: " + salary);
        } 
        else 
        {
            salary = hoursWorked * payBase;
            System.out.println("Employee " + employeeID + "'s total pay: " + salary);
        }
		return salary;
    }
    
    public void setID(){
        employeeID = nextID++;
    }

	public int getEmployeeID() {
		return employeeID;
	}
}
