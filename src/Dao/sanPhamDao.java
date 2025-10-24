/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import entity.sanPhamEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;
/**
 *
 * @author nem mèn mén
 */
public class sanPhamDao {
    public List<sanPhamEntity> getAll() {
        List<sanPhamEntity> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM SanPham";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                sanPhamEntity sp = new sanPhamEntity(result.getInt("MaSP"),
                        result.getString("TenSP"),
                        result.getString("MauSac"),
                        result.getString("KichThuoc"),
                        result.getString("ChatLieu"),
                        result.getInt("Gia"),
                        result.getString("TenDM"),
                        result.getInt("SoLuong"),
                        result.getString("TrangThai"));
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu chiTietSP: " + e.getMessage());
        }
        return list;
    }
    public void insert(sanPhamEntity sp) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO SanPham(TenDM, TenSP,KichThuoc,MauSac,ChatLieu,SoLuong,Gia, TrangThai) "
                    + "VALUES (?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, sp.getTenDM());
            statement.setString(2, sp.getTenSP());
            statement.setString(3, sp.getKichThuoc());
            statement.setString(4, sp.getMauSac());
            statement.setString(5, sp.getChatLieu());
            statement.setInt(6, sp.getSoLuong());
            statement.setInt(7, sp.getGia());
            statement.setString(8, sp.getTrangThai());
           

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi insert Sản phẩm: " + e.getMessage());
       
            }
        }
    public void update(sanPhamEntity ct) {
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "UPDATE SanPham SET TenDM = ?, TenSP = ?, KichThuoc = ?, MauSac = ?,ChatLieu = ?, SoLuong = ?, Gia = ?, TrangThai = ? WHERE MaSP = ?";
        PreparedStatement statement = con.prepareStatement(sql);

        // Gán đúng thứ tự 9 tham số
        statement.setString(1, ct.getTenDM());
        statement.setString(2, ct.getTenSP());
        statement.setString(3, ct.getKichThuoc());
        statement.setString(4, ct.getMauSac());
        statement.setString(5, ct.getChatLieu());
        statement.setInt(6, ct.getSoLuong());
        statement.setInt(7, ct.getGia());
        statement.setString(8, ct.getTrangThai());
        statement.setInt(9, ct.getMaSP()); // WHERE MaSP = ?

        statement.executeUpdate();
        System.out.println("Cập nhật sản phẩm thành công!");
    } catch (Exception e) {
        System.out.println("Lỗi update chiTietSP: " + e.getMessage());
    }
}
    public void delete(int maSP) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "DELETE FROM SanPham WHERE  MaSP = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, maSP);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi delete Sản phẩm: " + e.getMessage());
        }
    }
}
