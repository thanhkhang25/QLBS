package DTO;

import java.sql.Date;

public class PhieuNhap {
    private int maPN;
    private int maNCC; 
    private int maNV;
    private Date ngayNhap;
    private Status trangThai;      // Using enum
    private double tongTien; // double for DECIMAL(12,2)

    // Enum for trangThai
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public PhieuNhap() {
    }

    // Constructor without maPN (for new receipts)
    public PhieuNhap(int maNCC, int maNV, Date ngayNhap, Status trangThai, double tongTien) {
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    // Constructor with maPN (for existing receipts)
    public PhieuNhap(int maPN, int maNCC, int maNV, Date ngayNhap, Status trangThai, double tongTien) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    // Getters and Setters

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Status getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    
    // toString() method
    @Override
    public String toString() {
        return "PhieuNhap{" +
                "maPN=" + maPN +
                ", maNCC=" + maNCC +
                ", maNV=" + maNV +
                ", ngayNhap=" + ngayNhap +
                ", trangThai=" + trangThai +
                ", tongTien=" + tongTien +
                '}';
    }
}