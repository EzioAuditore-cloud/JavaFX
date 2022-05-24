package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Person类的JDBC 工具类，抽取公共方法
 */
public class JDBC {
	//设置数据库名称和登录用户信息
	private static String DRIVERCLASS="com.mysql.cj.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/cardsys?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    
    private static final String USER="root";		//数据库用户
    private static final String PASSWORD="123456";	//用户root的连接数据库的密码
    
    private static Connection conn=null;	//与数据库的连接；
    
    // 装载驱动
    private static void loadDriver() {
       	try {
            //1.加载MYSQL JDBC驱动程序
       		Class.forName(DRIVERCLASS);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }        
    }
    
    //建立连接
    public static Connection getConnection() throws Exception {
        loadDriver();
        System.out.println("数据库连接成功");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    //释放资源
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        release(stmt, conn);
    }
    
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}