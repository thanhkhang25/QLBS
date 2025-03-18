/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author xuand
 */
public class NhanVien {
    private int maNV;
    private String tenNV;
    private Date ngaySinh;
    private Gender gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String chiNhanh;
    private boolean trangThai; //(true/false)


    // Enum for gender
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    
    // Enum for Role
    public enum Role {
        Admin, QuanLyKho, QuanLyNhanVien, NhanVien 
    }
    public NhanVien() {

    }

    // Constructor with maNV only (useful for lookups or deletions)
    public NhanVien(int maNV) {
        this.maNV = maNV;
    }
    
    // Constructor with all data (for example when inserting into a database.)
    public NhanVien(int maNV, String tenNV, Date ngaySinh, Gender gioiTinh, String sdt, String email, String diaChi, String chiNhanh, boolean trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    
    // Constructor when id is not provided. For database insertions when id is auto_increment.
     public NhanVien( String tenNV, Date ngaySinh, Gender gioiTinh, String sdt, String email, String diaChi, String chiNhanh, boolean trangThai) {        
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }


    // Getters and Setters
    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public String gettenNV() {
        return tenNV;
    }

    public void settenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    public Date getngaySinh() {
        return ngaySinh;
    }

    public void setngaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Gender getgioiTinh() {
        return gioiTinh;
    }

    public void setgioiTinh(Gender gioiTinh) {
        this.gioiTinh = gioiTinh;
    }    
    
    public String getsdt() {
        return sdt;
    }

    public void setsdt(String sdt) {
        this.sdt = sdt;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getdiaChi() {
        return diaChi;
    }

    public void setdiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
   
    public String getchiNhanh() {
        return chiNhanh;
    }

    public void setchiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
    
    public boolean gettrangThai() {
        return trangThai;
    }

    public void settrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    //  toString() method (optional but very useful for debugging)
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", sdt=" + sdt +
                ", email=" + email +
                ", diaChi=" + diaChi +
                ", chiNhanh=" + chiNhanh +
                ", trangThai=" + trangThai +
                '}';
    }
}