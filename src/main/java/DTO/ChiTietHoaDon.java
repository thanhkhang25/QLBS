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
       public int getMaHoaDon() {
           return maHoaDon;
       }

       public void setMaHoaDon(int maHoaDon) {
           this.maHoaDon = maHoaDon;
       }

       public int getMaSach() {
           return maSach;
       }

       public void setMaSach(int maSach) {
           this.maSach = maSach;
       }

       public int getSoLuong() {
           return soLuong;
       }

       public void setSoLuong(int soLuong) {
           this.soLuong = soLuong;
       }

       public double getDonGia() {
           return donGia;
       }

       public void setDonGia(double donGia) {
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