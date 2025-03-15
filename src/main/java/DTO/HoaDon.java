package DTO;

import java.sql.Date;

public class HoaDon {
    private int maHoaDon;
    private int maNV;
    private Date ngayBan;
    private int maKM;
    private double tongTien; // double for DECIMAL(12,2)
    private Status trangThai;     // Using enum

    // Enum for trangThai
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public HoaDon() {
    }

    // Constructor without maHoaDon (for new receipts)
    public HoaDon(int maNV, Date ngayBan, int maKM, double tongTien, Status trangThai) {
        this.maNV = maNV;
        this.ngayBan = ngayBan;
        this.maKM = maKM;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    // Constructor with maHoaDon (for existing receipts)
    public HoaDon(int maHoaDon, int maNV, int maKM, Date ngayBan, double tongTien, Status trangThai) {
        this.maHoaDon = maHoaDon;
        this.maNV = maNV;
        this.ngayBan = ngayBan;
        this.maKM = maKM;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
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
        return "HoaDon{" +
                "maHoaDon=" + maHoaDon +
                ", maNV=" + maNV +
                ", ngayBan=" + ngayBan +
                ", maKM=" + maKM +
                ", tongTien=" + tongTien +
                ", trangThai=" + trangThai +
                '}';
    }
}