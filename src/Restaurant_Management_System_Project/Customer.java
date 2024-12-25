package Restaurant_Management_System_Project;

import java.util.Scanner;

public class Customer extends Person {
    private int customerId;
    private int orderCount;
    private int loyaltyPoints;

    Customer() {
        super();
        customerId = 0;
        orderCount = 0;
        loyaltyPoints = 0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void increamentOrderCount(){
        orderCount++;
        calculateLoyaltyPoints();
    }

    private void calculateLoyaltyPoints(){
        this.loyaltyPoints += 10;
    }

    public void setter() {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter customer id: ");
                customerId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for customer id.");
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
    }

    public void update() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter new customer id: ");
                customerId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for customer id.");
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
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter new address: ");
        address = input.nextLine();

        System.out.println("Enter new phone number: ");
        phoneNo = input.nextLine();
    }

    public void display() {
        System.out.println("Customer id: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
    }
}
