/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class HoaDonChiTietEntity {
    private int MaHD; 
    private int MaSP;
    private String tenSP;
    private String mauSac;
    private String kichThuoc;
    private int SoLuong;
    private int donGia; 
    private int thanhTien;

    public HoaDonChiTietEntity() {
    }

    public HoaDonChiTietEntity(int MaHD, int MaSP, String tenSP, String mauSac, String kichThuoc, int SoLuong, int thanhTien) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.SoLuong = SoLuong;
        this.thanhTien = thanhTien;
    }




    
    

    public HoaDonChiTietEntity(int MaHD, int MaSP, int SoLuong, int donGia, int thanhTien, String tenSP, String mauSac, String kichThuoc) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }


    
    
    
    
    
}
