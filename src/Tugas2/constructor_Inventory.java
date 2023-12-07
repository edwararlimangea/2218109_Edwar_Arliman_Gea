/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2;

/**
 *
 * @author Edwar Arliman Gea
 */
public class constructor_Inventory {

    // Atribut
    String Merk; 
    String Model;
    int TahunProduksi;
    int Harga;
    int JumlahStok;

    // Constructor
    public constructor_Inventory(String Model, int TahunProduksi, int Harga, int JumlahStok) {
        this.Merk = "HONDA";
        this.Model = Model;
        this.TahunProduksi = TahunProduksi;
        this.Harga = Harga;
        this.JumlahStok = JumlahStok;
    }

    // Membuat Method untuk mengambil nilai kembali pada atribut
    String printMerk() {
        return Merk;
    }

    String printModel() {
        return Model;
    }

    int printTahunProduksi() {
        return TahunProduksi;
    }

    int printHarga() {
        return Harga;
    }

    int printJumlahStok() {
        return JumlahStok;
    }
}