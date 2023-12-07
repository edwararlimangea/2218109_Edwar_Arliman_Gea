/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas1;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Inventory_sepeda_motor_listrik {
    //Artibut
    String Merk;
    String Model;
    int TahunProduksi;
    int Harga;
    int JumlahStok;
    
    //Method setter untuk mengisi data motor listrik
    void DataMerk (String Merk){
        this.Merk = Merk;
    }
    
    void DataModel (String Model){
        this.Model = Model;
    }
    
    void DataTahunProduksi (int TahunProduksi) {
            this.TahunProduksi = TahunProduksi;
    }
    
    void DataHarga (int Harga ){
        this.Harga = Harga;
    }
    
    void DataJumlahStok (int JumlahStok){
        this.JumlahStok = JumlahStok;
    }
    
    //Membuat Method untuk mengambil nilai kembali pada atribut
    String printMerk(){
        return Merk;
    }
    
    String printModel (){
        return Model;
    }
    
    int printTahunProduksi (){
        return TahunProduksi;
    }
    
    int printHarga (){
        return Harga;
    }
    
    int printJumlahStok (){
        return JumlahStok;
    }
}
