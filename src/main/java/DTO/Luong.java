package DTO;

public class Luong {
    private int maLuong;
    private int maNV; 
    private int thang;
    private int nam;
    private int soNgayLam;
    private double luongCoBan;
    private double thuong;
    private double khauTru;
    private double phuCapXang;
    private double phuCapBHYT;
    private double phuCapBHXH;
    private double phuCapBHTN;
    private double tongLuongNhan;
    private String trangThai;
    
    public Luong() {
    }
    public Luong(int maLuong, int maNV, int thang, int nam, int soNgayLam, double luongCoBan, double thuong,
            double khauTru, double phuCapXang, double phuCapBHYT, double phuCapBHXH, double phuCapBHTN,
            double tongLuongNhan, String trangThai) {
        this.maLuong = maLuong;
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.soNgayLam = soNgayLam;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
        this.khauTru = khauTru;
        this.phuCapXang = phuCapXang;
        this.phuCapBHYT = phuCapBHYT;
        this.phuCapBHXH = phuCapBHXH;
        this.phuCapBHTN = phuCapBHTN;
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
    public double getLuongCoBan() {
        return luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    public double getThuong() {
        return thuong;
    }
    public void setThuong(double thuong) {
        this.thuong = thuong;
    }
    public double getKhauTru() {
        return khauTru;
    }
    public void setKhauTru(double khauTru) {
        this.khauTru = khauTru;
    }
    public double getPhuCapXang() {
        return phuCapXang;
    }
    public void setPhuCapXang(double phuCapXang) {
        this.phuCapXang = phuCapXang;
    }
    public double getPhuCapBHYT() {
        return phuCapBHYT;
    }
    public void setPhuCapBHYT(double phuCapBHYT) {
        this.phuCapBHYT = phuCapBHYT;
    }
    public double getPhuCapBHXH() {
        return phuCapBHXH;
    }
    public void setPhuCapBHXH(double phuCapBHXH) {
        this.phuCapBHXH = phuCapBHXH;
    }
    public double getPhuCapBHTN() {
        return phuCapBHTN;
    }
    public void setPhuCapBHTN(double phuCapBHTN) {
        this.phuCapBHTN = phuCapBHTN;
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
