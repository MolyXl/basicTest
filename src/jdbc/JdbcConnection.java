package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaZhuli
 * @description jdbc编程
 * @date 2019/6/24
 */
public class JdbcConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/nongda?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionPool.getConnection();
        System.out.println(ConnectionPool.getConnectionSize());
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from sys_user");
        while (rs.next()) {
            System.out.println(rs.getString("username") + " " + rs.getString("password"));
        }
        rs.close();
        st.close();
        ConnectionPool.close(conn);
        System.out.println(ConnectionPool.getConnectionSize());
    }
}
