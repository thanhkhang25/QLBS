package DTO;

import java.sql.Date;

public class LichSuGiaBan {
    private int maSach;
    private double giaBan; 
    private Date ngayApDung;

    // Constructors
    public LichSuGiaBan() {
    }

    // Constructor without maPX (for new details)
    public LichSuGiaBan(double giaBan, Date ngayApDung) {
        this.giaBan = giaBan;
        this.ngayApDung = ngayApDung;
    }

    // Constructor with maPX (for existing details)
    public LichSuGiaBan(int maSach, double giaBan, Date ngayApDung) {
        this.maSach = maSach;
        this.giaBan = giaBan;
        this.ngayApDung = ngayApDung;
    }

    // Getters and Setters

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }


    // toString() method
    @Override
    public String toString() {
        return "LichSuGiaBan{" +
                "maSach=" + maSach +
                ", giaBan=" + giaBan +
                ", ngayApDung=" + ngayApDung +
                '}';
    }
}