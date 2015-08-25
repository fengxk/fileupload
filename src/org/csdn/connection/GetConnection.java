package org.csdn.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 获取数据库链接
 * @author closewubq
 */
public class GetConnection {
 
 /**
  * 获取数据库连接
  * @return Connection
  *         返回数据库连接
  */
 public static Connection getConn() {
  try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   String url = "jdbc:mysql://localhost:3306/test?user=root&password=";
   Connection connection = DriverManager.getConnection(url);
   return connection;
  } catch (Exception e) {
   e.printStackTrace();
   return null;
  }
 }
 
 /**
  * 关闭连接释放资源
  * @param conn
  * @param rs
  * @param st
  */
 public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
  if(rs!=null)
   try {
    rs.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if(ps!=null)
   try {
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if(conn!=null)
   try {
    conn.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  
 }

}

