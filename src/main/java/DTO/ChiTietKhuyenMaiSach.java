package DTO;

public class ChiTietKhuyenMaiSach {
    private int maKM;
    private int maSach;
    private double giaDaGiam;

    public ChiTietKhuyenMaiSach() {}
    public ChiTietKhuyenMaiSach(int maKM, int maSach, double giaDaGiam) {
        this.maKM = maKM;
        this.maSach = maSach;
        this.giaDaGiam = giaDaGiam;
    }

    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }
    public int getMaSach() {
        return maSach;
    }
    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    public double getGiaDaGiam() {
        return giaDaGiam;
    }
    public void setGiaDaGiam(double giaDaGiam) {
        this.giaDaGiam = giaDaGiam;
    }
}
