package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCap;
import javax.swing.JOptionPane;

public class ThemNCC extends javax.swing.JFrame {
    public ThemNCC() {
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
        tenNCCLabel = new javax.swing.JLabel();
        sdtNCCLabel = new javax.swing.JLabel();
        emailNCCLabel = new javax.swing.JLabel();
        dCNCCLabel = new javax.swing.JLabel();
        tenNCCTextField = new javax.swing.JTextField();
        sdtNCCTextField = new javax.swing.JTextField();
        emailNCCTextField = new javax.swing.JTextField();
        dCNCCTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jScrollPane1.setViewportView(jEditorPane1);

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 224, 243));
        setFocusTraversalPolicyProvider(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(186, 224, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tenNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tenNCCLabel.setText("Tên Nhà cung cấp");

        sdtNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sdtNCCLabel.setText("Số Điện Thoại");

        emailNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        emailNCCLabel.setText("Email");

        dCNCCLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dCNCCLabel.setText("Địa Chỉ");

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

        label.setBackground(new java.awt.Color(186, 224, 243));
        label.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        label.setForeground(new java.awt.Color(0, 71, 171));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Thêm Nhà Cung Cấp");
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tenNCCLabel)
                            .addComponent(sdtNCCLabel)
                            .addComponent(emailNCCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dCNCCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dCNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sdtNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenNCCLabel)
                    .addComponent(tenNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sdtNCCLabel)
                    .addComponent(sdtNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailNCCLabel)
                    .addComponent(emailNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dCNCCLabel)
                    .addComponent(dCNCCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String tenNCC = tenNCCTextField.getText().trim();
        String sdtNCC = sdtNCCTextField.getText().trim();
        String emailNCC = emailNCCTextField.getText().trim();
        String diaChiNCC = dCNCCTextField.getText().trim();

        // Kiểm tra dữ liệu hợp lệ
        if (tenNCC.isEmpty() || sdtNCC.isEmpty() || emailNCC.isEmpty() || diaChiNCC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra định dạng số điện thoại (chỉ chứa số và có độ dài hợp lý)
        if (!sdtNCC.matches("\\d{10,11}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra định dạng email
        if (!emailNCC.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo đối tượng nhà cung cấp mới
        NhaCungCap ncc = new NhaCungCap(tenNCC, emailNCC, sdtNCC, diaChiNCC);

        // Gọi phương thức từ BUS để thêm nhà cung cấp
        boolean success = nccBUS.themNhaCungCap(ncc);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Đóng cửa sổ sau khi thêm thành công
        } else {
            JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemNCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel dCNCCLabel;
    private javax.swing.JTextField dCNCCTextField;
    private javax.swing.JLabel emailNCCLabel;
    private javax.swing.JTextField emailNCCTextField;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel sdtNCCLabel;
    private javax.swing.JTextField sdtNCCTextField;
    private javax.swing.JLabel tenNCCLabel;
    private javax.swing.JTextField tenNCCTextField;
    // End of variables declaration//GEN-END:variables
}
