/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Windows
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        SetUpPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChucNangPanel = new javax.swing.JPanel();
        quanLyNhanVienButton = new javax.swing.JButton();
        quanLySachButton = new javax.swing.JButton();
        quanLyPhieuNhapButton = new javax.swing.JButton();
        quanLyHoaDonButton = new javax.swing.JButton();
        quanLyXuatKhoButton = new javax.swing.JButton();
        quanLyTaiKhoanButton = new javax.swing.JButton();
        nopDonXinNghiButton = new javax.swing.JButton();
        thongKeButton = new javax.swing.JButton();
        thongKeKhoHangButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        QuyenPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        HienThiPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChucNangPanel.setPreferredSize(new java.awt.Dimension(230, 582));

        quanLyNhanVienButton.setText("Quản lý nhân viên");
        quanLyNhanVienButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyNhanVienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyNhanVienButtonActionPerformed(evt);
            }
        });

        quanLySachButton.setText("Quản Lý Sách");
        quanLySachButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLySachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLySachButtonActionPerformed(evt);
            }
        });

        quanLyPhieuNhapButton.setText("Quản lý phiếu nhập");
        quanLyPhieuNhapButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyPhieuNhapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyPhieuNhapButtonActionPerformed(evt);
            }
        });

        quanLyHoaDonButton.setText("Quản lý hoá đơn");
        quanLyHoaDonButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyHoaDonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyHoaDonButtonActionPerformed(evt);
            }
        });

        quanLyXuatKhoButton.setText("Quản lý xuất kho");
        quanLyXuatKhoButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyXuatKhoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyXuatKhoButtonActionPerformed(evt);
            }
        });

        quanLyTaiKhoanButton.setText("Quản lý tài khoản");
        quanLyTaiKhoanButton.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyTaiKhoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyTaiKhoanButtonActionPerformed(evt);
            }
        });

        nopDonXinNghiButton.setText("Nộp đơn xin nghỉ");
        nopDonXinNghiButton.setPreferredSize(new java.awt.Dimension(220, 42));
        nopDonXinNghiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopDonXinNghiButtonActionPerformed(evt);
            }
        });

        thongKeButton.setText("Thống kê");
        thongKeButton.setPreferredSize(new java.awt.Dimension(220, 42));
        thongKeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeButtonActionPerformed(evt);
            }
        });

        thongKeKhoHangButton.setText("Thông kê kho hàng");
        thongKeKhoHangButton.setPreferredSize(new java.awt.Dimension(220, 42));
        thongKeKhoHangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeKhoHangButtonActionPerformed(evt);
            }
        });

        jButton10.setText("Thông kê nhân viên");
        jButton10.setPreferredSize(new java.awt.Dimension(220, 42));

        jButton11.setText("Đăng xuất");
        jButton11.setPreferredSize(new java.awt.Dimension(220, 42));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setLabel("Trang chủ");
        jButton12.setPreferredSize(new java.awt.Dimension(220, 42));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChucNangPanelLayout = new javax.swing.GroupLayout(ChucNangPanel);
        ChucNangPanel.setLayout(ChucNangPanelLayout);
        ChucNangPanelLayout.setHorizontalGroup(
            ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChucNangPanelLayout.createSequentialGroup()
                        .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quanLyNhanVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quanLySachButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quanLyPhieuNhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quanLyHoaDonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quanLyXuatKhoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thongKeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChucNangPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quanLyTaiKhoanButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nopDonXinNghiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thongKeKhoHangButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        ChucNangPanelLayout.setVerticalGroup(
            ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyNhanVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLySachButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyPhieuNhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyHoaDonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyXuatKhoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyTaiKhoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nopDonXinNghiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongKeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongKeKhoHangButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("                        ADMIN");

        javax.swing.GroupLayout QuyenPanelLayout = new javax.swing.GroupLayout(QuyenPanel);
        QuyenPanel.setLayout(QuyenPanelLayout);
        QuyenPanelLayout.setHorizontalGroup(
            QuyenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuyenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QuyenPanelLayout.setVerticalGroup(
            QuyenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuyenPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HienThiPanel.setPreferredSize(new java.awt.Dimension(1140, 720));
        HienThiPanel.setVerifyInputWhenFocusTarget(false);
        HienThiPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChucNangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(QuyenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HienThiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HienThiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QuyenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChucNangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quanLyNhanVienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyNhanVienButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLyNhanVienPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLyNhanVienButtonActionPerformed

    private void quanLyXuatKhoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyXuatKhoButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLyPhieuXuatPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLyXuatKhoButtonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void quanLySachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLySachButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLySachPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLySachButtonActionPerformed

    private void quanLyPhieuNhapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyPhieuNhapButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLyPhieuNhapPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLyPhieuNhapButtonActionPerformed

    private void quanLyHoaDonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyHoaDonButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLyHoaDonPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLyHoaDonButtonActionPerformed

    private void quanLyTaiKhoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyTaiKhoanButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanLyTaiKhoanPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_quanLyTaiKhoanButtonActionPerformed

    private void nopDonXinNghiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopDonXinNghiButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(thongBaoNghiPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_nopDonXinNghiButtonActionPerformed

    private void thongKeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(thongKePanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_thongKeButtonActionPerformed

    private void thongKeKhoHangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeKhoHangButtonActionPerformed
        HienThiPanel.removeAll();
//        HienThiPanel.add(thong);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_thongKeKhoHangButtonActionPerformed

    private void SetUpPanel(){
        quanLySachPanel.setPreferredSize(new Dimension(1140, 720));        
        quanLySachPanel.setBackground(Color.GRAY);
        quanLyNhanVienPanel.setPreferredSize(new Dimension(1140, 720));
        quanLyNhanVienPanel.setBackground(Color.RED);
        quanLyNhaCungCapPanel.setPreferredSize(new Dimension(1140, 720));        
        quanLyNhaCungCapPanel.setBackground(Color.YELLOW);
        quanLyTaiKhoanPanel.setPreferredSize(new Dimension(1140, 720));
        quanLyTaiKhoanPanel.setBackground(Color.BLUE);
        thongBaoNghiPanel.setPreferredSize(new Dimension(1140, 720));
        thongBaoNghiPanel.setBackground(Color.PINK);
        thongKePanel.setPreferredSize(new Dimension(1140, 720));        
        thongKePanel.setBackground(Color.CYAN);
        quanLyPhieuNhapPanel.setPreferredSize(new Dimension(1140, 720));
        quanLyPhieuNhapPanel.setBackground(Color.DARK_GRAY);
        quanLyHoaDonPanel.setPreferredSize(new Dimension(1140, 720));        
        quanLyHoaDonPanel.setBackground(Color.orange);
        quanLyPhieuXuatPanel.setPreferredSize(new Dimension(1140, 720));
        quanLyPhieuXuatPanel.setBackground(Color.MAGENTA);
    };
    
    JPanel quanLySachPanel = new QuanLySach();
    JPanel quanLyNhanVienPanel = new QuanLyNhanVien();
    JPanel quanLyNhaCungCapPanel = new QuanLyNhaCungCap();
    JPanel quanLyTaiKhoanPanel = new QuanLyTaiKhoan();
    JPanel thongBaoNghiPanel = new ThongBaoNghi();
    JPanel thongKePanel = new ThongKe();
    JPanel quanLyPhieuNhapPanel = new QuanLyPhieuNhap();
    JPanel quanLyHoaDonPanel = new QuanLyHoaDon();
    JPanel quanLyPhieuXuatPanel = new QuanLyPhieuXuat();

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChucNangPanel;
    private javax.swing.JPanel HienThiPanel;
    private javax.swing.JPanel QuyenPanel;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nopDonXinNghiButton;
    private javax.swing.JButton quanLyHoaDonButton;
    private javax.swing.JButton quanLyNhanVienButton;
    private javax.swing.JButton quanLyPhieuNhapButton;
    private javax.swing.JButton quanLySachButton;
    private javax.swing.JButton quanLyTaiKhoanButton;
    private javax.swing.JButton quanLyXuatKhoButton;
    private javax.swing.JButton thongKeButton;
    private javax.swing.JButton thongKeKhoHangButton;
    // End of variables declaration//GEN-END:variables
}
