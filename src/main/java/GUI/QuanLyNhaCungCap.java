/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCap;
import DTO.NhanVien;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhaCungCap extends javax.swing.JPanel {

    public QuanLyNhaCungCap() {
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
        idNCCLabel = new javax.swing.JLabel();
        idNCCTextField = new javax.swing.JTextField();
        nameNCCLabel = new javax.swing.JLabel();
        nameNCCTextField = new javax.swing.JTextField();
        sdtLabel = new javax.swing.JLabel();
        sdtTextField = new javax.swing.JTextField();
        diaChiLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JLabel();
        diaChiTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        statusCombobox = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(1140, 720));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchLabel.setText("Tìm kiếm");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        viewAllButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewAllButton.setText("Xem tất cả");
        viewAllButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchButton.setText("Tìm kiếm");
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewTable);

        addButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addButton.setText("Thêm");
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(viewAllButton)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        idNCCLabel.setText("Mã nhà cung câp");

        idNCCTextField.setEnabled(false);
        idNCCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNCCTextFieldActionPerformed(evt);
            }
        });

        nameNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameNCCLabel.setText("Tên nhà cung cấp");

        nameNCCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameNCCTextFieldActionPerformed(evt);
            }
        });

        sdtLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sdtLabel.setText("Số điện thoại");

        sdtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtTextFieldActionPerformed(evt);
            }
        });

        diaChiLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diaChiLabel.setText("Địa chỉ");

        statusPanel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        statusPanel.setText("Trạng thái");

        updateButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        updateButton.setText("Cập nhật");
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Chi Tiết Nhà Cung Cấp");

        emailLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        emailLabel.setText("Email");

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hợp tác", "Ngừng hợp tác" }));
        statusCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(diaChiLabel)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(sdtLabel)
                                                .addGap(43, 43, 43)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(statusPanel)
                                                .addComponent(nameNCCLabel))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(diaChiTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(nameNCCTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(sdtTextField)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(statusCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(idNCCLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                    .addComponent(idNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailLabel))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idNCCLabel)
                    .addComponent(idNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameNCCLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sdtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdtLabel))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusPanel)
                    .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaChiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void idNCCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idNCCTextFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idNCCTextFieldActionPerformed

    private void nameNCCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nameNCCTextFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_nameNCCTextFieldActionPerformed

    private void sdtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sdtTextFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_sdtTextFieldActionPerformed

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewAllButtonActionPerformed
        loadData();
    }// GEN-LAST:event_viewAllButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchButtonActionPerformed
        searchTextFieldActionPerformed(evt);
    }// GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchTextFieldActionPerformed
        String keyword = removeAccent(searchTextField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
        model.setRowCount(0);

        for (NhaCungCap ncc : listNCC) {
            if (removeAccent(ncc.getTenNCC().toLowerCase()).contains(keyword) ||
                    removeAccent(ncc.getSdt().toLowerCase()).contains(keyword) ||
                    removeAccent(ncc.getEmail().toLowerCase()).contains(keyword) ||
                    removeAccent(ncc.getDiaChi().toLowerCase()).contains(keyword)) {
                model.addRow(new Object[] {
                        ncc.getMaNCC(),
                        ncc.getTenNCC(),
                        ncc.getSdt(),
                        ncc.getEmail(),
                        ncc.getDiaChi(),
                        ncc.getTrangThai()
                });
            }
        }
    }

    private void viewTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_viewTableMouseClicked
        int selectedRow = viewTable.getSelectedRow();
        if (selectedRow != -1) {
            idNCCTextField.setText(viewTable.getValueAt(selectedRow, 0).toString());
            nameNCCTextField.setText(viewTable.getValueAt(selectedRow, 1).toString());
            sdtTextField.setText(viewTable.getValueAt(selectedRow, 2).toString());
            emailTextField.setText(viewTable.getValueAt(selectedRow, 3).toString());
            diaChiTextField.setText(viewTable.getValueAt(selectedRow, 4).toString());
            statusCombobox.setSelectedItem(viewTable.getValueAt(selectedRow, 5));
        }
    }

    private void statusComboboxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_statusComboboxActionPerformed
        
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
        String idNCC = idNCCTextField.getText().trim();
        String tenNCC = nameNCCTextField.getText().trim();
        String sdt = sdtTextField.getText().trim();
        String diaChi = diaChiTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String trangThai = statusCombobox.getSelectedItem().toString();

        if (idNCC.isEmpty() || tenNCC.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || email.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        NhaCungCap ncc = new NhaCungCap(Integer.parseInt(idNCC), tenNCC, email, sdt, diaChi, trangThai);

        boolean success = nccBUS.capNhatNhaCungCap(ncc);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cập nhật nhà cung cấp thành công!");
            loadData(); // Tải lại bảng dữ liệu
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Lỗi",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        ThemNCC addFrame = new ThemNCC();
        addFrame.setVisible(true);
    }

    private void loadData() {
        listNCC = nccBUS.layDanhSachNhaCungCap();
        DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (NhaCungCap ncc : listNCC) {
            model.addRow(new Object[] {
                    ncc.getMaNCC(),
                    ncc.getTenNCC(),
                    ncc.getSdt(),
                    ncc.getEmail(),
                    ncc.getDiaChi(),
                    ncc.getTrangThai()
            });
        }
    }

    private String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D");
    }

    private List<NhaCungCap> listNCC = new ArrayList();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel diaChiLabel;
    private javax.swing.JTextField diaChiTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel idNCCLabel;
    private javax.swing.JTextField idNCCTextField;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameNCCLabel;
    private javax.swing.JTextField nameNCCTextField;
    private javax.swing.JLabel sdtLabel;
    private javax.swing.JTextField sdtTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JLabel statusPanel;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewAllButton;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
