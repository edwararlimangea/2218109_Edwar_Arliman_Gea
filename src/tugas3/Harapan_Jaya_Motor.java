/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas3;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Harapan_Jaya_Motor {

    String Merk;
    String Model;
    String Baterai; // Menambahkan atribut Baterai
    int JumlahStok;
    int TahunProduksi;

    void DataMerk(String Merk) {
        this.Merk = Merk;
    }

    void DataModel(String Model) {
        this.Model = Model;
    }

    void DataBaterai(String Baterai) {
        this.Baterai = Baterai; // Menambahkan metode DataBaterai
    }

    void DataTahunProduksi(int TahunProduksi) {
        this.TahunProduksi = TahunProduksi;
    }

    void DataJumlahStok(int JumlahStok) {
        this.JumlahStok = JumlahStok;
    }

    String printMerk() {
        return Merk;
    }

    String printModel() {
        return Model;
    }

    String printBaterai() {
        return Baterai;
    }

    int printJumlahStok() {
        return JumlahStok;
    }

    int printTahunProduksi() {
        return TahunProduksi;
    }
}
