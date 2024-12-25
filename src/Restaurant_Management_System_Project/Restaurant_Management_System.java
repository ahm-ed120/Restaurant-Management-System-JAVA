package Restaurant_Management_System_Project;

import java.util.ArrayList;

public class Restaurant_Management_System {

    public static void main(String[] args) {
        ArrayList<Customer> customer = new ArrayList<>();
        ArrayList<Menu> menu = new ArrayList<>();
        Customer c = new Customer();
        Menu m = new Menu();
        c.setter();
        m.setter();
        customer.add(c);
        menu.add(m);

        Order order = new Order();
        order.setter(customer, menu);
        order.generateRecipt();
        order.setter(customer, menu);
        order.generateRecipt();
        order.setter(customer,menu);

    }
    
    
}
