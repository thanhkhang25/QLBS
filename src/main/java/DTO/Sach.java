package DTO;

public class Sach {
    private int maSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private String chiNhanh;
    private Status trangThai; // Using the enum

    // Enum for trangThai
    public enum Status {
        AVAILABLE, OUT_OF_STOCK
    }

    // Constructors
    public Sach() {
    }

    // Constructor without maSach (for new suppliers)
    public Sach(String tenSach, String theLoai, String tacGia, String chiNhanh, Status trangThai) {
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }

    // Constructor with maSach (for existing suppliers)
    public Sach(int maSach, String tenSach, String theLoai, String tacGia, String chiNhanh, Status trangThai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia; 
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }

    // Getters and Setters

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

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public Status getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }

    // toString() method
    @Override
    public String toString() {
        return "Sach{" +
                "maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chiNhanh='" + chiNhanh + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}