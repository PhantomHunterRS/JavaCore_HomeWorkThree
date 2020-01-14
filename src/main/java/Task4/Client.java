package Task4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost",8188);
                Car car1  = new Car("Audi","RS3",2.480,"Black",250,"Hatchback");
                Car car2  = new Car("BMW","M3",4.000,"Blue",250,"Sedan");
                Car car3  = new Car("Mercedes-AMG","E43",2.996,"White",250,"Sedan");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(car1);
            objectOutputStream.writeObject(car2);
            objectOutputStream.writeObject(car3);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
