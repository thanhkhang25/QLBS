package DTO;

public class ChiTietPhieuXuat {
    private int maPX;
    private int maSach; 
    private int soLuong;

    // Constructors
    public ChiTietPhieuXuat() {
    }

    // Constructor without maPX (for new details)
    public ChiTietPhieuXuat(int maSach, int soLuong) {
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    // Constructor with maPX (for existing details)
    public ChiTietPhieuXuat(int maPX, int maSach, int soLuong) {
        this.maPX = maPX;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }
    
    // Getters and Setters
    public int getMaPX() {
        return maPX;
    }

    public void setMaPX(int maPX) {
        this.maPX = maPX;
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

    // toString() method
    @Override
    public String toString() {
        return "ChiTietPhieuXuat{" +
                "maPX=" + maPX +
                ", maSach=" + maSach +
                ", soLuong=" + soLuong +
                '}';
    }
}