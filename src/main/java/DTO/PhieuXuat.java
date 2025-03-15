package DTO;

import java.sql.Date;

public class PhieuXuat {
    private int maPX;
    private int maNV; 
    private Date ngayXuat;
    private String chiNhanh;
    private Status trangThai;      // Using enum

    // Enum for trangThai
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public PhieuXuat() {
    }

    // Constructor without maPX (for new receipts)
    public PhieuXuat(int maNV, Date ngayXuat,String chiNhanh, Status trangThai) {
        this.maNV = maNV;
        this.ngayXuat = ngayXuat;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }

    // Constructor with maPX (for existing receipts)
    public PhieuXuat(int maPX, int maNV, Date ngayXuat, String chiNhanh, Status trangThai) {
        this.maPX = maPX;
        this.maNV = maNV;
        this.ngayXuat = ngayXuat;
        this.trangThai = trangThai;
    }

    // Getters and Setters

    public int getMaPX() {
        return maPX;
    }

    public void setMaPX(int maPX) {
        this.maPX = maPX;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
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
        return "PhieuXuat{" +
                "maPX=" + maPX +
                ", maNV=" + maNV +
                ", ngayXuat=" + ngayXuat +
                ", maPX=" + maPX +
                ", chiNhanh=" + chiNhanh +
                ", trangThai=" + trangThai +
                '}';
    }
}