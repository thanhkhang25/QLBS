package DTO;

public class NhaCungCap {
    private int maNCC;
    private String tenNCC;
    private String diaChi;
    private String email;
    private String sdt;
    private Status trangThai; // Using the enum

    // Enum for trangThai
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public NhaCungCap() {
    }

    // Constructor without maNCC (for new suppliers)
    public NhaCungCap(String tenNCC, String diaChi, String email, String sdt, Status trangThai) {
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    // Constructor with maNCC (for existing suppliers)
    public NhaCungCap(int maNCC, String tenNCC, String diaChi, String email, String sdt, Status trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email; 
        this.sdt = sdt;
        this.trangThai = trangThai;
    }
    
    // Getters and Setters

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
        return "NhaCungCap{" +
                "maNCC=" + maNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}