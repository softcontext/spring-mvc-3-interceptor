<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false"%> --%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>jAcademy</title>
	<script src="${pageContext.request.contextPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
		$(function(){
			//alert("jQuery-ready-for-use!")
			//var msg = '${msg}';
			console.log('<c:out value="${msg}"/>');
			//if (msg !== null && msg.length !== 0) {
			//	alert(msg);
			//}
			
			var notice = '<c:out value="${notice}"/>';
			if(notice !== null && notice.length !== 0){
				alert(notice);
			}
		});
	</script>
</head>
<body>
	<h1>Hello world!</h1><c:out value="${msg }"></c:out>

	<P>The time on the server is ${serverTime}.</P>
	<hr>
	
	userid: ${userid }
	<hr>
	
	<a href="login?action=login">login/login_form.jsp</a><br>
	<a href="admin?action=member">admin/member_list.jsp</a><br>
	<a href="board?action=list">board/board_list.jsp</a><br>
	
</body>
</html>
