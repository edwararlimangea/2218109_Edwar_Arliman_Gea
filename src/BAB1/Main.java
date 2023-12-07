/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Main {
    public static void main (String [] args){
        //Membuat Objek
        Kendaraan mobil = new Kendaraan();
        mobil.nama = "Mobil";
        mobil.merk = "Merah";
        mobil.merk = "Toyota";
        System.out.println("Nama Kendaraan :" +mobil.nama);
        System.out.println("Warna Kendaraan :" +mobil.warna);
        System.out.println("Nama Kendaraan :" +mobil.merk);
        System.out.println("Jumlah Roda :" +mobil.jmlRoda(4)+"\n");
        System.out.println("Cara bergerak kendaraan :");
        System.out.println("Saat Maju :");
        mobil.KendaraanMaju();
        System.out.println("Saat Mundur");
        mobil.KendaraanMundur();
        System.out.println("Saat Berhenti");
        mobil.KendaraanBerhenti();
        
    }
}
