package DAL;

import DTO.ChiTietHoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAL {
    private Connection conn;

    public ChiTietHoaDonDAL(Connection conn) {
        this.conn = conn;
    }

    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        String sql = "{CALL ThemChiTietHoaDon(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cthd.getMaHoaDon());
            stmt.setInt(2, cthd.getMaSach());
            stmt.setInt(3, cthd.getMaKM());
            stmt.setInt(4, cthd.getSoLuong());
            stmt.setDouble(5, cthd.getDonGia());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatChiTietHoaDon(ChiTietHoaDon cthd) {
        String sql = "{CALL CapNhatChiTietHoaDon(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cthd.getMaHoaDon());
            stmt.setInt(2, cthd.getMaSach());
            stmt.setInt(3, cthd.getMaKM());
            stmt.setInt(4, cthd.getSoLuong());
            stmt.setDouble(5, cthd.getDonGia());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaChiTietHoaDon(int maHoaDon, int maSach) {
        String sql = "{CALL XoaChiTietHoaDon(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maHoaDon);
            stmt.setInt(2, maSach);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ChiTietHoaDon timChiTietHoaDon(int maHoaDon, int maSach) {
        String sql = "{CALL TimChiTietHoaDon(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maHoaDon);
            stmt.setInt(2, maSach);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ChiTietHoaDon(
                        rs.getInt("MaHoaDon"),
                        rs.getInt("MaSach"),
                        rs.getInt("MaKM"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("DonGia")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ChiTietHoaDon> layDanhSachChiTietHoaDon() {
        List<ChiTietHoaDon> danhSach = new ArrayList<>();
        String sql = "{CALL LayDanhSachChiTietHoaDon()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new ChiTietHoaDon(
                    rs.getInt("MaHoaDon"),
                    rs.getInt("MaSach"),
                    rs.getInt("MaKM"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
