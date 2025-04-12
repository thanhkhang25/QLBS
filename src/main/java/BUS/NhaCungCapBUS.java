package BUS;

import DAL.NhaCungCapDAL;
import DTO.NhaCungCap;
import java.util.List;

public class NhaCungCapBUS {
    private NhaCungCapDAL nhaCungCapDAL;

    public NhaCungCapBUS() {
        this.nhaCungCapDAL = new NhaCungCapDAL();
    }

    public boolean themNhaCungCap(NhaCungCap ncc) {
        if (ncc == null || ncc.getTenNCC().isEmpty() || !ncc.getEmail().contains("@") || ncc.getSdt().length() < 10) {
            System.err.println("Thông tin nhà cung cấp không hợp lệ.");
            return false;
        }
        return nhaCungCapDAL.themNhaCungCap(ncc);
    }

    public boolean capNhatNhaCungCap(NhaCungCap ncc) {
        if (ncc == null || ncc.getTenNCC().isEmpty()) {
            System.err.println("Thông tin nhà cung cấp không hợp lệ.");
            return false;
        }
        return nhaCungCapDAL.capNhatNhaCungCap(ncc);
    }
    
    public List<NhaCungCap> layDanhSachNhaCungCap() {
        return nhaCungCapDAL.layDanhSachNhaCungCap();
    }
}
