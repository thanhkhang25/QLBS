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
        ADMIN, QUAN_LY_KHO, QUAN_LY_NHAN_VIEN, NHAN_VIEN 
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

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Gender getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Gender gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public boolean isTrangThai() { // Theo chuẩn getter cho kiểu boolean
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
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