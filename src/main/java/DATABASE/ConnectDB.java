package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    // Chuỗi kết nối sử dụng integratedSecurity, không cần user và password riêng
    private static final String URL = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=QuanLyNhaSach;integratedSecurity=true;encrypt=false";
    private static Connection connection = null;

    // Constructor private để ngăn tạo nhiều instance
    private ConnectDB() {}

    // Phương thức kết nối database sử dụng integratedSecurity
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Tải driver JDBC cho SQL Server
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                // Kết nối mà không cần truyền user và password
                connection = DriverManager.getConnection(URL);
                System.out.println("Kết nối thành công!");
            } catch (ClassNotFoundException e) {
                System.err.println("Lỗi tải driver JDBC: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Lỗi kết nối SQL: " + e.getMessage());
            }
        }
        return connection;
    }

    // Đóng kết nối database
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Đã đóng kết nối!");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Kiểm tra kết nối
        getConnection();
        closeConnection();
    }
}
