package DTO;

public class TaiKhoan {
    private int maTK;
    private int maNV; 
    private String matKhau;
    private String chucVu;
    private String trangThai;

    public TaiKhoan() {}
    public TaiKhoan(int maTK, int maNV, String matKhau, String chucVu, String trangThai) {
        this.maTK = maTK;
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public int getMaTK() {
        return maTK;
    }
    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }
    public int getMaNV() {
        return maNV;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }    
}
