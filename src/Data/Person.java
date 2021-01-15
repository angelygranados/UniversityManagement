package Data;

public class Person {
    private static int ID = 1;
    private int id;
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        id = ID;
        ID++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
