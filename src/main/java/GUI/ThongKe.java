/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
 

import SESSION.CurrentSession;
import javax.swing.JPanel;
/**
 *
 * @author Windows
 */
public class ThongKe extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyNhanVien
     */
    public ThongKe() {
        initComponents();
        // Lấy chức vụ từ phiên đăng nhập từ lớp CurrentSession
        String role = CurrentSession.getChucVu();
        if (role == null) {
            role = "";
        }
        
        if (role.equalsIgnoreCase("Admin")) {
            // Nếu Admin: ẩn TK_BanHang và TK_LoiNhuan, hiển thị TK_NhanSu
            TK_BanHang.setVisible(true);
            TK_LoiNhuan.setVisible(true);
            TK_NhanSu.setVisible(true);
            
            XemTK.removeAll();
            XemTK.add(thongkenhansu);  // TK_NhanVien được dùng cho thống kê nhân sự
            XemTK.revalidate();
            XemTK.repaint();
        } else if (role.equalsIgnoreCase("Quản lý kho hàng")) {
            // Nếu Quản lý kho: ẩn TK_NhanSu, hiển thị TK_BanHang và TK_LoiNhuan
            TK_NhanSu.setVisible(false);
            TK_BanHang.setVisible(true);
            TK_LoiNhuan.setVisible(true);
            
            XemTK.removeAll();
            XemTK.add(thongkebanhang); // Panel thống kê bán hàng
            XemTK.revalidate();
            XemTK.repaint();
        } else if (role.equalsIgnoreCase("Quản lý nhân viên")) {
            TK_NhanSu.setVisible(true);
            TK_BanHang.setVisible(false);
            TK_LoiNhuan.setVisible(false);
            
            XemTK.removeAll();
            XemTK.add(thongkenhansu); // Panel thống kê bán hàng
            XemTK.revalidate();
            XemTK.repaint();
        } 
    }
      JPanel thongkebanhang = new TK_BanHang();
      JPanel thongkenhansu = new TK_NhanVien();
      JPanel thongkeloinhuan = new TK_LoiNhuan();    
      /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TK_BanHang = new javax.swing.JButton();
        TK_NhanSu = new javax.swing.JButton();
        TK_LoiNhuan = new javax.swing.JButton();
        XemTK = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1140, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TK_BanHang.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        TK_BanHang.setText("Thống Kê Bán Hàng");
        TK_BanHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TK_BanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TK_BanHangActionPerformed(evt);
            }
        });

        TK_NhanSu.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        TK_NhanSu.setText("Thống kê tình hình nhân sự");
        TK_NhanSu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TK_NhanSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TK_NhanSuActionPerformed(evt);
            }
        });

        TK_LoiNhuan.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        TK_LoiNhuan.setText("Thống kê lợi nhuận");
        TK_LoiNhuan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TK_LoiNhuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TK_LoiNhuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TK_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TK_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TK_LoiNhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(662, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(TK_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TK_NhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TK_LoiNhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        XemTK.setBackground(new java.awt.Color(255, 255, 255));
        XemTK.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XemTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(XemTK, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TK_BanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TK_BanHangActionPerformed
        // TODO add your handling code here:
        XemTK.removeAll();
        XemTK.add(thongkebanhang);
        XemTK.revalidate();
        XemTK.repaint();
    }//GEN-LAST:event_TK_BanHangActionPerformed

    private void TK_NhanSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TK_NhanSuActionPerformed
        // TODO add your handling code here:
        XemTK.removeAll();
        XemTK.add(thongkenhansu);
        XemTK.revalidate();
        XemTK.repaint();
    }//GEN-LAST:event_TK_NhanSuActionPerformed

    private void TK_LoiNhuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TK_LoiNhuanActionPerformed
        // TODO add your handling code here:
        XemTK.removeAll();
        XemTK.add(thongkeloinhuan);    
        XemTK.revalidate();
        XemTK.repaint();
    }//GEN-LAST:event_TK_LoiNhuanActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TK_BanHang;
    private javax.swing.JButton TK_LoiNhuan;
    private javax.swing.JButton TK_NhanSu;
    private javax.swing.JPanel XemTK;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
