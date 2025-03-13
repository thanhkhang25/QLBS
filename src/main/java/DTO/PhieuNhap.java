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
    public int getmaPN() {
        return maPN;
    }

    public void setmaPN(int maPN) {
        this.maPN = maPN;
    }

    public int getmaNCC() {
        return maNCC;
    }

    public void setmaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getngayNhap() {
        return ngayNhap;
    }

    public void setngayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Status gettrangThai() {
        return trangThai;
    }

    public void settrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }

    public double gettongTien() {
        return tongTien;
    }

    public void settongTien(double tongTien) {
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