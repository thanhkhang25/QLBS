package DTO;

import java.time.LocalDate;

public class ChiTietKhuyenMaiHoaDon {
    private int maKM;
    private int maHD;
    private double giaHoaDon;
    private int phanTramGiam;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String trangThai;

    public ChiTietKhuyenMaiHoaDon() {}
    public ChiTietKhuyenMaiHoaDon(int maKM, int maHD, double giaHoaDon, int phanTramGiam, LocalDate ngayBatDau, LocalDate ngayKetThuc, String trangThai) {
        this.maKM = maKM;
        this.maHD = maHD;
        this.giaHoaDon = giaHoaDon;
        this.phanTramGiam = phanTramGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }
    public ChiTietKhuyenMaiHoaDon(int maKM, LocalDate ngayBatDau, LocalDate ngayKetThuc, int phanTramGiam, double giaHoaDon, String trangThai) {
        this.maKM = maKM;
        this.giaHoaDon = giaHoaDon;
        this.phanTramGiam = phanTramGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }
    public ChiTietKhuyenMaiHoaDon(LocalDate ngayBatDau, LocalDate ngayKetThuc, double giaHoaDon, int phanTramGiam) {
        this.giaHoaDon = giaHoaDon;
        this.phanTramGiam = phanTramGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
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
    public int getPhanTramGiam() {
        return phanTramGiam;
    }
    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
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
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}