<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <title>File Upload</title>
  <link href="<%=request.getContextPath()%>/css/fileupload.css"
   rel="stylesheet" type="text/css">
 </head>
 <body bgcolor="#cccccc">
  <div style="padding-top: 30px; padding-left: 30px">
   <fieldset
    style="width: 600px; border-color: #000000; padding-left: 10px">
    <legend>
     <font size="-1" color="#000000"><b>上传图片</b> </font>
    </legend>
    <div class="ErrorDiv">
       <s:fielderror/>
     <s:actionerror/>
    </div>
    <s:form action="fileUpload.action" method="post" theme="simple"
     enctype="multipart/form-data">
     <table border="1" width="500px">
      <tr>
       <td class="tableTDCenter">
        图片路径：
       </td>
       <td class="tableTDCenter">
        <s:file name="file" cssClass="fileInput"/> 
       </td>
      </tr>
      <tr>
       <td class="tableTDCenter" colspan="2">
        <s:submit value="提交" cssClass="button"></s:submit>
       </td>
      </tr>
     </table>
    </s:form>
   </fieldset>
  </div>
 </body>
</html>
