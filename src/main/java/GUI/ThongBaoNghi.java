/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author Windows
 */
import BUS.DonXinNghiBUS;
import BUS.NhanVienBUS;
import DTO.DonXinNghi;
import DTO.NhanVien;
import SESSION.CurrentSession; // Lớp này cần được tạo để lưu thông tin phiên đăng nhập
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThongBaoNghi extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyNhanVien
     */
    private DefaultTableModel tableModel;
    private DonXinNghiBUS donBUS;
    
    // Lấy thông tin từ phiên đăng nhập
    private int currentMaNV;
    private String currentChucVu;
    
    public ThongBaoNghi() {
        initComponents();
        // Thêm sự kiện khi chọn một dòng trong bảng thông báo nghỉ
        tblThongBaoNghi.getSelectionModel().addListSelectionListener(e -> {
            // Chỉ xử lý khi sự kiện không phải là "adjusting"
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblThongBaoNghi.getSelectedRow();
                if (selectedRow >= 0) {
                    // Giả sử bạn muốn hiển thị thông tin: Mã NV, Tên NV, Số ngày nghỉ, Ngày bắt đầu, Ngày kết thúc, Lý do, Trạng thái
                    txtMaNhanVien.setText(tblThongBaoNghi.getValueAt(selectedRow, 1).toString());
                    txtTenNhanVien.setText(tblThongBaoNghi.getValueAt(selectedRow, 2).toString());
                    txtSoNgayNghi.setText(tblThongBaoNghi.getValueAt(selectedRow, 4).toString());
                    txtNgayBatDau.setText(tblThongBaoNghi.getValueAt(selectedRow, 5).toString());
                    txtNgayKetThuc.setText(tblThongBaoNghi.getValueAt(selectedRow, 6).toString());
                    txtLyDo.setText(tblThongBaoNghi.getValueAt(selectedRow, 7).toString());
                    txtTrangThai.setText(tblThongBaoNghi.getValueAt(selectedRow, 8).toString());
                }
            }
        });

        // Khởi tạo BUS
        donBUS = new DonXinNghiBUS();
        // Lấy thông tin phiên hiện tại từ CurrentSession
        currentMaNV = CurrentSession.getMaNV();
        currentChucVu = CurrentSession.getChucVu();
        // Ẩn/hiện các nút dựa trên chức vụ
        if (currentChucVu.equalsIgnoreCase("Quản lý nhân viên")) {
            // Quản lý nhân viên: hiển thị btnDuyet và btnKhongDuyet, ẩn btnThem
            btnDuyet.setVisible(true);
            btnKhongDuyet.setVisible(true);
            bthThem.setVisible(false);
        } else if (currentChucVu.equalsIgnoreCase("Nhân viên bán hàng") ||
                   currentChucVu.equalsIgnoreCase("Quản lý kho hàng")) {
            // Các bộ phận này: hiển thị btnThem, ẩn btnDuyet và btnKhongDuyet
            btnDuyet.setVisible(false);
            btnKhongDuyet.setVisible(false);
            bthThem.setVisible(true);
        }
        
        initTable();
        loadDataThongBaoNghi();
    }

        // Khởi tạo model cho bảng
    private void initTable() {
        String[] columnNames = {
            "Mã Đơn", "Mã NV", "Tên NV", "Ngày nộp đơn", "Số ngày nghỉ", 
            "Ngày bắt đầu", "Ngày kết thúc", "Lý do", "Trạng thái", "Người duyệt", "Ngày duyệt"
        };
        tableModel = new DefaultTableModel(columnNames, 0);
        tblThongBaoNghi.setModel(tableModel);
    }
    

    private void loadDataThongBaoNghi() {
        tableModel.setRowCount(0);
        DonXinNghiBUS donBUS = new DonXinNghiBUS();
        NhanVienBUS nvBUS = new NhanVienBUS();
        List<DonXinNghi> list = donBUS.getAllDonXinNghi();

        // Định dạng ngày chỉ đến giây
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (DonXinNghi don : list) {
            // Nếu chức vụ hiện tại không phải "Quản lý nhân viên"
            // thì chỉ load đơn có mã NV bằng currentMaNV (biến currentMaNV phải được set từ phiên đăng nhập)
            if (!currentChucVu.equalsIgnoreCase("Quản lý nhân viên") && don.getMaNV() != currentMaNV) {
                continue;
            }

            // Lấy tên nhân viên dựa trên maNV
            String tenNV = "";
            NhanVien nv = nvBUS.getNhanVienByMaNV(don.getMaNV());
            if (nv != null) {
                tenNV = nv.getTenNV();
            }

            // Định dạng ngày nộp đơn
            String ngayNopDonStr = "";
            if (don.getNgayNopDon() != null) {
                ngayNopDonStr = don.getNgayNopDon().format(dtf);
            }

            // Lấy tên người duyệt (nếu có); nếu không có, hiển thị chuỗi rỗng
            String tenNguoiDuyet = "";
            if (don.getMaNguoiDuyet() > 0) {
                NhanVien nvDuyet = nvBUS.getNhanVienByMaNV(don.getMaNguoiDuyet());
                if (nvDuyet != null) {
                    tenNguoiDuyet = nvDuyet.getTenNV();
                }
            }

            // Định dạng ngày duyệt
            String ngayDuyetStr = "";
            if (don.getNgayDuyet() != null) {
                ngayDuyetStr = don.getNgayDuyet().format(dtf);
            }

            // Các cột hiển thị theo thứ tự: 
            // Mã đơn, Mã NV, Tên NV, Ngày nộp đơn, Số ngày nghỉ, Ngày bắt đầu, Ngày kết thúc, Lý do, Trạng thái, Tên người duyệt, Ngày duyệt
            Object[] row = {
                don.getMaDon(),
                don.getMaNV(),
                tenNV,
                ngayNopDonStr,
                don.getSoNgayNghi(),
                don.getNgayBatDau().toString(),   // Bạn có thể định dạng nếu cần
                don.getNgayKetThuc().toString(),   // Bạn có thể định dạng nếu cần
                don.getNoiDung(),
                don.getTrangThai(),
                tenNguoiDuyet,
                ngayDuyetStr
            };
            tableModel.addRow(row);
        }
    }

    private void searchDonXinNghi(String keyword) {
        tableModel.setRowCount(0);
        DonXinNghiBUS donBUS = new DonXinNghiBUS();
        NhanVienBUS nvBUS = new NhanVienBUS();
        List<DonXinNghi> list = donBUS.getAllDonXinNghi();

        // Định dạng ngày chỉ đến giây
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        boolean isNumeric = keyword.matches("\\d+");
        for (DonXinNghi don : list) {
            // Nếu chức vụ hiện tại không phải "Quản lý nhân viên" thì chỉ load đơn có mã NV bằng currentMaNV
            if (!currentChucVu.equalsIgnoreCase("Quản lý nhân viên") && don.getMaNV() != currentMaNV) {
                continue;
            }

            // Lấy thông tin nhân viên dựa trên maNV
            NhanVien nv = nvBUS.getNhanVienByMaNV(don.getMaNV());
            String tenNV = (nv != null) ? nv.getTenNV() : "";

            // Kiểm tra điều kiện tìm kiếm: nếu keyword là số thì so sánh với maNV;
            // nếu là chữ thì kiểm tra tên nhân viên chứa từ khóa
            boolean match = false;
            if (isNumeric) {
                if (don.getMaNV() == Integer.parseInt(keyword)) {
                    match = true;
                }
            } else {
                if (!keyword.isEmpty() && tenNV.toLowerCase().contains(keyword.toLowerCase())) {
                    match = true;
                }
            }
            // Nếu keyword rỗng, load hết
            if (keyword.isEmpty()) {
                match = true;
            }

            if (match) {
                // Định dạng ngày nộp đơn
                String ngayNopDonStr = (don.getNgayNopDon() != null) ? don.getNgayNopDon().format(dtf) : "";

                // Lấy tên người duyệt dựa trên maNguoiDuyet, nếu có; nếu không có thì để chuỗi rỗng
                String tenNguoiDuyet = "";
                if (don.getMaNguoiDuyet() > 0) {
                    NhanVien nvDuyet = nvBUS.getNhanVienByMaNV(don.getMaNguoiDuyet());
                    if (nvDuyet != null) {
                        tenNguoiDuyet = nvDuyet.getTenNV();
                    }
                }

                // Định dạng ngày duyệt
                String ngayDuyetStr = (don.getNgayDuyet() != null) ? don.getNgayDuyet().format(dtf) : "";

                Object[] row = {
                    don.getMaDon(),
                    don.getMaNV(),
                    tenNV,
                    ngayNopDonStr,
                    don.getSoNgayNghi(),
                    don.getNgayBatDau().toString(),   // Có thể thêm định dạng nếu cần
                    don.getNgayKetThuc().toString(),   // Có thể thêm định dạng nếu cần
                    don.getNoiDung(),
                    don.getTrangThai(),
                    tenNguoiDuyet,
                    ngayDuyetStr
                };
                tableModel.addRow(row);
            }
        }

        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy đơn xin nghỉ phù hợp với từ khóa: " + keyword);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongBaoNghi = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnXemTatCa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        scrThongBaoNghi = new javax.swing.JScrollPane();
        tblThongBaoNghi = new javax.swing.JTable();
        bthThem = new javax.swing.JButton();
        pnlChiTietTBN = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lblTenNhanVien = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        lblSoNgayNghi = new javax.swing.JLabel();
        txtSoNgayNghi = new javax.swing.JTextField();
        lblNgayBatDau = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();
        lblNgayKetThuc = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        btnDuyet = new javax.swing.JButton();
        btnKhongDuyet = new javax.swing.JButton();
        lblLyDo = new javax.swing.JLabel();
        lblChiTietThongBaoNghi = new javax.swing.JLabel();
        txtLyDo = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(1140, 720));

        pnlThongBaoNghi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTimKiem.setText("Tìm kiếm");

        btnXemTatCa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemTatCa.setText("Xem tất cả");
        btnXemTatCa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXemTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblThongBaoNghi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Đơn", "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Nộp Đơn", "Số Ngày Nghỉ", "Ngày Bắt Đầu", "Ngày kết Thúc", "Lý Do", "Trạng Thái", "Người Duyệt", "Ngày Duyệt"
            }
        ));
        scrThongBaoNghi.setViewportView(tblThongBaoNghi);

        bthThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bthThem.setText("Thêm");
        bthThem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bthThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthThemMouseClicked(evt);
            }
        });
        bthThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongBaoNghiLayout = new javax.swing.GroupLayout(pnlThongBaoNghi);
        pnlThongBaoNghi.setLayout(pnlThongBaoNghiLayout);
        pnlThongBaoNghiLayout.setHorizontalGroup(
            pnlThongBaoNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongBaoNghiLayout.createSequentialGroup()
                .addGroup(pnlThongBaoNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongBaoNghiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bthThem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrThongBaoNghi, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThongBaoNghiLayout.setVerticalGroup(
            pnlThongBaoNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongBaoNghiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongBaoNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemTatCa)
                    .addComponent(btnTimKiem)
                    .addComponent(bthThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrThongBaoNghi, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlChiTietTBN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMaNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMaNhanVien.setText("Mã nhân viên");

        txtMaNhanVien.setEditable(false);
        txtMaNhanVien.setEnabled(false);
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        lblTenNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTenNhanVien.setText("Tên nhân viên");

        txtTenNhanVien.setEditable(false);
        txtTenNhanVien.setEnabled(false);
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhanVienActionPerformed(evt);
            }
        });

        lblSoNgayNghi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSoNgayNghi.setText("Số Ngày Nghỉ");

        txtSoNgayNghi.setEditable(false);
        txtSoNgayNghi.setEnabled(false);
        txtSoNgayNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayNghiActionPerformed(evt);
            }
        });

        lblNgayBatDau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNgayBatDau.setText("Ngày Bắt Đầu");

        txtNgayBatDau.setEditable(false);
        txtNgayBatDau.setEnabled(false);

        lblNgayKetThuc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNgayKetThuc.setText("Ngày Kết Thúc");

        txtNgayKetThuc.setEditable(false);
        txtNgayKetThuc.setEnabled(false);

        btnDuyet.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDuyet.setText("Duyệt");
        btnDuyet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuyetActionPerformed(evt);
            }
        });

        btnKhongDuyet.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnKhongDuyet.setText("Không duyệt");
        btnKhongDuyet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKhongDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongDuyetActionPerformed(evt);
            }
        });

        lblLyDo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLyDo.setText("Lý Do");

        lblChiTietThongBaoNghi.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblChiTietThongBaoNghi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChiTietThongBaoNghi.setText("Chi Tiết Thông Báo Nghỉ");

        txtLyDo.setEditable(false);
        txtLyDo.setEnabled(false);
        txtLyDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLyDoActionPerformed(evt);
            }
        });

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTrangThai.setText("Trạng Thái");

        txtTrangThai.setEditable(false);
        txtTrangThai.setEnabled(false);
        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChiTietTBNLayout = new javax.swing.GroupLayout(pnlChiTietTBN);
        pnlChiTietTBN.setLayout(pnlChiTietTBNLayout);
        pnlChiTietTBNLayout.setHorizontalGroup(
            pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblMaNhanVien))
                    .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTenNhanVien)
                                .addComponent(lblNgayKetThuc)
                                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSoNgayNghi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblLyDo)))
                    .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTrangThai)))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaNhanVien)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgayNghi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayBatDau)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txtLyDo)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChiTietThongBaoNghi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                        .addComponent(btnDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhongDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlChiTietTBNLayout.setVerticalGroup(
            pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietTBNLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblChiTietThongBaoNghi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNhanVien)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoNgayNghi)
                    .addComponent(txtSoNgayNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayBatDau)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayKetThuc)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLyDo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrangThai))
                .addGap(27, 27, 27)
                .addGroup(pnlChiTietTBNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhongDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongBaoNghi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChiTietTBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlChiTietTBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addComponent(pnlThongBaoNghi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienActionPerformed

    private void txtSoNgayNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayNghiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNgayNghiActionPerformed

    private void bthThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthThemMouseClicked
        // TODO add your handling code here:
        ThemTBN n = new ThemTBN();
        n.setVisible(true);
    }//GEN-LAST:event_bthThemMouseClicked

    private void bthThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthThemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bthThemActionPerformed

    private void txtLyDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLyDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLyDoActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();
        searchDonXinNghi(keyword);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXemTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaActionPerformed
        // TODO add your handling code here:
        loadDataThongBaoNghi();
    }//GEN-LAST:event_btnXemTatCaActionPerformed

    private void btnDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuyetActionPerformed
        // TODO add your handling code here:
        // Lấy đơn được chọn từ bảng
        int selectedRow = tblThongBaoNghi.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn xin nghỉ để duyệt!");
            return;
        }
        
        int maDon = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        DonXinNghi don = donBUS.getDonXinNghiByMaDon(maDon);
        if (don == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy đơn xin nghỉ!");
            return;
        }

        if (!don.getTrangThai().equalsIgnoreCase("Chờ duyệt")) {
            JOptionPane.showMessageDialog(this, "Đơn đã được xử lý, không thể duyệt lại!");
            return;
        }
        // Gọi BUS duyệt đơn
        BUS.DonXinNghiBUS donBUS = new BUS.DonXinNghiBUS();
        boolean result = donBUS.approveDonXinNghi(maDon);
        if (result) {
            JOptionPane.showMessageDialog(this, "Đã duyệt đơn thành công!");
            loadDataThongBaoNghi();
        } else {
            JOptionPane.showMessageDialog(this, "Duyệt đơn thất bại!");
        }
    }//GEN-LAST:event_btnDuyetActionPerformed

    private void btnKhongDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongDuyetActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblThongBaoNghi.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn xin nghỉ để từ chối!");
            return;
        }
        int maDon = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        DonXinNghi don = donBUS.getDonXinNghiByMaDon(maDon);
        if (don == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy đơn xin nghỉ!");
            return;
        }

        if (!don.getTrangThai().equalsIgnoreCase("Chờ duyệt")) {
            JOptionPane.showMessageDialog(this, "Đơn đã được xử lý, không thể từ chối lại!");
            return;
        }
        BUS.DonXinNghiBUS donBUS = new BUS.DonXinNghiBUS();
        boolean result = donBUS.disapproveDonXinNghi(maDon);
        if (result) {
            JOptionPane.showMessageDialog(this, "Đã từ chối đơn thành công!");
            loadDataThongBaoNghi();
        } else {
            JOptionPane.showMessageDialog(this, "Từ chối đơn thất bại!");
        }
    }//GEN-LAST:event_btnKhongDuyetActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthThem;
    private javax.swing.JButton btnDuyet;
    private javax.swing.JButton btnKhongDuyet;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JLabel lblChiTietThongBaoNghi;
    private javax.swing.JLabel lblLyDo;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgayBatDau;
    private javax.swing.JLabel lblNgayKetThuc;
    private javax.swing.JLabel lblSoNgayNghi;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlChiTietTBN;
    private javax.swing.JPanel pnlThongBaoNghi;
    private javax.swing.JScrollPane scrThongBaoNghi;
    private javax.swing.JTable tblThongBaoNghi;
    private javax.swing.JTextField txtLyDo;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtSoNgayNghi;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
