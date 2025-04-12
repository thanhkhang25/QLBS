package BUS;

import DAL.ChiTietHoaDonDAL;
import DTO.ChiTietHoaDon;
import java.sql.Connection;
import java.util.List;

public class ChiTietHoaDonBUS {
    private ChiTietHoaDonDAL chiTietHoaDonDAL;

    public ChiTietHoaDonBUS(Connection conn) {
        this.chiTietHoaDonDAL = new ChiTietHoaDonDAL(conn);
    }

    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        if (cthd.getSoLuong() <= 0 || cthd.getDonGia() <= 0) {
            System.out.println("Lỗi: Số lượng hoặc đơn giá không hợp lệ!");
            return false;
        }
        return chiTietHoaDonDAL.themChiTietHoaDon(cthd);
    }

    public boolean capNhatChiTietHoaDon(ChiTietHoaDon cthd) {
        if (cthd.getSoLuong() <= 0 || cthd.getDonGia() <= 0) {
            System.out.println("Lỗi: Số lượng hoặc đơn giá không hợp lệ!");
            return false;
        }
        return chiTietHoaDonDAL.capNhatChiTietHoaDon(cthd);
    }

    public boolean xoaChiTietHoaDon(int maHoaDon, int maSach) {
        return chiTietHoaDonDAL.xoaChiTietHoaDon(maHoaDon, maSach);
    }

    public ChiTietHoaDon timChiTietHoaDon(int maHoaDon, int maSach) {
        return chiTietHoaDonDAL.timChiTietHoaDon(maHoaDon, maSach);
    }

    public List<ChiTietHoaDon> layDanhSachChiTietHoaDon() {
        return chiTietHoaDonDAL.layDanhSachChiTietHoaDon();
    }
}
