package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=QuanLyNhaSach;integratedSecurity=true;encrypt=false";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Kết nối thành công!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi tải driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
