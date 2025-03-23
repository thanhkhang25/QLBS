package BUS;

import DAL.NhanVienDAL;
import DTO.NhanVien;
import java.util.ArrayList;
import java.util.List;

public class NhanVienBUS {
    private NhanVienDAL nvDAL;

    public NhanVienBUS() {
        nvDAL = new NhanVienDAL();
    }

    // Lấy toàn bộ danh sách nhân viên
    public List<NhanVien> getAllNhanVien() {
        return nvDAL.getAllNhanVien();
    }

    // Thêm nhân viên mới sau khi kiểm tra dữ liệu đầu vào
    public boolean addNhanVien(NhanVien nv) {
        if (nv.getTenNV() == null || nv.getTenNV().trim().isEmpty()) {
            System.out.println("Tên nhân viên không được để trống!");
            return false;
        }
        // Có thể thêm các kiểm tra khác như kiểm tra định dạng email, số điện thoại, vv.
        return nvDAL.insertNhanVien(nv);
    }

    // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(NhanVien nv) {
        if (nv.getMaNV() <= 0) {
            System.out.println("Mã nhân viên không hợp lệ!");
            return false;
        }
        return nvDAL.updateNhanVien(nv);
    }

    // Xóa nhân viên theo mã
    public boolean deleteNhanVien(int maNV) {
        if (maNV <= 0) {
            System.out.println("Mã nhân viên không hợp lệ!");
            return false;
        }
        return nvDAL.deleteNhanVien(maNV);
    }

    // Tìm kiếm nhân viên theo tên (sử dụng lọc từ danh sách lấy từ DAL)
    public List<NhanVien> searchNhanVienByName(String keyword) {
        List<NhanVien> allNhanVien = getAllNhanVien();
        if (keyword == null || keyword.trim().isEmpty()) {
            return allNhanVien;
        }
        List<NhanVien> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (NhanVien nv : allNhanVien) {
            if (nv.getTenNV().toLowerCase().contains(lowerKeyword)) {
                result.add(nv);
            }
        }
        return result;
    }
    //Lấy NV từ mã NV
    public NhanVien getNhanVienByMaNV(int maNV) {
        List<NhanVien> list = getAllNhanVien();
        for (NhanVien nv : list) {
            if(nv.getMaNV() == maNV){
                return nv;
            }
        }
        return null;
    }

}
