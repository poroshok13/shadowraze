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
        if (registerNumber <= 0) {
            System.out.println("Invalid register number");
            return;
        }
        this.registerNumber = registerNumber;
    }

    @Override
    public void work() {
        System.out.println("Cashier scans products at register " + registerNumber);
    }

    @Override
    public String toString() {
        return "Cashier | ID: " + id + ", Name: " + name +
                ", Salary: " + salary + ", Register: " + registerNumber;
    }
}
