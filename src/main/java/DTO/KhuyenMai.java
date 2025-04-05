package DTO;

import java.time.LocalDate;

public class KhuyenMai {
    private int maKM;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private double phanTramGiam;
    private String trangThai;

    public KhuyenMai() {}
    public KhuyenMai(int maKM, LocalDate ngayBatDau, LocalDate ngayKetThuc, double phanTramGiam, String trangThai) {
        this.maKM = maKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.trangThai = trangThai;
    }

    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }
    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public double getPhanTramGiam() {
        return phanTramGiam;
    }
    public void setPhanTramGiam(double phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
