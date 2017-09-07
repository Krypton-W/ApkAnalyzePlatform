<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传APK文件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <script type="text/javascript">

$(document).ready(function(){

$("#form0").submit(function() {

var filepath=$("input[name='myFile']").val();

        var extStart=filepath.lastIndexOf(".");

        var ext=filepath.substring(extStart,filepath.length).toUpperCase();

        if(ext!=".BMP"&&ext!=".PNG"&&ext!=".GIF"&&ext!=".JPG"&&ext!=".JPEG"){

         alert("图片限于bmp,png,gif,jpeg,jpg格式");

         return false;

        }

       

   var img=new Image();

   img.src=filepath;  

while(true){

   if(img.fileSize>0){

   if(img.fileSize>3*1024){      

alert("图片不大于300KB。");

return false;

   }

       break;

   }

}

   return true;     

});

});

</script>
    	<h3>上传apk文件</h3>
    	<form method="post" enctype="multipart/form-data" action="/uploadServlet">
    		选择一个文件	<input type="file" name="uploadFile">
    		<br/>
    		<input type="submit" value="上传">
    	</form>
    
  </body>
</html>
