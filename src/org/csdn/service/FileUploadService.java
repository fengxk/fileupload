package org.csdn.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.csdn.connection.GetConnection;
import org.csdn.vo.Picture;
/**
 * @author closewubq
 */
public class FileUploadService {

 /**
  * 上传图片到数据库
  * @param flie
  * @return boolean
  *         上传是否成功
  */
 public boolean fileUpload(File flie) {
  FileInputStream in = null;
  Connection conn = null;
  PreparedStatement ps = null;
  try {
   in = new FileInputStream(flie);
   String sql = "insert into savepicture(picture) value(?)";
   conn = GetConnection.getConn();
   if (conn == null) {
    System.out.println("连接为null");
    return false;
   }
   ps = conn.prepareStatement(sql);
   ps.setBinaryStream(1, in, in.available());
   if (ps.executeUpdate() > 0) {
    GetConnection.close(conn, ps, null);
    return true;
   } else {
    GetConnection.close(conn, ps, null);
    return false;
   }
  } catch (Exception e) {
   System.out.println(e.getMessage());
   GetConnection.close(conn, ps, null);
   return false;
  }
 }

 /**
  * 检索所有图片
  * @return list
  *        返回所有图片记录
  */
 public List<Picture> findAll() {
  List<Picture> list = new ArrayList<Picture>();
  Picture pic = null;
  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  try {
   String sql = "select id from savepicture";
   conn = GetConnection.getConn();
   if (conn == null) {
    System.out.println("连接为null");
    return null;
   }
   ps = conn.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    pic = new Picture();
    pic.setId(rs.getInt("id"));
    list.add(pic);
   }
   GetConnection.close(conn, ps, rs);
   return list;
  } catch (Exception e) {
   e.printStackTrace();
   GetConnection.close(conn, ps, rs);
   return null;
  }

 }

 /**
  * 根据图片ID获取流对象
  * @param id
  * @return InputStream
  */
 public InputStream getPicById(int id) {
  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  InputStream is = null;
  try {
   String sql = "select picture  from savepicture where id=?";
   conn = GetConnection.getConn();
   ps = conn.prepareStatement(sql);
   ps.setInt(1, id);
   rs = ps.executeQuery();
   if(rs.next()){
    is = rs.getBinaryStream("picture");
    GetConnection.close(conn, ps, rs);
    return is;
   }
   GetConnection.close(conn, ps, rs);
   return null;
  } catch (Exception ex) {
   ex.printStackTrace();
   GetConnection.close(conn, ps, rs);
   return null;
  }
 }

}


