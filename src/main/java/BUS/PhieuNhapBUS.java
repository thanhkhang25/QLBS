package BUS;

import DAL.ChiTietPhieuNhapDAL;
import DAL.PhieuNhapDAL;
import DTO.ChiTietPhieuNhap;
import DTO.PhieuNhap;
import java.sql.Connection;
import java.util.List;

public class PhieuNhapBUS {
    private PhieuNhapDAL phieuNhapDAL;
    private ChiTietPhieuNhapDAL chiTietPhieuNhapDAL;

    public PhieuNhapBUS() {
        this.phieuNhapDAL = new PhieuNhapDAL();
        this.chiTietPhieuNhapDAL = new ChiTietPhieuNhapDAL();
    }

    public boolean insertPhieuNhap(PhieuNhap pn) {
        if (pn == null || pn.getTongTien() <= 0 || pn.getMaNV() <= 0 || pn.getMaNCC() <= 0) {
            System.err.println("Dữ liệu phiếu nhập không hợp lệ.");
            return false;
        }
        return phieuNhapDAL.insertPhieuNhap(pn);
    }

    public boolean updatePhieuNhap(int maPN) {
        return phieuNhapDAL.updatePhieuNhap(maPN);
    }
    
    public String getIdPhieuNhap() {
        return String.valueOf(phieuNhapDAL.getIdPhieuNhap()+ 1);
    }
    
    public List<PhieuNhap> getAllPhieuNhap() {
        return phieuNhapDAL.getAllPhieuNhap();
    }
    
    public List<PhieuNhap> getAllPhieuNhapDaHuy() {
        return phieuNhapDAL.getAllPhieuNhapDaHuy();
    }

    public boolean themChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        return chiTietPhieuNhapDAL.themChiTietPhieuNhap(ctpn);
    }

    public List<ChiTietPhieuNhap> layDanhSachChiTietPhieuNhap() {
        return chiTietPhieuNhapDAL.layDanhSachChiTietPhieuNhap();
    }
}
