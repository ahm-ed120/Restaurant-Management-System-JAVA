package Restaurant_Management_System_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee {
    ArrayList<Integer> tableAssigned;
    double tipRecived;

    public Waiter() {
        super();
        tableAssigned = new ArrayList<>();
        tipRecived = 0.0;
    }

    public ArrayList<Integer> getTableAssigned() {
        return tableAssigned;
    }

    public void setTableAssigned(ArrayList<Integer> tableAssigned) {
        this.tableAssigned = tableAssigned;
    }

    public double getTipRecived() {
        return tipRecived;
    }

    public void setTipRecived(double tipRecived) {
        this.tipRecived = tipRecived;
    }

    public void setter() {
        super.setter();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter the table number assigned to you (or -1 to finish): ");
                int table = input.nextInt();

                if (table == -1) {
                    break;
                }

                tableAssigned.add(table);

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for assigned table.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter total tip you recieved: ");
                tipRecived = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for tip recived.");
                input.nextLine();
            }
        }

        double total = super.getTotalSalary() + tipRecived;
        super.setTotalSalary(total);

    }

    public void update() {
        tableAssigned.clear();
        super.setter();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter the table number assigned to you (or -1 to finish): ");
                int table = input.nextInt();

                if (table == -1) {
                    break;
                }

                tableAssigned.add(table);

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter total tip you recieved: ");
                tipRecived = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for tip recived.");
                input.nextLine();
            }
        }

        double total = super.getTotalSalary() + tipRecived;
        super.setTotalSalary(total);

    }

    public void display() {
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.print("Assigned Tables: ");
        for (int i = 0; i < tableAssigned.size(); i++) {
            System.out.print(tableAssigned.get(i));
            if (i < tableAssigned.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Base Salary: " + getSalary());
        System.out.println("Total Salary: " + getTotalSalary());
    }

    public void displaySalary() {
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + getEmployeeId());
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee Type      : Waitor");
        System.out.println("Base Salary        : $" + String.format("%.2f", getSalary()));
        System.out.println("Bonus              : $" + String.format("%.2f", getBonus()));
        System.out.println("Tip recived        : $" + String.format("%.2f", tipRecived));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", getTotalSalary()));
        System.out.println("----------------------------------------------------------------------");

    }
}
