/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas4;

import tugas3.*;

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
