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
        ADMIN, QUAN_LY_KHO, QUAN_LY_NHAN_VIEN, NHAN_VIEN 
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

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Role getChucVu() {
        return chucVu;
    }

    public void setChucVu(Role chucVu) {
        this.chucVu = chucVu;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public boolean isTrangThai() { // Đối với kiểu boolean, dùng "is" thay vì "get"
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
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