<%@page import="com.kh.semi01.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sKeyWord = (String)request.getAttribute("sKeyWord");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:900px;
		height:500px;
		margin-left: 350px;
	}

	#li1{
		font-size: 12px;
		color: gray;
		line-height: 22px;
	}
	
	.result{
		color:red;
		float:left;
	}

</style>
</head>
<body>
	<%@ include file = "/views/common/header.jsp" %>
	<br><br><br>
	<div class="outer">
		<ul class="errorMsg">
			<li style="list-style: none;"><h4 class="result"><%= "'" + sKeyWord + "'" %>&nbsp;&nbsp;</h4>
										  <h4><%= request.getAttribute("errorMsg") %></h4></li>
			<br>
			<li id="li1">단어의 철자가 정확한지 확인해보세요.</li>
			<li id="li1">한글을 영어로, 영어를 한글로 입력했는지 확인해보세요.</li>
			<li id="li1">정확한 상품명을 모를 경우, 상품명 일부만으로 검색해보세요.</li>
		</ul>
	</div>
	
	<%@ include file = "/views/common/footer.jsp" %>
</body>
</html>