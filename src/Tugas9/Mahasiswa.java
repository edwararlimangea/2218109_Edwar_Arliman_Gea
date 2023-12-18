/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprakbab7;

/**
 *
 * @author octar
 */
public abstract class Mahasiswa {
        private String Matkul;
    public Mahasiswa(String matkul) {
        this.Matkul = matkul;
    }
    public void setMatkul(String matkul) {
        this.Matkul = matkul;
    }
    public String getMatkul() {
        return Matkul;
    }
   @Override
    public String toString() {
        return super.toString() + "\nMatakuliah: " + Matkul;
    }
    public abstract String getPenilaian();
    public static String getPenilaian (String nilai){
        String lowercaseMahasiswa = nilai.toLowerCase();
        switch (lowercaseMahasiswa){
            case "nilai1":
                return "Nilai Anda Adalah A";
            case "nilai2":
                return "Nilai Anda Adalah B";
            case "nilai3":
                return "Nilai Anda Adalah C";
            case "nilai4":
                return "Nilai Anda Adalah D";
            case "nilai5":
                return "Nilai Anda Adalah E";
            default:
                return "Nilai Anda Masih Kosong";
        }
    }
}
