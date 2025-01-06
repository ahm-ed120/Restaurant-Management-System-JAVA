package Restaurant_Management_System_Project;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant_Management_System {

    public static int login() {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available.");
            return 0;
        }

        String username = console.readLine("Login: ");

        char[] passwordArray = console.readPassword("Password: ");
        String password = new String(passwordArray);

        String correctLogin = "ahmedullah6897@gmail.com";
        String correctPassword = "Ahmedullah1@";
        if (username.equals(correctLogin) && password.equals(correctPassword)) {
            System.out.println("Login successful.");
            return 1;
        } else {
            System.out.println("Incorrect username or password.");
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employee = new ArrayList<>();
        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Menu> menu = new ArrayList<>();
        ArrayList<Order> order = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("********RESTAURANT MANAGEMENT SYSTEM********");
        while (true) {
            System.out.println("\n***MAIN MENU***\n");
            System.out.println("1.Admin");
            System.out.println("2.Customer");
            System.out.println("0.Exit");

            int choice;
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input.Enter a valid input.");
                }
            }

            switch (choice) {
                case 1:// Admin portal
                    int a = login();
                    if (a == 0) {
                        break;
                    }
                    while (true) {
                        System.out.println("\n***ADMIN PORTAL***\n");
                        System.out.println("1.Manage Employee");
                        System.out.println("2.Manage Customer");
                        System.out.println("3.Manage Order");
                        System.out.println("4.Manage Menu");
                        System.out.println("0.Back");

                        int choice1;
                        while (true) {
                            try {
                                choice1 = input.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input.Enter a valid input.");
                            }
                        }

                        switch (choice1) {
                            case 1:// manage employee
                                while (true) {
                                    System.out.println("\n***MANAGE EMPLOYEE***\n");
                                    System.out.println("1.Add");
                                    System.out.println("2.Update");
                                    System.out.println("3.Delete");
                                    System.out.println("4.Display");
                                    System.out.println("5.Display Salary Slip");
                                    System.out.println("0.Back");

                                    int choice2;
                                    while (true) {
                                        try {
                                            choice2 = input.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid input.Enter a valid input.");
                                        }
                                    }

                                    switch (choice2) {
                                        case 1:
                                            while (true) {
                                                System.out.println();
                                                System.out.println("1.Chef");
                                                System.out.println("2.Waiter");
                                                System.out.println("3.Janitor");

                                                int choice3;
                                                while (true) {
                                                    try {
                                                        choice3 = input.nextInt();
                                                        break;
                                                    } catch (Exception e) {
                                                        System.out.println("Invalid input.Enter a valid input.");
                                                    }
                                                }

                                                switch (choice3) {
                                                    case 1:
                                                        Employee e = new Chef();
                                                        e.setter();
                                                        employee.add(e);
                                                        break;
                                                    case 2:
                                                        Employee e1 = new Waiter();
                                                        e1.setter();
                                                        employee.add(e1);
                                                        break;
                                                    case 3:
                                                        Employee e2 = new Janitor();
                                                        e2.setter();
                                                        employee.add(e2);
                                                        break;
                                                    default:
                                                        System.out.println("Invalid input.");
                                                        break;
                                                }

                                                if (choice3 == 1 || choice3 == 2 || choice3 == 3) {
                                                    break;
                                                }

                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter employee id to update: ");
                                            int employeeId;
                                            while (true) {
                                                try {
                                                    employeeId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Employee e : employee) {
                                                if (e.getEmployeeId() == employeeId) {
                                                    e.update();
                                                    System.out.println("Employee updated.");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter employee id to delete: ");
                                            while (true) {
                                                try {
                                                    employeeId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Employee e : employee) {
                                                if (e.getEmployeeId() == employeeId) {
                                                    employee.remove(e);
                                                    System.out.println("Employee deleted.");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            for (Employee e : employee) {
                                                e.display();
                                                System.out.println();
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Enter employee id to display salary slip: ");
                                            while (true) {
                                                try {
                                                    employeeId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Employee e : employee) {
                                                if (e.getEmployeeId() == employeeId) {
                                                    e.displaySalary();
                                                    break;
                                                }
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid input.");
                                            break;
                                    }

                                    if (choice2 == 0) {
                                        break;
                                    }
                                }
                                break;
                            case 2:// manage customer
                                while (true) {
                                    System.out.println("\n***MANAGE CUSTOMER***\n");
                                    System.out.println("1.Add");
                                    System.out.println("2.Update");
                                    System.out.println("3.Delete");
                                    System.out.println("4.Display");
                                    System.out.println("0.Back");

                                    int choice2;
                                    while (true) {
                                        try {
                                            choice2 = input.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid input.Enter a valid input.");
                                        }
                                    }

                                    switch (choice2) {
                                        case 1:
                                            Customer c = new Customer();
                                            c.setter();
                                            customer.add(c);
                                            break;
                                        case 2:
                                            System.out.println("Enter customer id to update: ");
                                            int customerId;
                                            while (true) {
                                                try {
                                                    customerId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Customer c1 : customer) {
                                                if (c1.getCustomerId() == customerId) {
                                                    c1.update();
                                                    System.out.println("Customer updated");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter customer id to delete: ");

                                            while (true) {
                                                try {
                                                    customerId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Customer c1 : customer) {
                                                if (c1.getCustomerId() == customerId) {
                                                    customer.remove(c1);
                                                    System.out.println("Customer Deleted");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            for (Customer c1 : customer) {
                                                c1.display();
                                                System.out.println();
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid input.");
                                            break;
                                    }

                                    if (choice2 == 0) {
                                        break;
                                    }
                                }
                                break;
                            case 3:// manage order
                                while (true) {
                                    System.out.println("\n***MANAGE ORDER***\n");
                                    System.out.println("1.Add");
                                    System.out.println("2.Update");
                                    System.out.println("3.Delete");
                                    System.out.println("4.Display");
                                    System.out.println("5.Display Recipt");
                                    System.out.println("0.Back");

                                    int choice2;
                                    while (true) {
                                        try {
                                            choice2 = input.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid input.Enter a valid input.");
                                        }
                                    }

                                    switch (choice2) {
                                        case 1:
                                            Order o = new Order();
                                            int x = o.setter(customer, menu);
                                            if (x == 1) {
                                                order.add(o);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter order id to update: ");
                                            int orderId;
                                            while (true) {
                                                try {
                                                    orderId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Order o1 : order) {
                                                if (o1.getOrderId() == orderId) {
                                                    int y = o1.update(customer, menu);
                                                    if (y == 1) {
                                                        System.out.println("Order updated");
                                                    } else {
                                                        System.out.println("Order not updated");
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter order id to delete: ");
                                            while (true) {
                                                try {
                                                    orderId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Order o1 : order) {
                                                if (o1.getOrderId() == orderId) {
                                                    order.remove(o1);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            for (Order o1 : order) {
                                                o1.display();
                                                System.out.println();
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Enter order id to generate recipt: ");
                                            while (true) {
                                                try {
                                                    orderId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Order o1 : order) {
                                                if (o1.getOrderId() == orderId) {
                                                    o1.generateRecipt();
                                                    break;
                                                }
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid input.");
                                            break;
                                    }

                                    if (choice2 == 0) {
                                        break;
                                    }
                                }
                                break;
                            case 4:// manage menu
                                while (true) {
                                    System.out.println("\n***MANAGE MENU***\n");
                                    System.out.println("1.Add");
                                    System.out.println("2.Update");
                                    System.out.println("3.Delete");
                                    System.out.println("4.Display");
                                    System.out.println("0.Back");

                                    int choice2;
                                    while (true) {
                                        try {
                                            choice2 = input.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid input.Enter a valid input.");
                                        }
                                    }

                                    switch (choice2) {
                                        case 1:
                                            Menu m = new Menu();
                                            m.setter();
                                            menu.add(m);
                                            break;
                                        case 2:
                                            System.out.println("Enter item id to update: ");
                                            int itemId;
                                            while (true) {
                                                try {
                                                    itemId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Menu m1 : menu) {
                                                if (m1.getItemId() == itemId) {
                                                    m1.update();
                                                    System.out.println("Menu updated");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter item id to update: ");
                                            while (true) {
                                                try {
                                                    itemId = input.nextInt();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid input.Enter a valid input.");
                                                }
                                            }

                                            for (Menu m1 : menu) {
                                                if (m1.getItemId() == itemId) {
                                                    menu.remove(m1);
                                                    System.out.println("Menu deleted");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            for (Menu m1 : menu) {
                                                m1.display();
                                                System.out.println();
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid input.");
                                            break;
                                    }

                                    if (choice2 == 0) {
                                        break;
                                    }
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid input.");
                                break;

                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 2:// customer portal
                    while (true) {
                        System.out.println("\n***CUSTOMER PORTAL***\n");
                        System.out.println("1.Add Order");
                        System.out.println("2.Update Order");
                        System.out.println("3.Delete Order");
                        System.out.println("4.Display Recipt");
                        System.out.println("0.Back");

                        int choice1;
                        while (true) {
                            try {
                                choice1 = input.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input.Enter a valid input.");
                            }
                        }

                        switch (choice1) {
                            case 1:
                                Order o = new Order();
                                int x = o.setter(customer, menu);
                                if (x == 1) {
                                    order.add(o);
                                }
                                break;
                            case 2:
                                System.out.println("Enter order id to update: ");
                                int orderId;
                                while (true) {
                                    try {
                                        orderId = input.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input.Enter a valid input.");
                                    }
                                }

                                for (Order o1 : order) {
                                    if (o1.getOrderId() == orderId) {
                                        int y = o1.update(customer, menu);
                                        if (y == 1) {
                                            System.out.println("Order updated");
                                        } else {
                                            System.out.println("Order not updated");
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Enter order id to delete: ");
                                while (true) {
                                    try {
                                        orderId = input.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input.Enter a valid input.");
                                    }
                                }

                                for (Order o1 : order) {
                                    if (o1.getOrderId() == orderId) {
                                        order.remove(o1);
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Enter order id to generate recipt: ");
                                while (true) {
                                    try {
                                        orderId = input.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input.Enter a valid input.");
                                    }
                                }

                                for (Order o1 : order) {
                                    if (o1.getOrderId() == orderId) {
                                        o1.generateRecipt();
                                        break;
                                    }
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid input.");
                                break;
                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            if (choice == 0) {
                System.out.println("Good Bye!!");
                break;
            }

        }
    }
}
