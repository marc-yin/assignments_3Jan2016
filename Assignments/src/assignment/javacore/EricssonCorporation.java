package assignment.javacore;

import assignment.javacore.exception.SalaryException;
import assignment.javacore.exception.WorkingHoursException;

public class EricssonCorporation {
    
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee(7.5, 35);
        employees[1] = new Employee(8.2, 47);
        employees[2] = new Employee(10.0, 73);
            
        for(Employee e : employees){
            try {
				e.calculatePayment();
			} catch (SalaryException | WorkingHoursException e1) {
				System.out.println("Employee " + e.getEmployeeID() + ": \n" + e1.getMessage() );
			}
        }    
    }
}
