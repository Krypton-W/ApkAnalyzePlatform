<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.Query" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="java.util.List" %>
<%@ page import="com.analysis.hibernate.Message"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
<head>
	<meta charset="utf-8"> 
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
    <title>DashBoard</title>

    <!-- CORE CSS-->    
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection">

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="FusionCharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="FusionCharts/js/themes/fusioncharts.theme.fint.js"></script>

<style>
	html{height:100%;}
body{min-height:100%;margin:0;padding:0;position:relative;}

header{background-color: #ffe4c4;}
main{padding-bottom:100px;background-color: #bdb76b;}/* main的padding-bottom值要等于或大于footer的height值 */
footer{position:absolute;bottom:0;width:100%;height:100px;background-color: #ffc0cb;}
</style>
</head>

<body>
		<!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    
    <!-- Start Page Loading -->
    <!--<div id="loader-wrapper">
        <div id="loader"></div>        
        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>
    </div>-->
    <!-- End Page Loading -->

    <!-- //////////////////////////////////////////////////////////////////////////// -->
    
  
    <!-- START HEADER -->
    <header id="header" class="page-topbar">
        <!-- start header nav-->
        <div class="navbar-fixed">
            <nav class="cyan">
                <div class="nav-wrapper">
                    <h4 class="logo-wrapper">AnalyzeSystem</h4>
                </div>
            </nav>
        </div>
        <!-- end header nav-->
    </header>
    <!-- END HEADER -->

    <!-- //////////////////////////////////////////////////////////////////////////// -->
    <!-- START MAIN -->
    <div id="main">
        <!-- START WRAPPER -->
        <div class="wrapper">

            <!-- START LEFT SIDEBAR NAV-->
            <aside id="left-sidebar-nav">
                <ul id="slide-out" class="side-nav fixed leftside-navigation">
                    <li class="user-details cyan darken-2">
                        <div class="row">
                            <div class="col col s8 m8 l8">
                            
                            <!--选项-->
                         
                                <!--用户名-->
                                <a class="btn-flat dropdown-button waves-effect waves-light white-text profile-btn" data-activates="profile-dropdown">John Doe</a>
                                
                                <!--用户权限-->
                                <p class="user-roal">管理员</p>              
                                
                            </div>
                        </div>
                    </li>
                    <li class="bold"><a href="dashboard.jsp" class="waves-effect waves-cyan"><i class="material-icons">toc</i> 控制台</a>
                    </li>
                    <li class="bold"><a href="upload.jsp" class="waves-effect waves-cyan"><i class="material-icons">present_to_all</i> 文件上传</a>
                    </li>
                    <li class="bold active teal lighten-4"><a href="message.jsp" class="waves-effect waves-cyan"><i class="material-icons">message</i>消息通知 <span class="new badge">4</span></a>
                    </li>
                    <li class="bold"><a href="statistic.jsp" class="waves-effect waves-cyan"><i class="material-icons">assessment</i> 统计管理</a>
                    </li>
                    <li class="bold"><a href="usermanager.jsp" class="waves-effect waves-cyan"><i class="material-icons">perm_identity</i> 用户管理</a>
                    </li>
                    <li class="bold"><a href="search.jsp" class="waves-effect waves-cyan"><i class="material-icons">search</i> 查找</a>
                    </li>

                    <li class="li-hover"><div class="divider"></div></li>
                    <li class="li-hover"><p class="ultra-small margin more-text">MORE</p></li>
                    <li><a href="setting.jsp"><i class="material-icons">info</i> 设置</a>
                    </li> 
                    <li><a href="help.jsp"><i class="material-icons">star</i>帮助</a>
                    </li>                  
                    <li>
                    <a href="aboutus.jsp"><i class="material-icons">turned_in</i>关于我们</a>
                    </li>
                    <li class="li-hover"><div class="divider"></div></li>
                    
                    
                    <!--登录统计-->
                    <li class="li-hover"><p class="ultra-small margin more-text">登录统计</p></li>
                    <li class="li-hover">
                        <div class="row">
                            <div class="col s12 m12 l12">
                                <div class="sample-chart-wrapper">                            
                                    <div class="ct-chart ct-golden-section" id="ct2-chart"></div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </aside>
            <!-- END LEFT SIDEBAR NAV-->

            <!-- //////////////////////////////////////////////////////////////////////////// -->

            <!-- START CONTENT -->
            <section id="content">

                <!--start container-->
                <div class="container popout">
                	 <ul class="collapsible" data-collapsible="accordion">
                	 <%
                	    Configuration conf = new Configuration().configure();
						//2 根据配置信息,创建 SessionFactory对象
						SessionFactory sf = conf.buildSessionFactory();
						//3 获得session
						Session session2 = sf.openSession();
						//4 session获得操作事务的Transaction对象
						//获得操作事务的tx对象
						//Transaction tx = session.getTransaction();
						//开启事务并获得操作事务的tx对象(建议使用)
						Transaction tx2 = session2.beginTransaction();
						//----------------------------------------------
						Message message = new Message();  
				        Query q = session2.createQuery("from Message where receiver_id=?");  
				        q.setString(0, "1");  
				        List<Message> list=q.list();
				        if(list.size()>0)
				        { 
				        	 for(int i=0;i<list.size();i++)
				        	 { %>
				        		 <li>
								      <div class="collapsible-header"><i class="material-icons">message</i>来自<%list.get(i).getSenderId(); %></div>
								      <div class="collapsible-body"><p><%list.get(i).getContent(); %></p></div>
								 </li>
				        	<% }
				        }
                	  %>
					</ul>
                

                </div>
                <!--end container-->
            </section>
            <!-- END CONTENT -->

            <!-- //////////////////////////////////////////////////////////////////////////// -->
            

        </div>
        <!-- END WRAPPER -->

    </div>
    <!-- END MAIN -->



    <!-- //////////////////////////////////////////////////////////////////////////// -->

    <!-- START FOOTER -->
    <footer class="page-footer">
          <div class="container">
             Copyright MonsterFucker Team © 2017   All rights reserved.
          </div>
          <div class="footer-copyright">
            <div class="container">
            © Design and Developed by MonsterFucker
            </div>
          </div>
        </footer>
    <!-- END FOOTER -->

</body>

</html>
