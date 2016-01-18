package company.example.myapplication.descriptor;

/**
 * Created by admin on 1/17/2016.
 */
public class Street
{

    private String  name;
    private int     number;
    private String  state;

    public Street(String name, int number, String state) {
        this.name = name;
        this.number = number;
        this.state = state;
    }
    public Street(){
        //nada que hacer
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
