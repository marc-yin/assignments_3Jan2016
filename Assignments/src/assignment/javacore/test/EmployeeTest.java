package assignment.javacore.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import assignment.javacore.Employee;
import assignment.javacore.exception.SalaryException;
import assignment.javacore.exception.WorkingHoursException;

public class EmployeeTest {
	private static final double DELTA = 1e-15;
	
	@Test  
	public void testCalculatePayment_Normal() throws SalaryException, WorkingHoursException {
		Employee tester1 = new Employee(8, 34);
		assertEquals("(8$/h, 34h) salary must be: ", 272.0, tester1.calculatePayment(), DELTA);
	}

	@Test(expected = SalaryException.class)   
	public void testCalculatePayment_SalaryException() throws SalaryException, WorkingHoursException {
		Employee tester1 = new Employee(4.5, 36);
		tester1.calculatePayment();
	}
	
	@Test(expected = WorkingHoursException.class)   
	public void testCalculatePayment_WorkingHoursException() throws SalaryException, WorkingHoursException {
		Employee tester1 = new Employee(12, 89);
		tester1.calculatePayment();
	}

}
