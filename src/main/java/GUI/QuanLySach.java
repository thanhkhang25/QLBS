/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.SachBUS;
import DTO.Sach;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class QuanLySach extends javax.swing.JPanel {
    public QuanLySach() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        viewAllButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        maSachLabel = new javax.swing.JLabel();
        maSachTextField = new javax.swing.JTextField();
        tenSachLabel = new javax.swing.JLabel();
        tacGiaLabel = new javax.swing.JLabel();
        tacGiaTextField = new javax.swing.JTextField();
        theLoaiLabel = new javax.swing.JLabel();
        theLoaiTextField = new javax.swing.JTextField();
        chiNhanhLabel = new javax.swing.JLabel();
        tenSachTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        trangThaiLabel = new javax.swing.JLabel();
        chiNhanhCombobox = new javax.swing.JComboBox<>();
        trangThaiComBoBox = new javax.swing.JComboBox<>();
        giaBanLabel = new javax.swing.JLabel();
        giaNhapLabel = new javax.swing.JLabel();
        giaDaGiamLabel = new javax.swing.JLabel();
        soLuongTonKhoLabel = new javax.swing.JLabel();
        giaBanTextField = new javax.swing.JTextField();
        giaDaGiamTextField = new javax.swing.JTextField();
        giaNhapTextField = new javax.swing.JTextField();
        soLuongTonKhoTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(135, 206, 235));
        setPreferredSize(new java.awt.Dimension(1140, 720));

        jPanel1.setBackground(new java.awt.Color(135, 206, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(0, 71, 171));
        searchLabel.setText("Tìm kiếm");
        searchLabel.setPreferredSize(new java.awt.Dimension(60, 30));

        searchTextField.setBackground(new java.awt.Color(237, 242, 251));
        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        viewAllButton.setBackground(new java.awt.Color(0, 100, 168));
        viewAllButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewAllButton.setForeground(new java.awt.Color(237, 242, 251));
        viewAllButton.setText("Xem tất cả");
        viewAllButton.setToolTipText("");
        viewAllButton.setAutoscrolls(true);
        viewAllButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllButton.setPreferredSize(new java.awt.Dimension(95, 30));
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 100, 168));
        searchButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(237, 242, 251));
        searchButton.setText("Tìm kiếm");
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.setPreferredSize(new java.awt.Dimension(85, 30));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        viewTable.setBackground(new java.awt.Color(237, 242, 251));
        viewTable.setForeground(new java.awt.Color(0, 71, 171));
        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Giá Bán", "Giá đã Giảm", "Giá Nhập", "Số lượng", "Chi Nhánh", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewTable.setGridColor(new java.awt.Color(0, 71, 171));
        viewTable.setSelectionBackground(new java.awt.Color(80, 171, 231));
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewTable);
        viewTable.getAccessibleContext().setAccessibleName("");

        addButton.setBackground(new java.awt.Color(0, 100, 168));
        addButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(237, 242, 251));
        addButton.setText("Thêm");
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );

        addButton.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBackground(new java.awt.Color(135, 206, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        maSachLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        maSachLabel.setForeground(new java.awt.Color(0, 71, 171));
        maSachLabel.setText("Mã Sách");

        maSachTextField.setBackground(new java.awt.Color(237, 242, 251));
        maSachTextField.setEnabled(false);
        maSachTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSachTextFieldActionPerformed(evt);
            }
        });

        tenSachLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tenSachLabel.setForeground(new java.awt.Color(0, 71, 171));
        tenSachLabel.setText("Tên Sách");

        tacGiaLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tacGiaLabel.setForeground(new java.awt.Color(0, 71, 171));
        tacGiaLabel.setText("Tác Giả");

        tacGiaTextField.setBackground(new java.awt.Color(237, 242, 251));
        tacGiaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tacGiaTextFieldActionPerformed(evt);
            }
        });

        theLoaiLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        theLoaiLabel.setForeground(new java.awt.Color(0, 71, 171));
        theLoaiLabel.setText("Thể Loại");

        theLoaiTextField.setBackground(new java.awt.Color(237, 242, 251));

        chiNhanhLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chiNhanhLabel.setForeground(new java.awt.Color(0, 71, 171));
        chiNhanhLabel.setText("Chi nhánh");

        tenSachTextField.setBackground(new java.awt.Color(237, 242, 251));

        updateButton.setBackground(new java.awt.Color(0, 100, 168));
        updateButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(237, 242, 251));
        updateButton.setText("Cập nhật");
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        trangThaiLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        trangThaiLabel.setForeground(new java.awt.Color(0, 71, 171));
        trangThaiLabel.setText("Trạng Thái");

        chiNhanhCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hồ Chí Minh" }));

        trangThaiComBoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng", "Ngừng bán" }));

        giaBanLabel.setText("Giá bán");

        giaNhapLabel.setText("giaNhap");

        giaDaGiamLabel.setText("Giá đã giảm");

        soLuongTonKhoLabel.setText("Số lượng tồn kho");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chiNhanhLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(maSachLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tacGiaLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maSachTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(tacGiaTextField)
                    .addComponent(theLoaiTextField)
                    .addComponent(tenSachTextField)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(trangThaiComBoBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chiNhanhCombobox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(giaBanTextField)
                    .addComponent(giaDaGiamTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(giaNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaDaGiamLabel)
                    .addComponent(tenSachLabel)
                    .addComponent(theLoaiLabel)
                    .addComponent(trangThaiLabel)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(giaBanLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soLuongTonKhoLabel)
                            .addComponent(giaNhapLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soLuongTonKhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maSachLabel)
                    .addComponent(maSachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenSachLabel)
                    .addComponent(tenSachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(theLoaiLabel)
                    .addComponent(theLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tacGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tacGiaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chiNhanhLabel)
                    .addComponent(chiNhanhCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trangThaiLabel)
                    .addComponent(trangThaiComBoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaBanLabel)
                    .addComponent(giaBanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giaDaGiamLabel)
                    .addComponent(giaDaGiamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giaNhapLabel)
                    .addComponent(giaNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soLuongTonKhoLabel)
                    .addComponent(soLuongTonKhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maSachTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSachTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSachTextFieldActionPerformed

    private void tacGiaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tacGiaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tacGiaTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ThemSach addFrame = new ThemSach();
        addFrame.setVisible(true);      
    }//GEN-LAST:event_addButtonActionPerformed

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_addButtonMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String idSach = maSachTextField.getText().trim();
        String tenSach = tenSachTextField.getText().trim();
        String theLoai = theLoaiTextField.getText().trim();
        String tacGia = tacGiaTextField.getText().trim();
        String giaBan = giaBanTextField.getText().trim();
        String giaDaGiam = giaDaGiamTextField.getText().trim();
        String giaNhap = giaNhapTextField.getText().trim();
        String chiNhanh = chiNhanhCombobox.getSelectedItem().toString();
        String trangThai = trangThaiComBoBox.getSelectedItem().toString();

        if (idSach.isEmpty() || tenSach.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sach sach = new Sach(Integer.parseInt(idSach), tenSach, theLoai, tacGia, Double.parseDouble(giaBan), Double.parseDouble(giaNhap), chiNhanh, trangThai);

        boolean success = sachBUS.updateSach(sach);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cập nhật thông tin sách thành công!");
            loadData(); // Tải lại bảng dữ liệu
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Lỗi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        String keyword = removeAccent(searchTextField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
        model.setRowCount(0);

        for (Sach sach : listBook) {
            if (removeAccent(sach.getTenSach().toLowerCase()).contains(keyword) ||
                    removeAccent(sach.getTacGia().toLowerCase()).contains(keyword) ||
                    removeAccent(sach.getTheLoai().toLowerCase()).contains(keyword) ||
                    removeAccent(sach.getChiNhanh().toLowerCase()).contains(keyword) ||
                    removeAccent(sach.getTrangThai().toLowerCase()).contains(keyword)) {
                    model.addRow(new Object[] {
                        sach.getMaSach(),
                        sach.getTenSach(),
                        sach.getTheLoai(),
                        sach.getTacGia(),
                        sach.getGiaBan(),
                        sach.getGiaDaGiam(),
                        sach.getGiaNhap(),
                        sach.getSoLuongTonKho(),
                        sach.getChiNhanh(),
                        sach.getTrangThai()
                    });
            }
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchTextFieldActionPerformed(evt);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void viewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTableMouseClicked
        int selectedRow = viewTable.getSelectedRow();
        if (selectedRow != -1) {
            maSachTextField.setText(viewTable.getValueAt(selectedRow, 0).toString());
            tenSachTextField.setText(viewTable.getValueAt(selectedRow, 1).toString());
            theLoaiTextField.setText(viewTable.getValueAt(selectedRow, 2).toString());
            tacGiaTextField.setText(viewTable.getValueAt(selectedRow, 3).toString());
            giaBanTextField.setText(viewTable.getValueAt(selectedRow, 4).toString());
            giaDaGiamTextField.setText(viewTable.getValueAt(selectedRow, 5).toString());
            giaNhapTextField.setText(viewTable.getValueAt(selectedRow, 6).toString());
            soLuongTonKhoTextField.setText(viewTable.getValueAt(selectedRow, 7).toString());
            chiNhanhCombobox.setSelectedItem(viewTable.getValueAt(selectedRow, 8));
            trangThaiComBoBox.setSelectedItem(viewTable.getValueAt(selectedRow, 9));
        }
    }//GEN-LAST:event_viewTableMouseClicked

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllButtonActionPerformed
        loadData();
    }//GEN-LAST:event_viewAllButtonActionPerformed
    
    private void loadData() {
        listBook = sachBUS.getAllSach();
        DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (Sach sach : listBook) {
            model.addRow(new Object[] {
                    sach.getMaSach(),
                    sach.getTenSach(),
                    sach.getTheLoai(),
                    sach.getTacGia(),
                    sach.getGiaBan(),
                    sach.getGiaDaGiam(),
                    sach.getGiaNhap(),
                    sach.getSoLuongTonKho(),
                    sach.getChiNhanh(),
                    sach.getTrangThai()
            });
        }
    }

    private String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D");
    }
    
    private List<Sach> listBook = new ArrayList();
    private SachBUS sachBUS = new SachBUS();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> chiNhanhCombobox;
    private javax.swing.JLabel chiNhanhLabel;
    private javax.swing.JLabel giaBanLabel;
    private javax.swing.JTextField giaBanTextField;
    private javax.swing.JLabel giaDaGiamLabel;
    private javax.swing.JTextField giaDaGiamTextField;
    private javax.swing.JLabel giaNhapLabel;
    private javax.swing.JTextField giaNhapTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maSachLabel;
    private javax.swing.JTextField maSachTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel soLuongTonKhoLabel;
    private javax.swing.JTextField soLuongTonKhoTextField;
    private javax.swing.JLabel tacGiaLabel;
    private javax.swing.JTextField tacGiaTextField;
    private javax.swing.JLabel tenSachLabel;
    private javax.swing.JTextField tenSachTextField;
    private javax.swing.JLabel theLoaiLabel;
    private javax.swing.JTextField theLoaiTextField;
    private javax.swing.JComboBox<String> trangThaiComBoBox;
    private javax.swing.JLabel trangThaiLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewAllButton;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables

}