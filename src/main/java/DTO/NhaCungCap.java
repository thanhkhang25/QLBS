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
    public int getmaNCC() {
        return maNCC;
    }

    public void setmaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String gettenNCC() {
        return tenNCC;
    }

    public void settenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getdiaChi() {
        return diaChi;
    }

    public void setdiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
    }

    public String getsdt() {
        return sdt;
    }

    public void setsdt(String sdt) {
        this.sdt = sdt;
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