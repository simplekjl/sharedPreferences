package company.example.myapplication.descriptor;

/**
 * Created by admin on 1/15/2016.
 */
public class Contact {
    private int     id;
    private String  name;

    private int     phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact(int id, String name, int phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }
    public Contact()
    {

    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
