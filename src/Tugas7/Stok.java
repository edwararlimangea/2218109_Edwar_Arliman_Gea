/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas7;

/**
 *
 * @author Edwar Arliman Gea
 */
public abstract class Stok {
    private String Model;
    public Stok(String model) {
        this.Model = model;
    }
    public void setModel(String model) {
        this.Model = model;
    }
    public String getModel() {
        return Model;
    }
   @Override
    public String toString() {
        return super.toString() + "\nModel: " + Model;
    }
    public abstract String getSisaBarang();
    public static String getSisaBarang (String stok){
        String lowercaseStok = stok.toLowerCase();
        switch (lowercaseStok){
            case "stok1":
                return "Sisa Barang 25 pac";
            case "stok2":
                return "Sisa Barang 23 pac";
            case "stok3":
                return "Sisa Barang 17 pac";
            case "stok4":
                return "Sisa Barang 15 pac";
            case "stok5":
                return "Sisa Barang 10 pac";
            default:
                return "Sisa Barang Tidak Ditemukan";
        }
    }
}
