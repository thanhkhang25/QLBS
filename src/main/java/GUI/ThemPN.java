package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.SachBUS;
import DTO.ChiTietPhieuNhap;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.Sach;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ThemPN extends javax.swing.JFrame {
    public ThemPN() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // Code">//GEN-BEGIN:initComponents
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
        giaNhapLabel = new javax.swing.JLabel();
        giaNhapTextField = new javax.swing.JTextField();
        soLuongTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        maPNLabel = new javax.swing.JLabel();
        maPhieuNhapTextField = new javax.swing.JTextField();
        tenNVLabel = new javax.swing.JLabel();
        NCCLabel = new javax.swing.JLabel();
        nhayNhapLabel = new javax.swing.JLabel();
        tongTienLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tongTienTextField = new javax.swing.JTextField();
        importButton = new javax.swing.JButton();
        NCCCombobox = new javax.swing.JComboBox<>();
        tenNVCombobox = new javax.swing.JComboBox<>();
        ngayNhapLabel = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        viewDetailTable = new javax.swing.JTable();
        moveButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
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
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Mã sách", "Tên sách", "Số lượng tồn", "Giá nhập"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(refershButton)
                                        .addComponent(searchButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        maSPLabel.setText("Mã sản phẩm");

        maSPTextField.setEditable(false);

        tenSPLabel.setText("Tên sản phẩm");

        tenSPTextField.setEditable(false);

        soLuongLabel.setText("Số lượng nhập");

        choseButton.setText("Chọn sản phẩm");
        choseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choseButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Thông tin chi tiết");

        giaNhapLabel.setText("Giá Nhập");

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
                                        .addComponent(soLuongTextField)
                                        .addComponent(giaNhapTextField)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout
                                                .createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                .addComponent(tenSPTextField,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(maSPLabel,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(tenSPLabel,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(maSPTextField,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(choseButton,
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 185,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(jLabel4)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(soLuongLabel)
                                                        .addComponent(giaNhapLabel))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maSPLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenSPLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soLuongLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soLuongTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(giaNhapLabel)
                                .addGap(4, 4, 4)
                                .addComponent(giaNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choseButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        maPNLabel.setText("Mã phiếu nhập");

        maPhieuNhapTextField.setEditable(false);

        tenNVLabel.setText("Nhân viên nhập");

        NCCLabel.setText("Nhà cung cấp");

        nhayNhapLabel.setText("Ngày nhập");

        tongTienLabel.setText("Tổng tiền");

        jLabel10.setText("VND");

        tongTienTextField.setEditable(false);

        importButton.setText("Nhập hàng");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        ngayNhapLabel.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(maPNLabel)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(tongTienLabel)))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(maPhieuNhapTextField)
                                        .addComponent(NCCCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel4Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel4Layout.createSequentialGroup()
                                                                        .addComponent(tongTienTextField,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                127, Short.MAX_VALUE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel10))
                                                        .addComponent(importButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tenNVLabel)
                                                        .addComponent(NCCLabel)
                                                        .addComponent(nhayNhapLabel)
                                                        .addComponent(tenNVCombobox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(ngayNhapLabel))
                                .addContainerGap()));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maPNLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maPhieuNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tenNVLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenNVCombobox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NCCLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NCCCombobox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nhayNhapLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ngayNhapLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tongTienLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tongTienTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        viewDetailTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Mã sách", "Tên sách", "Số lượng nhập", "Giá nhập"
                }));
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
                                        .addComponent(moveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 543,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 543,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(moveButton)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewBookTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = viewBookTable.getSelectedRow();
        if (selectedRow != -1) {
            maSPTextField.setText(viewBookTable.getValueAt(selectedRow, 0).toString());
            tenSPTextField.setText(viewBookTable.getValueAt(selectedRow, 1).toString());
            giaNhapTextField.setText(viewBookTable.getValueAt(selectedRow, 3).toString());
        }
    }

    private void soLuongTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void viewDetailTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = viewDetailTable.getSelectedRow();
        if (selectedRow != -1) {
            maSPTextField.setText(viewDetailTable.getValueAt(selectedRow, 0).toString());
            tenSPTextField.setText(viewDetailTable.getValueAt(selectedRow, 1).toString());
            soLuongTextField.setText(viewDetailTable.getValueAt(selectedRow, 2).toString());
            giaNhapTextField.setText(viewDetailTable.getValueAt(selectedRow, 3).toString());
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
                        sach.getSoLuongTonKho(),
                        sach.getGiaNhap()
                });
            }
        }
    }

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Lấy tên nhân viên và nhà cung cấp từ combobox
        String tenNV = tenNVCombobox.getSelectedItem().toString();
        String tenNCC = NCCCombobox.getSelectedItem().toString();

        int maNV = -1;
        int maNCC = -1;

        // Tìm mã nhân viên dựa trên tên
        for (NhanVien nv : listNV) {
            if (nv.getTenNV().equals(tenNV)) {
                maNV = nv.getMaNV();
                break;
            }
        }

        // Tìm mã nhà cung cấp dựa trên tên
        for (NhaCungCap ncc : listNCC) {
            if (ncc.getTenNCC().equals(tenNCC)) {
                maNCC = ncc.getMaNCC();
                break;
            }
        }

        double tongTien = Double.parseDouble(tongTienTextField.getText());

        // Tạo đối tượng phiếu nhập
        PhieuNhap phieuNhap = new PhieuNhap(maNV, maNCC, tongTien);

        // Gọi BUS để thêm phiếu nhập
        boolean success = pnBUS.insertPhieuNhap(phieuNhap);

        if (success) {
            // Thêm chi tiết phiếu nhập
            for (int i = 0; i < detailModel.getRowCount(); i++) {
                String tenSach = detailModel.getValueAt(i, 1).toString();
                int maSach = -1;
                int soLuong = Integer.parseInt(detailModel.getValueAt(i, 2).toString());
                double giaNhap = Double.parseDouble(detailModel.getValueAt(i, 3).toString());

                // Tìm mã sách từ listBook
                for (Sach s : listSach) {
                    if (s.getTenSach().equals(tenSach)) {
                        maSach = s.getMaSach();
                        break;
                    }
                }
                ChiTietPhieuNhap chiTiet = new ChiTietPhieuNhap(Integer.parseInt(maPhieuNhapTextField.getText()), maSach, soLuong, giaNhap);
                pnBUS.themChiTietPhieuNhap(chiTiet);
            }
            JOptionPane.showMessageDialog(this, "Thêm chi tiết phiếu nhập thành công!" , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            maPhieuNhapTextField.setText(pnBUS.getIdPhieuNhap());

            // Reset lại giao diện sau khi thêm thành công
            tongTienTextField.setText("0");
            detailModel.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void choseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String maSP = maSPTextField.getText().trim();
        String tenSP = tenSPTextField.getText().trim();
        String soLuongStr = soLuongTextField.getText().trim();
        String giaNhapStr = giaNhapTextField.getText().trim();

        // Kiểm tra đầu vào không rỗng
        if (maSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra số lượng và giá nhập có hợp lệ không
        int soLuong;
        double giaNhap;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            giaNhap = Double.parseDouble(giaNhapStr);
            if (soLuong <= 0 || giaNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng và giá nhập phải lớn hơn 0!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá nhập phải là số hợp lệ!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem mã sản phẩm đã tồn tại chưa
        boolean exists = false;
        for (int i = 0; i < detailModel.getRowCount(); i++) {
            if (detailModel.getValueAt(i, 0).toString().equals(maSP)) { // So sánh mã sản phẩm
                exists = true;

                detailModel.setValueAt(soLuong, i, 2);

                double giaNhapCu = Double.parseDouble(detailModel.getValueAt(i, 3).toString());
                // Nếu giá mới khác giá cũ thì cập nhật giá mới
                if (giaNhap != giaNhapCu) {
                    detailModel.setValueAt(giaNhap, i, 3);
                }
                break;
            }
        }

        // Nếu chưa có, thêm vào bảng
        if (!exists) {
            detailModel.addRow(new Object[] { maSP, tenSP, soLuong, giaNhap });
        }

        // Cập nhật tổng tiền
        double tongTienHienTai = 0.0;
        try {
            tongTienHienTai = Double.parseDouble(tongTienTextField.getText().trim());
        } catch (NumberFormatException e) {
            tongTienHienTai = 0.0; // Nếu rỗng hoặc lỗi, đặt về 0
        }

        double tongTienMoi = 0.0;
        for (int i = 0; i < detailModel.getRowCount(); i++) {
            int sl = Integer.parseInt(detailModel.getValueAt(i, 2).toString());
            double gia = Double.parseDouble(detailModel.getValueAt(i, 3).toString());
            tongTienMoi += sl * gia;
        }

        tongTienTextField.setText(String.valueOf(tongTienMoi));
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextFieldActionPerformed(evt);
    }

    private void refershButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextField.setText("");
        maSPTextField.setText("");
        tenSPTextField.setText("");
        soLuongTextField.setText("");
        giaNhapTextField.setText("");
        tongTienTextField.setText("");
        detailModel.setRowCount(0);
        loadData();
    }

    private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = viewDetailTable.getSelectedRow(); // Lấy hàng đang chọn

        if (selectedRow != -1) { // Kiểm tra có hàng nào được chọn không
            // Lấy giá trị số lượng và giá nhập từ hàng đang chọn
            int soLuong = Integer.parseInt(viewDetailTable.getValueAt(selectedRow, 2).toString());
            double giaNhap = Double.parseDouble(viewDetailTable.getValueAt(selectedRow, 3).toString());

            // Cập nhật tổng tiền sau khi xóa
            double tongTienHienTai = Double.parseDouble(tongTienTextField.getText().trim());
            double tongTienMoi = tongTienHienTai - (soLuong * giaNhap);
            tongTienTextField.setText(String.valueOf(tongTienMoi));

            // Xóa hàng khỏi bảng
            detailModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadData() {
        // Xóa dữ liệu cũ trước khi tải dữ liệu mới
        listNCC.clear();
        listNV.clear();
        listSach.clear();
        
        // Lấy dữ liệu mới từ BUS
        listNCC = nccBUS.layDanhSachNhaCungCap();
        listNV = nvBUS.getAllNhanVien();
        listSach = sachBUS.getAllSach();

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
                    sach.getSoLuongTonKho(),
                    sach.getGiaNhap()
            });
        }

        // Lấy ngày hiện tại và hiển thị
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        ngayNhapLabel.setText(today.format(formatter));

        maPhieuNhapTextField.setText(pnBUS.getIdPhieuNhap());

        // Xóa các mục cũ trong combobox trước khi thêm dữ liệu mới
        NCCCombobox.removeAllItems();
        tenNVCombobox.removeAllItems();
        for (NhaCungCap ncc : listNCC) {
            NCCCombobox.addItem(ncc.getTenNCC());
        }
        for (NhanVien nv : listNV) {
            tenNVCombobox.addItem(nv.getTenNV());
        }
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
            java.util.logging.Logger.getLogger(ThemPN.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPN.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPN.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPN.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPN().setVisible(true);
            }
        });
    }
    
    
    DefaultTableModel detailModel;
    DefaultTableModel bookModel;
    private PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private SachBUS sachBUS = new SachBUS();
    private List<Sach> listSach = new ArrayList();
    private List<NhaCungCap> listNCC = new ArrayList();
    private List<NhanVien> listNV = new ArrayList();  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> NCCCombobox;
    private javax.swing.JLabel NCCLabel;
    private javax.swing.JButton choseButton;
    private javax.swing.JLabel giaNhapLabel;
    private javax.swing.JTextField giaNhapTextField;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField maPhieuNhapTextField;
    private javax.swing.JLabel maSPLabel;
    private javax.swing.JTextField maSPTextField;
    private javax.swing.JButton moveButton;
    private javax.swing.JTextField ngayNhapLabel;
    private javax.swing.JLabel nhayNhapLabel;
    private javax.swing.JButton refershButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel soLuongLabel;
    private javax.swing.JTextField soLuongTextField;
    private javax.swing.JComboBox<String> tenNVCombobox;
    private javax.swing.JLabel tenNVLabel;
    private javax.swing.JLabel tenSPLabel;
    private javax.swing.JTextField tenSPTextField;
    private javax.swing.JLabel tongTienLabel;
    private javax.swing.JTextField tongTienTextField;
    private javax.swing.JTable viewBookTable;
    private javax.swing.JTable viewDetailTable;
    // End of variables declaration//GEN-END:variables

}
