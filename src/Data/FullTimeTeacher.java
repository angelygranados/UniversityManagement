package Data;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;

    public FullTimeTeacher(String name, String email, int experienceYears) {
        super(name, email);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public double getSalary() {
        return super.getBaseSalary() * (this.experienceYears * 1.1);
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Email: " + this.getEmail() + ", Dedication: Full time, Experience: " + this.getExperienceYears() + " years, Salary: " + this.getSalary();
    }

}
