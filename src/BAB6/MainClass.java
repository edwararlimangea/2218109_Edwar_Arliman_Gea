/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB6;

/**
 *
 * @author Edwar Arliman Gea
 */
public class MainClass {

    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "Avanza", 4);
        mobil.displayInfo();
        mobil.start();
        mobil.bukaPintu();
        mobil.stop();
        System.out.println();

        Motor motor = new Motor("Honda", "CBR", true);
        motor.displayInfo();
        motor.start();
        motor.kickStart();
        motor.stop();
    }
}
