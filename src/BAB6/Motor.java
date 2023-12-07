/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Motor extends Kendaraan{

    private boolean kickStart;

    // Constructor
    public Motor(String merk, String model, boolean kickStart) {
        super(merk, model);
        this.kickStart = kickStart;
    }

    //  method start
    @Override
    public void start() {
        System.out.println("Motor dinyalakan");
    }

    //  method stop
    @Override
    public void stop() {
        System.out.println("Motor dimatikan");
    }

    //  method
    public void kickStart() {
        if (kickStart) {
            System.out.println("Motor dinyalakan dengan kick start");
        } else {
            System.out.println("Motor tidak memiliki kick start");
        }
    }
}
