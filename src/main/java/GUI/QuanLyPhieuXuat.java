package GUI;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuXuatBUS;
import BUS.SachBUS;
import DTO.ChiTietPhieuXuat;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuXuat;
import DTO.Sach;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyPhieuXuat extends javax.swing.JPanel {
    public QuanLyPhieuXuat() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pXTable = new javax.swing.JTable();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        viewAllButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        cancellationListButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        idPNLabel = new javax.swing.JLabel();
        nvLabel = new javax.swing.JLabel();
        ngayXuatLabel = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pXDetailTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        maPNTextField = new javax.swing.JTextField();
        ngayXuatTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        huyButton = new javax.swing.JButton();
        trangThaiTextField = new javax.swing.JTextField();
        chiNhanhLabel = new javax.swing.JLabel();
        tenNVTextField = new javax.swing.JTextField();
        chiNhanhTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(1140, 720));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pXTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Xuất", "Tên Nhân Viên", "Ngày xuất", "Chi nhánh", "Trạng thái"
            }
        ));
        pXTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pXTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pXTable);

        searchLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchLabel.setText("Tìm kiếm ");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
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

        viewAllButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewAllButton.setText("Xem danh sách");
        viewAllButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addButton.setText("Thêm");
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancellationListButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancellationListButton.setText("Danh sách hủy");
        cancellationListButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancellationListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellationListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cancellationListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(viewAllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(cancellationListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idPNLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        idPNLabel.setText("Mã Phiếu xuất");

        nvLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nvLabel.setText("Tên Nhân Viên");

        ngayXuatLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ngayXuatLabel.setText("Ngày Xuất");

        trangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        trangThai.setText("Trạng thái");

        pXDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng "
            }
        ));
        jScrollPane3.setViewportView(pXDetailTable);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Danh Sách Sản Phẩm");

        maPNTextField.setEditable(false);

        ngayXuatTextField.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Chi Tiết Phiếu Xuất");

        huyButton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        huyButton.setText("Hủy");
        huyButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        huyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyButtonActionPerformed(evt);
            }
        });

        trangThaiTextField.setEditable(false);

        chiNhanhLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chiNhanhLabel.setText("Chi Nhánh");

        tenNVTextField.setEditable(false);

        chiNhanhTextField.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idPNLabel)
                                    .addComponent(nvLabel)
                                    .addComponent(ngayXuatLabel)
                                    .addComponent(trangThai)
                                    .addComponent(chiNhanhLabel))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maPNTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(ngayXuatTextField)
                                    .addComponent(trangThaiTextField)
                                    .addComponent(tenNVTextField)
                                    .addComponent(chiNhanhTextField))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(huyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPNLabel)
                    .addComponent(maPNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nvLabel)
                    .addComponent(tenNVTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngayXuatLabel)
                    .addComponent(ngayXuatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chiNhanhLabel)
                    .addComponent(chiNhanhTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(trangThaiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangThai))
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(huyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchTextFieldActionPerformed(evt);
    }

    private void viewAllButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadData();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addFrame.setVisible(true);
    }

    private void huyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean tc = pxBUS.capNhatPhieuXuat(Integer.parseInt(maPNTextField.getText()));
        if (tc) {
            JOptionPane.showMessageDialog(this, "Huỷ phiếu xuất thành công!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            loadData();
        }
    }

    private void cancellationListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        listPX = pxBUS.layDanhSachPhieuXuatDaHuy();
        DefaultTableModel model = (DefaultTableModel) pXTable.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        DefaultTableModel model2 = (DefaultTableModel) pXDetailTable.getModel();
        model2.setRowCount(0); // Xóa dữ liệu cũ

        // Tạo HashMap để tra cứu nhanh
        Map<Integer, String> mapNV = new HashMap<>();
        for (NhanVien nv : listNV) {
            mapNV.put(nv.getMaNV(), nv.getTenNV());
        }

        for (PhieuXuat px : listPX) {
            String nameNV = mapNV.getOrDefault(px.getMaNV(), "");
            for (NhanVien nv : listNV)
                if (nv.getMaNV() == px.getMaNV())
                    nameNV = nv.getTenNV();

            model.addRow(new Object[] {
                    px.getMaPX(),
                    nameNV,
                    px.getNgayXuat(),
                    px.getChiNhanh(),
                    px.getTrangThai()
            });
        }
    }

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = removeAccent(searchTextField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) pXTable.getModel();
        model.setRowCount(0);

        // Tạo HashMap để tra cứu nhanh
        Map<Integer, String> mapNV = new HashMap<>();
        for (NhanVien nv : listNV) {
            mapNV.put(nv.getMaNV(), nv.getTenNV());
        }

        for (PhieuXuat px : listPX) {
            String nameNV = mapNV.getOrDefault(px.getMaNV(), "");
            if (removeAccent(nameNV.toLowerCase()).contains(keyword)) {
                for (NhanVien nv : listNV)
                    if (nv.getMaNV() == px.getMaNV())
                        nameNV = nv.getTenNV();

                model.addRow(new Object[] {
                        px.getMaPX(),
                        nameNV,
                        px.getNgayXuat(),
                        px.getChiNhanh(),
                        px.getTrangThai()
                });
            }
        }
    }

    private void pXTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = pXTable.getSelectedRow();
        if (selectedRow != -1) {
            maPNTextField.setText(pXTable.getValueAt(selectedRow, 0).toString());
            tenNVTextField.setText(pXTable.getValueAt(selectedRow, 1).toString());
            chiNhanhTextField.setText(pXTable.getValueAt(selectedRow, 2).toString());
            ngayXuatTextField.setText(pXTable.getValueAt(selectedRow, 3).toString());
            trangThaiTextField.setText(pXTable.getValueAt(selectedRow, 4).toString());

            DefaultTableModel model = (DefaultTableModel) pXDetailTable.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ

            for (ChiTietPhieuXuat ctpx : listCTPX)
                if (ctpx.getMaPX() == Integer.parseInt(pXTable.getValueAt(selectedRow, 0).toString())) {
                    for (Sach sach : listBook)
                        if (sach.getMaSach() == ctpx.getMaSach()) {
                            model.addRow(new Object[] {
                                    sach.getMaSach(),
                                    sach.getTenSach(),
                                    ctpx.getSoLuong()
                            });
                        }
                }
        }
    }

    private void loadData() {
        listBook = sachBUS.getAllSach();
        listPX = pxBUS.layDanhSachPhieuXuat();
        listCTPX = pxBUS.layDanhSachChiTietPhieuXuat();
        listNV = nvBUS.getAllNhanVien();
        
        DefaultTableModel model = (DefaultTableModel) pXTable.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        DefaultTableModel model2 = (DefaultTableModel) pXDetailTable.getModel();
        model2.setRowCount(0); // Xóa dữ liệu cũ

        // Tạo HashMap để tra cứu nhanh
        Map<Integer, String> mapNV = new HashMap<>();
        for (NhanVien nv : listNV) {
            mapNV.put(nv.getMaNV(), nv.getTenNV());
        }

        for (PhieuXuat px : listPX) {
            String nameNV = mapNV.getOrDefault(px.getMaNV(), "");           
            for (NhanVien nv : listNV)
                if (nv.getMaNV() == px.getMaNV())
                    nameNV = nv.getTenNV();

            model.addRow(new Object[] {
                    px.getMaPX(),
                    nameNV,
                    px.getNgayXuat(),
                    px.getChiNhanh(),
                    px.getTrangThai()
            });
        }
    }

    private String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D");
    }

    private List<Sach> listBook = new ArrayList<>();
    private List<PhieuXuat> listPX = new ArrayList<>();
    private List<NhanVien> listNV = new ArrayList<>();
    private List<ChiTietPhieuXuat> listCTPX = new ArrayList<>();
    private SachBUS sachBUS = new SachBUS();
    private PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    ThemPX addFrame = new ThemPX();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancellationListButton;
    private javax.swing.JLabel chiNhanhLabel;
    private javax.swing.JTextField chiNhanhTextField;
    private javax.swing.JButton huyButton;
    private javax.swing.JLabel idPNLabel;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField maPNTextField;
    private javax.swing.JLabel ngayXuatLabel;
    private javax.swing.JTextField ngayXuatTextField;
    private javax.swing.JLabel nvLabel;
    private javax.swing.JTable pXDetailTable;
    private javax.swing.JTable pXTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField tenNVTextField;
    private javax.swing.JLabel trangThai;
    private javax.swing.JTextField trangThaiTextField;
    private javax.swing.JButton viewAllButton;
    // End of variables declaration//GEN-END:variables
}
