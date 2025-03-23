package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DATABASE.ConnectDB;
import DTO.Luong;

public class LuongDAL {
    private Connection conn;

    public LuongDAL() {
        conn = ConnectDB.getConnection();
    }
    
    // Lấy danh sách Luong
    public List<Luong> getAllLuong() {
        List<Luong> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachLuong()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Luong l = new Luong(
                    rs.getInt("maLuong"),
                    rs.getInt("maNV"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getInt("soNgayLam"),
                    rs.getDouble("luongCoBan"),
                    rs.getDouble("thuong"),
                    rs.getDouble("khauTru"),
                    rs.getDouble("phuCapXang"),
                    rs.getDouble("phuCapBHYT"),
                    rs.getDouble("phuCapBHXH"),
                    rs.getDouble("phuCapBHTN"),
                    rs.getDouble("tongLuongNhan"),
                    rs.getString("trangThai")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Thêm mới Luong
    public boolean insertLuong(Luong l) {
        String sql = "{CALL sp_ThemLuong(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, l.getMaNV());
            stmt.setInt(2, l.getThang());
            stmt.setInt(3, l.getNam());
            stmt.setInt(4, l.getSoNgayLam());
            stmt.setDouble(5, l.getLuongCoBan());
            stmt.setDouble(6, l.getThuong());
            stmt.setDouble(7, l.getKhauTru());
            stmt.setDouble(8, l.getPhuCapXang());
            stmt.setDouble(9, l.getPhuCapBHYT());
            stmt.setDouble(10, l.getPhuCapBHXH());
            stmt.setDouble(11, l.getPhuCapBHTN());
            stmt.setDouble(12, l.getTongLuongNhan());
            // Lưu ý: trường 'trangThai' có thể không cần thiết trong thao tác tạo bảng lương tùy vào nghiệp vụ
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật Luong
    public boolean updateLuong(Luong l) {
        String sql = "{CALL sp_CapNhatLuong(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, l.getMaLuong());
            stmt.setInt(2, l.getMaNV());
            stmt.setInt(3, l.getThang());
            stmt.setInt(4, l.getNam());
            stmt.setInt(5, l.getSoNgayLam());
            stmt.setDouble(6, l.getLuongCoBan());
            stmt.setDouble(7, l.getThuong());
            stmt.setDouble(8, l.getKhauTru());
            stmt.setDouble(9, l.getPhuCapXang());
            stmt.setDouble(10, l.getPhuCapBHYT());
            stmt.setDouble(11, l.getPhuCapBHXH());
            stmt.setDouble(12, l.getPhuCapBHTN());
            stmt.setDouble(13, l.getTongLuongNhan());
            // Nếu cần cập nhật 'trangThai', thêm tham số sau
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa Luong theo maLuong
    public boolean deleteLuong(int maLuong) {
        String sql = "{CALL sp_XoaLuong(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maLuong);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
