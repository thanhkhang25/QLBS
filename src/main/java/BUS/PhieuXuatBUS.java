package BUS;

import DAL.ChiTietPhieuXuatDAL;
import DAL.PhieuXuatDAL;
import DTO.ChiTietPhieuXuat;
import DTO.PhieuXuat;
import java.sql.Connection;
import java.util.List;

public class PhieuXuatBUS {
    private PhieuXuatDAL phieuXuatDAL;
    private ChiTietPhieuXuatDAL chiTietPhieuXuatDAL;

    public PhieuXuatBUS() {
        this.phieuXuatDAL = new PhieuXuatDAL();
        this.chiTietPhieuXuatDAL = new ChiTietPhieuXuatDAL();
    }

    public boolean themPhieuXuat(PhieuXuat phieuXuat) {
        return phieuXuatDAL.themPhieuXuat(phieuXuat);
    }

    public boolean capNhatPhieuXuat(int maPX) {
        return phieuXuatDAL.capNhatPhieuXuat(maPX);
    }

    public List<PhieuXuat> layDanhSachPhieuXuat() {
        return phieuXuatDAL.layDanhSachPhieuXuat();
    }
    
    public List<PhieuXuat> layDanhSachPhieuXuatDaHuy() {
        return phieuXuatDAL.layDanhSachPhieuXuatDaHuy();
    }

    public boolean themChiTietPhieuXuat(ChiTietPhieuXuat ctpn) {
        return chiTietPhieuXuatDAL.themChiTietPhieuXuat(ctpn);
    }

    public List<ChiTietPhieuXuat> layDanhSachChiTietPhieuXuat() {
        return chiTietPhieuXuatDAL.layDanhSachChiTietPhieuXuat();
    }
    
    public String getIdPhieuXuat() {
        return String.valueOf(phieuXuatDAL.getIdPhieuXuat()+ 1);
    }
}
