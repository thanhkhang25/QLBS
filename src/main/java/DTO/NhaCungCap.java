package DTO;

public class NhaCungCap {
    private int maNCC;
    private String tenNCC;
    private String email;
    private String sdt;
    private String diaChi;
    private String trangThai;

    public NhaCungCap() {
    }
    public NhaCungCap(int maNCC, String tenNCC, String email, String sdt, String diaChi, String trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }
    
    public NhaCungCap(String tenNCC, String email, String sdt, String diaChi) {
        this.tenNCC = tenNCC;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }
    
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
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
