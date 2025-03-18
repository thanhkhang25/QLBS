package DTO;

import java.sql.Date;

public class DonXinNghi {
    private int maDon;
    private int maNV; 
    private Date ngayNopDon;
    private String lyDo;
    private int soNgayNghi;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int maNguoiDuyet;
    private Date ngayDuyet;
    private Status trangThai;      // Using enum

    // Enum for trangThai
    public enum Status {
        ChuaXuLy, DaDuyet, TuChoi
    }

    // Constructors
    public DonXinNghi() {
    }

    // Constructor without maDon (Tao moi)
    public DonXinNghi(int maNV, Date ngayNopDon, String lyDo, int soNgayNghi, Date ngayBatDau, Date ngayKetThuc, int maNguoiDuyet, Date ngayDuyet, Status trangThai) {
        this.maNV = maNV;
        this.ngayNopDon = ngayNopDon;
        this.lyDo = lyDo;
        this.soNgayNghi = soNgayNghi;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maNguoiDuyet = maNguoiDuyet;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
    }

    // Constructor with maDon (for existing receipts)
    public DonXinNghi(int maDon,int maNV, Date ngayNopDon, String lyDo, int soNgayNghi, Date ngayBatDau, Date ngayKetThuc, int maNguoiDuyet, Date ngayDuyet, Status trangThai) {
        this.maDon = maDon;
        this.maNV = maNV;
        this.ngayNopDon = ngayNopDon;
        this.lyDo = lyDo;
        this.soNgayNghi = soNgayNghi;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maNguoiDuyet = maNguoiDuyet;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getmaDon() {
        return maDon;
    }

    public void setmaDon(int maDon) {
        this.maDon = maDon;
    }

    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getngayNopDon() {
        return ngayNopDon;
    }

    public void setngayNopDon(Date ngayNopDon) {
        this.ngayNopDon = ngayNopDon;
    }
    
    public String getlyDo(){
        return lyDo;
    }
    
    public void setlyDo(String lyDo){
        this.lyDo = lyDo;
    }

    public int getsoNgayNghi(){
        return soNgayNghi;
    }
    
    public void setsoNgayNghi(int soNgayNghi){
        this.soNgayNghi = soNgayNghi;
    }
    
    public Date getngayBatDau() {
        return ngayBatDau;
    }
    
    public void setngayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    
    public Date getngayKetThuc() {
        return ngayKetThuc;
    }

    public void setngayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public int getmaNguoiDuyet() {
        return maNguoiDuyet;
    }

    public void setmaNguoiDuyet(int maNguoiDuyet) {
        this.maNguoiDuyet = maNguoiDuyet;
    }
    
    public Date getngayDuyet() {
        return ngayDuyet;
    }

    public void setngayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
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
        return "DonXinNghi{" +
                "maDon=" + maDon +
                ", maNV=" + maNV +
                ", ngayNopDon=" + ngayNopDon +
                ", lyDo=" + lyDo +
                ", soNgayNghi=" + soNgayNghi +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", maNguoiDuyet=" + maNV +
                ", ngayDuyet=" + ngayDuyet +
                ", trangThai=" + trangThai +
                '}';
    }
}