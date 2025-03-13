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

    public int getmaSach() {
        return maSach;
    }

    public void setmaSach(int maSach) {
        this.maSach = maSach;
    }
    
    public double getgiaBan(){
        return giaBan;
    }
    
    public void setgiaBan(double giaBan){
        this.giaBan = giaBan;
    }

    public Date getngayApDung() {
        return ngayApDung;
    }

    public void setngayApDung(Date ngayApDung) {
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