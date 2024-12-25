package Restaurant_Management_System_Project;

import java.util.Scanner;

public class Chef extends Employee {
    private String specialtyCuisine;

    public Chef() {
        super();
        specialtyCuisine = null;
    }

    public String getSpecialtyCuisine() {
        return specialtyCuisine;
    }

    public void setSpecialtyCuisine(String specialtyCuisine) {
        this.specialtyCuisine = specialtyCuisine;
    }

    public void setter() {
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your specialty Cuisine: ");
        specialtyCuisine = input.nextLine();
    }

    public void update(){
        super.update();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your specialty Cuisine: ");
        specialtyCuisine = input.nextLine();
    }

    public void display() {
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Specialty Cuisine: " + specialtyCuisine);
        System.out.println("Base Salary: " + getSalary());
        System.out.println("Total Salary: " + getTotalSalary());

    }

    public void displaySalary(){
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + getEmployeeId());
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee Type      : Chef");
        System.out.println("Base Salary        : $" + String.format("%.2f", getSalary()));
        System.out.println("Bonus              : $" + String.format("%.2f", getBonus()));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", getTotalSalary()));
        System.out.println("----------------------------------------------------------------------");

    }


}
