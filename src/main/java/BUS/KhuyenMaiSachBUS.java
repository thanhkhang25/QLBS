package BUS;

import DAL.KhuyenMaiSachDAL;
import DTO.ChiTietKhuyenMaiSach;
import java.util.List;

public class KhuyenMaiSachBUS {
    private KhuyenMaiSachDAL khuyenMaiSachDAL;

    public KhuyenMaiSachBUS() {
        this.khuyenMaiSachDAL = new KhuyenMaiSachDAL();
    }

    // Thêm khuyến mãi sách với kiểm tra hợp lệ
    public boolean themKhuyenMaiSach(ChiTietKhuyenMaiSach kmSach) {
        return khuyenMaiSachDAL.themKhuyenMaiSach(kmSach);
    }

    // Lấy danh sách khuyến mãi sách
    public List<ChiTietKhuyenMaiSach> getAllKhuyenMaiSach() {
        return khuyenMaiSachDAL.layDanhSachKhuyenMaiSach();
    }
}
