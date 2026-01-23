package model;

public abstract class Employee {
    protected int id;
    protected String name;
    protected double salary;

    public Employee(int id, String name, double salary) {
        setId(id);
        setName(name);
        setSalary(salary);
    }

    public abstract void work();

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name is empty");
        this.name = name.trim();
    }

    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary < 0");
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee | " + id + " | " + name + " | " + salary;
    }
}
