/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas8;

import Tugas5.*;

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

        if (Baterai1.toLowerCase().equals(lowercaseBatteryType)) {
            return "55 kM/Bateri";
        } else if (Baterai2.toLowerCase().equals(lowercaseBatteryType)) {
            return "85 KM/Baterai";
        } else if (Baterai3.toLowerCase().equals(lowercaseBatteryType)) {
            return "60 kM/Baterai";
        } else if (Baterai4.toLowerCase().equals(lowercaseBatteryType)) {
            return "35 KM/Baterai";
        } else if (Baterai5.toLowerCase().equals(lowercaseBatteryType)) {
            return "50 KM/Baterai";
        } else {
            return "Jarak tidak diketahui";
        }
    }
    public String getJarakByBatteryType(String batteryType, int additionalDistance) {
        String baseDistance = getJarakByBatteryType(batteryType);
        int totalDistance = Integer.parseInt(baseDistance.split(" ")[0]) + additionalDistance;
        return totalDistance + " KM/Baterai";
    }
}
