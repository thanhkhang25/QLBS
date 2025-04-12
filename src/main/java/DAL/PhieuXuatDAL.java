package DAL;

import DATABASE.ConnectDB;
import DTO.PhieuXuat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuXuatDAL {
    private Connection conn;

    public PhieuXuatDAL() {
        conn = ConnectDB.getConnection();
    }

    public boolean themPhieuXuat(PhieuXuat phieuXuat) {
        String sql = "EXEC sp_ThemPhieuXuat ?, ?";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, phieuXuat.getMaNV());
            stmt.setString(2, phieuXuat.getChiNhanh());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatPhieuXuat(int maPX) {
        String sql = "EXEC sp_CapNhatPhieuXuat ?";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maPX);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PhieuXuat> layDanhSachPhieuXuat() {
        List<PhieuXuat> danhSach = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachPhieuXuat";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new PhieuXuat(
                    rs.getInt("MaPX"),
                    rs.getInt("MaNV"),
                    rs.getTimestamp("NgayXuat").toLocalDateTime(),
                    rs.getString("ChiNhanh"),
                    rs.getString("TrangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public List<PhieuXuat> layDanhSachPhieuXuatDaHuy() {
        List<PhieuXuat> danhSach = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachPhieuXuatDaHuy";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new PhieuXuat(
                    rs.getInt("MaPX"),
                    rs.getInt("MaNV"),
                    rs.getTimestamp("NgayXuat").toLocalDateTime(),
                    rs.getString("ChiNhanh"),
                    rs.getString("TrangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public int getIdPhieuXuat() {
        String sql = "EXEC sp_LayIdMaxPhieuXuat";
        int id = 0;
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {  // Kiểm tra có dữ liệu hay không
                id = rs.getInt("MaxPhieuXuat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
