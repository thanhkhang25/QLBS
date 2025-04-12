package DAL;

import DTO.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAL {
    private Connection conn;

    public HoaDonDAL(Connection conn) {
        this.conn = conn;
    }

    private boolean executeUpdate(String sql, HoaDon hoaDon) {
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, hoaDon.getMaHoaDon());
            stmt.setInt(2, hoaDon.getMaNV());
            stmt.setInt(3, hoaDon.getMaKM());
            stmt.setTimestamp(4, Timestamp.valueOf(hoaDon.getNgayBan()));
            stmt.setDouble(5, hoaDon.getTongTien());
            stmt.setString(6, hoaDon.getChiNhanh());
            stmt.setString(7, hoaDon.getTrangThai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thực thi câu lệnh SQL: " + e.getMessage());
        }
        return false;
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        return executeUpdate("{CALL ThemHoaDon(?, ?, ?, ?, ?, ?, ?)}", hoaDon);
    }

    public boolean capNhatHoaDon(HoaDon hoaDon) {
        return executeUpdate("{CALL CapNhatHoaDon(?, ?, ?, ?, ?, ?, ?)}", hoaDon);
    }

    public boolean xoaHoaDon(int maHoaDon) {
        String sql = "{CALL XoaHoaDon(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maHoaDon);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa hóa đơn: " + e.getMessage());
        }
        return false;
    }

    public HoaDon timHoaDon(int maHoaDon) {
        String sql = "{CALL TimHoaDon(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maHoaDon);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new HoaDon(
                        rs.getInt("MaHoaDon"),
                        rs.getInt("MaNV"),
                        rs.getInt("MaKM"),
                        rs.getTimestamp("NgayBan").toLocalDateTime(),
                        rs.getDouble("TongTien"),
                        rs.getString("ChiNhanh"),
                        rs.getString("TrangThai")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm hóa đơn: " + e.getMessage());
        }
        return null;
    }

    public List<HoaDon> layDanhSachHoaDon() {
        List<HoaDon> danhSach = new ArrayList<>();
        String sql = "{CALL LayDanhSachHoaDon()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new HoaDon(
                    rs.getInt("MaHoaDon"),
                    rs.getInt("MaNV"),
                    rs.getInt("MaKM"),
                    rs.getTimestamp("NgayBan").toLocalDateTime(),
                    rs.getDouble("TongTien"),
                    rs.getString("ChiNhanh"),
                    rs.getString("TrangThai")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách hóa đơn: " + e.getMessage());
        }
        return danhSach;
    }
}
