/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB2;

/**
 *
 * @author Edwar Arliman Gea
 */
public class Luas_Segitiga {
    int alas,tinggi;
    double luas;
    
    //menginisialisasi nilai alas dengan costruktor
    public Luas_Segitiga() {
        this.alas = 10;
    }
    public double luas(){
        luas = (alas*tinggi)/2;
        return luas;
    }
}
