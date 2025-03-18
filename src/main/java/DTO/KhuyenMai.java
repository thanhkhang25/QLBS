package DTO;

import java.util.Date;

public class KhuyenMai {
    private int maKM;
    private String tenKM;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private double phanTramGiam;
    private Status trangThai; // Enum cho trạng thái

    // Enum cho trạng thái khuyến mãi
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public KhuyenMai() {
    }

    public KhuyenMai(String tenKM, Date ngayBatDau, Date ngayKetThuc, double phanTramGiam, Status trangThai) {
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.trangThai = trangThai;
    }

    public KhuyenMai(int maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc, double phanTramGiam, Status trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.trangThai = trangThai;
    }

    // Getters and Setters

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(double phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public Status getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }

    // toString() method
    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM=" + maKM +
                ", tenKM='" + tenKM + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", phanTramGiam=" + phanTramGiam +
                ", trangThai=" + trangThai +
                '}';
    }
}
