package zjw.util.druidutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidDemo {
    //1.定义成员变量 DataSource
    private static DataSource ds;
    static {
        //1.加载配置文件
        Properties pro=new Properties();
        try {
//            ClassLoader classLoader= DruidDemo.class.getClassLoader();
//            URL res=classLoader.getResource("druid.properties");
//            String path=res.getPath();
//            FileReader file=new FileReader(path);
//            pro.load(file);
            //用字节输入流服务器报错
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            InputStream is=JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.获取DataSource
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    public static void close(ResultSet resultSet,Statement statement, Connection conn){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement statement, Connection conn){
    close(null,statement,conn);
    }










}
