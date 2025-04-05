package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import DATABASE.ConnectDB;
import DTO.NhanVien;

public class NhanVienDAL {
    private Connection conn;

    public NhanVienDAL() {
        conn = ConnectDB.getConnection();
    }
    
    // Lấy danh sách NhanVien
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachNhanVien()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                    rs.getInt("maNV"),
                    rs.getString("tenNV"),
                    rs.getDate("ngaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("sdt"),
                    rs.getString("email"),
                    rs.getString("diaChi"),
                    rs.getDate("ngayVaoLam"),
                    rs.getString("chiNhanh"),
                    rs.getString("trangThai")
                );
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //Thêm nv
    public boolean insertNhanVien(NhanVien nv) {
        String sql = "{CALL sp_ThemNhanVien(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setNString(1, nv.getTenNV());       // Dùng setNString cho chuỗi Unicode
            stmt.setDate(2, nv.getNgaySinh());
            stmt.setNString(3, nv.getGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getEmail());
            stmt.setNString(6, nv.getDiaChi());
            stmt.setDate(7, nv.getNgayVaoLam());
            stmt.setNString(8, nv.getChiNhanh());
            stmt.setNString(9, nv.getTrangThai());     // Dùng setNString cho trangThai
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    
    // Cập nhật NhanVien
    public boolean updateNhanVien(NhanVien nv) {
        String sql = "{CALL sp_CapNhatNhanVien(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, nv.getMaNV());
            stmt.setNString(2, nv.getTenNV());
            stmt.setDate(3, nv.getNgaySinh());
            stmt.setNString(4, nv.getGioiTinh());
            stmt.setNString(5, nv.getSdt());
            stmt.setNString(6, nv.getEmail());
            stmt.setNString(7, nv.getDiaChi());
            stmt.setDate(8, nv.getNgayVaoLam());
            stmt.setNString(9, nv.getChiNhanh());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa NhanVien theo maNV
    public boolean deleteNhanVien(int maNV) {
        String sql = "{CALL sp_XoaNhanVien(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maNV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
