/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import entity.HoaDonChiTietEntity;
import entity.HoaDonEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;
import static ulti.ConnectDB.con;

/**
 *
 * @author DELL
 */
public class HoaDonDAO {
    public List<HoaDonEntity> getAllHD() {
        List<HoaDonEntity> list = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from HoaDon";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                HoaDonEntity hd = new HoaDonEntity(result.getInt("MaHD"),
                        result.getInt("MaKH"),
                        result.getInt("MaNV"),
                        result.getString("TenKH"),
                        result.getString("HinhThucTT"),
                        result.getInt("TongTien"),
                        result.getInt("TrangThai"),
                        result.getDate("NgayTao"));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Loi get all " + e.getMessage());
        }
        return list;
    }
    
    public void insert(int maNV) {
        String sql = "INSERT INTO HoaDon"
                + "(maNV) values"            
                + "(?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNV);
            ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Lỗi insert hóa đơn: " + e.getMessage());
    }
}
    
    public List<HoaDonEntity> getAllHoaDonCho() {
        List<HoaDonEntity> list = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from HoaDon where TrangThai = 0";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                HoaDonEntity hd = new HoaDonEntity(result.getInt("MaHD"),
                        result.getInt("MaKH"),
                        result.getInt("MaNV"),
                        result.getString("TenKH"),
                        result.getString("HinhThucTT"),
                        result.getInt("TongTien"),
                        result.getInt("TrangThai"),
                        result.getDate("NgayTao"));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Loi get all " + e.getMessage());
        }
        return list;
    }
    
    public HoaDonEntity getAllOneHD(int id) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from HoaDon where MaHD = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                HoaDonEntity hd = new HoaDonEntity(result.getInt("MaHD"),
                        result.getInt("MaKH"),
                        result.getInt("MaNV"),
                        result.getString("TenKH"),
                        result.getString("HinhThucTT"),
                        result.getInt("TongTien"),
                        result.getInt("TrangThai"),
                        result.getDate("NgayTao"));
                return hd;
            }
        } catch (Exception e) {
            System.out.println("Loi get all " + e.getMessage());
        }
        return null;
    }
    
    public static boolean capNhatTrangThai(int maHD) {
        try {
            Connection conn = ConnectDB.getConnect();
            String sql = "UPDATE HoaDon SET TrangThai = 1 WHERE MaHD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maHD);

            int rows = ps.executeUpdate();
            ps.close();
            conn.close();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
public static List<HoaDonEntity> timKiemHoaDon(String maHD) {
    List<HoaDonEntity> list = new ArrayList<>();
    String sql = "SELECT * FROM HoaDon WHERE 1=1";

    if (maHD != null && !maHD.isEmpty()) {
        sql += " AND MaHD LIKE ?";
    }

    try (
        Connection con = ConnectDB.getConnect();
        PreparedStatement st = con.prepareStatement(sql);
    ) {
        if (maHD != null && !maHD.isEmpty()) {
            st.setString(1, "%" + maHD + "%");
        }

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            HoaDonEntity hd = new HoaDonEntity();
            hd.setMaHD(rs.getInt("MaHD"));
            hd.setMaKH(rs.getInt("MaKH"));
            hd.setMaNV(rs.getInt("MaNV"));
            hd.setTenKH(rs.getString("TenKH"));
            hd.setHinhThucTT(rs.getString("HinhThucTT"));
            hd.setTongTien(rs.getInt("TongTien"));
            hd.setTrangThai(rs.getInt("TrangThai"));
            hd.setNgayTao(rs.getDate("NgayTao"));
            list.add(hd);
        }
    } catch (Exception e) {
        System.out.println("Lỗi timKiemHoaDon: " + e.getMessage());
    }

    return list;
}

    
    public void updateTrangThai(int maHD) {
        try {
            Connection conn = ConnectDB.getConnect();
            String sql = "UPDATE HoaDon SET TrangThai = 2 WHERE MaHD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maHD);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi update: " + e.getMessage());
        }
    }
    
     public void xoaHoaDon(int maHD) {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        try (Connection conn = ConnectDB.getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maHD);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
