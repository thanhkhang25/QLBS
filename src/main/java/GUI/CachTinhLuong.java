/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author LENOVO
 */
public class CachTinhLuong extends javax.swing.JPanel {

    /**
     * Creates new form CachTinhLuong
     */
    public CachTinhLuong() {
        initComponents();
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
        lblChuyenCan = new javax.swing.JLabel();
        lblThuong = new javax.swing.JLabel();
        lblBHXH = new javax.swing.JLabel();
        lblBHYT = new javax.swing.JLabel();
        lblBHTN = new javax.swing.JLabel();
        txtChuyenCan = new javax.swing.JTextField();
        txtBHTN = new javax.swing.JTextField();
        txtThuong = new javax.swing.JTextField();
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
        btnHuy = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXemTatCa = new javax.swing.JButton();
        btnDanhSachHuy = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblCachTinhLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hệ số lương", "Lương cơ bản", "Phụ cấp xăng xe", "Thưởng", "Chuyên cần", "Bảo hiểm y tế", "Bảo hiểm xã hội", "Bảo hiểm thất nghiệp"
            }
        ));
        scrCachTinhLuong.setViewportView(tblCachTinhLuong);

        lblLuongCoBan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblLuongCoBan.setText("Lương Cơ Bản");

        lblPhuCapXangXe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPhuCapXangXe.setText("Phụ cấp xăng xe");

        lblChuyenCan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblChuyenCan.setText("Chuyên Cần");

        lblThuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblThuong.setText("Thưởng");

        lblBHXH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHXH.setText("Bảo Hiểm Xã Hội (8%)");

        lblBHYT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHYT.setText("Bảo Hiểm Y Tế (1.5%)");

        lblBHTN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBHTN.setText("Bảo Hiểm Thất Nghiệp (1%)");

        txtChuyenCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChuyenCanActionPerformed(evt);
            }
        });

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

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCachTinhLuongLayout = new javax.swing.GroupLayout(pnlCachTinhLuong);
        pnlCachTinhLuong.setLayout(pnlCachTinhLuongLayout);
        pnlCachTinhLuongLayout.setHorizontalGroup(
            pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCachTinhLuongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCongThucTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMaHSL)
                            .addComponent(lblPhuCapXangXe)
                            .addComponent(lblLuongCoBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                                .addComponent(txtMaHSL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(lblChuyenCan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChuyenCan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblBHXH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(txtBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                                        .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(lblThuong)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                                        .addComponent(txtThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblBHYT)
                                        .addGap(45, 45, 45)
                                        .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCachTinhLuongLayout.createSequentialGroup()
                                        .addComponent(lblBHTN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBHTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCachTinhLuongLayout.setVerticalGroup(
            pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMaHSL)
                        .addComponent(txtMaHSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtChuyenCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblChuyenCan))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBHXH)
                        .addComponent(txtBHXH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBHYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBHYT))
                    .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLuongCoBan)
                        .addComponent(lblThuong)))
                .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBHTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBHTN)))
                    .addGroup(pnlCachTinhLuongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCachTinhLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhuCapXangXe))))
                .addGap(19, 19, 19)
                .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnXemTatCa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemTatCa.setText("Xem tất cả");
        btnXemTatCa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDanhSachHuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDanhSachHuy.setText("Danh sách hủy");
        btnDanhSachHuy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDanhSachHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachHuyActionPerformed(evt);
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDanhSachHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnThem)
                    .addComponent(btnDanhSachHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrCachTinhLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(pnlCachTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtPhuCapXangXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhuCapXangXeActionPerformed

    private void txtChuyenCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuyenCanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChuyenCanActionPerformed

    private void btnDanhSachHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDanhSachHuyActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhSachHuy;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemTatCa;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblBHTN;
    private javax.swing.JLabel lblBHXH;
    private javax.swing.JLabel lblBHYT;
    private javax.swing.JLabel lblChuyenCan;
    private javax.swing.JLabel lblCongThucTinhLuong;
    private javax.swing.JLabel lblLuongCoBan;
    private javax.swing.JLabel lblLuuY;
    private javax.swing.JLabel lblMaHSL;
    private javax.swing.JLabel lblNgayNghi;
    private javax.swing.JLabel lblPhuCapXangXe;
    private javax.swing.JLabel lblThuong;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlCachTinhLuong;
    private javax.swing.JScrollPane scrCachTinhLuong;
    private javax.swing.JTable tblCachTinhLuong;
    private javax.swing.JTextField txtBHTN;
    private javax.swing.JTextField txtBHXH;
    private javax.swing.JTextField txtBHYT;
    private javax.swing.JTextField txtChuyenCan;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtMaHSL;
    private javax.swing.JTextField txtPhuCapXangXe;
    private javax.swing.JTextField txtThuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
