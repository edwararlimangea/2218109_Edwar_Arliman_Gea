/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas8;

/**
 *
 * @author Edwar Arliman Gea
 */
public interface SimpanData{
    abstract void setMerk(String merk);
    String getMerk();

    abstract void setModel(String model);
    String getModel();

    abstract void setJumlahStok(int jumlahStok);
    int getJumlahStok();

    abstract void setTahunProduksi(int tahunProduksi);
    int getTahunProduksi();

    String toString();
}