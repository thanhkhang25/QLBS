package DAL;

import DATABASE.ConnectDB;
import DTO.ChiTietPhieuNhap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAL {
    private Connection conn;

    public ChiTietPhieuNhapDAL() {
        conn = ConnectDB.getConnection();
    }

    public boolean themChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        String sql = "EXEC sp_ThemChiTietPhieuNhap ?, ?, ?, ?";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, ctpn.getMaPN());
            stmt.setInt(2, ctpn.getMaSach());
            stmt.setInt(3, ctpn.getSoLuong());
            stmt.setDouble(4, ctpn.getGiaNhap());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChiTietPhieuNhap> layDanhSachChiTietPhieuNhap() {
        List<ChiTietPhieuNhap> danhSach = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachChiTietPhieuNhap";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new ChiTietPhieuNhap(
                    rs.getInt("MaPN"),
                    rs.getInt("MaSach"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
