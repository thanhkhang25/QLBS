package DTO;

public class HeSoLuong {
    private String maHeSoLuong;
    private double luongCoBan;
    private double phuCapXang;
    private double phuCapBHXH;
    private double phuCapBHYT;
    private double phuCapBHTN;

    public HeSoLuong() {
    }

    public HeSoLuong(String maHeSoLuong, double luongCoBan, double phuCapXang, double phuCapBHXH, double phuCapBHYT, double phuCapBHTN) {
        this.maHeSoLuong = maHeSoLuong;
        this.luongCoBan = luongCoBan;
        this.phuCapXang = phuCapXang;
        this.phuCapBHXH = phuCapBHXH;
        this.phuCapBHYT = phuCapBHYT;
        this.phuCapBHTN = phuCapBHTN;
    }

    public String getMaHeSoLuong() {
        return maHeSoLuong;
    }

    public void setMaHeSoLuong(String maHeSoLuong) {
        this.maHeSoLuong = maHeSoLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getPhuCapXang() {
        return phuCapXang;
    }

    public void setPhuCapXang(double phuCapXang) {
        this.phuCapXang = phuCapXang;
    }

    public double getPhuCapBHXH() {
        return phuCapBHXH;
    }

    public void setPhuCapBHXH(double phuCapBHXH) {
        this.phuCapBHXH = phuCapBHXH;
    }

    public double getPhuCapBHYT() {
        return phuCapBHYT;
    }

    public void setPhuCapBHYT(double phuCapBHYT) {
        this.phuCapBHYT = phuCapBHYT;
    }

    public double getPhuCapBHTN() {
        return phuCapBHTN;
    }

    public void setPhuCapBHTN(double phuCapBHTN) {
        this.phuCapBHTN = phuCapBHTN;
    }
}
