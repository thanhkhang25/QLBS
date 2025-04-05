package DTO;

public class ChiTietPhieuXuat {
    private int maPX;
    private int maSach; 
    private int soLuong;

    public ChiTietPhieuXuat() {}
    public ChiTietPhieuXuat(int maPX, int maSach, int soLuong) {
        this.maPX = maPX;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }
    
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
}
