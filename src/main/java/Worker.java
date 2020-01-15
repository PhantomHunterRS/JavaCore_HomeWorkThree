import java.io.Serializable;


public class Worker implements Serializable {
    int id;
    String firstName;
    String middleName;
    String lastName;
    double hours;
    int rate;

    public Worker(int _id, String _firstName, String _middleName, String _lastName, double _hours, int _rate) {
        id = _id;
        firstName = _firstName;
        middleName = _middleName;
        lastName = _lastName;
        hours = _hours;
        rate = _rate;
    }
    public void info(){
        System.out.println(id + " " + firstName + " " + middleName + " " + lastName + " " + hours + " " + rate);
    }
}