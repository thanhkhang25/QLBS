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
        CHUA_XU_LY, DA_DUYET, TU_CHOI
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
    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayNopDon() {
        return ngayNopDon;
    }

    public void setNgayNopDon(Date ngayNopDon) {
        this.ngayNopDon = ngayNopDon;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMaNguoiDuyet() {
        return maNguoiDuyet;
    }

    public void setMaNguoiDuyet(int maNguoiDuyet) {
        this.maNguoiDuyet = maNguoiDuyet;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
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