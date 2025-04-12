package BUS;

import DAL.LuongDAL;
import DTO.Luong;
import java.util.List;

public class LuongBUS {
    private LuongDAL luongDAL;

    public LuongBUS() {
        luongDAL = new LuongDAL();
    }

    // Lấy tất cả thông tin lương
    public List<Luong> getAllLuong() {
        return luongDAL.getAllLuong();
    }

    // Thêm lương mới
    public boolean addLuong(Luong l) {
        if (l == null) {
            System.out.println("Dữ liệu lương không hợp lệ!");
            return false;
        }
        return luongDAL.insertLuong(l);
    }

    // Cập nhật thông tin lương
    public boolean updateLuong(Luong l) {
        if (l == null || l.getMaLuong() <= 0) {
            System.out.println("Mã lương không hợp lệ!");
            return false;
        }
        return luongDAL.updateLuong(l);
    }

    // Xóa lương theo mã lương
    public boolean deleteLuong(int maLuong) {
        if (maLuong <= 0) {
            System.out.println("Mã lương không hợp lệ!");
            return false;
        }
        return luongDAL.deleteLuong(maLuong);
    }

    // Tìm kiếm lương theo mã nhân viên
    public List<Luong> searchLuongByMaNV(int maNV) {
        return getAllLuong().stream()
                .filter(l -> l.getMaNV() == maNV)
                .toList();
    }

    // Tìm kiếm lương theo tháng và năm
    public List<Luong> searchLuongByThangNam(int thang, int nam) {
        return getAllLuong().stream()
                .filter(l -> l.getThang() == thang && l.getNam() == nam)
                .toList();
    }

    // Tính tổng lương thực nhận cho một nhân viên cụ thể
    public double calculateTotalSalary(int maNV) {
        return getAllLuong().stream()
                .filter(l -> l.getMaNV() == maNV)
                .mapToDouble(Luong::getTongLuongNhan)
                .sum();
    }
    public List<Luong> getLuongByMonth(int year, int month) {
        return getAllLuong().stream()
                .filter(l -> l.getNam() == year && l.getThang() == month)
                .toList();
    }
}
