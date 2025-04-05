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
    
    // Lấy danh sách lương
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
                    rs.getString("maHeSoLuong"),
                    rs.getDouble("thuong"),
                    rs.getDouble("chuyencan"),
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
    
    // Thêm mới lương
    public boolean insertLuong(Luong l) {
        String sql = "{CALL sp_ThemLuong(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, l.getMaNV());
            stmt.setInt(2, l.getThang());
            stmt.setInt(3, l.getNam());
            stmt.setInt(4, l.getSoNgayLam());
            stmt.setString(5, l.getMaHeSoLuong());
            stmt.setDouble(6, l.getThuong());
            stmt.setDouble(7, l.getChuyencan());
            stmt.setDouble(8, l.getTongLuongNhan());
            stmt.setNString(9, l.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật lương
    public boolean updateLuong(Luong l) {
        String sql = "{CALL sp_CapNhatLuong(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, l.getMaLuong());
            stmt.setInt(2, l.getMaNV());
            stmt.setInt(3, l.getThang());
            stmt.setInt(4, l.getNam());
            stmt.setInt(5, l.getSoNgayLam());
            stmt.setString(6, l.getMaHeSoLuong());
            stmt.setDouble(7, l.getThuong());
            stmt.setDouble(8, l.getChuyencan());
            stmt.setDouble(9, l.getTongLuongNhan());
            stmt.setNString(10, l.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa lương theo mã lương
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
