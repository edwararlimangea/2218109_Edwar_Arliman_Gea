/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas6;

/**
 *
 * @author Edwar Arliman Gea
 */
public class abstractbaterai extends Baterai{
    @Override
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
}
