package Restaurant_Management_System_Project;

import java.util.ArrayList;

public class Restaurant_Management_System {

    public static void main(String[] args) {
        ArrayList <Menu> menu = new ArrayList<>();
        ArrayList <Customer> customer = new ArrayList<>();
        Order o = new Order();

        Menu m = new Menu();
        m.setter();
        menu.add(m);
        Customer c = new Customer();
        c.setter();
        customer.add(c);
        o.setter(customer, menu);

        System.out.println();
        for (Customer c1 : customer){
            c1.display();
        }

        o.generateRecipt();
    }
    
    
}
