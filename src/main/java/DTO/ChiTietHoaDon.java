package DTO;

public class ChiTietHoaDon {
    private int maHoaDon;
    private int maSach;  
    private int maKM;  
    private int soLuong;
    private double donGia;

    public ChiTietHoaDon() {}
    public ChiTietHoaDon(int maHoaDon, int maSach, int maKM, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.maKM = maKM;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
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
    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
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
}
