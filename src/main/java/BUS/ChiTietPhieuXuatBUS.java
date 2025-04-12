package BUS;

import DAL.ChiTietPhieuXuatDAL;
import DTO.ChiTietPhieuXuat;
import java.sql.Connection;
import java.util.List;

public class ChiTietPhieuXuatBUS {
    private ChiTietPhieuXuatDAL chiTietPhieuXuatDAL;

    public ChiTietPhieuXuatBUS() {
        this.chiTietPhieuXuatDAL = new ChiTietPhieuXuatDAL();
    }

    public boolean themChiTietPhieuXuat(ChiTietPhieuXuat ctpn) {
        return chiTietPhieuXuatDAL.themChiTietPhieuXuat(ctpn);
    }

    public List<ChiTietPhieuXuat> layDanhSachChiTietPhieuXuat() {
        return chiTietPhieuXuatDAL.layDanhSachChiTietPhieuXuat();
    }
}
