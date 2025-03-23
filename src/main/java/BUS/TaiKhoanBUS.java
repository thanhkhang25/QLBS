package BUS;

import DAL.TaiKhoanDAL;
import DTO.TaiKhoan;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanBUS {
    private TaiKhoanDAL tkDAL;

    public TaiKhoanBUS() {
        tkDAL = new TaiKhoanDAL();
    }
    
    // Lấy toàn bộ danh sách tài khoản
    public List<TaiKhoan> getAllTaiKhoan() {
        return tkDAL.getAllTaiKhoan();
    }
    //Lấy tk qua mã nv
    public TaiKhoan getTaiKhoanByMaNV(int maNV) {
        return tkDAL.getTaiKhoanByMaNV(maNV);
    }
    // Thêm tài khoản mới sau khi kiểm tra dữ liệu đầu vào
    public boolean addTaiKhoan(TaiKhoan tk) {
        if (tk.getMatKhau() == null || tk.getMatKhau().trim().isEmpty()) {
            System.out.println("Mật khẩu không được để trống!");
            return false;
        }
        // Bạn có thể bổ sung thêm các kiểm tra khác (ví dụ: kiểm tra định dạng email, giá trị cho chucVu,...)
        return tkDAL.insertTaiKhoan(tk);
    }
    
    // Cập nhật thông tin tài khoản
    public boolean updateTaiKhoan(TaiKhoan tk) {
        if (tk.getMaTK() <= 0) {
            System.out.println("Mã tài khoản không hợp lệ!");
            return false;
        }
        return tkDAL.updateTaiKhoan(tk);
    }
    
    // Xóa tài khoản theo maTK
    public boolean deleteTaiKhoan(int maTK) {
        if (maTK <= 0) {
            System.out.println("Mã tài khoản không hợp lệ!");
            return false;
        }
        return tkDAL.deleteTaiKhoan(maTK);
    }
}
