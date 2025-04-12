/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author LENOVO
 */
import BUS.HeSoLuongBUS;
import DAL.ChamCongDAL;
import DAL.LuongDAL;
import DAL.NhanVienDAL;
import DTO.ChamCong;
import DTO.HeSoLuong;
import DTO.Luong;
import DTO.NhanVien;
import SESSION.CurrentSession;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class XemLuong extends javax.swing.JPanel {

    /**
     * Creates new form XemLuong
     */
    // Model cho table và các đối tượng DAL/BUS
    private DefaultTableModel tableModel;
    private LuongDAL luongDAL;
    private NhanVienDAL nhanVienDAL;
    private HeSoLuongBUS heSoLuongBUS;
    private ChamCongDAL chamCongDAL;
    // Thêm biến toàn cục để lưu giá trị thưởng ban đầu
private double originalThuong = 0;
        // Danh sách lương được load từ DB
    private List<Luong> listLuong;
    public XemLuong() {
        initComponents();
        String role = CurrentSession.getChucVu();
        if (role == null) {
            role = "";
        }
        
        if (role.equalsIgnoreCase("Nhân viên bán hàng")) {
            btnCapNhatHeSoLuong.setVisible(false);
            btnChotLuong.setVisible(false);
        } else if (role.equalsIgnoreCase("Quản lý kho hàng")) {
            btnCapNhatHeSoLuong.setVisible(false);
            btnChotLuong.setVisible(false);
        } 
        else if (role.equalsIgnoreCase("Quản lý nhân viên")){
            btnCapNhatHeSoLuong.setVisible(true);
            btnChotLuong.setVisible(true);
        }
        // Khởi tạo các đối tượng truy xuất dữ liệu
        luongDAL = new LuongDAL();
        nhanVienDAL = new NhanVienDAL();
        heSoLuongBUS = new HeSoLuongBUS();
        chamCongDAL = new ChamCongDAL();
        // Khởi tạo table và load dữ liệu
        initTable();
        loadDataLuong();
        initTableListener();
    }
      // Khởi tạo model cho bảng XemLuong
    private void initTable() {
        String[] columnNames = {"Mã Lương", "Mã NV", "Tên NV", "Tháng", "Năm"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblXemLuong.setModel(tableModel);
    }
    
    private void loadDataLuong() {
        tableModel.setRowCount(0);
        listLuong = luongDAL.getAllLuong();

        int currentMaNV = SESSION.CurrentSession.getMaNV();
        String role = SESSION.CurrentSession.getChucVu();

        for (Luong l : listLuong) {
            // Nếu chức vụ không phải "Quản lý nhân viên" và không phải "Admin", chỉ thêm nếu mã NV trùng với phiên hiện tại
            if (!role.equalsIgnoreCase("Quản lý nhân viên") &&
                !role.equalsIgnoreCase("Admin") &&
                l.getMaNV() != currentMaNV) {
                continue;
            }

            NhanVien nv = nhanVienDAL.getAllNhanVien().stream()
                    .filter(n -> n.getMaNV() == l.getMaNV())
                    .findFirst()
                    .orElse(null);
            String tenNV = (nv != null) ? nv.getTenNV() : "";
            tableModel.addRow(new Object[]{
                l.getMaLuong(), l.getMaNV(), tenNV, l.getThang(), l.getNam()
            });
        }
    }

    
    // Tính số ngày làm thực tế dựa trên số lần chấm công trong tháng/năm của NV
    private int getSoNgayLamThucTe(int maNV, int thang, int nam) {
        int count = 0;
        List<ChamCong> listCC = chamCongDAL.getAllChamCong();
        for (ChamCong cc : listCC) {
            if (cc.getMaNV() == maNV &&
                cc.getThoiGianChamCong().getMonthValue() == thang &&
                cc.getThoiGianChamCong().getYear() == nam) {
                count++;
            }
        }
        return count;
    }
    
    // Hàm tính lương thực nhận theo công thức:
    // (LuongCoBan/26)*soNgayLamThucTe + phuCapXang + thuong + chuyenCan - BHXH - BHYT - BHTN
    private double computeLuongThucNhan(double luongCoBan, double phuCapXang, double thuong,
                                          double chuyenCan, double phuCapBHYT, double phuCapBHXH, double phuCapBHTN,
                                          int soNgayLamThucTe) {
        return (luongCoBan / 26.0) * soNgayLamThucTe + phuCapXang + thuong + chuyenCan - phuCapBHXH - phuCapBHYT - phuCapBHTN;
    }
    
       // Load thông tin chi tiết của bản ghi lương khi chọn dòng trong bảng
    private void loadLuongDetails(Luong luong) {
        NhanVien nv = nhanVienDAL.getAllNhanVien().stream()
                .filter(n -> n.getMaNV() == luong.getMaNV())
                .findFirst()
                .orElse(null);
        int soNgayLamThucTe = getSoNgayLamThucTe(luong.getMaNV(), luong.getThang(), luong.getNam());
        double chuyenCan = (soNgayLamThucTe >= 26) ? 200000 : 0;

        double luongThucNhan = 0;
        if (luong.getTrangThai().equalsIgnoreCase("Đã thanh toán")) {
            // Nếu đã chốt, dùng giá trị lưu trong Luong
            luongThucNhan = luong.getTongLuongNhan();
            txtThuong.setEditable(false);
            txtThuong.setEnabled(false);
            // Bạn hiển thị các giá trị đã lưu (thuong, chuyencan, tongLuongNhan) từ Luong
            txtChuyenCan.setText(String.valueOf(luong.getChuyencan()));
            txtLuongThucNhan.setText(String.valueOf(luong.getTongLuongNhan()));
            // Lưu ý: Các giá trị như lương cơ bản, phụ cấp,... vẫn được lấy theo mã hệ số lương hiện hành
            // vì không có snapshot trong Luong.
        } else {
            // Nếu chưa chốt, tính lại từ HeSoLuong
            List<HeSoLuong> listHSL = heSoLuongBUS.searchHeSoLuongByMa(luong.getMaHeSoLuong());
            HeSoLuong hsl = (listHSL != null && !listHSL.isEmpty()) ? listHSL.get(0) : null;
            if (hsl != null) {
                luongThucNhan = computeLuongThucNhan(
                    hsl.getLuongCoBan(),
                    hsl.getPhuCapXang(),
                    luong.getThuong(),
                    chuyenCan,
                    hsl.getPhuCapBHYT(),
                    hsl.getPhuCapBHXH(),
                    hsl.getPhuCapBHTN(),
                    soNgayLamThucTe
                );
                txtLuongCoBan.setText(String.valueOf(hsl.getLuongCoBan()));
                txtPhuCapXangXe.setText(String.valueOf(hsl.getPhuCapXang()));
                txtBHYT.setText(String.valueOf(hsl.getPhuCapBHYT()));
                txtBHXH.setText(String.valueOf(hsl.getPhuCapBHXH()));
                txtBHTN.setText(String.valueOf(hsl.getPhuCapBHTN()));
            }
            txtThuong.setEditable(true);
            txtThuong.setEnabled(true);
            txtChuyenCan.setText(String.valueOf(chuyenCan));
            txtLuongThucNhan.setText(String.valueOf(luongThucNhan));
        }
        txtMaNhanVien.setText(String.valueOf(luong.getMaNV()));
        if (nv != null) {
            txtTenNhanVien.setText(nv.getTenNV());
        }
        txtMaHeSoLuong.setText(luong.getMaHeSoLuong());
        txtSoNgayLamThucTe.setText(String.valueOf(soNgayLamThucTe));
        txtThuong.setText(String.valueOf(luong.getThuong()));

        if (!luong.getTrangThai().equalsIgnoreCase("Đã thanh toán")) {
            originalThuong = luong.getThuong();
        }
    }

    
     // Khởi tạo sự kiện khi chọn một dòng trong bảng
    private void initTableListener() {
        tblXemLuong.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblXemLuong.getSelectedRow();
                if (selectedRow >= 0) {
                    int maLuong = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                    Luong selectedLuong = null;
                    for (Luong l : listLuong) {
                        if (l.getMaLuong() == maLuong) {
                            selectedLuong = l;
                            break;
                        }
                    }
                    if (selectedLuong != null) {
                        loadLuongDetails(selectedLuong);
                    }
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        pnlXemLuong = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnXemTatCa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        scrXemLuong = new javax.swing.JScrollPane();
        tblXemLuong = new javax.swing.JTable();
        btnXuatExcel = new javax.swing.JButton();
        pnlChiTietLuong = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lblTenNhanVien = new javax.swing.JLabel();
        txtSoNgayLamThucTe = new javax.swing.JTextField();
        lblLuongThucNhan = new javax.swing.JLabel();
        txtLuongThucNhan = new javax.swing.JTextField();
        lblMaHeSoLuong = new javax.swing.JLabel();
        txtMaHeSoLuong = new javax.swing.JTextField();
        lblLuongCoBan = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        btnCapNhatHeSoLuong = new javax.swing.JButton();
        lblSoNgayLamThucTe = new javax.swing.JLabel();
        txtBHXH = new javax.swing.JTextField();
        lblChiTietLuong = new javax.swing.JLabel();
        lblPhuCapXangXe = new javax.swing.JLabel();
        lblThuong = new javax.swing.JLabel();
        lblChuyenCan = new javax.swing.JLabel();
        lblBHYT = new javax.swing.JLabel();
        lblBHXH = new javax.swing.JLabel();
        lblBHTN = new javax.swing.JLabel();
        txtChuyenCan = new javax.swing.JTextField();
        txtThuong = new javax.swing.JTextField();
        txtBHYT = new javax.swing.JTextField();
        txtLuongCoBan = new javax.swing.JTextField();
        txtPhuCapXangXe = new javax.swing.JTextField();
        txtBHTN = new javax.swing.JTextField();
        btnChotLuong = new javax.swing.JButton();

        jPanel7.setBackground(new java.awt.Color(135, 206, 235));
        jPanel7.setPreferredSize(new java.awt.Dimension(1140, 720));

        pnlXemLuong.setBackground(new java.awt.Color(135, 206, 235));
        pnlXemLuong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(0, 71, 171));
        lblTimKiem.setText("Tìm kiếm");
        lblTimKiem.setPreferredSize(new java.awt.Dimension(60, 30));

        txtTimKiem.setBackground(new java.awt.Color(237, 242, 251));
        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(64, 30));

        btnXemTatCa.setBackground(new java.awt.Color(0, 100, 168));
        btnXemTatCa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemTatCa.setForeground(new java.awt.Color(237, 242, 251));
        btnXemTatCa.setText("Xem tất cả");
        btnXemTatCa.setToolTipText("");
        btnXemTatCa.setAutoscrolls(true);
        btnXemTatCa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXemTatCa.setPreferredSize(new java.awt.Dimension(95, 30));
        btnXemTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(0, 100, 168));
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(237, 242, 251));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(85, 30));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblXemLuong.setBackground(new java.awt.Color(237, 242, 251));
        tblXemLuong.setForeground(new java.awt.Color(0, 71, 171));
        tblXemLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Lương", "Mã Nhân Viên", "Tên Nhân Viên", "Tháng ", "Năm"
            }
        ));
        tblXemLuong.setGridColor(new java.awt.Color(0, 71, 171));
        tblXemLuong.setSelectionBackground(new java.awt.Color(80, 171, 231));
        scrXemLuong.setViewportView(tblXemLuong);

        btnXuatExcel.setBackground(new java.awt.Color(0, 100, 168));
        btnXuatExcel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(237, 242, 251));
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuatExcel.setPreferredSize(new java.awt.Dimension(85, 30));
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlXemLuongLayout = new javax.swing.GroupLayout(pnlXemLuong);
        pnlXemLuong.setLayout(pnlXemLuongLayout);
        pnlXemLuongLayout.setHorizontalGroup(
            pnlXemLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXemLuongLayout.createSequentialGroup()
                .addGroup(pnlXemLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlXemLuongLayout.createSequentialGroup()
                        .addComponent(scrXemLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlXemLuongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlXemLuongLayout.setVerticalGroup(
            pnlXemLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXemLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlXemLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrXemLuong)
                .addContainerGap())
        );

        pnlChiTietLuong.setBackground(new java.awt.Color(186, 224, 243));
        pnlChiTietLuong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMaNhanVien.setForeground(new java.awt.Color(0, 71, 171));
        lblMaNhanVien.setText("Mã nhân viên");

        txtMaNhanVien.setEditable(false);
        txtMaNhanVien.setBackground(new java.awt.Color(237, 242, 251));
        txtMaNhanVien.setEnabled(false);
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        lblTenNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(0, 71, 171));
        lblTenNhanVien.setText("Tên nhân viên");

        txtSoNgayLamThucTe.setEditable(false);
        txtSoNgayLamThucTe.setBackground(new java.awt.Color(237, 242, 251));
        txtSoNgayLamThucTe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoNgayLamThucTe.setEnabled(false);
        txtSoNgayLamThucTe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayLamThucTeActionPerformed(evt);
            }
        });

        lblLuongThucNhan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLuongThucNhan.setForeground(new java.awt.Color(0, 71, 171));
        lblLuongThucNhan.setText("Lương Thực Nhận");

        txtLuongThucNhan.setEditable(false);
        txtLuongThucNhan.setBackground(new java.awt.Color(237, 242, 251));
        txtLuongThucNhan.setEnabled(false);
        txtLuongThucNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongThucNhanActionPerformed(evt);
            }
        });

        lblMaHeSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMaHeSoLuong.setForeground(new java.awt.Color(0, 71, 171));
        lblMaHeSoLuong.setText("Mã Hệ Số Lương");

        txtMaHeSoLuong.setEditable(false);
        txtMaHeSoLuong.setBackground(new java.awt.Color(237, 242, 251));
        txtMaHeSoLuong.setEnabled(false);

        lblLuongCoBan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLuongCoBan.setForeground(new java.awt.Color(0, 71, 171));
        lblLuongCoBan.setText("Lương Cơ Bản");

        txtTenNhanVien.setEditable(false);
        txtTenNhanVien.setBackground(new java.awt.Color(237, 242, 251));
        txtTenNhanVien.setEnabled(false);

        btnCapNhatHeSoLuong.setBackground(new java.awt.Color(0, 100, 168));
        btnCapNhatHeSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCapNhatHeSoLuong.setForeground(new java.awt.Color(237, 242, 251));
        btnCapNhatHeSoLuong.setText("Cập Nhật Lương");
        btnCapNhatHeSoLuong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhatHeSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatHeSoLuongActionPerformed(evt);
            }
        });

        lblSoNgayLamThucTe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSoNgayLamThucTe.setForeground(new java.awt.Color(0, 71, 171));
        lblSoNgayLamThucTe.setText("Số Ngày Làm thực Tế");

        txtBHXH.setEditable(false);
        txtBHXH.setBackground(new java.awt.Color(237, 242, 251));
        txtBHXH.setEnabled(false);
        txtBHXH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBHXHActionPerformed(evt);
            }
        });

        lblChiTietLuong.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblChiTietLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChiTietLuong.setText("Chi Tiết Lương");

        lblPhuCapXangXe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPhuCapXangXe.setForeground(new java.awt.Color(0, 71, 171));
        lblPhuCapXangXe.setText("Phụ Cấp Xăng Xe");

        lblThuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblThuong.setForeground(new java.awt.Color(0, 71, 171));
        lblThuong.setText("Thưởng");

        lblChuyenCan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblChuyenCan.setForeground(new java.awt.Color(0, 71, 171));
        lblChuyenCan.setText("Chuyên Cần");

        lblBHYT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHYT.setForeground(new java.awt.Color(0, 71, 171));
        lblBHYT.setText("Bảo Hiểm Y Tế");

        lblBHXH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHXH.setForeground(new java.awt.Color(0, 71, 171));
        lblBHXH.setText("Bảo Hiểm Xã Hội");

        lblBHTN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHTN.setForeground(new java.awt.Color(0, 71, 171));
        lblBHTN.setText("Bảo Hiểm Thất Nghiệp");

        txtChuyenCan.setEditable(false);
        txtChuyenCan.setBackground(new java.awt.Color(237, 242, 251));
        txtChuyenCan.setEnabled(false);
        txtChuyenCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChuyenCanActionPerformed(evt);
            }
        });

        txtThuong.setBackground(new java.awt.Color(237, 242, 251));
        txtThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThuongActionPerformed(evt);
            }
        });

        txtBHYT.setEditable(false);
        txtBHYT.setBackground(new java.awt.Color(237, 242, 251));
        txtBHYT.setEnabled(false);
        txtBHYT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBHYTActionPerformed(evt);
            }
        });

        txtLuongCoBan.setEditable(false);
        txtLuongCoBan.setBackground(new java.awt.Color(237, 242, 251));
        txtLuongCoBan.setEnabled(false);
        txtLuongCoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongCoBanActionPerformed(evt);
            }
        });

        txtPhuCapXangXe.setEditable(false);
        txtPhuCapXangXe.setBackground(new java.awt.Color(237, 242, 251));
        txtPhuCapXangXe.setEnabled(false);
        txtPhuCapXangXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhuCapXangXeActionPerformed(evt);
            }
        });

        txtBHTN.setEditable(false);
        txtBHTN.setBackground(new java.awt.Color(237, 242, 251));
        txtBHTN.setEnabled(false);
        txtBHTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBHTNActionPerformed(evt);
            }
        });

        btnChotLuong.setBackground(new java.awt.Color(0, 100, 168));
        btnChotLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChotLuong.setForeground(new java.awt.Color(237, 242, 251));
        btnChotLuong.setText("Chốt Lương");
        btnChotLuong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChotLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChotLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChiTietLuongLayout = new javax.swing.GroupLayout(pnlChiTietLuong);
        pnlChiTietLuong.setLayout(pnlChiTietLuongLayout);
        pnlChiTietLuongLayout.setHorizontalGroup(
            pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietLuongLayout.createSequentialGroup()
                        .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnChotLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblChiTietLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCapNhatHeSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaHeSoLuong)
                                    .addComponent(lblMaNhanVien)
                                    .addComponent(lblTenNhanVien)
                                    .addComponent(lblLuongThucNhan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtMaHeSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLuongThucNhan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(58, 58, 58))
                    .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                        .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                                .addComponent(lblBHTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBHTN, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlChiTietLuongLayout.createSequentialGroup()
                                    .addComponent(lblLuongCoBan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlChiTietLuongLayout.createSequentialGroup()
                                    .addComponent(lblThuong)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlChiTietLuongLayout.createSequentialGroup()
                                    .addComponent(lblChuyenCan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtChuyenCan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlChiTietLuongLayout.createSequentialGroup()
                                    .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSoNgayLamThucTe)
                                        .addComponent(lblPhuCapXangXe))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoNgayLamThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                                .addComponent(lblBHXH)
                                .addGap(39, 39, 39)
                                .addComponent(txtBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                                .addComponent(lblBHYT)
                                .addGap(54, 54, 54)
                                .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlChiTietLuongLayout.setVerticalGroup(
            pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChiTietLuong)
                .addGap(13, 13, 13)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenNhanVien)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHeSoLuong))
                .addGap(7, 7, 7)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLuongThucNhan)
                    .addComponent(txtLuongThucNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThuong)
                    .addComponent(txtThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChuyenCan)
                    .addComponent(txtChuyenCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLuongCoBan)
                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhuCapXangXe)
                    .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoNgayLamThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNgayLamThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBHYT)
                    .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBHXH)
                    .addComponent(txtBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBHTN)
                    .addComponent(txtBHTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(btnCapNhatHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnChotLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlXemLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(pnlChiTietLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlChiTietLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlXemLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void txtSoNgayLamThucTeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayLamThucTeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNgayLamThucTeActionPerformed

    private void txtLuongThucNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongThucNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongThucNhanActionPerformed

    private void btnCapNhatHeSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatHeSoLuongActionPerformed
        // TODO add your handling code here:
     int selectedRow = tblXemLuong.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bản ghi cần cập nhật!");
            return;
        }
        
        double newThuong = 0;
        try {
            newThuong = Double.parseDouble(txtThuong.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá trị thưởng không hợp lệ!");
            return;
        }
        
        if (newThuong == originalThuong) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chỉnh sửa gì!");
            return;
        }
        
        int maLuong = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        Luong selectedLuong = null;
        for (Luong l : listLuong) {
            if (l.getMaLuong() == maLuong) {
                selectedLuong = l;
                break;
            }
        }
        if (selectedLuong == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy bản ghi lương!");
            return;
        }
        
        // Nếu đã chốt, không cho cập nhật
        if (selectedLuong.getTrangThai().equalsIgnoreCase("Đã thanh toán")) {
            JOptionPane.showMessageDialog(this, "Bản ghi đã chốt lương, không thể cập nhật!");
            return;
        }
        
        selectedLuong.setThuong(newThuong);
        
        int soNgayLamThucTe = 0;
        try {
            soNgayLamThucTe = Integer.parseInt(txtSoNgayLamThucTe.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Số ngày làm thực tế không hợp lệ!");
            return;
        }
        double newChuyenCan = (soNgayLamThucTe >= 26) ? 200000 : 0;
        selectedLuong.setChuyencan(newChuyenCan);
        
        List<HeSoLuong> listHSL = heSoLuongBUS.searchHeSoLuongByMa(selectedLuong.getMaHeSoLuong());
        HeSoLuong hsl = (listHSL != null && !listHSL.isEmpty()) ? listHSL.get(0) : null;
        if (hsl == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin hệ số lương!");
            return;
        }
        
        double newTongLuongNhan = computeLuongThucNhan(
            hsl.getLuongCoBan(),
            hsl.getPhuCapXang(),
            selectedLuong.getThuong(),   // giá trị thưởng mới
            newChuyenCan,
            hsl.getPhuCapBHYT(),
            hsl.getPhuCapBHXH(),
            hsl.getPhuCapBHTN(),
            soNgayLamThucTe
        );
        selectedLuong.setTongLuongNhan(newTongLuongNhan);
        
        boolean result = luongDAL.updateLuong(selectedLuong);
        if (result) {
            JOptionPane.showMessageDialog(this, "Cập nhật lương thành công!");
            loadDataLuong();
            loadLuongDetails(selectedLuong);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật lương thất bại!");
        }
    }//GEN-LAST:event_btnCapNhatHeSoLuongActionPerformed

    private void txtBHXHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBHXHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBHXHActionPerformed

    private void txtChuyenCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuyenCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChuyenCanActionPerformed

    private void txtThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThuongActionPerformed

    private void txtBHYTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBHYTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBHYTActionPerformed

    private void txtLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongCoBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongCoBanActionPerformed

    private void txtPhuCapXangXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhuCapXangXeActionPerformed

    private void txtBHTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBHTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBHTNActionPerformed

    private void btnChotLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChotLuongActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblXemLuong.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bản ghi lương cần chốt!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn chốt lương không?\nSau khi chốt, dữ liệu sẽ không thể chỉnh sửa được nữa.", 
            "Xác nhận chốt lương", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int maLuong = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        Luong selectedLuong = null;
        for (Luong l : listLuong) {
            if (l.getMaLuong() == maLuong) {
                selectedLuong = l;
                break;
            }
        }
        if (selectedLuong == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy bản ghi lương!");
            return;
        }

        // Lấy thông tin hệ số lương hiện hành
        List<HeSoLuong> listHSL = heSoLuongBUS.searchHeSoLuongByMa(selectedLuong.getMaHeSoLuong());
        HeSoLuong hsl = (listHSL != null && !listHSL.isEmpty()) ? listHSL.get(0) : null;
        if (hsl == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin hệ số lương!");
            return;
        }

        int soNgayLamThucTe = getSoNgayLamThucTe(selectedLuong.getMaNV(), selectedLuong.getThang(), selectedLuong.getNam());
        double chuyenCan = (soNgayLamThucTe >= 26) ? 200000 : 0;

        // Tính tổng lương thực nhận tại thời điểm chốt
        double frozenTongLuongNhan = computeLuongThucNhan(
            hsl.getLuongCoBan(),
            hsl.getPhuCapXang(),
            selectedLuong.getThuong(),
            chuyenCan,
            hsl.getPhuCapBHYT(),
            hsl.getPhuCapBHXH(),
            hsl.getPhuCapBHTN(),
            soNgayLamThucTe
        );

        // Cập nhật các cột trong bảng Luong mà có thể thay đổi
        selectedLuong.setTongLuongNhan(frozenTongLuongNhan);
        selectedLuong.setChuyencan(chuyenCan);
        selectedLuong.setTrangThai("Đã thanh toán");
        // Lưu ý: không thay đổi maHeSoLuong để tránh vi phạm ràng buộc FK

        boolean result = luongDAL.updateLuong(selectedLuong);
        if (result) {
            JOptionPane.showMessageDialog(this, "Chốt lương thành công!");
            loadDataLuong();
            loadLuongDetails(selectedLuong);
            txtThuong.setEditable(false);
            txtThuong.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Chốt lương thất bại!");
        }
    }//GEN-LAST:event_btnChotLuongActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnXemTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaActionPerformed
        // TODO add your handling code here:
        loadDataLuong();
    }//GEN-LAST:event_btnXemTatCaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
       if (keyword.isEmpty()) {
           loadDataLuong();
           return;
       }

       int currentMaNV = SESSION.CurrentSession.getMaNV();
       String role = SESSION.CurrentSession.getChucVu();

       DefaultTableModel model = (DefaultTableModel) tblXemLuong.getModel();
       model.setRowCount(0);
       for (Luong l : listLuong) {
           // Nếu chức vụ không phải "Quản lý nhân viên" và không phải "Admin", chỉ xét nếu l.getMaNV() bằng currentMaNV
           if (!role.equalsIgnoreCase("Quản lý nhân viên") &&
               !role.equalsIgnoreCase("Admin") &&
               l.getMaNV() != currentMaNV) {
               continue;
           }

           NhanVien nv = nhanVienDAL.getAllNhanVien().stream()
                   .filter(n -> n.getMaNV() == l.getMaNV())
                   .findFirst()
                   .orElse(null);
           String tenNV = (nv != null) ? nv.getTenNV() : "";
           boolean match = false;
           if (keyword.matches("\\d+")) {
               if (l.getMaNV() == Integer.parseInt(keyword)) {
                   match = true;
               }
           } else {
               if (!keyword.isEmpty() && tenNV.toLowerCase().contains(keyword.toLowerCase())) {
                   match = true;
               }
           }
           if (match) {
               model.addRow(new Object[]{l.getMaLuong(), l.getMaNV(), tenNV, l.getThang(), l.getNam()});
           }
       }
       if (model.getRowCount() == 0) {
           JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!");
       }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatHeSoLuong;
    private javax.swing.JButton btnChotLuong;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblBHTN;
    private javax.swing.JLabel lblBHXH;
    private javax.swing.JLabel lblBHYT;
    private javax.swing.JLabel lblChiTietLuong;
    private javax.swing.JLabel lblChuyenCan;
    private javax.swing.JLabel lblLuongCoBan;
    private javax.swing.JLabel lblLuongThucNhan;
    private javax.swing.JLabel lblMaHeSoLuong;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblPhuCapXangXe;
    private javax.swing.JLabel lblSoNgayLamThucTe;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThuong;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlChiTietLuong;
    private javax.swing.JPanel pnlXemLuong;
    private javax.swing.JScrollPane scrXemLuong;
    private javax.swing.JTable tblXemLuong;
    private javax.swing.JTextField txtBHTN;
    private javax.swing.JTextField txtBHXH;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtChuyenCan;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtLuongThucNhan;
    private javax.swing.JTextField txtMaHeSoLuong;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtPhuCapXangXe;
    private javax.swing.JTextField txtSoNgayLamThucTe;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtThuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
