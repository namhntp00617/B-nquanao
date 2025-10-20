/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import entity.DanhMucEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class DanhMucDao {
    
    public List<DanhMucEntity> getAll() {
        List<DanhMucEntity> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM DanhMuc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMucEntity dm = new DanhMucEntity(
                    rs.getInt("MaDM"),
                    rs.getString("TenDM")
                );
                list.add(dm);
            }
        } catch (Exception e) {
            System.out.println("Lỗi getAll DanhMuc: " + e.getMessage());
        }
        return list;
    }
    public void insert(DanhMucEntity dm) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO DanhMuc (TenDM) VALUES ( ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, dm.getTenDanhMuc());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Lỗi insert danh mục: " + e.getMessage());
        }
    }
   
    public boolean update(DanhMucEntity dm) {
        String sql = "UPDATE DanhMuc SET TenDM = ? WHERE MaDM = ?";
        try (Connection conn = ConnectDB.getConnect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dm.getTenDanhMuc());
            stmt.setInt(2, dm.getMaDanhMuc());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(String maDanhMuc) {
        String sql = "DELETE FROM DanhMuc WHERE MaDM = ?";
        try (
            Connection con = ConnectDB.getConnect();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, maDanhMuc);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
}
}
