/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Mobil extends Kendaraan{

    private int jumlahPintu;

    // Constructor
    public Mobil(String merk, String model, int jumlahPintu) {
        super(merk, model);
        this.jumlahPintu = jumlahPintu;
    }

    //  method start
    @Override
    public void start() {
        System.out.println("Mobil dinyalakan");
    }

    //  method stop
    @Override
    public void stop() {
        System.out.println("Mobil dimatikan");
    }

    // Additional method
    public void bukaPintu() {
        System.out.println("Pintu mobil dibuka");
    }
}

