package com.app.pasien;

import com.app.pasien.model.Pasien;
import com.app.pasien.utility.DatabaseUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PasienDataSource {

    private Connection connection;
    private Pasien pasien;

    public PasienDataSource() {
        connection = DatabaseUtility.getConnection();
    }

    public List<Pasien> getAll() {
        List<Pasien> list = new ArrayList<>();
        String sql = "SELECT * FROM Pasien";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Pasien pasien;
            while (rs.next()) {
                pasien = new Pasien();
                pasien.setIdPasien(rs.getString("idPasien"));
                pasien.setNama(rs.getString("nama"));
                pasien.setPenyakit(rs.getString("penyakit"));
                pasien.setDokter(rs.getString("dokter"));
                pasien.setTahun(rs.getInt("tahun"));
                list.add(pasien);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Pasien getByID(String id) {
        Pasien pasien = null;
        String sql = "SELECT * FROM Pasien WHERE idPasien=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                pasien = new Pasien();
                pasien.setIdPasien(rs.getString("idPasien"));
                pasien.setNama(rs.getString("nama"));
                pasien.setPenyakit(rs.getString("penyakit"));
                pasien.setDokter(rs.getString("dokter"));
                pasien.setTahun(rs.getInt("tahun"));
            }
        } catch (Exception e) {
        }
        return pasien;
    }

    public boolean update(Pasien pasien) {
        String sql = "UPDATE Pasien SET nama=?,penyakit=?,dokter=?,tahun=? "
                + "WHERE idPasien=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pasien.getNama());
            statement.setString(2, pasien.getPenyakit());
            statement.setString(3, pasien.getDokter());
            statement.setInt(4, pasien.getTahun());
            statement.setString(5, pasien.getIdPasien());
            int result = statement.executeUpdate();
            return result  > 0;
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
            return false;
    }
    
    public boolean insert(Pasien pasien) {
        String sql = "INSERT INTO Pasien VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pasien.getIdPasien());
            statement.setString(2, pasien.getNama());
            statement.setString(3, pasien.getPenyakit());
            statement.setString(4, pasien.getDokter());
            statement.setInt(5, pasien.getTahun());
            int result = statement.executeUpdate();
            return result  > 0;
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
            return false;
    }
    
    public boolean delete(String id) {
        String sql = "DELETE FROM Pasien WHERE idPasien=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            int result = statement.executeUpdate();
            return result  > 0;
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
            return false;
    }
}
