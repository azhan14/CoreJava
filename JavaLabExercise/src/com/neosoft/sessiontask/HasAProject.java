package com.neosoft.sessiontask;

public class HasAProject {

	public static void main(String[] args) {
		Project mobile = new Project(1, "Mobile App for Project management", "Mumbai");
		Project web = new Project(2, "E-Commerce Web App", "Pune");
		
		Employee E1 = new Employee(1, "Azhan", 29000.0, mobile);
		Employee E2 = new Employee(2, "Pratham", 27000.0, mobile);
		Employee E3 = new Employee(3, "Asim", 28000.0, web);
		Employee E4 = new Employee(4, "Amaan", 24000.0, web);
		
		Employee[] E = {E1,E2,E3,E4};
		for(Employee e: E) {
			if((e.esal > 25000) && (e.project == web)) {
				System.out.println("Employee ID: "+e.eid);
				System.out.println("Employee Name: "+e.ename);
				System.out.println("Employee Salary: "+e.esal);
				System.out.println("Employee Project ID: "+e.project.pid);
				System.out.println("Employee Project Name: "+e.project.pname);
				System.out.println("Employee Project Location: "+e.project.plocation);
				System.out.println("=================================================");
			}
		}
	}

}

class Employee{
	int eid;
	String ename;
	double esal;
	Project project;
	public Employee(int eid, String ename, double esal, Project project) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.project = project;
	}
}

class Project{
	int pid;
	String pname;
	String plocation;
	public Project(int pid, String pname, String plocation) {
		this.pid = pid;
		this.pname = pname;
		this.plocation = plocation;
	}
	
}