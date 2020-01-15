package Task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8188);
            System.out.println("Server started");

            socket = serverSocket.accept();
            System.out.println("Client connection");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Car car11 = (Car)objectInputStream.readObject();
                Car car22 = (Car)objectInputStream.readObject();
                Car car33 = (Car)objectInputStream.readObject();

                car11.infoCar();
                car22.infoCar();
                car33.infoCar();
                objectInputStream.close();
                socket.close();
                serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
