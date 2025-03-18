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
    public int getmaCC() {
        return maCC;
    }

    public void setmaCC(int maCC) {
        this.maCC = maCC;
    }

    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getngay() {
        return ngay;
    }

    public void setngay(Date ngay) {
        this.ngay = ngay;
    }
    
    public String getloaiChamCong(){
        return loaiChamCong;
    }
    
    public void setloaiChamCong(String loaiChamCong){
        this.loaiChamCong = loaiChamCong;
    }

    public Time getthoiGianChamCong() {
        return thoiGianChamCong;
    }

    public void setthoiGianChamCong(Time thoiGianChamCong) {
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