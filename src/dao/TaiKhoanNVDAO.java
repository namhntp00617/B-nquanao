/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
            String sql = "select * from NhanVien";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                TaiKhoanNVEntity nv = new TaiKhoanNVEntity(result.getLong("MaNV"),
                        result.getString("MatKhau"),
                        result.getString("TenNV"),
                        result.getString("Email"),
                        result.getString("Quyen"),
                        result.getInt("Sdt"));
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
            String sql = "INSERT INTO NhanVien (TenNV, Email, MatKhau, Sdt, Quyen) "
                    + "VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nv.getTenTK());
            statement.setString(2, nv.getEmail());
            statement.setString(3, nv.getPassword());
            statement.setInt(4, nv.getSdt());
            statement.setString(5, nv.getPermission());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi insert tài khoản nhân viên: " + e.getMessage());
        }
    }

    public void update(TaiKhoanNVEntity nv) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE NhanVien SET TenNV = ?, Email = ?, MatKhau = ?, Sdt = ?, Quyen = ? WHERE MaNV = ?";
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
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, maTK);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi xóa tài khoản nhân viên: " + e.getMessage());
        }
    }
}
