package DAL;

import DATABASE.ConnectDB;
import DTO.ChiTietPhieuXuat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuXuatDAL {
    private Connection conn;

    public ChiTietPhieuXuatDAL() {
        conn = ConnectDB.getConnection();
    }

    public boolean themChiTietPhieuXuat(ChiTietPhieuXuat ctpx) {
        String sql = "EXEC sp_ThemChiTietPhieuXuat ?, ?, ?";
            System.out.println(ctpx.getMaSach());
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, ctpx.getMaPX());
            stmt.setInt(2, ctpx.getMaSach());
            stmt.setInt(3, ctpx.getSoLuong());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChiTietPhieuXuat> layDanhSachChiTietPhieuXuat() {
        List<ChiTietPhieuXuat> danhSach = new ArrayList<>();
        String sql = "EXEC sp_LayDanhSachChiTietPhieuXuat";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new ChiTietPhieuXuat(
                    rs.getInt("MaPX"),
                    rs.getInt("MaSach"),
                    rs.getInt("SoLuong")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
