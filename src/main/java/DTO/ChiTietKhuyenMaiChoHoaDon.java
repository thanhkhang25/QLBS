package DTO;

public class ChiTietKhuyenMaiChoHoaDon {
    private int maKM;  // Mã khuyến mãi
    private int maHD;  // Mã hóa đơn
    private String dieuKien; // Điều kiện áp dụng khuyến mãi

    // Constructors
    public ChiTietKhuyenMaiChoHoaDon() {
    }

    public ChiTietKhuyenMaiChoHoaDon(int maKM, int maHD, String dieuKien) {
        this.maKM = maKM;
        this.maHD = maHD;
        this.dieuKien = dieuKien;
    }

    // Getters and Setters

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

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    // toString() method
    @Override
    public String toString() {
        return "ChiTietKhuyenMaiChoHoaDon{" +
                "maKM=" + maKM +
                ", maHD=" + maHD +
                ", dieuKien='" + dieuKien + '\'' +
                '}';
    }
}
