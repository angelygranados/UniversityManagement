package Data;

public class PartTimeTeacher extends Teacher{
    private int activeHours;

    public PartTimeTeacher(String name, String email, int activeHours) {
        super(name, email);
        this.activeHours = activeHours;
    }

    public int getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(int activeHours) {
        this.activeHours = activeHours;
    }


    @Override
    public double getSalary() {
        return super.getBaseSalary() * this.activeHours;
    }
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Email: " + this.getEmail() + ", Dedication: Part time, Weekly hours: " + this.getActiveHours() + " hrs, Salary: " + this.getSalary();
    }
}
