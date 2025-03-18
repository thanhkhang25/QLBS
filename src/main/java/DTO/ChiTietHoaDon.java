package DTO;

public class ChiTietHoaDon {
    private int maHoaDon;
    private int maSach;  
    private int soLuong;
    private double donGia; // double for DECIMAL(12,2)

    // Constructors
    public ChiTietHoaDon() {
    }

    // Constructor without maHoaDon (for new details)
    public ChiTietHoaDon(int maSach, int soLuong, double donGia) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Constructor with maHoaDon (for existing details)
    public ChiTietHoaDon(int maHoaDon, int maSach, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Getters and Setters
    public int getmaHoaDon() {
        return maHoaDon;
    }

    public void setmaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getmaSach() {
        return maSach;
    }

    public void setmaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getsoLuong() {
        return soLuong;
    }

    public void setsoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getdonGia() {
        return donGia;
    }

    public void setdonGia(double donGia) {
        this.donGia = donGia;
    }

    // toString() method
    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maHoaDon=" + maHoaDon +
                ", maSach=" + maSach +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}