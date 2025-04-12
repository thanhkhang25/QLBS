package GUI;

import BUS.SachBUS;
import DTO.Sach;
import javax.swing.JOptionPane;

public class ThemSach extends javax.swing.JFrame {
    public ThemSach() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        tenSachLabel = new javax.swing.JLabel();
        theLoaiLabel = new javax.swing.JLabel();
        tacGiaLabel = new javax.swing.JLabel();
        chiNhanhLabel = new javax.swing.JLabel();
        tenSachTextField = new javax.swing.JTextField();
        theLoaiTextField = new javax.swing.JTextField();
        tacGiaTextField = new javax.swing.JTextField();
        chiNhanhCombobox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        giaNhapLabel = new javax.swing.JLabel();
        giaBanLabel = new javax.swing.JLabel();
        giaNhapTextField = new javax.swing.JTextField();
        giaBanTextField = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        jScrollPane1.setViewportView(jEditorPane1);

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 224, 243));
        setFocusTraversalPolicyProvider(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(186, 224, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tenSachLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tenSachLabel.setText("Tên Sách");

        theLoaiLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        theLoaiLabel.setText("Thể Loại");

        tacGiaLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tacGiaLabel.setText("Tác Giả");

        chiNhanhLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chiNhanhLabel.setText("Chi Nhánh");

        chiNhanhCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hồ Chí Minh" }));

        addButton.setBackground(new java.awt.Color(0, 71, 171));
        addButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        addButton.setForeground(new java.awt.Color(237, 242, 251));
        addButton.setText("Thêm");
        addButton.setToolTipText("");
        addButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(186, 224, 243));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 71, 171));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Sách");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        giaNhapLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        giaNhapLabel.setText("Giá Nhập");

        giaBanLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        giaBanLabel.setText("Giá Bán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tenSachLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tenSachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(theLoaiLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(theLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tacGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chiNhanhCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tacGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(giaBanLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(giaBanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chiNhanhLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(giaNhapLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(giaNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenSachTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSachLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(theLoaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theLoaiLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tacGiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tacGiaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chiNhanhLabel)
                    .addComponent(chiNhanhCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaNhapLabel)
                    .addComponent(giaNhapTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giaBanLabel)
                    .addComponent(giaBanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String tenSach = tenSachTextField.getText().trim();
        String theLoai = theLoaiTextField.getText().trim();
        String tacGia = tacGiaTextField.getText().trim();
        String chiNhanh = (String) chiNhanhCombobox.getSelectedItem();
        String giaNhapStr = giaNhapTextField.getText().trim();
        String giaBanStr = giaBanTextField.getText().trim();

        // Kiểm tra dữ liệu hợp lệ
        if (tenSach.isEmpty() || theLoai.isEmpty() || tacGia.isEmpty() || giaNhapStr.isEmpty() || giaBanStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double giaNhap = Double.parseDouble(giaNhapStr);
            double giaBan = Double.parseDouble(giaBanStr);

            if (giaNhap < 0 || giaBan < 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập và giá bán phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Sach sach = new Sach(tenSach, theLoai, tacGia, giaBan, giaNhap, chiNhanh);

            // Gọi phương thức từ BUS
            boolean success = sachBUS.addSach(sach);

            if (success) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Đóng cửa sổ sau khi thêm thành công
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập và giá bán phải là số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemSach().setVisible(true);
            }
        });
    }

    private SachBUS sachBUS = new SachBUS();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> chiNhanhCombobox;
    private javax.swing.JLabel chiNhanhLabel;
    private javax.swing.JLabel giaBanLabel;
    private javax.swing.JTextField giaBanTextField;
    private javax.swing.JLabel giaNhapLabel;
    private javax.swing.JTextField giaNhapTextField;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tacGiaLabel;
    private javax.swing.JTextField tacGiaTextField;
    private javax.swing.JLabel tenSachLabel;
    private javax.swing.JTextField tenSachTextField;
    private javax.swing.JLabel theLoaiLabel;
    private javax.swing.JTextField theLoaiTextField;
    // End of variables declaration//GEN-END:variables
}
