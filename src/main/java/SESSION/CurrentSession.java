package SESSION;

public class CurrentSession {
    private static int maNV =20;
    private static String tenNV;
    private static int maTK; // Thêm thuộc tính mã tài khoản

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
    
    // Phương thức reset phiên nếu cần
    public static void clear() {
        maNV = 0;
        tenNV = null;
        maTK = 0;
    }
}
