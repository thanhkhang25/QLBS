package BUS;

import DAL.HeSoLuongDAL;
import DTO.HeSoLuong;
import java.util.List;

public class HeSoLuongBUS {
    private HeSoLuongDAL hslDAL;

    public HeSoLuongBUS() {
        hslDAL = new HeSoLuongDAL();
    }

    // Lấy danh sách hệ số lương
    public List<HeSoLuong> getAllHeSoLuong() {
        return hslDAL.getAllHeSoLuong();
    }
    // Tìm kiếm hệ số lương theo mã (nhận vào dạng số, chuyển sang chuỗi)
    public List<HeSoLuong> searchHeSoLuongByMa(String ma) {
        // Nếu bạn có SP tìm kiếm riêng trong DAL, gọi luôn:
        return hslDAL.searchHeSoLuongByMa(ma);
        
        /*// Nếu không, bạn có thể lấy toàn bộ rồi lọc:
        return getAllHeSoLuong().stream()
                .filter(hsl -> hsl.getMaHeSoLuong().equals(String.valueOf(ma)))
                .collect(Collectors.toList());*/
    }

    // Thêm mới hệ số lương
    public boolean addHeSoLuong(HeSoLuong hsl) {
        if (hsl == null || hsl.getMaHeSoLuong() == null || hsl.getMaHeSoLuong().trim().isEmpty()) {
            System.out.println("Dữ liệu hệ số lương không hợp lệ!");
            return false;
        }
        return hslDAL.insertHeSoLuong(hsl);
    }

    // Cập nhật hệ số lương
    public boolean updateHeSoLuong(HeSoLuong hsl) {
        if (hsl == null || hsl.getMaHeSoLuong() == null || hsl.getMaHeSoLuong().trim().isEmpty()) {
            System.out.println("Mã hệ số lương không hợp lệ!");
            return false;
        }
        return hslDAL.updateHeSoLuong(hsl);
    }

    // Xóa hệ số lương theo mã
    public boolean deleteHeSoLuong(String maHeSoLuong) {
        if (maHeSoLuong == null || maHeSoLuong.trim().isEmpty()) {
            System.out.println("Mã hệ số lương không hợp lệ!");
            return false;
        }
        return hslDAL.deleteHeSoLuong(maHeSoLuong);
    }
}
