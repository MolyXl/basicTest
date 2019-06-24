package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaZhuli
 * @description 数据库连接池
 * @date 2019/6/24
 */
public class ConnectionPool {
    private List<Connection> pool = new ArrayList<>();

}
