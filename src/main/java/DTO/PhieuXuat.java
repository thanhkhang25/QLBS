package DTO;

import java.time.LocalDateTime;

public class PhieuXuat {
    private int maPX;
    private int maNV; 
    private LocalDateTime ngayXuat;
    private String chiNhanh;
    private String trangThai;

    public PhieuXuat() {}
    public PhieuXuat(int maPX, int maNV, LocalDateTime ngayXuat, String chiNhanh, String trangThai) {
        this.maPX = maPX;
        this.maNV = maNV;
        this.ngayXuat = ngayXuat;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }
    
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
    public LocalDateTime getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(LocalDateTime ngayXuat) {
        this.ngayXuat = ngayXuat;
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
