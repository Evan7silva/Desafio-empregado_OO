package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Department name: ");
		String name = sc.nextLine();
		System.out.print("Pay day: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Phone: ");
		String phone = sc.nextLine();
		Department dept = new Department(name, payDay, new Address(email, phone));
		
		System.out.print("How many employees does the department have? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Employee daata " + (i+1) + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employee emp = new Employee(employeeName, salary);
			dept.addEmployee(emp);
		}
		
		showReport(dept);
		
		
		sc.close();

	}
	
	private static void showReport(Department dept) {
		System.out.println("PAYROLL: ");
		System.out.print("Sales department = R$ " + String.format("%.2f", dept.payroll()) + "\n");
		System.out.print("Payment made on the day " + dept.getPayDay() + "\n");
		System.out.println("Employees: ");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		
		System.out.println("For any queries, please get in touch: " + dept.getAddress().getEmail());
	
		
		
	}

}
