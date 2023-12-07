/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Tipe extends Harapan_Jaya_Motor {
    private String Tipe1;
    private String Tipe2;
    private String Tipe3;
    public Tipe() {
        super();
        Tipe1 = "Metic";
        Tipe2 = "Kompling";
        Tipe3 = "Manual";
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipe1: " + Tipe1 + "\nTipe2: " + Tipe2 + "\nTipe3: " + Tipe3;
    }
    public void setTipe(int tipeNumber, String value) {
        switch (tipeNumber) {
            case 1:
                setTipe1(value);
                break;
            case 2:
                setTipe2(value);
                break;
            case 3:
                setTipe3(value);
                break;
            default:
                System.out.println("Tipe tidak valid");
        }
    }
    public String getTipe(int tipeNumber) {
        switch (tipeNumber) {
            case 1:
                return getTipe1();
            case 2:
                return getTipe2();
            case 3:
                return getTipe3();
            default:
                System.out.println("Tipe tidak valid");
                return "";
        }
    }
    public String getTipe1() {
        return Tipe1;
    }
    public void setTipe1(String Tipe1) {
        this.Tipe1 = Tipe1;
    }
    public String getTipe2() {
        return Tipe2;
    }
    public void setTipe2(String Tipe2) {
        this.Tipe2 = Tipe2;
    }
    public String getTipe3() {
        return Tipe3;
    }
    public void setTipe3(String Tipe3) {
        this.Tipe3 = Tipe3;
    }
}

