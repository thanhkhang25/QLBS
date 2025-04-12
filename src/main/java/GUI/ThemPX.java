package GUI;

import BUS.NhanVienBUS;
import BUS.PhieuXuatBUS;
import BUS.SachBUS;
import DTO.ChiTietPhieuXuat;
import DTO.NhanVien;
import DTO.PhieuXuat;
import DTO.Sach;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ThemPX extends javax.swing.JFrame {
    public ThemPX() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        refershButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewBookTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        maSPLabel = new javax.swing.JLabel();
        maSPTextField = new javax.swing.JTextField();
        tenSPLabel = new javax.swing.JLabel();
        tenSPTextField = new javax.swing.JTextField();
        soLuongLabel = new javax.swing.JLabel();
        choseButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        soLuongTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        maPNLabel = new javax.swing.JLabel();
        maPhieuXuatTextField = new javax.swing.JTextField();
        tenNVLabel = new javax.swing.JLabel();
        nhayXuatLabel = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        tenNVCombobox = new javax.swing.JComboBox<>();
        ngayXuatLabel = new javax.swing.JTextField();
        giaNhapLabel = new javax.swing.JLabel();
        chiNhanhComboBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        viewDetailTable = new javax.swing.JTable();
        moveButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        refershButton.setText("Làm mới");
        refershButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refershButtonActionPerformed(evt);
            }
        });

        viewBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng tồn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewBookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewBookTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(refershButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refershButton)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        maSPLabel.setText("Mã sản phẩm");

        maSPTextField.setEditable(false);

        tenSPLabel.setText("Tên sản phẩm");

        tenSPTextField.setEditable(false);

        soLuongLabel.setText("Số lượng xuất");

        choseButton.setText("Chọn sản phẩm");
        choseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choseButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Thông tin chi tiết");

        soLuongTextField.setText("1");
        soLuongTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuongTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tenSPTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(maSPLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tenSPLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(maSPTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(choseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(soLuongLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(soLuongTextField))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maSPLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenSPLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soLuongLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soLuongTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(choseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        maPNLabel.setText("Mã phiếu xuất");

        maPhieuXuatTextField.setEditable(false);

        tenNVLabel.setText("Nhân viên nhận");

        nhayXuatLabel.setText("Ngày xuất");

        exportButton.setText("Xuất hàng");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        ngayXuatLabel.setEditable(false);

        giaNhapLabel.setText("Chi nhánh");

        chiNhanhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hồ Chí Minh", "Hà Nội" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(maPNLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maPhieuXuatTextField)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ngayXuatLabel)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenNVLabel)
                            .addComponent(nhayXuatLabel)
                            .addComponent(tenNVCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(giaNhapLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chiNhanhComboBox, 0, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maPNLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maPhieuXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tenNVLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenNVCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhayXuatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngayXuatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(giaNhapLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chiNhanhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        viewDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng xuất"
            }
        ));
        viewDetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewDetailTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(viewDetailTable);

        moveButton.setText("Bỏ sản phẩm");
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(moveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewBookTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = viewBookTable.getSelectedRow();
        if (selectedRow != -1) {
            maSPTextField.setText(viewBookTable.getValueAt(selectedRow, 0).toString());
            tenSPTextField.setText(viewBookTable.getValueAt(selectedRow, 1).toString());
        }
    }

    private void soLuongTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Lấy giá trị nhập vào
            String input = soLuongTextField.getText().trim();

            // Kiểm tra nếu rỗng
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra có phải là số nguyên không
            int soLuongNhap = Integer.parseInt(input);

            // Kiểm tra mã sách có hợp lệ không
            int maSach;
            try {
                maSach = Integer.parseInt(maSPTextField.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Mã sách không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tìm số lượng tồn kho trong danh sách sách
            int soLuongTonKho = 0;
            boolean timThay = false;
            for (Sach sach : listSach) {
                if (sach.getMaSach() == maSach) {
                    soLuongTonKho = sach.getSoLuongTonKho();
                    timThay = true;
                    break;
                }
            }

            // Nếu không tìm thấy sách, báo lỗi
            if (!timThay) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách có mã: " + maSach, "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra số lượng nhập có hợp lệ không
            if (soLuongNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra nếu số lượng nhập lớn hơn số lượng tồn
            if (soLuongNhap > soLuongTonKho) {
                JOptionPane.showMessageDialog(this, "Số lượng nhập vượt quá số lượng tồn kho (" + soLuongTonKho + ")!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewDetailTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = viewDetailTable.getSelectedRow();
        if (selectedRow != -1) {
            maSPTextField.setText(viewDetailTable.getValueAt(selectedRow, 0).toString());
            tenSPTextField.setText(viewDetailTable.getValueAt(selectedRow, 1).toString());
        }
    }

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = removeAccent(searchTextField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) viewBookTable.getModel();
        model.setRowCount(0);

        for (Sach sach : listSach) {
            if (removeAccent(sach.getTenSach().toLowerCase()).contains(keyword)) {
                model.addRow(new Object[] {
                        sach.getMaSach(),
                        sach.getTenSach(),
                        sach.getSoLuongTonKho()
                });
            }
        }
    }

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy tên nhân viên, chi nhánh từ combobox
        String tenNV = tenNVCombobox.getSelectedItem().toString();
        String chiNhanh = chiNhanhComboBox.getSelectedItem().toString();

        int maNV = -1;

        // Tìm mã nhân viên dựa trên tên
        for (NhanVien nv : listNV) {
            if (nv.getTenNV().equals(tenNV)) {
                maNV = nv.getMaNV();
                break;
            }
        }

        // Tạo đối tượng phiếu xuất
        PhieuXuat phieuXuat = new PhieuXuat(maNV, chiNhanh);

        // Gọi BUS để thêm phiếu xuất
        boolean success = pxBUS.themPhieuXuat(phieuXuat);

        if (success) {
            // Thêm chi tiết phiếu xuất
            for (int i = 0; i < detailModel.getRowCount(); i++) {
                int maPX = Integer.parseInt(maPhieuXuatTextField.getText());
                int maSach = Integer.parseInt(detailModel.getValueAt(i, 0).toString());
                int soLuong = Integer.parseInt(detailModel.getValueAt(i, 2).toString());

                ChiTietPhieuXuat chiTiet = new ChiTietPhieuXuat(maPX, maSach, soLuong);
                pxBUS.themChiTietPhieuXuat(chiTiet);
            }
            JOptionPane.showMessageDialog(this, "Thêm chi tiết phiếu xuất thành công!", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            maPhieuXuatTextField.setText(pxBUS.getIdPhieuXuat());

            // Reset lại giao diện sau khi thêm thành công
            detailModel.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm phiếu xuát thất bại!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void choseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String maSP = maSPTextField.getText().trim();
        String tenSP = tenSPTextField.getText().trim();
        String soLuongStr = soLuongTextField.getText().trim();

        // Kiểm tra đầu vào không rỗng
        if (maSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra số lượng có hợp lệ không
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số hợp lệ!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem mã sản phẩm đã tồn tại chưa
        boolean exists = false;
        for (int i = 0; i < detailModel.getRowCount(); i++) {
            if (detailModel.getValueAt(i, 0).toString().equals(maSP)) { // So sánh mã sản phẩm
                exists = true;
                detailModel.setValueAt(soLuong, i, 2);
                break;
            }
        }

        // Nếu chưa có, thêm vào bảng
        if (!exists) {
            detailModel.addRow(new Object[] { maSP, tenSP, soLuong });
        }
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextFieldActionPerformed(evt);
    }

    private void refershButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextField.setText("");
        maSPTextField.setText("");
        tenSPTextField.setText("");
        soLuongTextField.setText("");
        detailModel.setRowCount(0);
        loadData();
    }

    private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = viewDetailTable.getSelectedRow(); // Lấy hàng đang chọn
        if (selectedRow != -1) { // Kiểm tra có hàng nào được chọn không
            // Xóa hàng khỏi bảng
            detailModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadData() {
        // Xóa dữ liệu cũ trước khi tải dữ liệu mới
        listNV.clear();
        listSach.clear();

        // Lấy dữ liệu mới từ BUS
        listNV = nvBUS.getAllNhanVien();
        listSach = sachBUS.getAllSach();

        // Xóa các mục cũ trong combobox trước khi thêm dữ liệu mới
        tenNVCombobox.removeAllItems();
        for (NhanVien nv : listNV) {
            tenNVCombobox.addItem(nv.getTenNV());
        }

        maPhieuXuatTextField.setText(pxBUS.getIdPhieuXuat());

        bookModel = (DefaultTableModel) viewBookTable.getModel();
        viewBookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookModel.setRowCount(0);

        detailModel = (DefaultTableModel) viewDetailTable.getModel();
        viewDetailTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        detailModel.setRowCount(0);

        detailModel.setRowCount(0);
        bookModel.setRowCount(0); // Xóa dữ liệu cũ
        for (Sach sach : listSach) {
            bookModel.addRow(new Object[] {
                    sach.getMaSach(),
                    sach.getTenSach(),
                    sach.getSoLuongTonKho()
            });
        }

        // Lấy ngày hiện tại và hiển thị
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        ngayXuatLabel.setText(today.format(formatter));
    }

    private String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemPX.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPX.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPX.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPX.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPX().setVisible(true);
            }
        });
    }

    DefaultTableModel detailModel;
    DefaultTableModel bookModel;
    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private SachBUS sachBUS = new SachBUS();
    private List<Sach> listSach = new ArrayList();
    private List<NhanVien> listNV = new ArrayList();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chiNhanhComboBox;
    private javax.swing.JButton choseButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel giaNhapLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel maPNLabel;
    private javax.swing.JTextField maPhieuXuatTextField;
    private javax.swing.JLabel maSPLabel;
    private javax.swing.JTextField maSPTextField;
    private javax.swing.JButton moveButton;
    private javax.swing.JTextField ngayXuatLabel;
    private javax.swing.JLabel nhayXuatLabel;
    private javax.swing.JButton refershButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel soLuongLabel;
    private javax.swing.JTextField soLuongTextField;
    private javax.swing.JComboBox<String> tenNVCombobox;
    private javax.swing.JLabel tenNVLabel;
    private javax.swing.JLabel tenSPLabel;
    private javax.swing.JTextField tenSPTextField;
    private javax.swing.JTable viewBookTable;
    private javax.swing.JTable viewDetailTable;
    // End of variables declaration//GEN-END:variables

}
