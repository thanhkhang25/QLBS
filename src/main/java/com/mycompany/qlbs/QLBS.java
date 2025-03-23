package com.mycompany.qlbs;

import javax.swing.JFrame;
import GUI.QuanLyNhanVien;
import GUI.QuanLyTaiKhoan;

public class QLBS {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản Lý Tài Khoản");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuanLyTaiKhoan());
        //frame.add(new QuanLyNhanVien());
        frame.pack(); // Tự động tính toán kích thước theo các thành phần trong frame
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mở rộng toàn màn hình (tùy chọn)
        frame.setLocationRelativeTo(null);
//        frame.setAlwaysOnTop(true); // Kiểm tra xem cửa sổ có hiển thị không (tạm thời)
        frame.setVisible(true);
    }
}
