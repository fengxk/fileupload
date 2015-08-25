package org.csdn.action;
import java.io.InputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.csdn.service.FileUploadService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Í¼Æ¬Êä³ö
 * @author closewubq
 *
 */
public class OutPictureAction extends ActionSupport {
 private static final long serialVersionUID = 1L;     
 @Override
 public String execute() throws Exception {
    HttpServletRequest request = ServletActionContext.getRequest(); 
    int id=Integer.parseInt(request.getParameter("id")); 
    FileUploadService service=new FileUploadService(); 
    InputStream in=service.getPicById(id); 
    HttpServletResponse response=ServletActionContext.getResponse(); 
    response.setContentType("image/gif"); 
    int size=in.available(); 
    byte[] image=new byte[size]; 
    in.read(image); 
    ServletOutputStream out=response.getOutputStream(); 
    out.write(image); 
    return null;
 }
}

