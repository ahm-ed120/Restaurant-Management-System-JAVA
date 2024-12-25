package Restaurant_Management_System_Project;

public abstract class Person {

    protected String name;
    protected int age;
    protected String address;
    protected String phoneNo;

    Person() {
        name = null;
        age = 0;
        address = null;
        phoneNo = null;
    }

    public abstract void setter();

    public abstract void update();

    public abstract void display();

}
