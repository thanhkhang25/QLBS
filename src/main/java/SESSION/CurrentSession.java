package SESSION;

public class CurrentSession {
    private static int maNV = 27;
    private static String tenNV;
    private static int maTK; // Thêm thuộc tính mã tài khoản
    private static String chucVu="Quản lý nhân viên";
    
    public static int getMaNV() {
        return maNV;
    }
    
    public static void setMaNV(int maNV) {
        CurrentSession.maNV = maNV;
    }
    
    public static String getTenNV() {
        return tenNV;
    }
    
    public static void setTenNV(String tenNV) {
        CurrentSession.tenNV = tenNV;
    }
    
    public static int getMaTK() {
        return maTK;
    }
    
    public static void setMaTK(int maTK) {
        CurrentSession.maTK = maTK;
    }
    
    public static String getChucVu(){
        return chucVu;
    }
    
    public static void setChucVu(String chucVu){
        CurrentSession.chucVu = chucVu;
    }
    
    // Phương thức reset phiên nếu cần
    public static void clear() {
        maNV = 0;
        tenNV = null;
        maTK = 0;
        chucVu = null;
    }
}
