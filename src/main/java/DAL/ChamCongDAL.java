package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDB;
import DTO.ChamCong;

public class ChamCongDAL {
    private Connection conn;

    public ChamCongDAL() {
        conn = ConnectDB.getConnection();
    }
    
    // Lấy danh sách ChamCong
    public List<ChamCong> getAllChamCong() {
        List<ChamCong> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachChamCong()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ChamCong cc = new ChamCong(
                    rs.getInt("maCC"),
                    rs.getInt("maNV"),
                    rs.getTimestamp("thoiGianChamCong").toLocalDateTime()
                );
                list.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Thêm một bản ghi ChamCong mới (giả sử maCC được tạo tự động)
    public boolean insertChamCong(ChamCong cc) {
        String sql = "{CALL sp_ThemChamCong(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cc.getMaNV());
            stmt.setTimestamp(2, Timestamp.valueOf(cc.getThoiGianChamCong()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật thông tin ChamCong
    public boolean updateChamCong(ChamCong cc) {
        String sql = "{CALL sp_CapNhatChamCong(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, cc.getMaCC());
            stmt.setInt(2, cc.getMaNV());
            stmt.setTimestamp(3, Timestamp.valueOf(cc.getThoiGianChamCong()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa ChamCong theo maCC
    public boolean deleteChamCong(int maCC) {
        String sql = "{CALL sp_XoaChamCong(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maCC);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
