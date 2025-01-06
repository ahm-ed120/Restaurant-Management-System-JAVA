package Restaurant_Management_System_Project;

import java.util.Scanner;

public class Employee extends Person implements EmployeeInfo {
    private int employeeId;
    private double salary;
    private int year;
    private double totalSalary;
    private double bonus;

    Employee() {
        super();
        employeeId = 0;
        salary = 0.0;
        year = 0;
        totalSalary = 0.0;
        bonus = 0.0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void setter() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter employee id: ");
                employeeId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for employee id.");
                input.nextLine();
            }
        }

        System.out.println("Enter name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter address: ");
        address = input.nextLine();

        System.out.println("Enter phone number: ");
        phoneNo = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter the number of year you have worked with us: ");
                year = input.nextInt();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for employee id.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter salary: ");
                salary = input.nextDouble();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
                input.nextLine();
            }
        }

        bonus = calculateBonus();
        totalSalary = salary + bonus;

    }

    @Override
    public void update() {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter new employee id: ");
                employeeId = input.nextInt();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for employee id.");
                input.nextLine();

            }
        }

        System.out.println("Enter new name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter new age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter new address: ");
        address = input.nextLine();

        System.out.println("Enter new phone number: ");
        phoneNo = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter the number of year you have worked with us: ");
                year = input.nextInt();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for number of year.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter salary: ");
                salary = input.nextDouble();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
                input.nextLine();
            }
        }

        bonus = calculateBonus();
        totalSalary = salary + bonus;

    }

    @Override
    public void display() {
        System.out.println("Employee id: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Base Salary: " + salary);
        System.out.println("Total Salary: " + totalSalary);
    }

    @Override
    public double calculateBonus() {
        double bonusPercentage;

        if (year >= 10) {
            bonusPercentage = 0.20;
        } else if (year >= 5) {
            bonusPercentage = 0.10;
        } else if (year >= 2) {
            bonusPercentage = 0.05;
        } else {
            bonusPercentage = 0.02;
        }

        return salary * bonusPercentage;

    }

    @Override
    public void displaySalary() {
        System.out.println("=====================================================================");
        System.out.println("                          Salary Slip                                ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + employeeId);
        System.out.println("Employee Name      : " + name);
        System.out.println("Base Salary        : $" + String.format("%.2f", salary));
        System.out.println("Bonus              : $" + String.format("%.2f", bonus));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", totalSalary));
        System.out.println("======================================================================");

    }

}
