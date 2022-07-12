package Inheritance;

public class Client extends Person {
    private String status;

    public Client(String name, String surname, String status) {
        super(name, surname);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
