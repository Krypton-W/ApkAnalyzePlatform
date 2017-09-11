<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Query" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="java.util.List" %>
<%@ page import="com.analysis.hibernate.Message"%>
<%@ page import="com.analysis.message.demo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<!-- Head -->
<head>

	<title>ApkAnalyzeSystem</title>


</head>
<!-- //Head -->

<!-- Body -->
<body>


   <%
                	   demo temp=new demo();
                	   List<Message> list=temp.getmessage();
                	   for(int i=0;i<list.size();i++)
				        	 { %>
				        		 <li>
								      <div class="collapsible-header"><i class="material-icons">message</i>来自<%list.get(i).getSenderId(); %></div>
								      <div class="collapsible-body"><p><%list.get(i).getContent(); %></p></div>
								 </li>
				        	<% }
				        
                	  %>

</body>
<!-- //Body -->

</html>