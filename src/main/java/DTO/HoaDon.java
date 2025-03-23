package DTO;

import java.time.LocalDateTime;

public class HoaDon {
    private int maHoaDon;
    private int maNV;
    private int maKM;
    private LocalDateTime ngayBan;
    private double tongTien;
    private String chiNhanh;
    private String trangThai;

    public HoaDon() {}
    public HoaDon(int maHoaDon, int maNV, int maKM, LocalDateTime ngayBan, double tongTien, String chiNhanh,
            String trangThai) {
        this.maHoaDon = maHoaDon;
        this.maNV = maNV;
        this.maKM = maKM;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    
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
    public int getMaKM() {
        return maKM;
    }
    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }
    public LocalDateTime getNgayBan() {
        return ngayBan;
    }
    public void setNgayBan(LocalDateTime ngayBan) {
        this.ngayBan = ngayBan;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public String getChiNhanh() {
        return chiNhanh;
    }
    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
