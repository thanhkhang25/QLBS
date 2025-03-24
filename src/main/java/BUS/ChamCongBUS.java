package BUS;

import DAL.ChamCongDAL;
import DTO.ChamCong;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChamCongBUS {
    private ChamCongDAL ccDAL;

    public ChamCongBUS() {
        ccDAL = new ChamCongDAL();
    }
    
    // Lấy toàn bộ bản ghi chấm công
    public List<ChamCong> getAllChamCong() {
        return ccDAL.getAllChamCong();
    }
    
    // Tìm kiếm bản ghi chấm công theo từ khóa:
    // Nếu từ khóa là số, ta kiểm tra xem mã NV có chứa từ khóa đó hay không.
    // Nếu từ khóa là chữ, ta có thể để GUI xử lý việc so sánh tên NV (do bảng ChamCong không có tên NV).
    public List<ChamCong> searchChamCongByKeyword(String keyword) {
        List<ChamCong> allList = getAllChamCong();
        List<ChamCong> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return allList;
        }
        keyword = keyword.trim().toLowerCase();

        // Tạo instance của NhanVienBUS để lấy thông tin nhân viên
        BUS.NhanVienBUS nvBUS = new BUS.NhanVienBUS();

        for (ChamCong cc : allList) {
            String maNVStr = String.valueOf(cc.getMaNV());
            // Lấy thông tin nhân viên theo maNV
            DTO.NhanVien nv = nvBUS.getNhanVienByMaNV(cc.getMaNV());
            String tenNV = (nv != null) ? nv.getTenNV().toLowerCase() : "";

            // Nếu từ khóa xuất hiện trong mã NV hoặc tên NV thì thêm bản ghi này vào kết quả
            if (maNVStr.contains(keyword) || tenNV.contains(keyword)) {
                result.add(cc);
            }
        }
        return result;
    }

    
    // Lọc các bản ghi chấm công theo khoảng thời gian
    public List<ChamCong> filterChamCongByDate(LocalDate from, LocalDate to) {
        List<ChamCong> allList = getAllChamCong();
        List<ChamCong> result = new ArrayList<>();
        for (ChamCong cc : allList) {
            LocalDate date = cc.getThoiGianChamCong().toLocalDate();
            // Nếu ngày chấm công nằm trong khoảng từ 'from' đến 'to'
            if ((date.isEqual(from) || date.isAfter(from)) && (date.isEqual(to) || date.isBefore(to))) {
                result.add(cc);
            }
        }
        return result;
    }
    
    // Thêm mới một bản ghi chấm công cho nhân viên với mã NV cho trước.
    // Nếu thêm thành công, trả về true, ngược lại false.
    public boolean addChamCong(int maNV) {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        // Kiểm tra nếu nhân viên đã chấm công hôm nay
        if (ccDAL.hasChamCongToday(maNV, today)) {
            System.out.println("Nhân viên " + maNV + " đã chấm công hôm nay.");
            return false;
        }
        // Nếu chưa chấm, lấy thời gian hiện tại (loại bỏ nano)
        LocalDateTime currentTime = LocalDateTime.now().withNano(0);
        ChamCong cc = new ChamCong();
        cc.setMaNV(maNV);
        cc.setThoiGianChamCong(currentTime);
        return ccDAL.insertChamCong(cc);
    }

    public boolean hasChamCongToday(int maNV) {
        LocalDate today = LocalDate.now();
        return ccDAL.hasChamCongToday(maNV, today);
    }


}
