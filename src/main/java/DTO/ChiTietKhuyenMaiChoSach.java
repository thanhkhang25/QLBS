package DTO;

public class ChiTietKhuyenMaiChoSach {
    private int maKM; // Khóa ngoại đến bảng KhuyenMai
    private int maSach; // Khóa ngoại đến bảng Sach

    // Constructors
    public ChiTietKhuyenMaiChoSach() {
    }

    public ChiTietKhuyenMaiChoSach(int maKM, int maSach) {
        this.maKM = maKM;
        this.maSach = maSach;
    }

    // Getters and Setters

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    // toString() method
    @Override
    public String toString() {
        return "ChiTietKhuyenMaiChoSach{" +
                "maKM=" + maKM +
                ", maSach=" + maSach +
                '}';
    }
}
