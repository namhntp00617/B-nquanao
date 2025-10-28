/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class HoaDonEntity {
    private int maHD;
    private int maKH;
    private int maNV;
    private String tenKH;
    private String hinhThucTT;
    private int tongTien;
    private int trangThai;
    private Date ngayTao;

    public HoaDonEntity() {
    }

    public HoaDonEntity(int maHD, int maNV, int trangThai, Date ngayTao) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }
    
    

    public HoaDonEntity(int maHD, int maKH, int maNV, String tenKH, String hinhThucTT, int tongTien, int trangThai, Date ngayTao) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.hinhThucTT = hinhThucTT;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
}
