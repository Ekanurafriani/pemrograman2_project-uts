package com.app.pasien;

import com.app.pasien.model.Pasien;
import java.util.List;

public class Main {
    private PasienDataSource dataSource;

    public Main() {
        dataSource = new PasienDataSource();
    }    
    
    public static void main(String[] args) {
        new Main().GetAll();
    }
    
    public void GetAll(){
        List<Pasien> list = dataSource.getAll();
        for(Pasien psn : list){
            System.out.println("Dokter : " + psn.getDokter());
        }
    }
    
    public void GetByID(){
        Pasien pasien = dataSource.getByID("080499");
        if(pasien != null){
            System.out.println("ID Pasien : " +pasien.getIdPasien());
            System.out.println("Penyakit : " +pasien.getPenyakit());
            }
    }
    
    public void Insert(){
        Pasien pasien = new Pasien("180499", "Eka Nur Afriani", "Sehat", "Adam Maulana", 2020);
        boolean hasil = dataSource.insert(pasien);
        if(hasil){
            System.out.println("Insert Data Berhasil");
        }
    }
    
    public void Update(){
        Pasien pasien = dataSource.getByID("180499");
        pasien.setPenyakit("Tidak Sakit");
        boolean hasil = dataSource.update(pasien);
        if(hasil){
            System.out.println("Update Data Berhasil");
        }
    }
    
    public void Delete(){
        boolean hasil = dataSource.delete("080499");
        if(hasil){
            System.out.println("Delete Data Pasien 080499 Berhasil");
        }
    }
} 
 