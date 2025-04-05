package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DATABASE.ConnectDB;
import DTO.HeSoLuong;

public class HeSoLuongDAL {
    private Connection conn;

    public HeSoLuongDAL() {
        conn = ConnectDB.getConnection();
    }
    
   // Lấy danh sách HeSoLuong
    public List<HeSoLuong> getAllHeSoLuong() {
        List<HeSoLuong> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachHeSoLuong()}"; // SP này cần được tạo trong DB
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HeSoLuong hsl = new HeSoLuong(
                    rs.getString("maHeSoLuong"),
                    rs.getDouble("luongCoBan"),
                    rs.getDouble("phuCapXang"),
                    rs.getDouble("phuCapBHXH"),
                    rs.getDouble("phuCapBHYT"),
                    rs.getDouble("phuCapBHTN")
                );
                list.add(hsl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Tìm kiếm HeSoLuong theo mã (truyền vào dạng chuỗi)
    public List<HeSoLuong> searchHeSoLuongByMa(String ma) {
        List<HeSoLuong> list = new ArrayList<>();
        String sql = "{CALL sp_TimKiemHeSoLuong(?)}"; // Stored procedure cần tạo trong DB
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setNString(1, ma);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    HeSoLuong hsl = new HeSoLuong(
                        rs.getString("maHeSoLuong"),
                        rs.getDouble("luongCoBan"),
                        rs.getDouble("phuCapXang"),
                        rs.getDouble("phuCapBHYT"),    
                        rs.getDouble("phuCapBHXH"),
                        rs.getDouble("phuCapBHTN")
                    );
                    list.add(hsl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Thêm mới hệ số lương
    public boolean insertHeSoLuong(HeSoLuong hsl) {
        String sql = "{CALL sp_ThemHeSoLuong(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setNString(1, hsl.getMaHeSoLuong());
            stmt.setDouble(2, hsl.getLuongCoBan());
            stmt.setDouble(3, hsl.getPhuCapXang());
            stmt.setDouble(4, hsl.getPhuCapBHXH());
            stmt.setDouble(5, hsl.getPhuCapBHYT());
            stmt.setDouble(6, hsl.getPhuCapBHTN());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật hệ số lương
    public boolean updateHeSoLuong(HeSoLuong hsl) {
        String sql = "{CALL sp_CapNhatHeSoLuong(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setNString(1, hsl.getMaHeSoLuong());
            stmt.setDouble(2, hsl.getLuongCoBan());
            stmt.setDouble(3, hsl.getPhuCapXang());
            stmt.setDouble(4, hsl.getPhuCapBHXH());
            stmt.setDouble(5, hsl.getPhuCapBHYT());
            stmt.setDouble(6, hsl.getPhuCapBHTN());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa hệ số lương theo mã
    public boolean deleteHeSoLuong(String maHeSoLuong) {
        String sql = "{CALL sp_XoaHeSoLuong(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setNString(1, maHeSoLuong);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
