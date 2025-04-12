package BUS;

import DAL.KhuyenMaiHoaDonDAL;
import DTO.ChiTietKhuyenMaiHoaDon;
import java.util.List;

public class KhuyenMaiHoaDonBUS {
    private KhuyenMaiHoaDonDAL khuyenMaiHoaDonDAL;

    public KhuyenMaiHoaDonBUS() {
        this.khuyenMaiHoaDonDAL = new KhuyenMaiHoaDonDAL();
    }

//     🟢 Lấy danh sách khuyến mãi hóa đơn (đang diễn ra)
    public List<ChiTietKhuyenMaiHoaDon> getDanhSachKhuyenMaiHoaDon() {
        return khuyenMaiHoaDonDAL.layDanhSachKhuyenMaiHoaDon();
    }

    // 🟢 Thêm khuyến mãi hóa đơn
    public boolean addKhuyenMaiHoaDon(ChiTietKhuyenMaiHoaDon km) {
        return khuyenMaiHoaDonDAL.themKhuyenMaiHoaDon(km);
    }
}
