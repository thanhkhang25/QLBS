package DAL;

import DATABASE.ConnectDB;
import DTO.ChiTietKhuyenMaiSach;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiSachDAL {
    private Connection conn;

    public KhuyenMaiSachDAL() {
        this.conn = ConnectDB.getConnection();
    }

    // Thêm khuyến mãi sách
    public boolean themKhuyenMaiSach(ChiTietKhuyenMaiSach kmSach) {
        String query = "EXEC sp_ThemKhuyenMaiSach ?, ?, ?";
        try (CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, kmSach.getMaKM());
            cs.setInt(2, kmSach.getMaSach());
            cs.setDouble(3, kmSach.getGiaDaGiam());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách khuyến mãi sách
    public List<ChiTietKhuyenMaiSach> layDanhSachKhuyenMaiSach() {
        List<ChiTietKhuyenMaiSach> list = new ArrayList<>();
        String query = "EXEC sp_LayDanhSachKhuyenMaiChoSach";
        try (CallableStatement cs = conn.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                list.add(new ChiTietKhuyenMaiSach(
                        rs.getInt("maKM"),
                        rs.getInt("maSach"),
                        rs.getDouble("giaDaGiam")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
