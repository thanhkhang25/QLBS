package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDB;
import DTO.DonXinNghi;

public class DonXinNghiDAL {
    private Connection conn;

    public DonXinNghiDAL() {
        conn = ConnectDB.getConnection();
    }
    
    // Lấy danh sách DonXinNghi
    public List<DonXinNghi> getAllDonXinNghi() {
        List<DonXinNghi> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachDonXinNghi()}";
        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DonXinNghi don = new DonXinNghi(
                    rs.getInt("maDon"),
                    rs.getInt("maNV"),
                    rs.getInt("maNguoiDuyet"),
                    rs.getTimestamp("ngayNopDon").toLocalDateTime(),
                    rs.getString("noiDung"),
                    rs.getDate("ngayBatDau").toLocalDate(),
                    rs.getInt("soNgayNghi"),
                    rs.getDate("ngayKetThuc").toLocalDate(),
                    rs.getTimestamp("ngayDuyet").toLocalDateTime(),
                    rs.getString("trangThai")
                );
                list.add(don);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Thêm mới DonXinNghi (giả sử maDon được tạo tự động)
    public boolean insertDonXinNghi(DonXinNghi don) {
        String sql = "{CALL sp_ThemDonXinNghi(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, don.getMaNV());
            stmt.setInt(2, don.getMaNguoiDuyet());
            stmt.setTimestamp(3, Timestamp.valueOf(don.getNgayNopDon()));
            stmt.setString(4, don.getNoiDung());
            stmt.setDate(5, Date.valueOf(don.getNgayBatDau()));
            stmt.setInt(6, don.getSoNgayNghi());
            stmt.setDate(7, Date.valueOf(don.getNgayKetThuc()));
            stmt.setString(8, don.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Cập nhật DonXinNghi
    public boolean updateDonXinNghi(DonXinNghi don) {
        String sql = "{CALL sp_CapNhatDonXinNghi(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, don.getMaDon());
            stmt.setInt(2, don.getMaNV());
            stmt.setInt(3, don.getMaNguoiDuyet());
            stmt.setTimestamp(4, Timestamp.valueOf(don.getNgayNopDon()));
            stmt.setString(5, don.getNoiDung());
            stmt.setDate(6, Date.valueOf(don.getNgayBatDau()));
            stmt.setInt(7, don.getSoNgayNghi());
            stmt.setDate(8, Date.valueOf(don.getNgayKetThuc()));
            stmt.setString(9, don.getTrangThai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Xóa DonXinNghi theo maDon
    public boolean deleteDonXinNghi(int maDon) {
        String sql = "{CALL sp_XoaDonXinNghi(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maDon);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
