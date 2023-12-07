/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas5;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Harapan_Jaya_Motor {
    private String Merk; 
    private String Model;
    private int JumlahStok;
    private int TahunProduksi;
    public void setMerk(String Merk) {
        this.Merk = Merk;
    }
    public String getMerk() {
        return Merk;
    }
    public void setModel(String Model) {
        this.Model = Model;
    }
    public String getModel() {
        return Model;
    }
    public void setJumlahStok(int JumlahStok) {
        this.JumlahStok = JumlahStok;
    }
    public int getJumlahStok() {
        return JumlahStok;
    }
    public void setTahunProduksi(int TahunProduksi) {
        this.TahunProduksi = TahunProduksi;
    }
    public void setTahunProduksi(String TahunProduksi) {
        this.TahunProduksi = Integer.parseInt(TahunProduksi);
    }
    public int getTahunProduksi() {
        return TahunProduksi;
    }
    @Override
    public String toString() {
        return "Merk: " + Merk + "\nModel: " + Model + "\nJumlah Stok: " + JumlahStok + "\nTahun Produksi: " + TahunProduksi;
    }
}
