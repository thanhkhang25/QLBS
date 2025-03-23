package DTO;

public class Sach {
    private int maSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private String donViTinh;
    private double giaBan;
    private double giaDaGiam;
    private double giaNhap;
    private int soLuongTonKho;
    private String chiNhanh;
    private String trangThai;
    public Sach() {
    }
    public Sach(int maSach, String tenSach, String theLoai, String tacGia, String donViTinh, double giaBan,
            double giaDaGiam, double giaNhap, int soLuongTonKho, String chiNhanh, String trangThai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.donViTinh = donViTinh;
        this.giaBan = giaBan;
        this.giaDaGiam = giaDaGiam;
        this.giaNhap = giaNhap;
        this.soLuongTonKho = soLuongTonKho;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    public int getMaSach() {
        return maSach;
    }
    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public String getTheLoai() {
        return theLoai;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public double getGiaDaGiam() {
        return giaDaGiam;
    }
    public void setGiaDaGiam(double giaDaGiam) {
        this.giaDaGiam = giaDaGiam;
    }
    public double getGiaNhap() {
        return giaNhap;
    }
    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }
    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }
    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
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
