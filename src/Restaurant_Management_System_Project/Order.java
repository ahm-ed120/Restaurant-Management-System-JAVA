package Restaurant_Management_System_Project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Order implements OrderInfo {
    private static int referenceCounter = 0;
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
        totalBill = 0.0;
        discount = 0.0;
        redeemPoints = 0;
        customer = new Customer();
        referenceCounter++;
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

    public static int getReferenceCounter() {
        return referenceCounter;
    }

    public static void setReferenceCounter(int referenceCounter) {
        Order.referenceCounter = referenceCounter;
    }

    private void applyDiscount() {
        double discountPercentage = redeemPoints / 10.0;

        discount = totalPrice * (discountPercentage / 100);
    }

    public int setter(ArrayList<Customer> availableCustomer, ArrayList<Menu> availableMenu) {
        int found = 0;

        Scanner input = new Scanner(System.in);

        orderId = referenceCounter;

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
            while (true) {
                System.out.println("Customer not found. Do you want to add customer (y/n):");
                String inputString = input.next().toLowerCase();

                if (inputString.length() == 1) {
                    char option = inputString.charAt(0);

                    if (option == 'y') {
                        customer = new Customer();
                        customer.setter();
                        availableCustomer.add(customer);
                        break;
                    } else if (option == 'n') {
                        System.out.println("Exiting... No order placed.");
                        return 0;
                    } else {
                        System.out.println("Error! Invalid input.");
                    }
                } else {
                    System.out.println("Error! Please enter a single character ('y' or 'n').");
                }
            }

        }

        if (availableMenu == null){
            System.out.println("Menu is not available!!!");
            return 0;
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

        while (true) {
            System.out.println("Do you want to redeem loyalty points? (y/n)");
            String inputString = input.next().toLowerCase();
        
            if (inputString.length() == 1) {
                char option = inputString.charAt(0);
        
                if (option == 'y') {
                    if(customer.getLoyaltyPoints()==0){
                        System.out.println("Sorry you have zero loyalty points.");
                        break;
                    }
                    System.out.println("Available loyalty points: " + customer.getLoyaltyPoints());
                    int redeemPoint;
        
                    while (true) {
                        try {
                            System.out.println("Enter redeem points: ");
                            redeemPoint = input.nextInt();
                            input.nextLine();
        
                            if (redeemPoint > customer.getLoyaltyPoints()) {
                                System.out.println("You don't have enough loyalty points. Please try again.");
                            } else if (redeemPoint > 300) {
                                System.out.println("You cannot redeem more than 300 points. Please try again.");
                            } else {
                                this.redeemPoints = redeemPoint;
                                System.out.println("Successfully redeemed " + redeemPoint + " points.");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for redeem points.");
                            input.nextLine(); 
                        }
                    }
                    break; 
                } else if (option == 'n') {
                    System.out.println("No loyalty points redeemed.");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } else {
                System.out.println("Error! Please enter a single character ('y' or 'n').");
            }
        }
        
        if (redeemPoints > 0) {
            applyDiscount();
            totalBill = totalPrice - discount;
            int loyaltyPoints = customer.getLoyaltyPoints() - redeemPoints;
            customer.setLoyaltyPoints(loyaltyPoints);
        } else {
            totalBill = totalPrice;
        }

        customer.increamentOrderCount();
        return 1;

    }

    public int update(ArrayList<Customer> availableCustomer, ArrayList<Menu> availableMenu) {
        int found = 0;

        int loyaltyPoints = customer.getLoyaltyPoints() + redeemPoints;
        customer.setLoyaltyPoints(loyaltyPoints);

        Scanner input = new Scanner(System.in);

        int customerId = 0;
        while (true) {
            try {
                System.out.println("Enter new Customer id: ");
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
            while (true) {
                System.out.println("Customer not found. Do you want to add customer (y/n):");
                String inputString = input.next().toLowerCase();

                if (inputString.length() == 1) {
                    char option = inputString.charAt(0);

                    if (option == 'y') {
                        customer = new Customer();
                        customer.setter();
                        availableCustomer.add(customer);
                        break;
                    } else if (option == 'n') {
                        System.out.println("Exiting... No order placed.");
                        return 0;
                    } else {
                        System.out.println("Error! Invalid input.");
                    }
                } else {
                    System.out.println("Error! Please enter a single character ('y' or 'n').");
                }
            }

        }

        menu.clear();
        quantities.clear();

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

        while (true) {
            System.out.println("Do you want to redeem loyalty points? (y/n)");
            String inputString = input.next().toLowerCase();

            if (inputString.length() == 1) {
                char option = inputString.charAt(0);

                if (option == 'y') {
                    System.out.println("Available loyalty points: " + customer.getLoyaltyPoints());
                    int redeemPoints;
                    while (true) {
                        try {
                            System.out.println("Enter redeem points: ");
                            redeemPoints = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid input for redeem points.");
                            input.nextLine();
                        }
                    }

                    if (redeemPoints > customer.getLoyaltyPoints()) {
                        System.out.println("You dont have enough loyalty point.");
                        break;
                    } else if (redeemPoints > 300) {
                        System.out.println("You can not redeem more than 300 points");
                        break;
                    } else {
                        this.redeemPoints = redeemPoints;
                        break;
                    }

                } else if (option == 'n') {
                    break;
                } else {
                    System.out.println("Invalid input.");
                }

            } else {
                System.out.println("Error! Please enter a single character ('y' or 'n').");
            }
        }
        if (redeemPoints > 0) {
            applyDiscount();
            totalBill = totalPrice - discount;
            loyaltyPoints = customer.getLoyaltyPoints() - redeemPoints;
            customer.setLoyaltyPoints(loyaltyPoints);
        } else {
            totalBill = totalPrice;
        }

        customer.increamentOrderCount();
        return 1;

    }

    public void display(){
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

    public void generateRecipt() {
        System.out.println("======================================");
        System.out.println("                RECIPT                ");
        System.out.println("======================================");
        System.out.printf("Order ID: %d%n", orderId);
        System.out.printf("Customer ID: %s%n", customer.getCustomerId());
        System.out.printf("Customer Name: %s%n", customer.name);
        System.out.println("--------------------------------------");
        System.out.printf("%-20s %5s %10s%n", "Item", "Qty", "Price");
        System.out.println("--------------------------------------");

        for (int i = 0; i < menu.size(); i++) {
            Menu item = menu.get(i);
            int qty = quantities.get(i);
            double itemTotal = item.getPrice() * qty;
            System.out.printf("%-20s %5d %10.2f%n", item.getName(), qty, itemTotal);
        }

        System.out.println("--------------------------------------");
        System.out.printf("Subtotal: %28.2f%n", totalPrice);
        System.out.printf("Discount: %28.2f%n", discount);
        System.out.printf("Total Bill: %26.2f%n", totalBill);
        System.out.println("======================================");
    }

}
