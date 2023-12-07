/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas1;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Main_Inventory_sepeda_motor_listrik {
    public static void main(String[] args) {
        //Membuat objek dengan nama "MotorListrik" dari class Inventory_sepeda_motor_listrik
        Inventory_sepeda_motor_listrik MotorListrik1 = new Inventory_sepeda_motor_listrik ();
        Inventory_sepeda_motor_listrik MotorListrik2 = new Inventory_sepeda_motor_listrik ();
        
        //Ketika Akan menggunakan method dari class Inventory_sepeda_motor_listrik maka harus menyertakan nama objek
        
        MotorListrik1.DataMerk("Honda ");
        MotorListrik1.DataModel("Honda V-Go");
        MotorListrik1.DataTahunProduksi(2023);
        MotorListrik1.DataHarga(17299345);
        MotorListrik1.DataJumlahStok(21);
        
        MotorListrik2.DataMerk("Honda ");
        MotorListrik2.DataModel("Honda M8");
        MotorListrik2.DataTahunProduksi(2022);
        MotorListrik2.DataHarga(17000000);
        MotorListrik2.DataJumlahStok(11);
        
        System.out.println("------------------------------------");
        System.out.println("Informasi Data Sepeda Motor Listrik");
        System.out.println("-----------------------------------");
        System.out.println("Merk             :" +MotorListrik1.printMerk());
        System.out.println("Model            :" +MotorListrik1.printModel());
        System.out.println("Tahun Produksi   :" +MotorListrik1.printTahunProduksi());
        System.out.println("Harga            :" +MotorListrik1.printHarga());
        System.out.println("Jumlah Stok      :" +MotorListrik1.printJumlahStok());
        System.out.println("");
        System.out.println("Merk             :" +MotorListrik2.printMerk());
        System.out.println("Model            :" +MotorListrik2.printModel());
        System.out.println("Tahun Produksi   :" +MotorListrik2.printTahunProduksi());
        System.out.println("Harga            :" +MotorListrik2.printHarga());
        System.out.println("Jumlah Stok      :" +MotorListrik2.printJumlahStok());
    }
}