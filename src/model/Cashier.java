package model;
public class Cashier extends Employee {
    private int registerNumber;
    public Cashier(int id, String name, double salary, int registerNumber) {
        super(id, name, salary);
        setRegisterNumber(registerNumber);
    }
    public int getRegisterNumber() {
        return registerNumber;
    }
    public void setRegisterNumber(int registerNumber) {
        if (registerNumber <= 0)
            throw new IllegalArgumentException(("Register number cann ot be lower than 0"));
            this.registerNumber = registerNumber;
    }
    @Override
    public void work() {
        System.out.println("Cashier works at register " + registerNumber);
    }
    @Override
    public String toString() {
        return "Cashier " + id + " " + name + " " + salary + " reg=" + registerNumber;
    }
}