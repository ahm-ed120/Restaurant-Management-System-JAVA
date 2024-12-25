package Restaurant_Management_System_Project;

import java.util.Scanner;

public class Janitor extends Employee {
    String area;

    public Janitor (){
        super();
        area = null;

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setter(){
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter area of work: ");
        area = input.nextLine();
    }

    public void update(){
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new area of work: ");
        area = input.nextLine();

    }

    public void display (){
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Area of work: " + area);
        System.out.println("Base Salary: " + getSalary());
        System.out.println("Total Salary: " + getTotalSalary());

    }

    public void displaySalary(){
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + getEmployeeId());
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee Type      : Janitor");
        System.out.println("Base Salary        : $" + String.format("%.2f", getSalary()));
        System.out.println("Bonus              : $" + String.format("%.2f", getBonus()));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", getTotalSalary()));
        System.out.println("----------------------------------------------------------------------");

    }
}
