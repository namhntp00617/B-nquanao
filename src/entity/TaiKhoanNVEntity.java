/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author meoba
 */
public class TaiKhoanNVEntity {
    private long maTK;
    private String password;
    private String tenTK;
    private String email;
    private String permission;
    private int sdt;

    public TaiKhoanNVEntity(long maTK1, String password1, String tenTK1, String email1, String permission1, int sdt1) {
        this.maTK = maTK1;
        this.password = password1;
        this.tenTK = tenTK1;
        this.email = email1;
        this.permission = permission1;
        this.sdt = sdt1;
    }

    public long getMaTK() {
        return maTK;
    }

    public void setMaTK(long maTK) {
        this.maTK = maTK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
   }
    

    
    

