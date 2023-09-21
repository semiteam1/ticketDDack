<%@page import="com.kh.semi01.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Notice n	=(Notice)request.getAttribute("n");
	//글번호 글제목 내용 작성자 아이디 작성일
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background-color: #f8f9fa;
        border-radius: 30px; 
        color: black;
        width:1000px;
        height: 500px;
        margin: auto;
        margin-top : 50px;
    }
</style>

</head>
<body>
<%@ include file = "../common/header.jsp" %>
<div class="outer" align="center">
        <br>
        <h2 align="center">공지사항 상세보기</h2>
        <br>

        <table id="detail-area" border="1">
            <tr>
                <th width="70">제목</th>
                <td colspan="3" width="430"><%= n.getNoticeTitle() %></td>
                
            </tr>
            <tr>
                <th>번호</th>
                <td><%= n.getNoticeNo() %></td>
                <th>작성일</th>
                <td><%= n.getNoticeDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <pre style="height: 150px;"><%=n.getNoticeContent() %></pre>
                </td>
            </tr>
        </table>
        <br><br>

        <div>
            <button onclick="location.href='<%=contextPath %>/list.no'">목록가기</button>
            <!-- 현재 로그인한 사용자가 해당 글을 쓴 본인일 경우-->
            <% if(loginMember != null && loginMember.getUserId().equals("admin") ){ %>
            
            <button onclick="location.href='<%=contextPath %>/updateForm.no?num=<%=n.getNoticeNo() %>'">수정하기</button>
            <button onclick="location.href='<%= contextPath %>/delete.me.no?num=<%=n.getNoticeNo() %>'">삭제하기</button>
            
            <!-- 
            	삭제 구현 해보기
            	url-mapping 맘대로
            	
            	요청 성공시 => 공지사항 목록페이지 alert(공지사항이 성공적으로 삭제됐습니다.)
            	요청 실패시 => 에러문구 보여지는 에러페이지            
             -->
            <% } %>
        </div>
    </div>
    <%@ include file = "../common/footer.jsp" %>
</body>
</html>