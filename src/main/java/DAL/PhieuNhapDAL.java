package DAL;

import DATABASE.ConnectDB;
import DTO.PhieuNhap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapDAL {
    private Connection conn;
    
    public PhieuNhapDAL() {
        conn = ConnectDB.getConnection();
    }
    
    public boolean insertPhieuNhap(PhieuNhap pn) {
        String sql = "EXEC sp_ThemPhieuNhap ?, ?, ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pn.getMaNV());
            stmt.setInt(2, pn.getMaNCC());
            stmt.setDouble(3, pn.getTongTien());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePhieuNhap(int maPN) {
        String sql = "EXEC sp_CapNhatPhieuNhap ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPN);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<PhieuNhap> getAllPhieuNhap() {
        List<PhieuNhap> list = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachPhieuNhap";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new PhieuNhap(
                    rs.getInt("maPN"),
                    rs.getInt("maNV"),
                    rs.getInt("maNCC"),
                    rs.getTimestamp("ngayNhap").toLocalDateTime(),
                    rs.getDouble("tongTien"),
                    rs.getString("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<PhieuNhap> getAllPhieuNhapDaHuy() {
        List<PhieuNhap> list = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachPhieuNhapDaHuy";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new PhieuNhap(
                    rs.getInt("maPN"),
                    rs.getInt("maNV"),
                    rs.getInt("maNCC"),
                    rs.getTimestamp("ngayNhap").toLocalDateTime(),
                    rs.getDouble("tongTien"),
                    rs.getString("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int getIdPhieuNhap() {
        String sql = "EXEC sp_LayIdMaxPhieuNhap";
        int id = 0;
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {  // Kiểm tra có dữ liệu hay không
                id = rs.getInt("MaxPhieuNhap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}