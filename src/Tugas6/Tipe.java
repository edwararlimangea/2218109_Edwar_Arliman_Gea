/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas6;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Tipe {

    private String Tipe1, Tipe2, Tipe3;

    public Tipe() {
        super();
        Tipe1 = "Metic";
        Tipe2 = "Manual";
        Tipe3 = "Kopling";
    }

    String getTipeNumber(int enteredBatteryType) {
        switch (enteredBatteryType) {
            case 1:
                return Tipe1;
            case 2:
                return Tipe2;
            case 3:
                return Tipe3;
            default:
                return "Jenis baterai tidak valid";
        }
    } 
}