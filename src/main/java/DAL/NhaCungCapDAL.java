package DAL;

import DATABASE.ConnectDB;
import DTO.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAL {
    private Connection conn;

    public NhaCungCapDAL() {
        conn = ConnectDB.getConnection();
    }

    public boolean themNhaCungCap(NhaCungCap ncc) {
        String sql = "{CALL sp_ThemNhaCungCap(?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, ncc.getTenNCC());
            stmt.setString(2, ncc.getEmail());
            stmt.setString(3, ncc.getSdt());
            stmt.setString(4, ncc.getDiaChi());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatNhaCungCap(NhaCungCap ncc) {
        String sql = "{CALL sp_CapNhatNhaCungCap(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, ncc.getMaNCC());
            stmt.setString(2, ncc.getTenNCC());
            stmt.setString(3, ncc.getEmail());
            stmt.setString(4, ncc.getSdt());
            stmt.setString(5, ncc.getDiaChi());
            stmt.setString(6, ncc.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<NhaCungCap> layDanhSachNhaCungCap() {
        List<NhaCungCap> danhSach = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachNhaCungCap()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                danhSach.add(new NhaCungCap(
                    rs.getInt("MaNCC"),
                    rs.getString("TenNCC"),
                    rs.getString("Email"),
                    rs.getString("SDT"),
                    rs.getString("DiaChi"),
                    rs.getString("TrangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}
