package DTO;

public class Sach {
    private int maSach;
    private String tenSach;
    private String theLoai;
    private String tacGia;
    private String chiNhanh;
    private Status trangThai; // Using the enum

    // Enum for trangThai
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public Sach() {
    }

    // Constructor without maSach (for new suppliers)
    public Sach(String tenSach, String theLoai, String tacGia, String chiNhanh, Status trangThai) {
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }

    // Constructor with maSach (for existing suppliers)
    public Sach(int maSach, String tenSach, String theLoai, String tacGia, String chiNhanh, Status trangThai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia; 
        this.chiNhanh = chiNhanh;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getmaSach() {
        return maSach;
    }

    public void setmaSach(int maSach) {
        this.maSach = maSach;
    }

    public String gettenSach() {
        return tenSach;
    }

    public void settenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String gettheLoai() {
        return theLoai;
    }

    public void settheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    
    public String gettacGia(){
        return tacGia;
    }
    
    public void settacGia(String tacGia){
        this.tacGia = tacGia;
    }

    public String getchiNhanh() {
        return chiNhanh;
    }

    public void setchiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
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
        return "Sach{" +
                "maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chiNhanh='" + chiNhanh + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}