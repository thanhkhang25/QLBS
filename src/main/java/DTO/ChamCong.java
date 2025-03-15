package DTO;

import java.sql.Date;
import java.sql.Time;

public class ChamCong {
    private int maCC;
    private int maNV; 
    private Date ngay;
    private String loaiChamCong;
    private Time thoiGianChamCong;      


    // Constructors
    public ChamCong() {
    }

    // Constructor without maCC (for new receipts)
    public ChamCong(int maNV, Date ngay,String loaiChamCong, Time thoiGianChamCong) {
        this.maNV = maNV;
        this.ngay = ngay;
        this.loaiChamCong = loaiChamCong;
        this.thoiGianChamCong = thoiGianChamCong;
    }

    // Constructor with maCC (for existing receipts)
    public ChamCong(int maCC, int maNV, Date ngay, String loaiChamCong, Time thoiGianChamCong) {
        this.maCC = maCC;
        this.maNV = maNV;
        this.ngay = ngay;
        this.loaiChamCong = loaiChamCong;
        this.thoiGianChamCong = thoiGianChamCong;
    }

    // Getters and Setters
    public int getMaCC() {
        return maCC;
    }

    public void setMaCC(int maCC) {
        this.maCC = maCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getLoaiChamCong() {
        return loaiChamCong;
    }

    public void setLoaiChamCong(String loaiChamCong) {
        this.loaiChamCong = loaiChamCong;
    }

    public Time getThoiGianChamCong() {
        return thoiGianChamCong;
    }

    public void setThoiGianChamCong(Time thoiGianChamCong) {
        this.thoiGianChamCong = thoiGianChamCong;
    }

    // toString() method
    @Override
    public String toString() {
        return "ChamCong{" +
                "maCC=" + maCC +
                ", maNV=" + maNV +
                ", ngay=" + ngay +
                ", loaiChamCong=" + loaiChamCong +
                ", thoiGianChamCong=" + thoiGianChamCong +
                '}';
    }
}