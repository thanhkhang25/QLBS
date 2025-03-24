package BUS;

import DAL.DonXinNghiDAL;
import DTO.DonXinNghi;
import SESSION.CurrentSession;
import java.time.LocalDateTime;
import java.util.List;

public class DonXinNghiBUS {
    private DonXinNghiDAL donXinNghiDAL;

    public DonXinNghiBUS() {
        donXinNghiDAL = new DonXinNghiDAL();
    }

    // Lấy toàn bộ danh sách đơn xin nghỉ
    public List<DonXinNghi> getAllDonXinNghi() {
        return donXinNghiDAL.getAllDonXinNghi();
    }

    // Thêm mới đơn xin nghỉ
    public boolean addDonXinNghi(DonXinNghi don) {
        if (don == null) {
            System.out.println("Dữ liệu đơn xin nghỉ không hợp lệ!");
            return false;
        }
        // Có thể thêm kiểm tra các điều kiện khác (ví dụ: ngày bắt đầu, số ngày nghỉ, ...
        return donXinNghiDAL.insertDonXinNghi(don);
    }

    // Cập nhật đơn xin nghỉ
    public boolean updateDonXinNghi(DonXinNghi don) {
        if (don == null || don.getMaDon() <= 0) {
            System.out.println("Mã đơn xin nghỉ không hợp lệ!");
            return false;
        }
        return donXinNghiDAL.updateDonXinNghi(don);
    }

    // Xóa đơn xin nghỉ theo mã đơn
    public boolean deleteDonXinNghi(int maDon) {
        if (maDon <= 0) {
            System.out.println("Mã đơn xin nghỉ không hợp lệ!");
            return false;
        }
        return donXinNghiDAL.deleteDonXinNghi(maDon);
    }
    // Lấy đơn xin nghỉ theo mã đơn (tìm kiếm trong danh sách hiện có)
    public DonXinNghi getDonXinNghiByMaDon(int maDon) {
        List<DonXinNghi> list = getAllDonXinNghi();
        for (DonXinNghi don : list) {
            if (don.getMaDon() == maDon) {
                return don;
            }
        }
        return null;
    }
    // Phương thức duyệt đơn xin nghỉ:
    public boolean approveDonXinNghi(int maDon) {
        // Lấy mã nhân viên của người duyệt từ phiên đăng nhập
        int maNguoiDuyet = CurrentSession.getMaNV();
        // Lấy thời gian duyệt hiện tại
        LocalDateTime ngayDuyet = LocalDateTime.now();

        // Lấy đơn xin nghỉ cần duyệt (bạn có thể bổ sung phương thức getDonXinNghiByMaDon nếu cần)
        List<DonXinNghi> list = getAllDonXinNghi();
        DonXinNghi donToUpdate = null;
        for (DonXinNghi d : list) {
            if (d.getMaDon() == maDon) {
                donToUpdate = d;
                break;
            }
        }
        if (donToUpdate == null) {
            System.out.println("Không tìm thấy đơn xin nghỉ có mã: " + maDon);
            return false;
        }
        // Cập nhật các trường theo yêu cầu
        donToUpdate.setMaNguoiDuyet(maNguoiDuyet);
        donToUpdate.setNgayDuyet(ngayDuyet);
        donToUpdate.setTrangThai("Đã duyệt");
        return updateDonXinNghi(donToUpdate);
    }

    // Phương thức từ chối đơn xin nghỉ:
    public boolean disapproveDonXinNghi(int maDon) {
        int maNguoiDuyet = CurrentSession.getMaNV();
        LocalDateTime ngayDuyet = LocalDateTime.now();

        List<DonXinNghi> list = getAllDonXinNghi();
        DonXinNghi donToUpdate = null;
        for (DonXinNghi d : list) {
            if (d.getMaDon() == maDon) {
                donToUpdate = d;
                break;
            }
        }
        if (donToUpdate == null) {
            System.out.println("Không tìm thấy đơn xin nghỉ có mã: " + maDon);
            return false;
        }
        donToUpdate.setMaNguoiDuyet(maNguoiDuyet);
        donToUpdate.setNgayDuyet(ngayDuyet);
        donToUpdate.setTrangThai("Bị từ chối");
        return updateDonXinNghi(donToUpdate);
    }
}
