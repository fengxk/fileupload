package org.csdn.action;
import java.io.File;
import java.util.List;
import org.csdn.service.FileUploadService;
import org.csdn.vo.Picture;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author closewubq
 */
public class FileUploadAction extends ActionSupport {
 private static final long serialVersionUID = 1L;
 private File file;
 public File getFile() {
  return file;
 }
 public void setFile(File file) {
  this.file = file;
 }
 /**
  * 上传文件
  */
 @Override
 public String execute() {
  FileUploadService fuservice=new FileUploadService();
  if(fuservice.fileUpload(file)){
   List<Picture> list=fuservice.findAll();
   ActionContext cxt=ActionContext.getContext();
   cxt.put("list",list);
   return SUCCESS;
  }else{
   super.addActionError(this.getText("fileupload.fail"));
   return INPUT;
  }
 }
}
