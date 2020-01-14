package Task4;

import java.io.Serializable;

//enum Transmission implements Serializable { AT4("automatic transmission",4),AT8("automatic transmission",8),
//    MT5("mechanical transmission",5),MT6("mechanical transmission",6);
//    private int gears;
//    private String decryption;
//    Transmission(String _decryption,int _gears){
//        decryption = _decryption;
//        gears = _gears;
//    }
//}

public class Car implements Serializable {
    String brand;
    String model;
    double engineVolume;
//    enum Transmission {}
    String color;
    int maxSpeed;
    String bodywork;

    public Car(String brand, String model, double engineVolume, String color, int maxSpeed, String bodywork) {
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.bodywork = bodywork;
    }
    public void infoCar(){
        System.out.println(brand+ " "+model+" "+engineVolume+" "+color+" "+maxSpeed+" "+bodywork);
    }
}
