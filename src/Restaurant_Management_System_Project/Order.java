package Restaurant_Management_System_Project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Order implements OrderInfo {
    private int orderId;
    private ArrayList<Integer> quantities;
    private double totalPrice;
    private double totalBill;
    private int redeemPoints;
    private double discount;
    private Customer customer;
    private ArrayList<Menu> menu;

    Order() {
        menu = new ArrayList<>();
        orderId = 0;
        quantities = new ArrayList<>();
        totalPrice = 0.0;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public int getRedeemPoints() {
        return redeemPoints;
    }

    public void setRedeemPoints(int redeemPoints) {
        this.redeemPoints = redeemPoints;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setter(ArrayList<Customer> availableCustomer, ArrayList<Menu> availableMenu) {
        int found = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter order id: ");
        orderId = input.nextInt();

        System.out.println("Enter Customer id: ");
        int customerId = input.nextInt();

        for (Customer c : availableCustomer) {
            if (customerId == c.getCustomerId()) {
                found = 1;
                customer = c;
                break;
            }
        }

        if (found == 0) {
            System.out.println("Customer not found. Do you want to add customer(y/n)");
            char option = input.next().toLowerCase().charAt(0);

            if (option == 'y') {
                customer = new Customer();
                customer.setter();
                availableCustomer.add(customer);
            }

            else if (option == 'n') {
                return;
            }

            else {
                System.out.println("Error!! Invalid input.");
                return;
            }
        }

        System.out.println("***Menu***");
        for (Menu m : availableMenu) {
            m.display();
        }

        while (true) {
            System.out.println("Enter item id to order (or -1 to finish):");
            int itemId = input.nextInt();

            if (itemId == -1) {
                break;
            }

            Menu selectedItem = null;

            for (Menu m : availableMenu) {
                if (itemId == m.getItemId()) {
                    selectedItem = m;
                    break;
                }
            }

            if (selectedItem == null) {
                System.out.println("Invalid item id. Try again");
                continue;
            }

            System.out.println("Enter quantity for " + selectedItem.getName() + ": ");
            int quantity = input.nextInt();

            menu.add(selectedItem);
            quantities.add(quantity);
            totalPrice = selectedItem.getPrice() * quantity;

        }

    }

    public void update(ArrayList<Customer> availableCustomer, ArrayList<Menu> availableMenu) {
        int found = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter order id: ");
                orderId = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for order id.");
                input.nextLine();
            }
        }

        int customerId = 0;
        while (true) {
            try {
                System.out.println("Enter Customer id: ");
                customerId = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for customer id.");
                input.nextLine();
            }
        }

        for (Customer c : availableCustomer) {
            if (customerId == c.getCustomerId()) {
                found = 1;
                customer = c;
                break;
            }
        }

        if (found == 0) {
            System.out.println("Customer not found. Do you want to add customer (y/n):");
            char option = input.next().toLowerCase().charAt(0);

            if (option == 'y') {
                customer = new Customer();
                customer.setter();
                availableCustomer.add(customer);
            } else if (option == 'n') {
                System.out.println("Exiting... No order placed.");
                return;
            } else {
                System.out.println("Error! Invalid input.");
                return;
            }
        }

        System.out.println("***Menu***");
        for (Menu m : availableMenu) {
            m.display();
        }

        while (true) {
            int itemId = 0;

            while (true) {
                try {
                    System.out.println("Enter item id to order (or -1 to finish):");
                    itemId = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for item id.");
                    input.nextLine();
                }
            }

            if (itemId == -1) {
                break;
            }

            Menu selectedItem = null;

            for (Menu m : availableMenu) {
                if (itemId == m.getItemId()) {
                    selectedItem = m;
                    break;
                }
            }

            if (selectedItem == null) {
                System.out.println("Invalid item id. Try again.");
                continue;
            }

            int quantity = 0;
            while (true) {
                try {
                    System.out.println("Enter quantity for " + selectedItem.getName() + ": ");
                    quantity = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for quantity.");
                    input.nextLine();
                }
            }

            menu.add(selectedItem);
            quantities.add(quantity);
            totalPrice += selectedItem.getPrice() * quantity;
        }

        customer.increamentOrderCount();

    }

    

    public void generateRecipt() {
        System.out.println("***ORDER***");
        System.out.println("Order id: " + orderId);
        System.out.println("Customer Id: " + customer.getCustomerId());
        System.out.println("Customer name: " + customer.name);
        for (int i = 0; i < menu.size(); i++) {
            Menu item = menu.get(i);
            int qty = quantities.get(i);
            System.out.println(item.getName() + " x" + qty + " = " + (item.getPrice() * qty));
        }
        System.out.println("Total bill: " + totalPrice);

    }

}
