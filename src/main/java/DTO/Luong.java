package DTO;

public class Luong {
    private int maLuong;
    private int maNV; 
    private int thang;
    private int nam;
    private int soNgayLam;
    private String maHeSoLuong;  // Lưu mã hệ số lương (liên kết với bảng HeSoLuong)
    private double thuong;
    private double chuyencan;
    private double tongLuongNhan;
    private String trangThai;

    public Luong() {
    }

    public Luong(int maLuong, int maNV, int thang, int nam, int soNgayLam, String maHeSoLuong, double thuong, double chuyencan, double tongLuongNhan, String trangThai) {
        this.maLuong = maLuong;
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.soNgayLam = soNgayLam;
        this.maHeSoLuong = maHeSoLuong;
        this.thuong = thuong;
        this.chuyencan = chuyencan;
        this.tongLuongNhan = tongLuongNhan;
        this.trangThai = trangThai;
    }

    public int getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(int maLuong) {
        this.maLuong = maLuong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public String getMaHeSoLuong() {
        return maHeSoLuong;
    }

    public void setMaHeSoLuong(String maHeSoLuong) {
        this.maHeSoLuong = maHeSoLuong;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public double getChuyencan() {
        return chuyencan;
    }

    public void setChuyencan(double chuyencan) {
        this.chuyencan = chuyencan;
    }

    public double getTongLuongNhan() {
        return tongLuongNhan;
    }

    public void setTongLuongNhan(double tongLuongNhan) {
        this.tongLuongNhan = tongLuongNhan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
