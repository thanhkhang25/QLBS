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
import java.time.LocalDate;
import java.time.LocalDateTime;

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
                 // Lấy giá trị ngày, kiểm tra null trước khi chuyển đổi
                 Timestamp tsNgayNop = rs.getTimestamp("ngayNopDon");
                 LocalDateTime ngayNopDon = (tsNgayNop != null) ? tsNgayNop.toLocalDateTime() : null;
                 
                 java.sql.Date sqlNgayBatDau = rs.getDate("ngayBatDau");
                 LocalDate ngayBatDau = (sqlNgayBatDau != null) ? sqlNgayBatDau.toLocalDate() : null;
                 
                 java.sql.Date sqlNgayKetThuc = rs.getDate("ngayKetThuc");
                 LocalDate ngayKetThuc = (sqlNgayKetThuc != null) ? sqlNgayKetThuc.toLocalDate() : null;
                 
                 Timestamp tsNgayDuyet = rs.getTimestamp("ngayDuyet");
                 LocalDateTime ngayDuyet = (tsNgayDuyet != null) ? tsNgayDuyet.toLocalDateTime() : null;
                 
                 // Tạo đối tượng DonXinNghi
                 DonXinNghi don = new DonXinNghi(
                     rs.getInt("maDon"),
                     rs.getInt("maNV"),
                     rs.getInt("maNguoiDuyet"),
                     ngayNopDon,
                     rs.getString("noiDung"),
                     ngayBatDau,
                     rs.getInt("soNgayNghi"),
                     ngayKetThuc,
                     ngayDuyet,
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
            // Nếu maNguoiDuyet <= 0, đặt là NULL
            if (don.getMaNguoiDuyet() <= 0) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, don.getMaNguoiDuyet());
            }
            // Giả sử ngayNopDon không null vì có default GETDATE()
            stmt.setTimestamp(3, (don.getNgayNopDon() != null) ? Timestamp.valueOf(don.getNgayNopDon()) : Timestamp.valueOf(LocalDateTime.now()));
            stmt.setNString(4, don.getNoiDung());
            // Ngày bắt đầu phải không null
            if (don.getNgayBatDau() != null) {
                stmt.setDate(5, Date.valueOf(don.getNgayBatDau()));
            } else {
                stmt.setDate(5, null);
            }
            stmt.setInt(6, don.getSoNgayNghi());
            // Ngày kết thúc được tính tự động theo cột computed, nhưng nếu bạn cần set thì kiểm tra null:
            if (don.getNgayKetThuc() != null) {
                stmt.setDate(7, Date.valueOf(don.getNgayKetThuc()));
            } else {
                stmt.setDate(7, null);
            }
            stmt.setNString(8, don.getTrangThai());
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
            stmt.setTimestamp(4, (don.getNgayNopDon() != null) ? Timestamp.valueOf(don.getNgayNopDon()) : null);
            stmt.setNString(5, don.getNoiDung());
            if (don.getNgayBatDau() != null) {
                stmt.setDate(6, Date.valueOf(don.getNgayBatDau()));
            } else {
                stmt.setDate(6, null);
            }
            stmt.setInt(7, don.getSoNgayNghi());
            if (don.getNgayKetThuc() != null) {
                stmt.setDate(8, Date.valueOf(don.getNgayKetThuc()));
            } else {
                stmt.setDate(8, null);
            }
            stmt.setNString(9, don.getTrangThai());
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
    
    // Duyệt đơn xin nghỉ bằng SP riêng
    public boolean approveDonXinNghi(int maDon) {
        String sql = "{CALL sp_ApproveDonXinNghi(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maDon);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Từ chối đơn xin nghỉ bằng SP riêng
    public boolean rejectDonXinNghi(int maDon) {
        String sql = "{CALL sp_RejectDonXinNghi(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maDon);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
