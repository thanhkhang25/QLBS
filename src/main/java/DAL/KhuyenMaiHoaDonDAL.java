package DAL;

import DATABASE.ConnectDB;
import DTO.ChiTietKhuyenMaiHoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiHoaDonDAL {
    private Connection conn;

    public KhuyenMaiHoaDonDAL() {
        this.conn = ConnectDB.getConnection();
    }

    // 🟢 Lấy danh sách khuyến mãi hóa đơn (đang diễn ra)
    public List<ChiTietKhuyenMaiHoaDon> layDanhSachKhuyenMaiHoaDon() {
        List<ChiTietKhuyenMaiHoaDon> danhSach = new ArrayList<>();
        String query = "EXEC sp_LayDanhSachKhuyenMaiChoHoaDon";
        try (CallableStatement stmt = conn.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new ChiTietKhuyenMaiHoaDon(
                    rs.getInt("maKM"),
                    rs.getDate("ngayBatDau").toLocalDate(),
                    rs.getDate("ngayKetThuc").toLocalDate(),
                    rs.getInt("phanTramGiam"),
                    rs.getDouble("giaDaGiam"),
                    rs.getString("TrangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    // 🟢 Thêm khuyến mãi hóa đơn
    public boolean themKhuyenMaiHoaDon(ChiTietKhuyenMaiHoaDon km) {
        String query = "EXEC sp_ThemKhuyenMaiHoaDon ?, ?, ?, ?";
        try (CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setDate(1, java.sql.Date.valueOf(km.getNgayBatDau()));
            stmt.setDate(2, java.sql.Date.valueOf(km.getNgayKetThuc()));            
            stmt.setDouble(3, km.getGiaHoaDon());
            stmt.setInt(4, km.getPhanTramGiam());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
