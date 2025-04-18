/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        //ChucNangPanel.setLayout(new BoxLayout(ChucNangPanel, BoxLayout.Y_AXIS));
        roleLbl.setText(SESSION.CurrentSession.getChucVu());
        SetUpPanel();
        setRoleVisibility();  // Gọi để điều chỉnh các button theo chức vụ
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }
    // Phương thức setRoleVisibility() để ẩn/hiển thị các button dựa trên chức vụ của tài khoản đang đăng nhập
    private void setRoleVisibility() {
        String role = SESSION.CurrentSession.getChucVu(); // Lấy chức vụ từ CurrentSession

        // Ẩn hết các button trước
        trangChu.setVisible(false);
        dangXuat.setVisible(false);
        quanLyNhanVienButton.setVisible(false);
        quanLySachButton.setVisible(false);
        quanLyPhieuNhapButton.setVisible(false);
        quanLyHoaDonButton.setVisible(false);
        quanLyXuatKhoButton.setVisible(false);
        quanLyTaiKhoanButton.setVisible(false);
        nopDonXinNghiButton.setVisible(false);
        thongKeButton.setVisible(false);
        QuanLyKhuyenMaiButton.setVisible(false);
        CachTinhLuongButton.setVisible(false);
        xemLuongButton.setVisible(false);
        quanLyThongTinCaNhan.setVisible(false);
        
        // Sau đó hiển thị theo yêu cầu:
        if (role.equalsIgnoreCase("Nhân viên bán hàng")) {
            trangChu.setVisible(true);
            dangXuat.setVisible(true);
            nopDonXinNghiButton.setVisible(true);
            quanLyHoaDonButton.setVisible(true);
            xemLuongButton.setVisible(true);
            quanLyThongTinCaNhan.setVisible(true);
        } else if (role.equalsIgnoreCase("Quản lý nhân viên")) {
            trangChu.setVisible(true);
            dangXuat.setVisible(true);
            CachTinhLuongButton.setVisible(true);
            nopDonXinNghiButton.setVisible(true);
            quanLyNhanVienButton.setVisible(true);
            quanLyTaiKhoanButton.setVisible(true);
            xemLuongButton.setVisible(true);
            quanLyThongTinCaNhan.setVisible(true);
            thongKeButton.setVisible(true);
        } else if (role.equalsIgnoreCase("Quản lý kho hàng")) {
            trangChu.setVisible(true);
            dangXuat.setVisible(true);
            nopDonXinNghiButton.setVisible(true);
            quanLySachButton.setVisible(true);
            quanLyPhieuNhapButton.setVisible(true);
            quanLyHoaDonButton.setVisible(true);
            quanLyXuatKhoButton.setVisible(true);
            xemLuongButton.setVisible(true);
            quanLyThongTinCaNhan.setVisible(true);
            thongKeButton.setVisible(true);
        } else if (role.equalsIgnoreCase("Admin")) {
            // Hiển thị tất cả các button
            trangChu.setVisible(true);
            dangXuat.setVisible(true);
            quanLyNhanVienButton.setVisible(true);
            quanLySachButton.setVisible(true);
            quanLyPhieuNhapButton.setVisible(true);
            quanLyHoaDonButton.setVisible(true);
            quanLyXuatKhoButton.setVisible(true);
            quanLyTaiKhoanButton.setVisible(true);
            nopDonXinNghiButton.setVisible(true);
            thongKeButton.setVisible(true);
            QuanLyKhuyenMaiButton.setVisible(true);
            CachTinhLuongButton.setVisible(true);
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

        ChucNangPanel = new javax.swing.JPanel();
        quanLyNhanVienButton = new javax.swing.JButton();
        quanLySachButton = new javax.swing.JButton();
        quanLyPhieuNhapButton = new javax.swing.JButton();
        quanLyHoaDonButton = new javax.swing.JButton();
        quanLyXuatKhoButton = new javax.swing.JButton();
        quanLyTaiKhoanButton = new javax.swing.JButton();
        nopDonXinNghiButton = new javax.swing.JButton();
        thongKeButton = new javax.swing.JButton();
        QuanLyKhuyenMaiButton = new javax.swing.JButton();
        CachTinhLuongButton = new javax.swing.JButton();
        dangXuat = new javax.swing.JButton();
        trangChu = new javax.swing.JButton();
        xemLuongButton = new javax.swing.JButton();
        quanLyThongTinCaNhan = new javax.swing.JButton();
        QuyenPanel = new javax.swing.JPanel();
        roleLbl = new javax.swing.JLabel();
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

        nopDonXinNghiButton.setText("Thông Báo Nghỉ");
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

        QuanLyKhuyenMaiButton.setText("Quản Lý Khuyến Mãi");
        QuanLyKhuyenMaiButton.setPreferredSize(new java.awt.Dimension(220, 42));
        QuanLyKhuyenMaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLyKhuyenMaiButtonActionPerformed(evt);
            }
        });

        CachTinhLuongButton.setText("Cách tính lương");
        CachTinhLuongButton.setPreferredSize(new java.awt.Dimension(220, 42));
        CachTinhLuongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CachTinhLuongButtonActionPerformed(evt);
            }
        });

        dangXuat.setText("Đăng xuất");
        dangXuat.setPreferredSize(new java.awt.Dimension(220, 42));
        dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangXuatActionPerformed(evt);
            }
        });

        trangChu.setLabel("Trang chủ");
        trangChu.setPreferredSize(new java.awt.Dimension(220, 42));
        trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangChuActionPerformed(evt);
            }
        });

        xemLuongButton.setText("Xem Lương");
        xemLuongButton.setPreferredSize(new java.awt.Dimension(220, 42));
        xemLuongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemLuongButtonActionPerformed(evt);
            }
        });

        quanLyThongTinCaNhan.setText("Quản lý thông tin cá nhân");
        quanLyThongTinCaNhan.setPreferredSize(new java.awt.Dimension(220, 42));
        quanLyThongTinCaNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyThongTinCaNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChucNangPanelLayout = new javax.swing.GroupLayout(ChucNangPanel);
        ChucNangPanel.setLayout(ChucNangPanelLayout);
        ChucNangPanelLayout.setHorizontalGroup(
            ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChucNangPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChucNangPanelLayout.createSequentialGroup()
                        .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xemLuongButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CachTinhLuongButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLyTaiKhoanButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nopDonXinNghiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(QuanLyKhuyenMaiButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLyNhanVienButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLySachButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLyPhieuNhapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLyHoaDonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quanLyXuatKhoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(thongKeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(quanLyThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ChucNangPanelLayout.setVerticalGroup(
            ChucNangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucNangPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quanLyThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(QuanLyKhuyenMaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CachTinhLuongButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xemLuongButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roleLbl.setText("ADMIN");

        javax.swing.GroupLayout QuyenPanelLayout = new javax.swing.GroupLayout(QuyenPanel);
        QuyenPanel.setLayout(QuyenPanelLayout);
        QuyenPanelLayout.setHorizontalGroup(
            QuyenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuyenPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(roleLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QuyenPanelLayout.setVerticalGroup(
            QuyenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuyenPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HienThiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QuyenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChucNangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(HienThiPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangXuatActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Xóa thông tin phiên đăng nhập
            SESSION.CurrentSession.clear();

            // Hiển thị lại cửa sổ đăng nhập (bọc JPanel Login bên trong JFrame)
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);

            // Đóng MainWindow mà không tắt toàn bộ ứng dụng
            this.dispose();
        }
    }//GEN-LAST:event_dangXuatActionPerformed

    private void trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangChuActionPerformed
        // TODO add your handling code here:
            // Giả sử bạn có một panel trang chủ, nếu chưa có thì tạo mới một JPanel mặc định với thông báo
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.WHITE);
        homePanel.add(new JLabel("Chào mừng đến trang chủ!"));

        HienThiPanel.removeAll();
        HienThiPanel.setLayout(new BorderLayout());
        HienThiPanel.add(homePanel, BorderLayout.CENTER);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_trangChuActionPerformed

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

    private void QuanLyKhuyenMaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLyKhuyenMaiButtonActionPerformed
        HienThiPanel.removeAll();
        HienThiPanel.add(quanlykhuyenmaipanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_QuanLyKhuyenMaiButtonActionPerformed

    private void CachTinhLuongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CachTinhLuongButtonActionPerformed
        // TODO add your handling code here:
        HienThiPanel.removeAll();
        HienThiPanel.add(cachtinhluongPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_CachTinhLuongButtonActionPerformed

    private void xemLuongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemLuongButtonActionPerformed
        // TODO add your handling code here:
        HienThiPanel.removeAll();
        HienThiPanel.add(xemluongPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
    }//GEN-LAST:event_xemLuongButtonActionPerformed

    private void quanLyThongTinCaNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyThongTinCaNhanActionPerformed
        // TODO add your handling code here:
        HienThiPanel.removeAll();
        HienThiPanel.add(quanlythongtincanhanPanel);
        HienThiPanel.revalidate();
        HienThiPanel.repaint();
        
    }//GEN-LAST:event_quanLyThongTinCaNhanActionPerformed

    private void SetUpPanel(){
        quanLySachPanel.setPreferredSize(new Dimension(1140, 720));        
        quanLySachPanel.setBackground(Color.GRAY);
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
    JPanel quanlykhuyenmaipanel = new QuanLyKhuyenMai();
    JPanel cachtinhluongPanel = new CachTinhLuong();
    JPanel xemluongPanel = new XemLuong();
    JPanel quanlythongtincanhanPanel = new QL_ThongTinCaNhanVaTaiKhoan();
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
    private javax.swing.JButton CachTinhLuongButton;
    private javax.swing.JPanel ChucNangPanel;
    private javax.swing.JPanel HienThiPanel;
    private javax.swing.JButton QuanLyKhuyenMaiButton;
    private javax.swing.JPanel QuyenPanel;
    private javax.swing.JButton dangXuat;
    private javax.swing.JButton nopDonXinNghiButton;
    private javax.swing.JButton quanLyHoaDonButton;
    private javax.swing.JButton quanLyNhanVienButton;
    private javax.swing.JButton quanLyPhieuNhapButton;
    private javax.swing.JButton quanLySachButton;
    private javax.swing.JButton quanLyTaiKhoanButton;
    private javax.swing.JButton quanLyThongTinCaNhan;
    private javax.swing.JButton quanLyXuatKhoButton;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JButton thongKeButton;
    private javax.swing.JButton trangChu;
    private javax.swing.JButton xemLuongButton;
    // End of variables declaration//GEN-END:variables

}
