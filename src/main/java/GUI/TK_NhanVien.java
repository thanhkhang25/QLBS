/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import BUS.ChamCongBUS;
import BUS.LuongBUS;
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.Luong;
import DTO.NhanVien;
import SESSION.CurrentSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class TK_NhanVien extends javax.swing.JPanel {

    /**
     * Creates new form TK_NhanVien
     */
    private DefaultTableModel tableModel;
    private LuongBUS luongBUS;
    private NhanVienBUS nhanVienBUS;
    private TaiKhoanBUS taiKhoanBUS;  
    private ChamCongBUS chamCongBUS;    
    
    // Danh sách lưu dữ liệu lương của tháng đang chọn
    private List<Luong> listLuong;
    
    public TK_NhanVien() {
        initComponents();
        // Khởi tạo các đối tượng BUS
        luongBUS = new LuongBUS();
        nhanVienBUS = new NhanVienBUS();
        taiKhoanBUS = new TaiKhoanBUS();   // KHỞI TẠO cho truy xuất tài khoản (chức vụ của NV)
        chamCongBUS = new ChamCongBUS();     // KHỞI TẠO cho truy xuất chấm công
        // Khởi tạo table
        initTable();

        // Thiết lập giá trị mặc định cho cmbThang: chọn tháng trước
        int currentMonth = LocalDate.now().getMonthValue();
        // Xóa tất cả item hiện có trong cmbNam
        cmbNam.removeAllItems();
        // Thêm các năm từ năm 2015 đến năm hiện tại + 1 (có thể chỉnh sửa theo nhu cầu)
        int currentYear = LocalDate.now().getYear();
        for (int y = 2015; y <= currentYear + 1; y++) {
            cmbNam.addItem(String.valueOf(y));
        }
        // Thiết lập mặc định là năm hiện tại
        cmbNam.setSelectedItem(String.valueOf(currentYear));

        int defaultMonth = currentMonth - 1;
        if (defaultMonth < 1) { 
            defaultMonth = 12; 
        }
        cmbThang.setSelectedIndex(defaultMonth - 1); // vì index bắt đầu từ 0
        cmbNam.setSelectedItem(currentYear); // giả sử cmbNam chứa các giá trị là String
        // Đặt cmbLoc mặc định là "Tất Cả Nhân Viên"
        cmbLoc.setSelectedItem("Tất Cả Nhân Viên");

        // Sử dụng invokeLater để load dữ liệu sau khi giao diện được khởi tạo hoàn chỉnh
        javax.swing.SwingUtilities.invokeLater(() -> {
            loadData();
            updateTotals();
        });

        // Nếu người dùng thay đổi comboBox, cập nhật lại dữ liệu
        cmbThang.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                loadData();
                //updateTotals();
            }
        });
        cmbNam.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                loadData();
                //updateTotals();
            }
        });
        cmbLoc.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                loadData();
                //updateTotals();
            }
        });
    }

    
    private void initTable() {
        String[] columnNames = {
            "Mã NV", "Tên NV", "Ngày Sinh", "Giới Tính", "Chức Vụ", 
            "Mức Lương", "Thưởng", "Số Ngày Làm"
        };
        tableModel = new DefaultTableModel(columnNames, 0);
        tblThongKeTinhHinhNhanSu.setModel(tableModel);
    }

    private void loadData() {
        // 1. Lấy giá trị tháng và năm được chọn
        int selectedMonth = cmbThang.getSelectedIndex() + 1;
        int selectedYear = Integer.parseInt(cmbNam.getSelectedItem().toString());
        // Tính ngày cuối cùng của tháng được chọn (ví dụ: 31/03/2023)
        LocalDate endDate = LocalDate.of(selectedYear, selectedMonth,
                              LocalDate.of(selectedYear, selectedMonth, 1).lengthOfMonth());

        // 2. Lấy danh sách tất cả NV từ DB
        List<NhanVien> allNV = nhanVienBUS.getAllNhanVien();

        // 3. Lọc danh sách NV đã có mặt tại thời điểm được chọn: ngayVaoLam ≤ endDate
        List<NhanVien> employeesAtTime = new ArrayList<>();
        for (NhanVien nv : allNV) {
            LocalDate vaoLam = nv.getNgayVaoLam().toLocalDate();
            if (!vaoLam.isAfter(endDate)) {  // tức là vaoLam ≤ endDate
                employeesAtTime.add(nv);
            }
        }
        int totalEmployeesCount = employeesAtTime.size();

        // 4. Đếm NV mới: chỉ những NV có ngayVaoLam nằm trong tháng, năm được chọn
        int newEmployeesCount = 0;
        for (NhanVien nv : employeesAtTime) {
            LocalDate vaoLam = nv.getNgayVaoLam().toLocalDate();
            if (vaoLam.getMonthValue() == selectedMonth && vaoLam.getYear() == selectedYear) {
                newEmployeesCount++;
            }
        }

        // 5. Lấy dữ liệu lương của tháng, năm được chọn – nếu có (NV có bản ghi lương)
        List<Luong> listLuongForMonth = luongBUS.getLuongByMonth(selectedYear, selectedMonth);
        // Tạo Map từ maNV -> Luong
        java.util.Map<Integer, Luong> salaryMap = new java.util.HashMap<>();
        for (Luong l : listLuongForMonth) {
             salaryMap.put(l.getMaNV(), l);
        }

        // 6. Lấy giá trị bộ lọc từ cmbLoc: "Nhân Viên Mới" hoặc "Tất Cả Nhân Viên"
        String filter = (String) cmbLoc.getSelectedItem();
        List<NhanVien> displayedNV = new ArrayList<>();
        if (filter.equalsIgnoreCase("Nhân Viên Mới")) {
            // Chỉ lấy những NV mới: ngayVaoLam nằm chính xác trong tháng–năm được chọn
            for (NhanVien nv : employeesAtTime) {
                LocalDate vaoLam = nv.getNgayVaoLam().toLocalDate();
                if (vaoLam.getMonthValue() == selectedMonth && vaoLam.getYear() == selectedYear) {
                    displayedNV.add(nv);
                }
            }
        } else { // "Tất Cả Nhân Viên"
            displayedNV.addAll(employeesAtTime);
        }

        // 7. Nếu người dùng không phải QL nhân viên hay Admin, chỉ hiển thị NV của chính mình
        String currentRole = CurrentSession.getChucVu();
        int currentMaNV = CurrentSession.getMaNV();
        List<NhanVien> finalDisplayedNV = new ArrayList<>();
        for (NhanVien nv : displayedNV) {
            if (!currentRole.equalsIgnoreCase("Quản lý nhân viên") &&
                !currentRole.equalsIgnoreCase("Admin") &&
                nv.getMaNV() != currentMaNV) {
                continue;
            }
            finalDisplayedNV.add(nv);
        }

    // 8. Xóa dữ liệu cũ trong bảng và thêm dữ liệu từ finalDisplayedNV
    tableModel.setRowCount(0);
    double totalSalary = 0;
    double totalBonus = 0;
    // Duyệt qua NV hiển thị
    for (NhanVien nv : finalDisplayedNV) {
        // Lấy chức vụ của NV từ bảng TaiKhoan bằng cách sử dụng TaiKhoanBUS
        // Giả sử bạn có: taiKhoanBUS.getTaiKhoanByMaNV(nv.getMaNV()).getChucVu();
        String empRole = "";
        try {
            empRole = taiKhoanBUS.getTaiKhoanByMaNV(nv.getMaNV()).getChucVu();
        } catch(Exception ex) {
            empRole = "N/A";
        }
        
        // Lấy số ngày làm từ bảng ChamCong: đếm số lần chấm công của NV trong tháng năm được chọn
        int workingDays = chamCongBUS.countChamCongByNV(nv.getMaNV(), selectedYear, selectedMonth);
        
        // Lấy bản ghi lương từ map, nếu có
        Luong l = salaryMap.get(nv.getMaNV());
        double salary = (l != null) ? l.getTongLuongNhan() : 0;
        String formattedSalary = String.format("%.2f", (l != null) ? l.getTongLuongNhan() : 0);
        double bonus = (l != null) ? l.getThuong() : 0;
        
        tableModel.addRow(new Object[]{
            nv.getMaNV(),
            nv.getTenNV(),
            nv.getNgaySinh(),  // Có thể format lại nếu muốn
            nv.getGioiTinh(),
            empRole,             // Sử dụng chức vụ của NV từ bảng TaiKhoan
            formattedSalary,
            bonus,
            workingDays        // Số ngày làm tính từ bảng ChamCong
        });
        
        totalSalary += salary;
        totalBonus += bonus;
    }
        // 9. Cập nhật ô tổng
        txtTongSoNhanVien.setText(String.valueOf(totalEmployeesCount));
        txtSoNhanVienMoi.setText(String.valueOf(newEmployeesCount));
        txtTongLuong.setText(String.format("%.2f", totalSalary));
        txtTongThuong.setText(String.format("%.2f", totalBonus));
    }

   private void updateTotals() {
       // Nếu bạn muốn tách riêng cập nhật ô tổng, bạn có thể dùng logic tương tự loadData()
       // Nhưng một cách đơn giản là sau khi loadData() đã cập nhật table, gọi lại đoạn code tổng hợp ở đây.
       int selectedMonth = cmbThang.getSelectedIndex() + 1;
       int selectedYear = Integer.parseInt(cmbNam.getSelectedItem().toString());
       String filter = (String) cmbLoc.getSelectedItem();
       int currentMaNV = CurrentSession.getMaNV();
       String currentRole = CurrentSession.getChucVu();

       double totalSalary = 0;
       double totalBonus = 0;
       int totalEmployees = 0;
       int newEmployees = 0;

       // Giả sử bạn duyệt lại qua danh sách lương của tháng đã chọn, nhưng vì cách mới ta dùng nhân viên từ allNV:
       List<NhanVien> allNV = nhanVienBUS.getAllNhanVien();
       // Lấy danh sách lương của tháng, năm đã chọn
       List<Luong> listLuongForMonth = luongBUS.getLuongByMonth(selectedYear, selectedMonth);
       java.util.Map<Integer, Luong> salaryMap = new java.util.HashMap<>();
       for (Luong l : listLuongForMonth) {
            salaryMap.put(l.getMaNV(), l);
       }

       for (NhanVien nv : allNV) {
           if (!currentRole.equalsIgnoreCase("Quản lý nhân viên") &&
               !currentRole.equalsIgnoreCase("Admin") &&
               nv.getMaNV() != currentMaNV) {
               continue;
           }
           boolean include = true;
           if (filter.equalsIgnoreCase("Nhân Viên Mới")) {
               LocalDate vaoLam = nv.getNgayVaoLam().toLocalDate();
               if (vaoLam.getMonthValue() != selectedMonth || vaoLam.getYear() != selectedYear) {
                   include = false;
               }
           }
           if (!include) continue;

           Luong l = salaryMap.get(nv.getMaNV());
           double salary = (l != null) ? l.getTongLuongNhan() : 0;
           double bonus = (l != null) ? l.getThuong() : 0;

           totalSalary += salary;
           totalBonus += bonus;
           totalEmployees++;

           LocalDate vaoLam = nv.getNgayVaoLam().toLocalDate();
           if (vaoLam.getMonthValue() == selectedMonth && vaoLam.getYear() == selectedYear) {
               newEmployees++;
           }
       }

       txtTongSoNhanVien.setText(String.valueOf(totalEmployees));
       txtSoNhanVienMoi.setText(String.valueOf(newEmployees));
       txtTongLuong.setText(String.format("%.2f", totalSalary));
       txtTongThuong.setText(String.format("%.2f", totalBonus));
   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrThongKeTinhHinhNhanSu = new javax.swing.JScrollPane();
        tblThongKeTinhHinhNhanSu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTongThuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTongSoNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoNhanVienMoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTongLuong = new javax.swing.JTextField();
        cmbLoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbThang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbNam = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống kê Tình Hình Nhân Sự");

        tblThongKeTinhHinhNhanSu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tblThongKeTinhHinhNhanSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "Giới Tính", "Chức Vụ", "Mức Lương", "Thưởng", "Số Ngày Làm"
            }
        ));
        scrThongKeTinhHinhNhanSu.setViewportView(tblThongKeTinhHinhNhanSu);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText(" Tháng");

        txtTongThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongThuongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Tổng Số Nhân Viên");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Số Nhân Viên Mới");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Tổng Lương");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Tổng Thưởng");

        cmbLoc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên Mới", "Tất Cả Nhân Viên" }));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Lọc Theo");

        cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Năm");

        cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrThongKeTinhHinhNhanSu)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTongThuong)
                                                    .addComponent(txtTongLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTongSoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSoNhanVienMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 135, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTongThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongSoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoNhanVienMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrThongKeTinhHinhNhanSu, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTongThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongThuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbLoc;
    private javax.swing.JComboBox<String> cmbNam;
    private javax.swing.JComboBox<String> cmbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane scrThongKeTinhHinhNhanSu;
    private javax.swing.JTable tblThongKeTinhHinhNhanSu;
    private javax.swing.JTextField txtSoNhanVienMoi;
    private javax.swing.JTextField txtTongLuong;
    private javax.swing.JTextField txtTongSoNhanVien;
    private javax.swing.JTextField txtTongThuong;
    // End of variables declaration//GEN-END:variables
}
