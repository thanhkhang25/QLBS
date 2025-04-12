package BUS;

import DAL.HoaDonDAL;
import DTO.HoaDon;
import java.sql.Connection;
import java.util.List;

public class HoaDonBUS {
    private HoaDonDAL hoaDonDAL;

    public HoaDonBUS(Connection conn) {
        this.hoaDonDAL = new HoaDonDAL(conn);
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        if (hoaDon == null || hoaDon.getTongTien() < 0) {
            System.err.println("Dữ liệu hóa đơn không hợp lệ.");
            return false;
        }
        return hoaDonDAL.themHoaDon(hoaDon);
    }

    public boolean capNhatHoaDon(HoaDon hoaDon) {
        if (hoaDon == null || hoaDon.getTongTien() < 0) {
            System.err.println("Dữ liệu hóa đơn không hợp lệ.");
            return false;
        }
        return hoaDonDAL.capNhatHoaDon(hoaDon);
    }

    public boolean xoaHoaDon(int maHoaDon) {
        if (maHoaDon <= 0) {
            System.err.println("Mã hóa đơn không hợp lệ.");
            return false;
        }
        return hoaDonDAL.xoaHoaDon(maHoaDon);
    }

    public HoaDon timHoaDon(int maHoaDon) {
        if (maHoaDon <= 0) {
            System.err.println("Mã hóa đơn không hợp lệ.");
            return null;
        }
        return hoaDonDAL.timHoaDon(maHoaDon);
    }

    public List<HoaDon> layDanhSachHoaDon() {
        return hoaDonDAL.layDanhSachHoaDon();
    }
}
