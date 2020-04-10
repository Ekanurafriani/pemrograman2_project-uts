package com.app.pasien.model;

public class Pasien {

    private String idPasien;
    private String nama;
    private String penyakit;
    private String dokter;
    private int tahun;

    public Pasien() {
    }

    public Pasien(String idPasien, String nama, String penyakit, String dokter, int tahun) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.penyakit = penyakit;
        this.dokter = dokter;
        this.tahun = tahun;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    
    

}
