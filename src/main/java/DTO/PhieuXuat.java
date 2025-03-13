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
    public int getmaPX() {
        return maPX;
    }

    public void setmaPX(int maPX) {
        this.maPX = maPX;
    }

    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getngayXuat() {
        return ngayXuat;
    }

    public void setngayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
    
    public String getchiNhanh(){
        return chiNhanh;
    }
    
    public void setchiNhanh(String chiNhanh){
        this.chiNhanh = chiNhanh;
    }

    public Status gettrangThai() {
        return trangThai;
    }

    public void settrangThai(Status trangThai) {
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