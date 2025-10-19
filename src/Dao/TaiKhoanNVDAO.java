/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import entity.TaiKhoanNVEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;

/**
 *
 * @author meoba
 */
public class TaiKhoanNVDAO {

    public List<TaiKhoanNVEntity> getAll() {
        List<TaiKhoanNVEntity> list = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from TaiKhoanNV";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                TaiKhoanNVEntity nv = new TaiKhoanNVEntity(result.getLong("maTaiKhoan"),
                        result.getString("password"),
                        result.getString("tenTaiKhoan"),
                        result.getString("Email"),
                        result.getString("permission"),
                        result.getInt("SDT"));
                list.add(nv);
            }
        } catch (Exception e) {

            System.out.println("Lỗi get all tk" + e.getMessage());
        }
        return list;
    }

    public void insert(TaiKhoanNVEntity nv) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO NhanVien (tenTaiKhoan, Email, password, SDT, permission) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nv.getTenTK());
            statement.setString(2, nv.getEmail());
            statement.setString(3, nv.getPassword());
            statement.setInt(5, nv.getSdt());
            statement.setString(6, nv.getPermission());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi insert tài khoản nhân viên: " + e.getMessage());
        }
    }

    public void update(TaiKhoanNVEntity nv) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE TaiKhoanNV SET tenTaiKhoan = ?, Email = ?, password = ?, namSinh = ?, SDT = ?, permission = ? WHERE maTaiKhoan = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, nv.getTenTK());
            statement.setString(2, nv.getEmail());
            statement.setString(3, nv.getPassword());

            // Chuyển java.util.Date thành java.sql.Date
            statement.setInt(4, nv.getSdt());
            statement.setString(5, nv.getPermission());
            statement.setLong(6, nv.getMaTK());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi update tài khoản nhân viên: " + e.getMessage());
        }
    }

    public void delete(long maTK) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "DELETE FROM TaiKhoanNV WHERE maTaiKhoan = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, maTK);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi xóa tài khoản nhân viên: " + e.getMessage());
        }
    }

    public TaiKhoanNVEntity checkLogin(long maTaiKhoan, String password, String permission) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM TaiKhoanNV WHERE maTaiKhoan = ? AND password = ? AND permission = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, maTaiKhoan);
            stmt.setString(2, password);
            stmt.setString(3, permission);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TaiKhoanNVEntity(
                        rs.getLong("maTaiKhoan"),
                        rs.getString("tenTaiKhoan"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("permission"),
                        rs.getInt("SDT"),
                        null // hoặc rs.getDate("namSinh") nếu có cột này trong DB
                );

            }
        } catch (Exception e) {
            System.out.println("Lỗi kiểm tra đăng nhập: " + e.getMessage());
        }
        return null;
    }

}
