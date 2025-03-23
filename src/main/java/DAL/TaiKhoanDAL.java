package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DATABASE.ConnectDB;
import DTO.TaiKhoan;

public class TaiKhoanDAL {
    private Connection conn;

    public TaiKhoanDAL() {
        conn = ConnectDB.getConnection();
    }
    
    // Lấy danh sách tất cả tài khoản
    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> list = new ArrayList<>();
        String sql = "{CALL sp_LayTaiKhoan()}"; // SP cần trả về các cột: maTK, maNV, matKhau, chucVu, trangThai
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(
                    rs.getInt("maTK"),
                    rs.getInt("maNV"),
                    rs.getString("matKhau"),
                    rs.getString("chucVu"),
                    rs.getString("trangThai")
                );
                list.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Thêm tài khoản mới
    public boolean insertTaiKhoan(TaiKhoan tk) {
        // SP được giả định nhận 4 tham số:
        // @maNV, @matKhau, @chucVu, @trangThai
        String sql = "{CALL sp_ThemTaiKhoan(?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, tk.getMaNV());
            stmt.setString(2, tk.getMatKhau());
            // Sử dụng setNString cho các trường có dấu
            stmt.setNString(3, tk.getChucVu());
            stmt.setNString(4, tk.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật tài khoản
    public boolean updateTaiKhoan(TaiKhoan tk) {
        // SP được giả định nhận 5 tham số:
        // @maTK, @maNV, @matKhau, @chucVu, @trangThai
        String sql = "{CALL sp_CapNhatTaiKhoan(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, tk.getMaTK());
            stmt.setInt(2, tk.getMaNV());
            stmt.setString(3, tk.getMatKhau());
            stmt.setNString(4, tk.getChucVu());
            stmt.setNString(5, tk.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa tài khoản theo maTK
    public boolean deleteTaiKhoan(int maTK) {
        String sql = "{CALL sp_XoaTaiKhoan(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maTK);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public TaiKhoan getTaiKhoanByMaNV(int maNV) {
        TaiKhoan tk = null;
        String sql = "{CALL sp_GetTaiKhoanByMaNV(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tk = new TaiKhoan(
                        rs.getInt("maTK"),
                        rs.getInt("maNV"),
                        rs.getString("matKhau"),
                        rs.getString("chucVu"),
                        rs.getString("trangThai")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }

}
