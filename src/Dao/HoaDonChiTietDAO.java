/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import entity.HoaDonChiTietEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;

/**
 *
 * @author DELL
 */
public class HoaDonChiTietDAO {
    public void insertCTHD(HoaDonChiTietEntity hdct) {
    try {
        Connection con = ConnectDB.getConnect(); 
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaSP, TenSP, MauSac, KichThuoc, SoLuong, DonGia)"
                + "values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, hdct.getMaHD());
        ps.setInt(2, hdct.getMaSP());
        ps.setString(3, hdct.getTenSP() );
        ps.setString(4, hdct.getMauSac());
        ps.setString(5, hdct.getKichThuoc());
        ps.setInt(6, hdct.getSoLuong());
        ps.setDouble(7, hdct.getDonGia());
        ps.executeUpdate();
    }catch (Exception e) {
            System.out.println("Lỗi insert hdctdao: " + e.getMessage());
        }
    }
    
    public List<HoaDonChiTietEntity> getAllByMaHD(int maHD) {
    List<HoaDonChiTietEntity> list = new ArrayList<>();
    try {
        Connection con = ConnectDB.getConnect(); 
        String sql = "select * from ChiTietHoaDon where MaHD = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, maHD);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            HoaDonChiTietEntity hdct = new HoaDonChiTietEntity(
            result.getInt("MaHD"), 
            result.getInt("MaSP"),
            result.getString("TenSP"),
            result.getString("MauSac"),
            result.getString("KichThuoc"),       
            result.getInt("SoLuong"),
            result.getInt("ThanhTien"));
        list.add(hdct);
        }
    } catch (Exception e) {
        System.out.println("Lỗi getAll hdct: " + e.getMessage());
    }
    return list;
    }
    
    public boolean checkExistSPInHDCT(int maHD, int maSanPham) {
        try {
        Connection con = ConnectDB.getConnect(); 
        String sql = "select * from ChiTietHoaDon where MaHD = ? and MaSP = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, maHD);
        ps.setInt(2, maSanPham);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
           return true;
        }
    } catch (Exception e) {
        System.out.println("Lỗi checkExistSPInHDCT hdct: " + e.getMessage());
    }
    return false;
    }
    
    public void increaseQuantityHDCT(int maHD, int maSanPham) {
                try {
        Connection con = ConnectDB.getConnect(); 
        String sql = "update ChiTietHoaDon set SoLuong = SoLuong + 1 where MaHD = ? and MaSP = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, maHD);
        ps.setInt(2, maSanPham);
        ps.execute();
    } catch (Exception e) {
        System.out.println("Lỗi increaseQuantityHDCT hdct: " + e.getMessage());
        }
    } 
}
