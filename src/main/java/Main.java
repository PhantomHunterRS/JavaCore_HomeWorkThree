import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
       // Task 1
        try(FileInputStream input = new FileInputStream("src/main/java/task1.txt")){
            byte [] arrays = new byte[512];
            int x;
            while ((x = input.read(arrays))!=-1) {
                System.out.println(new String(arrays,0,x,"UTF-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Task 2
        File fileFinal = new File("src/main/java/task2_final.txt");
        try {
            fileFinal.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<InputStream> arrayList = new ArrayList<>();
        FileWriter fileWriter;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileWriter = new FileWriter("src/main/java/task2_final.txt");
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/main/java/task2_final.txt"));
            for (int i = 1; i <= 5; i++) {
                arrayList.add(new FileInputStream("src/main/java/task2_" + i + ".txt"));
             }
            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arrayList));
            int x;
            while ((x = in.read())!=-1){
                if((char)x =='.'){
                    bufferedOutputStream.write(x);
                    bufferedOutputStream.write('\n');
                }else bufferedOutputStream.write(x);
            }
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        ArrayList<Worker> workerArrayList = new ArrayList<>();
        Worker worker1 = new Worker(1,"Alex","Ser","Fil",15.2,700);
        Worker worker2 = new Worker(2,"Axel","Res","Lif",19.2,600);
        Worker worker3 = new Worker(3,"Mihail","Nik","Pop",25.2,900);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/victory.vic"));
            objectOutputStream.writeObject(worker1);
            objectOutputStream.writeObject(worker2);
            objectOutputStream.writeObject(worker3);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("victory.vic"));
            workerArrayList.add ((Worker) objectInputStream.readObject());
            workerArrayList.add ((Worker) objectInputStream.readObject());
            workerArrayList.add ((Worker) objectInputStream.readObject());
            objectInputStream.close();
            for (Worker x:workerArrayList) {
                x.info();
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Task 3
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/Input.txt","r");
            int page = 1000;
            int start = 0;
            int length = 1800;
            for (int i = 0; i <= page ; i++) {
                byte[] data = new byte[length];
                randomAccessFile.read(data, start, length);
                if (i == page) {
                    System.out.println(new String(data, start, length, "UTF-8"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Task 4

    }
}
