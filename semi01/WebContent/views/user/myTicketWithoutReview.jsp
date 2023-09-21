<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.kh.semi01.user.model.service.UserService"%>
<%@page import="com.kh.semi01.user.model.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.semi01.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	Date today = new Date();
	
	String date2 = sdf.format(today);
	
	today = sdf.parse(date2);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<style>
    /* 마이티켓 시작 */
    div {
        /* border: 1px solid red; */
    }
    .background {
        background-color: #f8f8f8;
        height: 800px;
        /* border: 1px solid red; */
    }
    .outer {
        /* border: 1px solid red; */
        /* background-color: #f8f8f8; */
        /* background-color: #f8f8f8; */
        width: 50%;
        height: 100%;
        margin: auto;
    }
    #myTicket-body {
        width: 100%;
        height: 80%;
        background-color: white;
		border-radius: 20px;
    }
    #myTicket-footer {
        width: 100%;
        height: 5%;
    }
    #right {
        width: 80%;
        /* border: 1px solid red; */
    }
    #right-top {
        width: 100%;
        height: 15%;
        /* border: 1px solid red; */
    }
    #right-bottom {
        width: 100%;
        height: 85%;
        /* border: 1px solid red; */
    }
    #myTicket-title {
        /* border: 1px solid red; */
        width: 80%;
        height: 100%;
        margin: auto;
        border-bottom: 2px solid #8c8c8c;
    }
    #myTicket-title>h4 {
        color: #202020;
        font-weight: normal;
        line-height: 6;
        /* border: 1px solid red; */
    }
    #myTicket-title>h4>span {
        color: #202020;
        font-size: 15px;
    }
    .myTicket-content {
        width: 80%;
        height: 200px;
        margin: auto;
        /* border: 1px solid blue; */
        line-height: 3;
        border-bottom: 1px solid #ceccc0;
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .myTicket-content div {
        height: 100%;
        float: left;
    }
    .content-img {
        width: 30%;
        padding-right: 10px;
    }
    .content-img>a {
        width: 100%;
        height: 100%;
    }
    .content-img>a>img {
        width: 100%;
        height: 180px;
    }
    .content-img>a>img:hover {
        width: 100%;
        height: 180px;
        opacity: 0.7;
    }
    .content-text {
        width: 60%;
    }
    .content-text>table {
    	line-height: 3;
    }
    .content-text a {
    	font-size:13px;
    }
    .content-text a:hover {
    	opacity: 0.5;
    }
    .content-delete {
        width: 10%;
        text-align: right;
    }
    .content-delete>button {
        background-color: white;
        border-color: white;
    }
    .content-delete>button:hover {
    	cursor: pointer;
    	opacity: 0.5;
    }
    .form-title {
        color: #707070;
        font-size: 15px;
    }
    .form-content>input {
        color: #202020;
        font-size: 14px;
        border-style: none;
    }
    .myTicket-content button, .paging-area>button {
        margin: 10px;
        display: inline;
        height: 35px;
        padding: 0 12px;
        line-height: 32px;
        border-radius: 3px;
        border: 1px solid #bbb;
        box-sizing: border-box;
        background-color: #f9f9f9;
        text-decoration: none;
        text-align: center;
        font-size: 13px;
        color: #202020;
    }
    .myTicket-content button:hover {
        opacity: 0.7;
    }
    .paging-area {
        margin-top: 40px;
    }
    /* //마이페이지 끝 */
</style>
</head>
<body>
    <%@ include file = "../common/header.jsp" %>
    
    <div class="background">

        <div class="outer">
    
            <%@ include file = "../common/myPageLogo.jsp" %>
    
            <div id="myTicket-body">
                
				<%@ include file = "../common/myPageTap.jsp" %>

                <div id="right" class="float">
                    <div id="right-top">
                        <div id="myTicket-title">
                            <h4>
                                마이리뷰 <span>한줄평 작성</span>
                            </h4>
                        </div>
                    </div>
                    
                    <div id="right-bottom">
                    
                    <% if(list.isEmpty()) { %>
                    	
                    	<br><br>
						<div align="center">한줄평을 작성할 예매내역이 없습니다.</div>
						
					<% } else { %>	
					
						<% for(Book b : list) { %>
                    		
	                       <div class="myTicket-content">
	
								<form action="<%= contextPath %>/deleteTicket.us" method="post">
								<input type="hidden" name="bno" value="<%= b.getBookedNo() %>">
	
	                            <div class="content-img">
	                                <a href="<%= contextPath %>/detail.pr?pno=<%= b.getProductNo() %>"><img src="<%= b.getTitleImg() %>"></a>
	                            </div>
	
	                            <div class="content-text">
	                                <table>
	                                    <tr>
	                                        <td class="form-title" width="100">공연 제목</td>
	                                        <td class="form-content"><%= b.getProduct() %></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="form-title">공연 장소</td>
	                                        <td class="form-content"><%= b.getAddress() %></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="form-title">공연 일시</td>
	                                        <td class="form-content"><%= b.getScreenDate() %></td>
	                                    </tr>
	                                    <% if(sdf.parse((b.getScreenDate().substring(0, b.getScreenDate().indexOf("("))) + b.getScreenDate().substring(b.getScreenDate().indexOf(")") + 1)).compareTo(today) < 0) { %>
		                                    <tr>
	                                    		<td><a href="<%= contextPath %>/reviewWriteForm.us?bno=<%= b.getBookedNo() %>">한줄평쓰기</a></td>
		                                    </tr>
	                                    <% } %>
	                                </table>
	                            </div>
	
	                            <div class="content-delete">
	                                <button class="close" type="submit" onclick="return ticketDelete();"><img style="width: 40px; height: 40px;" src="resource/이미지자료/close.png"></button>
	                            </div>
	                            
	                            </form>
	                            
	                   		</div>
                   		
        					<% } %>
                        
                        <% } %>
                        
                 	   <script>

                           function ticketDelete() {
   
                               return confirm("예매내역을 삭제하시겠습니까?");
   
                           }
   
                       </script>
                        
                       <div class="paging-area" align="center">
                       <% if(!list.isEmpty()) { %>
                           <% if(pi.getCurrentPage() != 1) { %>
			            		<button onclick="location.href='<%= contextPath %>/myTicketWithoutReview.us?cpage=<%= pi.getCurrentPage() - 1 %>'">&lt;</button>
			            	<% } %>
			            
			            	<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            	<% if(p == pi.getCurrentPage()) { %>
				            		<button disabled style="background-color: #cecece; color: #707070"><%= p %></button>
				            	<% } else { %>
				            		<button onclick="location.href='<%= contextPath %>/myTicketWithoutReview.us?cpage=<%= p %>'"><%= p %></button>
				            	<% } %>
				            <% } %>
				            
				            <% if(pi.getCurrentPage() != pi.getMaxPage()) { %>
				            	<button onclick="location.href='<%= contextPath %>/myTicketWithoutReview.us?cpage=<%= pi.getCurrentPage() + 1 %>'">&gt;</button>
				            <% } %>
			        	<% } %>    
                       </div>
                        
                    </div>
                    
                </div>

            </div>

            <div id="myTicket-footer"></div>
    
        </div>

    </div>

    <%@ include file = "../common/footer.jsp" %>
</body>
</html>