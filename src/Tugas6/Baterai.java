/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas6;

/**
 *
 * @author Edwar Arliman Gea
 */
abstract class Baterai {

    String Baterai1;
    String Baterai2;
    String Baterai3;
    String Baterai4;
    String Baterai5;

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

    public abstract String getJarakByBatteryType(String batteryType);
}
