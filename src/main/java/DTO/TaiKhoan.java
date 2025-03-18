/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuand
 */
public class TaiKhoan {
    private int maTK;
    private int maNV; 
    private String matKhau;
    private Role chucVu;
    private String chiNhanh;
    private boolean trangThai; //(true/false)


    // Enum for Role
    public enum Role {
        Admin, QuanLyKho, QuanLyNhanVien, NhanVien 
    }
    public TaiKhoan() {

    }

    // Constructor with maNV only (useful for lookups or deletions)
    public TaiKhoan(int maNV) {
        this.maNV = maNV;
    }
    
    // Constructor with all data (for example when inserting into a database.)
    public TaiKhoan(int maTK, int maNV, String matKhau, Role chucVu, String diaChi, String chiNhanh, boolean trangThai) {
        this.maTK = maTK;
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    
    // Constructor when id is not provided. For database insertions when id is auto_increment.
     public TaiKhoan(int maNV, String matKhau, Role chucVu, String diaChi, String chiNhanh, boolean trangThai) {        
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }


    // Getters and Setters
    public int getmaTK() {
        return maTK;
    }

    public void setmaTK(int maTK) {
        this.maTK = maTK;
    } 
    
    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getmatKhau() {
        return matKhau;
    }

    public void setmatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    public Role getchucVu() {
        return chucVu;
    }

    public void setchucVu(Role chucVu) {
        this.chucVu = chucVu;
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
        return "TaiKhoan{" +
                "maTK=" + maTK +
                ", maNV='" + maNV +
                ", matKhau='" + matKhau +
                ", chucVu=" + chucVu +
                ", chiNhanh=" + chiNhanh +
                ", trangThai=" + trangThai +
                '}';
    }
}