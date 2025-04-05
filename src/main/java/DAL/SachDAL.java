package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDB;
import DTO.Sach;

public class SachDAL {
    private Connection conn;

    public SachDAL() {
        conn = ConnectDB.getConnection(); // Kết nối CSDL từ ConnectDB
    }

    // Lấy danh sách sách từ Stored Procedure
    public List<Sach> getAllSach() {
        List<Sach> list = new ArrayList<>();
        String sql = "{CALL sp_LayDanhSachSach()}"; // Gọi Stored Procedure

        try (CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sach sach = new Sach(
                    rs.getInt("maSach"),
                    rs.getString("tenSach"),
                    rs.getString("theLoai"),
                    rs.getString("tacGia"),
                    rs.getString("donViTinh"),
                    rs.getFloat("giaBan"),
                    rs.getFloat("giaDaGiam"),
                    rs.getFloat("giaNhap"),
                    rs.getInt("soLuongTonKho"),
                    rs.getString("chiNhanh"),
                    rs.getString("trangThai")
                );
                list.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm một cuốn sách mới
    public boolean insertSach(Sach sach) {
        String sql = "{CALL sp_ThemSach(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, sach.getTenSach());
            stmt.setString(2, sach.getTheLoai());
            stmt.setString(3, sach.getTacGia());
            stmt.setString(4, sach.getDonViTinh());
            stmt.setDouble(5, sach.getGiaBan());
            stmt.setDouble(6, sach.getGiaDaGiam());
            stmt.setDouble(7, sach.getGiaNhap());
            stmt.setInt(8, sach.getSoLuongTonKho());
            stmt.setString(9, sach.getChiNhanh());
            stmt.setString(10, sach.getTrangThai());

            return stmt.executeUpdate() > 0; // Trả về true nếu thêm thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin sách
    public boolean updateSach(Sach sach) {
        String sql = "{CALL sp_CapNhatSach(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, sach.getMaSach());
            stmt.setString(2, sach.getTenSach());
            stmt.setString(3, sach.getTheLoai());
            stmt.setString(4, sach.getTacGia());
            stmt.setString(5, sach.getDonViTinh());
            stmt.setDouble(6, sach.getGiaBan());
            stmt.setDouble(7, sach.getGiaDaGiam());
            stmt.setDouble(8, sach.getGiaNhap());
            stmt.setInt(9, sach.getSoLuongTonKho());
            stmt.setString(10, sach.getChiNhanh());
            stmt.setString(11, sach.getTrangThai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sách theo mã
    public boolean deleteSach(int maSach) {
        String sql = "{CALL sp_XoaSach(?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, maSach);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
