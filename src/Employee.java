public class Employee {

    protected int id;
    protected String name;
    protected double salary;

    public Employee(int id, String name, double salary) {
        setId(id);
        setName(name);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be negative");
            return;
        }
        this.salary = salary;
    }

    public void work() {
        System.out.println("Employee is working");
    }

    @Override
    public String toString() {
        return "Employee | ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}
