/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas8;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Harapan_Jaya_Motor implements SimpanData{
   private String Merk; 
    private String Model;
    private int JumlahStok;
    private int TahunProduksi;

    @Override
    public void setMerk(String merk) {
        this.Merk = merk;
    }

    @Override
    public String getMerk() {
        return Merk;
    }

    @Override
    public void setModel(String model) {
        this.Model = model;
    }

    @Override
    public String getModel() {
        return Model;
    }

    @Override
    public void setJumlahStok(int jumlahStok) {
        this.JumlahStok = jumlahStok;
    }

    @Override
    public int getJumlahStok() {
        return JumlahStok;
    }

    @Override
    public void setTahunProduksi(int tahunProduksi) {
        this.TahunProduksi = tahunProduksi;
    }

    @Override
    public int getTahunProduksi() {
        return TahunProduksi;
    }

    @Override
    public String toString() {
        return "Merk: " + Merk + "\nModel: " + Model + "\nJumlah Stok: " + JumlahStok + "\nTahun Produksi: " + TahunProduksi;
    }
}
