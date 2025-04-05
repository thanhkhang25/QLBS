package DTO;

import java.sql.Date;

public class NhanVien {
    private int maNV;
    private String tenNV;
    private Date ngaySinh;
    private String gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private Date ngayVaoLam;
    private String chiNhanh;
    private String trangThai;

    public NhanVien() {}
    public NhanVien(int maNV, String tenNV, Date ngaySinh, String gioiTinh, String sdt, String email, String diaChi,
            Date ngayVaoLam, String chiNhanh, String trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayVaoLam = ngayVaoLam;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    
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
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
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
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public String getChiNhanh() {
        return chiNhanh;
    }
    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }   
}