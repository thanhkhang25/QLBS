package BUS;

import DAL.SachDAL;
import DTO.Sach;

import java.util.List;

public class SachBUS {
    private SachDAL sachDAL;

    public SachBUS() {
        sachDAL = new SachDAL();
    }

    // Lấy danh sách tất cả sách
    public List<Sach> getAllSach() {
        return sachDAL.getAllSach();
    }

    // Thêm sách mới (Kiểm tra dữ liệu trước khi thêm)
    public boolean addSach(Sach sach) {
        if (sach.getTenSach().isEmpty() || sach.getGiaBan() <= 0 || sach.getSoLuongTonKho() < 0) {
            System.out.println("Dữ liệu không hợp lệ!");
            return false;
        }
        return sachDAL.insertSach(sach);
    }

    // Cập nhật sách (Kiểm tra dữ liệu trước khi cập nhật)
    public boolean updateSach(Sach sach) {
        if (sach.getMaSach() <= 0 || sach.getGiaBan() <= 0 || sach.getSoLuongTonKho() < 0) {
            System.out.println("Dữ liệu không hợp lệ!");
            return false;
        }
        return sachDAL.updateSach(sach);
    }
}
