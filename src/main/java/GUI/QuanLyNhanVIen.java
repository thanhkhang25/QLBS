package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVien;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVien extends javax.swing.JPanel {

    // Khai báo biến BUS và TableModel
    private NhanVienBUS nvBUS;
    private DefaultTableModel tableModel;

    public QuanLyNhanVien() {
        initComponents();
        nvBUS = new NhanVienBUS();
        initTable();         // Khởi tạo bảng
        loadDataNhanVien();  // Load danh sách nhân viên từ BUS
        jTable1.getSelectionModel().addListSelectionListener(e -> {
        // Kiểm tra xem không phải là sự kiện tạm thời
        if (!e.getValueIsAdjusting()) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) {
                // Giả sử thứ tự cột của tableModel là:
                // 0: Mã, 1: Tên, 2: Ngày sinh, 3: Giới tính, 4: SĐT, 5: Email, 6: Địa chỉ, 7: Ngày vào làm, 8: Chi nhánh, 9: Trạng thái
                txtMaNhanVien.setText(tableModel.getValueAt(selectedRow, 0).toString());
                txtTenNhanVien.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtNgaySinh.setText(tableModel.getValueAt(selectedRow, 2).toString());
                // Nếu bạn có trường Giới tính, bạn có thể set cho combobox hoặc ô hiển thị
                // Ví dụ: cmbGioiTinh.setSelectedItem(tableModel.getValueAt(selectedRow, 3).toString());
                txtSDT.setText(tableModel.getValueAt(selectedRow, 4).toString());
                txtMail.setText(tableModel.getValueAt(selectedRow, 5).toString());

                txtChucVu.setText(tableModel.getValueAt(selectedRow,7).toString());
                txtChiNhanh.setText(tableModel.getValueAt(selectedRow, 9).toString());
                txtTrangThai.setText(tableModel.getValueAt(selectedRow, 10).toString());
            }
        }
    });

    }

    // Khởi tạo model cho jTable1 với các cột tương ứng
    private void initTable() {
        String[] columnNames = {"Mã", "Tên", "Ngày sinh", "Giới tính", "SĐT", "Email", "Địa chỉ","Chức Vụ", "Ngày vào làm", "Chi nhánh", "Trạng thái"};
        tableModel = new DefaultTableModel(columnNames, 0);
        jTable1.setModel(tableModel);
    }

    // Phương thức load dữ liệu nhân viên từ BUS và cập nhật vào bảng
    private void loadDataNhanVien() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<NhanVien> list = nvBUS.getAllNhanVien();
        // Tạo instance của TaiKhoanBUS để lấy thông tin chức vụ của từng nhân viên
        BUS.TaiKhoanBUS tkBUS = new BUS.TaiKhoanBUS();
        for (NhanVien nv : list) {
            // Lấy thông tin tài khoản của nhân viên dựa trên maNV
            DTO.TaiKhoan tk = tkBUS.getTaiKhoanByMaNV(nv.getMaNV());
            // Nếu không tìm thấy, set mặc định là rỗng
            String chucVu = (tk != null) ? tk.getChucVu() : "";
            Object[] row = {
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getNgaySinh(),
                nv.getGioiTinh(),
                nv.getSdt(),
                nv.getEmail(),
                nv.getDiaChi(),
                chucVu,                   // Cột Chức Vụ lấy từ bảng TaiKhoan
                nv.getNgayVaoLam(),
                nv.getChiNhanh(),
                nv.getTrangThai()         // Hoặc nếu trang thái tài khoản cần lấy từ TaiKhoan, bạn có thể lấy tk.getTrangThai()
            };
            tableModel.addRow(row);
        }
    }

    // -------------------------------
    // Xử lý sự kiện (Event Handlers)
    // -------------------------------


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuanLyNhanVien = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnXemTatCa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        scrQuanLyNhanVien = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        pnlChiTietNhanVien = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lblTenNhanVien = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblChiNhanh = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();
        lblNgaySinh = new javax.swing.JLabel();
        txtChiNhanh = new javax.swing.JTextField();
        lblChiTietNhanVien = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();

        setBackground(new java.awt.Color(135, 206, 235));
        setPreferredSize(new java.awt.Dimension(1140, 720));

        pnlQuanLyNhanVien.setBackground(new java.awt.Color(135, 206, 235));
        pnlQuanLyNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jTable1.setBackground(new java.awt.Color(237, 242, 251));
        jTable1.setForeground(new java.awt.Color(0, 71, 171));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Ngày sinh", "Số điện thoại", "Mail", "Giới Tính", "Địa Chỉ", "Chức Vụ", "Ngày Vào Làm", "Chi Nhánh", "Trạng thái"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 71, 171));
        jTable1.setSelectionBackground(new java.awt.Color(80, 171, 231));
        scrQuanLyNhanVien.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        btnThem.setBackground(new java.awt.Color(0, 100, 168));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(237, 242, 251));
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlQuanLyNhanVienLayout = new javax.swing.GroupLayout(pnlQuanLyNhanVien);
        pnlQuanLyNhanVien.setLayout(pnlQuanLyNhanVienLayout);
        pnlQuanLyNhanVienLayout.setHorizontalGroup(
            pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuanLyNhanVienLayout.createSequentialGroup()
                .addGroup(pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(pnlQuanLyNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlQuanLyNhanVienLayout.setVerticalGroup(
            pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuanLyNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnThem.getAccessibleContext().setAccessibleDescription("");

        pnlChiTietNhanVien.setBackground(new java.awt.Color(135, 206, 235));
        pnlChiTietNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        txtNgaySinh.setBackground(new java.awt.Color(237, 242, 251));
        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        lblSDT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(0, 71, 171));
        lblSDT.setText("Số điện thoại");

        txtSDT.setBackground(new java.awt.Color(237, 242, 251));
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        lblMail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMail.setForeground(new java.awt.Color(0, 71, 171));
        lblMail.setText("Mail");

        txtMail.setBackground(new java.awt.Color(237, 242, 251));

        lblChiNhanh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblChiNhanh.setForeground(new java.awt.Color(0, 71, 171));
        lblChiNhanh.setText("Chi nhánh");

        txtTenNhanVien.setBackground(new java.awt.Color(237, 242, 251));

        btnCapNhat.setBackground(new java.awt.Color(0, 100, 168));
        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(237, 242, 251));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        lblNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(0, 71, 171));
        lblNgaySinh.setText("Ngày Sinh");

        txtChiNhanh.setBackground(new java.awt.Color(237, 242, 251));
        txtChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChiNhanhActionPerformed(evt);
            }
        });

        lblChiTietNhanVien.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblChiTietNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChiTietNhanVien.setText("Chi Tiết Nhân Viên");

        lblChucVu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(0, 71, 171));
        lblChucVu.setText("Chức Vụ");

        txtChucVu.setBackground(new java.awt.Color(237, 242, 251));
        txtChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChucVuActionPerformed(evt);
            }
        });

        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(0, 71, 171));
        lblTrangThai.setText("Trạng Thái");

        txtTrangThai.setBackground(new java.awt.Color(237, 242, 251));
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChiTietNhanVienLayout = new javax.swing.GroupLayout(pnlChiTietNhanVien);
        pnlChiTietNhanVien.setLayout(pnlChiTietNhanVienLayout);
        pnlChiTietNhanVienLayout.setHorizontalGroup(
            pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChiTietNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietNhanVienLayout.createSequentialGroup()
                                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietNhanVienLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblMaNhanVien))
                                    .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblChiNhanh)
                                            .addComponent(lblNgaySinh))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(txtChiNhanh)
                                    .addComponent(txtSDT)
                                    .addComponent(txtMail)
                                    .addComponent(txtTenNhanVien)
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtChucVu)
                                    .addComponent(txtTrangThai)))
                            .addComponent(lblTenNhanVien)
                            .addComponent(lblMail)
                            .addComponent(lblSDT)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58))
                    .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                        .addComponent(lblChucVu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                        .addComponent(lblTrangThai)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlChiTietNhanVienLayout.setVerticalGroup(
            pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChiTietNhanVien)
                .addGap(13, 13, 13)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenNhanVien)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChiNhanh)
                    .addComponent(txtChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgaySinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChucVu)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangThai)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChiTietNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlChiTietNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChiNhanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChiNhanhActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        System.out.println("btnTimKiemActionPerformed được gọi");
        String keyword = txtTimKiem.getText().trim();
        // Tạo instance của TaiKhoanBUS để lấy thông tin chức vụ của từng nhân viên
        BUS.TaiKhoanBUS tkBUS = new BUS.TaiKhoanBUS();
        List<NhanVien> list = nvBUS.searchNhanVienByName(keyword);
        tableModel.setRowCount(0);
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên với từ khóa: " + keyword);
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên nào phù hợp với từ khóa: " + keyword);
        } else {
            for (NhanVien nv : list) {
                    DTO.TaiKhoan tk = tkBUS.getTaiKhoanByMaNV(nv.getMaNV());
                    // Nếu không tìm thấy, set mặc định là rỗng
                    String chucVu = (tk != null) ? tk.getChucVu() : "";
                Object[] row = {
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getNgaySinh(),
                    nv.getGioiTinh(),
                    nv.getSdt(),
                    nv.getEmail(),
                    nv.getDiaChi(),
                    chucVu,
                    nv.getNgayVaoLam(),
                    nv.getChiNhanh(),
                    nv.getTrangThai()
                };
                tableModel.addRow(row);
            }
            System.out.println("Đã cập nhật bảng với " + list.size() + " nhân viên");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXemTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaActionPerformed
        // TODO add your handling code here:
        System.out.println("btnXemTatCaActionPerformed được gọi");
        loadDataNhanVien();
    }//GEN-LAST:event_btnXemTatCaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        System.out.println("btnThemActionPerformed được gọi");
        // Tạo dialog thêm nhân viên; dùng constructor có tham số hoặc mặc định nếu bạn đã thêm constructor no-argument
        ThemNV themNVDialog = new ThemNV(null, true); // Hoặc new ThemNV() nếu đã có constructor mặc định
        themNVDialog.setVisible(true);
        // Sau khi dialog đóng, kiểm tra xem nhân viên đã được thêm thành công chưa
        if (themNVDialog.isAdded()) {  
            loadDataNhanVien();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để cập nhật!");
            return;
        }
        try {
            // Lấy mã nhân viên từ ô cập nhật
            int maNV = Integer.parseInt(txtMaNhanVien.getText().trim());

            // Lấy dữ liệu hiện tại của nhân viên và tài khoản từ database
            BUS.NhanVienBUS nvBUS = new BUS.NhanVienBUS();
            DTO.NhanVien nvCurrent = nvBUS.getNhanVienByMaNV(maNV);

            BUS.TaiKhoanBUS tkBUS = new BUS.TaiKhoanBUS();
            DTO.TaiKhoan tkCurrent = tkBUS.getTaiKhoanByMaNV(maNV);

            // Nếu không cập nhật mật khẩu, giữ lại mật khẩu hiện tại
            String currentMatKhau = (tkCurrent != null) ? tkCurrent.getMatKhau() : "";

            // Lấy dữ liệu cập nhật từ giao diện
            String tenNV = txtTenNhanVien.getText().trim();
            String email = txtMail.getText().trim();
            String sdt = txtSDT.getText().trim();
            String chiNhanh = txtChiNhanh.getText().trim();
            String ngaySinhStr = txtNgaySinh.getText().trim();  // Định dạng YYYY-MM-DD
            String chucVu = txtChucVu.getText().trim();         // Lấy từ ô cập nhật (mới)
            String trangThai = txtTrangThai.getText().trim();     // Lấy từ ô cập nhật

            // Chuyển đổi ngày sinh
            java.sql.Date ngaySinh = java.sql.Date.valueOf(ngaySinhStr);

            // Đối với các thông tin không có ô cập nhật, giữ lại giá trị hiện tại từ database
            String gioiTinh = (nvCurrent != null) ? nvCurrent.getGioiTinh() : "";
            String diaChi = (nvCurrent != null) ? nvCurrent.getDiaChi() : "";
            java.sql.Date ngayVaoLam = (nvCurrent != null) ? nvCurrent.getNgayVaoLam() : new java.sql.Date(System.currentTimeMillis());

            // Tạo đối tượng cập nhật cho NhanVien
            DTO.NhanVien nvUpdate = new DTO.NhanVien();
            nvUpdate.setMaNV(maNV);
            nvUpdate.setTenNV(tenNV);
            nvUpdate.setNgaySinh(ngaySinh);
            nvUpdate.setGioiTinh(gioiTinh);
            nvUpdate.setSdt(sdt);
            nvUpdate.setEmail(email);
            nvUpdate.setDiaChi(diaChi);
            nvUpdate.setNgayVaoLam(ngayVaoLam);
            nvUpdate.setChiNhanh(chiNhanh);
            // Giữ trạng thái của nhân viên (có thể cập nhật nếu bạn muốn)
            nvUpdate.setTrangThai((nvCurrent != null) ? nvCurrent.getTrangThai() : "Hoạt động");

            boolean updatedNV = nvBUS.updateNhanVien(nvUpdate);

            // Tạo đối tượng cập nhật cho TaiKhoan
            DTO.TaiKhoan tkUpdate = new DTO.TaiKhoan();
            // Lấy mã TK từ tkCurrent (nếu có)
            int maTK = (tkCurrent != null) ? tkCurrent.getMaTK() : 0;
            tkUpdate.setMaTK(maTK);
            tkUpdate.setMaNV(maNV);
            tkUpdate.setMatKhau(currentMatKhau); // Không cập nhật mật khẩu từ giao diện
            tkUpdate.setChucVu(chucVu);           // Cập nhật chức vụ mới từ ô txtChucVu
            tkUpdate.setTrangThai(trangThai);     // Cập nhật trạng thái từ ô txtTrangThai

            boolean updatedTK = tkBUS.updateTaiKhoan(tkUpdate);

            if (updatedNV && updatedTK) {
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công!");
                loadDataNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thất bại!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChucVuActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblChiNhanh;
    private javax.swing.JLabel lblChiTietNhanVien;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlChiTietNhanVien;
    private javax.swing.JPanel pnlQuanLyNhanVien;
    private javax.swing.JScrollPane scrQuanLyNhanVien;
    private javax.swing.JTextField txtChiNhanh;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

}