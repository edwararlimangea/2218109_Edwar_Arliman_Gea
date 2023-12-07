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
public class Stok extends Harapan_Jaya_Motor {

    private String Stok1, Stok2, Stok3, Stok4, Stok5;

    public Stok() {
        Stok1 = "Stok1";
        Stok2 = "Stok2";
        Stok3 = "Stok3";
        Stok4 = "Stok4";
        Stok5 = "Stok5";
    }

    // Metode untuk mendapatkan sisa barang berdasarkan stok
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
