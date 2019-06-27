package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaZhuli
 * @description 模拟数据库连接池
 * @date 2019/6/24
 */
public class ConnectionPool {
    private static List<Connection> pool = new ArrayList<>();
    private static int NORMAL = 10; //初始化连接数
    private static int MAX = 20; //最大的连接数
    private static int MIN = 5; //最小的连接数

    static {
        while (pool.size() < NORMAL) {
            pool.add(JdbcConnection.getInstance());
        }
    }

    public static Connection getConnection() {
        if (pool.size() > MIN) {
            return pool.remove(0);
        } else {
            if (pool.size() <= MAX) {
                Connection conn = JdbcConnection.getInstance();
                pool.add(conn);
                return conn;
            } else {
                Connection conn = JdbcConnection.getInstance();
                return conn;
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null && pool.size() < MAX) {
            pool.add(conn);
        } else {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionPool.getConnection();
    }

    public static int getConnectionSize() {
        return pool.size();
    }
}
