package DTO;

public class ChiTietKhuyenMaiHoaDon {
    private int maKM;
    private int maHD;
    private double giaHoaDon;

    public ChiTietKhuyenMaiHoaDon() {}
    public ChiTietKhuyenMaiHoaDon(int maKM, int maHD, double giaHoaDon) {
        this.maKM = maKM;
        this.maHD = maHD;
        this.giaHoaDon = giaHoaDon;
    }

    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }
    public int getMaHD() {
        return maHD;
    }
    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
    public double getGiaHoaDon() {
        return giaHoaDon;
    }
    public void setGiaHoaDon(double giaHoaDon) {
        this.giaHoaDon = giaHoaDon;
    }
}
