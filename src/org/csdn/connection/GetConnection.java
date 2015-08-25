package org.csdn.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ��ȡ���ݿ�����
 * @author closewubq
 */
public class GetConnection {
 
 /**
  * ��ȡ���ݿ�����
  * @return Connection
  *         �������ݿ�����
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
  * �ر������ͷ���Դ
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

