/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5;


/**
 *
 * @author Edwar Arliman Gea
 */
public class Stok extends Harapan_Jaya_Motor {
    private String Stok1, Stok2, Stok3, Stok4, Stok5;
    public Stok() {
        Stok1 = "Stok1";
        Stok2 = "Stok2";
        Stok3 = "Stok3";
        Stok4 = "Stok4";
        Stok5 = "Stok5";
    }
    @Override
    public String toString() {
        return super.toString() + "\nStok1: " + Stok1 + "\nStok2: " + Stok2 + "\nStok3: " + Stok3 + "\nStok4: " + Stok4 + "\nStok5: " + Stok5;
    }
    public String getSisaBarang(int stokNumber) {
        switch (stokNumber) {
            case 1:
                return getSisaBarang(Stok1);
            case 2:
                return getSisaBarang(Stok2);
            case 3:
                return getSisaBarang(Stok3);
            case 4:
                return getSisaBarang(Stok4);
            case 5:
                return getSisaBarang(Stok5);
            default:
                System.out.println("Stok tidak valid");
                return "";
        }
    }
    public String getSisaBarang(String stok) {
        String lowercaseStok = stok.toLowerCase();
        if (Stok1.toLowerCase().equals(lowercaseStok)) {
            return "Sisa Barang 25";
        } else if (Stok2.toLowerCase().equals(lowercaseStok)) {
            return "Sisa Barang 23";
        } else if (Stok3.toLowerCase().equals(lowercaseStok)) {
            return "Sisa Barang 17";
        } else if (Stok4.toLowerCase().equals(lowercaseStok)) {
            return "Sisa Barang 15";
        } else if (Stok5.toLowerCase().equals(lowercaseStok)) {
            return "Sisa Barang 10";
        } else {
            return "Barang tidak ditemukan";
        }
    }
}
