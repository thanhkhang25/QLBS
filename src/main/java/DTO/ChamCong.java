package DTO;

import java.time.LocalDateTime;

public class ChamCong {    
    private int maCC;
    private int maNV;
    private LocalDateTime thoiGianChamCong;

    public ChamCong() {}
    public ChamCong(int maCC, int maNV, LocalDateTime thoiGianChamCong) {
        this.maCC = maCC;
        this.maNV = maNV;
        this.thoiGianChamCong = thoiGianChamCong;
    }
    
    public int getMaCC() {
        return maCC;
    }
    public void setMaCC(int maCC) {
        this.maCC = maCC;
    }
    public int getMaNV() {
        return maNV;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    public LocalDateTime getThoiGianChamCong() {
        return thoiGianChamCong;
    }
    public void setThoiGianChamCong(LocalDateTime thoiGianChamCong) {
        this.thoiGianChamCong = thoiGianChamCong;
    }     
}
