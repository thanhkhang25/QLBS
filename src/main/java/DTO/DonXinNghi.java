package DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DonXinNghi {
    private int maDon;
    private int maNV; 
    private int maNguoiDuyet;
    private LocalDateTime ngayNopDon;
    private String noiDung;
    private LocalDate ngayBatDau;
    private int soNgayNghi;
    private LocalDate ngayKetThuc;
    private LocalDateTime ngayDuyet;
    private String trangThai;
    
    public DonXinNghi() {
    }
    public DonXinNghi(int maDon, int maNV, int maNguoiDuyet, LocalDateTime ngayNopDon, String noiDung,
            LocalDate ngayBatDau, int soNgayNghi, LocalDate ngayKetThuc, LocalDateTime ngayDuyet, String trangThai) {
        this.maDon = maDon;
        this.maNV = maNV;
        this.maNguoiDuyet = maNguoiDuyet;
        this.ngayNopDon = ngayNopDon;
        this.noiDung = noiDung;
        this.ngayBatDau = ngayBatDau;
        this.soNgayNghi = soNgayNghi;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
    }

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
    public int getMaNguoiDuyet() {
        return maNguoiDuyet;
    }
    public void setMaNguoiDuyet(int maNguoiDuyet) {
        this.maNguoiDuyet = maNguoiDuyet;
    }
    public LocalDateTime getNgayNopDon() {
        return ngayNopDon;
    }
    public void setNgayNopDon(LocalDateTime ngayNopDon) {
        this.ngayNopDon = ngayNopDon;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public int getSoNgayNghi() {
        return soNgayNghi;
    }
    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }
    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public LocalDateTime getNgayDuyet() {
        return ngayDuyet;
    }
    public void setNgayDuyet(LocalDateTime ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
