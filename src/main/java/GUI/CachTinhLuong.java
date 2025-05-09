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
import DTO.HeSoLuong;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CachTinhLuong extends javax.swing.JPanel {

    /**
     * Creates new form CachTinhLuong
     */
    private DefaultTableModel tableModel;
    private HeSoLuongBUS hslBUS;

    public CachTinhLuong() {
        initComponents();
        hslBUS = new HeSoLuongBUS();
        initTable();
        loadDataCachTinhLuong();

        // Khi người dùng chọn một dòng trên bảng, hiển thị chi tiết vào các ô TextField
        tblCachTinhLuong.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblCachTinhLuong.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaHSL.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtLuongCoBan.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    txtPhuCapXangXe.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    txtBHYT.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    txtBHXH.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    txtBHTN.setText(tableModel.getValueAt(selectedRow, 5).toString());
                }
            }
        });
    }

    // Khởi tạo TableModel với các cột tương ứng
    private void initTable() {
        String[] columnNames = {"Mã hệ số lương", "Lương cơ bản", "Phụ cấp xăng xe", "Bảo hiểm y tế", "Bảo hiểm xã hội", "Bảo hiểm thất nghiệp"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblCachTinhLuong.setModel(tableModel);
    }

    // Load dữ liệu từ BUS và đổ vào bảng
    private void loadDataCachTinhLuong() {
        tableModel.setRowCount(0);
        List<HeSoLuong> list = hslBUS.getAllHeSoLuong();
        for (HeSoLuong hsl : list) {
            Object[] row = {
                hsl.getMaHeSoLuong(),
                hsl.getLuongCoBan(),
                hsl.getPhuCapXang(),
                hsl.getPhuCapBHYT(),
                hsl.getPhuCapBHXH(),
                hsl.getPhuCapBHTN()
            };
            tableModel.addRow(row);
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

        scrCachTinhLuong = new javax.swing.JScrollPane();
        tblCachTinhLuong = new javax.swing.JTable();
        pnlCachTinhLuong = new javax.swing.JPanel();
        lblLuongCoBan = new javax.swing.JLabel();
        lblPhuCapXangXe = new javax.swing.JLabel();
        lblBHXH = new javax.swing.JLabel();
        lblBHYT = new javax.swing.JLabel();
        lblBHTN = new javax.swing.JLabel();
        txtBHTN = new javax.swing.JTextField();
        txtLuongCoBan = new javax.swing.JTextField();
        txtPhuCapXangXe = new javax.swing.JTextField();
        txtBHYT = new javax.swing.JTextField();
        txtBHXH = new javax.swing.JTextField();
        lblCongThucTinhLuong = new javax.swing.JLabel();
        lblLuuY = new javax.swing.JLabel();
        lblNgayNghi = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        lblMaHSL = new javax.swing.JLabel();
        txtMaHSL = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXemTatCa = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblCachTinhLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hệ số lương", "Lương cơ bản", "Phụ cấp xăng xe", "Bảo hiểm y tế", "Bảo hiểm xã hội", "Bảo hiểm thất nghiệp"
            }
        ));
        scrCachTinhLuong.setViewportView(tblCachTinhLuong);

        lblLuongCoBan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLuongCoBan.setText("Lương Cơ Bản");

        lblPhuCapXangXe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPhuCapXangXe.setText("Phụ cấp xăng xe");

        lblBHXH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHXH.setText("Bảo Hiểm Xã Hội (8%)");

        lblBHYT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHYT.setText("Bảo Hiểm Y Tế (1.5%)");

        lblBHTN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHTN.setText("Bảo Hiểm Thất Nghiệp (1%)");

        txtPhuCapXangXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhuCapXangXeActionPerformed(evt);
            }
        });

        lblCongThucTinhLuong.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblCongThucTinhLuong.setText("Công Thức Tính Lương: Lương Thực Nhận = (Lương cơ bản/26) * số ngày làm thực tế + phụ cấp xăng xe +thưởng + chuyên cần - BHXH - BHYT -BHTN");

        lblLuuY.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblLuuY.setText("Lưu ý: Chuyên cần chỉ có khi nhân viên làm đủ 26/tháng ");

        lblNgayNghi.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblNgayNghi.setText("Nhân viên có 12 ngày nghỉ phép không bị trừ lương / năm");

        lblMaHSL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMaHSL.setText("Mã hệ số lương");

        txtMaHSL.setEditable(false);
        txtMaHSL.setFocusable(false);

        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCachTinhLuongLayout = new javax.swing.GroupLayout(pnlCachTinhLuong);
        pnlCachTinhLuong.setLayout(pnlCachTinhLuongLayout);
        pnlCachTinhLuongLayout.setHorizontalGroup(
            pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCachTinhLuongLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblLuuY))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCachTinhLuongLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbl))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCachTinhLuongLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(lblNgayNghi))
                        .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPhuCapXangXe)
                                .addComponent(lblLuongCoBan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMaHSL, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMaHSL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(101, 101, 101)
                            .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCachTinhLuongLayout.createSequentialGroup()
                                    .addComponent(lblBHXH)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBHYT)
                                    .addComponent(lblBHTN)))
                            .addGap(18, 18, 18)
                            .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBHXH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBHTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBHYT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(59, 59, 59))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCachTinhLuongLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblCongThucTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCachTinhLuongLayout.setVerticalGroup(
            pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBHXH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBHYT))
                        .addGap(6, 6, 6)
                        .addComponent(txtBHTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBHTN)
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaHSL)
                            .addComponent(txtMaHSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLuongCoBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhuCapXangXe))))
                .addGap(25, 25, 25)
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCongThucTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLuuY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgayNghi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lblTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTimKiem.setText("Tìm Kiếm ");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnXemTatCa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemTatCa.setText("Xem tất cả");
        btnXemTatCa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXemTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrCachTinhLuong)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXemTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCachTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnXemTatCa)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrCachTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(pnlCachTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        ThemHSL n = new ThemHSL();
        n.setVisible(true);
        if (n.isAdded()) {  
            loadDataCachTinhLuong();
        }
        loadDataCachTinhLuong();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCachTinhLuong.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hệ số lương cần cập nhật!");
            return;
        }

        try {
            // Lấy giá trị từ các ô nhập liệu
            String maHeSoLuong = txtMaHSL.getText().trim();
            double luongCoBan = Double.parseDouble(txtLuongCoBan.getText().trim());
            double phuCapXang = Double.parseDouble(txtPhuCapXangXe.getText().trim());
            double phuCapBHYT = Double.parseDouble(txtBHYT.getText().trim());
            double phuCapBHXH = Double.parseDouble(txtBHXH.getText().trim());
            double phuCapBHTN = Double.parseDouble(txtBHTN.getText().trim());
            BUS.HeSoLuongBUS hslBUS = new BUS.HeSoLuongBUS();
            // Kiểm tra đầu vào hợp lệ
            if (maHeSoLuong.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã hệ số lương không được để trống!");
                return;
            }
            if (luongCoBan <= 0) {
                JOptionPane.showMessageDialog(this, "Lương cơ bản phải lớn hơn 0!");
                return;
            }

                        // Lấy dữ liệu hiện tại từ bảng (để kiểm tra thay đổi)
             String currentMaHSL = tblCachTinhLuong.getValueAt(selectedRow, 0).toString();
             double currentLuongCoBan = Double.parseDouble(tblCachTinhLuong.getValueAt(selectedRow, 1).toString());
             double currentPhuCapXang = Double.parseDouble(tblCachTinhLuong.getValueAt(selectedRow, 2).toString());
             double currentPhuCapBHYT = Double.parseDouble(tblCachTinhLuong.getValueAt(selectedRow, 3).toString());
             double currentPhuCapBHXH = Double.parseDouble(tblCachTinhLuong.getValueAt(selectedRow, 4).toString());
             double currentPhuCapBHTN = Double.parseDouble(tblCachTinhLuong.getValueAt(selectedRow, 5).toString());

                        // Kiểm tra nếu không có thay đổi
            if (maHeSoLuong.equals(currentMaHSL)
                    && luongCoBan == currentLuongCoBan
                    && phuCapXang == currentPhuCapXang
                    && phuCapBHYT == currentPhuCapBHYT
                    && phuCapBHXH == currentPhuCapBHXH
                    && phuCapBHTN == currentPhuCapBHTN) {
                JOptionPane.showMessageDialog(this, "Bạn chưa thay đổi gì.");
                return;
            }

            // Tạo đối tượng HeSoLuong
            HeSoLuong hsl = new HeSoLuong(maHeSoLuong, luongCoBan, phuCapXang, phuCapBHYT, phuCapBHXH, phuCapBHTN);

            // Cập nhật hệ số lương
            boolean updated = hslBUS.updateHeSoLuong(hsl);
            if (updated) {
                JOptionPane.showMessageDialog(this, "Cập nhật hệ số lương thành công!");
                loadDataCachTinhLuong(); // Cập nhật lại bảng
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại. Kiểm tra lại dữ liệu.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtPhuCapXangXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhuCapXangXeActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String keyword = txtTimKiem.getText().trim();

        // Kiểm tra nếu từ khóa trống, load toàn bộ dữ liệu
        List<HeSoLuong> list;
        if (keyword.isEmpty()) {
            list = hslBUS.getAllHeSoLuong(); // Hiển thị tất cả nếu không có từ khóa
        } else {
            list = hslBUS.searchHeSoLuongByMa(keyword); // Tìm kiếm theo mã hệ số lương (String)
        }

        // Xóa dữ liệu cũ trên bảng
        tableModel.setRowCount(0);

        // Hiển thị kết quả tìm kiếm lên bảng
        for (HeSoLuong hsl : list) {
            Object[] row = {
                hsl.getMaHeSoLuong(),
                hsl.getLuongCoBan(),
                hsl.getPhuCapXang(),
                hsl.getPhuCapBHYT(),
                hsl.getPhuCapBHXH(),
                hsl.getPhuCapBHTN()
            };
            tableModel.addRow(row);
        }

        // Hiển thị thông báo nếu không tìm thấy kết quả
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hệ số lương nào!");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXemTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTatCaActionPerformed
        // TODO add your handling code here:
        loadDataCachTinhLuong();
    }//GEN-LAST:event_btnXemTatCaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
                // Kiểm tra xem đã chọn dòng cần xóa chưa
        int selectedRow = tblCachTinhLuong.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hệ số lương cần xóa!");
            return;
        }

        // Xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hệ số lương này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Giả sử cột 0 của bảng là mã hệ số lương (kiểu String)
            String maHSL = tblCachTinhLuong.getValueAt(selectedRow, 0).toString();

            // Gọi BUS để xóa hệ số lương
            BUS.HeSoLuongBUS hslBUS = new BUS.HeSoLuongBUS();
            boolean success = hslBUS.deleteHeSoLuong(maHSL);

            if (success) {
                JOptionPane.showMessageDialog(this, "Xóa hệ số lương thành công!");
                // Cập nhật lại bảng dữ liệu
                loadDataCachTinhLuong();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hệ số lương thất bại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblBHTN;
    private javax.swing.JLabel lblBHXH;
    private javax.swing.JLabel lblBHYT;
    private javax.swing.JLabel lblCongThucTinhLuong;
    private javax.swing.JLabel lblLuongCoBan;
    private javax.swing.JLabel lblLuuY;
    private javax.swing.JLabel lblMaHSL;
    private javax.swing.JLabel lblNgayNghi;
    private javax.swing.JLabel lblPhuCapXangXe;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlCachTinhLuong;
    private javax.swing.JScrollPane scrCachTinhLuong;
    private javax.swing.JTable tblCachTinhLuong;
    private javax.swing.JTextField txtBHTN;
    private javax.swing.JTextField txtBHXH;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtMaHSL;
    private javax.swing.JTextField txtPhuCapXangXe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
