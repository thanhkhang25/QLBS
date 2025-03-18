package DTO;

public class ChiTietPhieuNhap {
    private int maPN;
    private int maSach; 
    private int soLuong;
    private double giaNhap; // double for DECIMAL(12,2)

    // Constructors
    public ChiTietPhieuNhap() {
    }

    // Constructor without maPN (for new details)
    public ChiTietPhieuNhap(int maSach, int soLuong, double giaNhap) {
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    // Constructor with maPN (for existing details)
    public ChiTietPhieuNhap(int maPN, int maSach, int soLuong, double giaNhap) {
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    // Getters and Setters
    public int getmaPN() {
        return maPN;
    }

    public void setmaPN(int maPN) {
        this.maPN = maPN;
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

    public double getgiaNhap() {
        return giaNhap;
    }

    public void setgiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    // toString() method
    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" +
                "maPN=" + maPN +
                ", maSach=" + maSach +
                ", soLuong=" + soLuong +
                ", giaNhap=" + giaNhap +
                '}';
    }
}