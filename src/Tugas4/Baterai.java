/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas4;


/**
 *
 * @author Edwar Arliman Gea
 */
public class Baterai extends Harapan_Jaya_Motor {

    private String Baterai1, Baterai2, Baterai3, Baterai4, Baterai5;

    public Baterai() {
        super();
        Baterai1 = "githium-ion (li-ion)";
        Baterai2 = "githium iron phosphate (lifepo4)"; 
        Baterai3 = "gel";
        Baterai4 = "asam timbal (lead acid)";
        Baterai5 = "natrium-ion";
    }

    public String getBaterai1() {
        return Baterai1;
    }

    public String getBaterai2() {
        return Baterai2;
    }
    
    public String getBaterai3() {
        return Baterai3;
    }

    public String getBaterai4() {
        return Baterai4;
    }

    public String getBaterai5() {
        return Baterai5;
    }

    public String getJarakByBatteryType(String batteryType) {
        String lowercaseBatteryType = batteryType.toLowerCase();

        if (Baterai1.equals(lowercaseBatteryType)) {
            return "55 kM/Bateri";
        } else if (Baterai2.equals(lowercaseBatteryType)) {
            return "85 KM/Baterai";
        } else if (Baterai3.equals(lowercaseBatteryType)) {
            return "60 kM/Baterai";
        } else if (Baterai4.equals(lowercaseBatteryType)) {
            return "35 KM/Baterai";
        } else if (Baterai5.equals(lowercaseBatteryType)) {
            return "50 KM/Baterai";
        } else {
            return "Jarak tidak diketahui";
        }
    }
}
