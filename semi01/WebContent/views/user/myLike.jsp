<%@page import="com.kh.semi01.product.model.vo.ProductLike"%>
<%@page import="com.kh.semi01.user.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.semi01.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	ArrayList<ProductLike> list = (ArrayList<ProductLike>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<style>
    /* 마이페이지 시작 */
    div {
        /*border: 1px solid red;*/
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
    #myLike-body {
        width: 100%;
        height: 80%;
        /* border: 1px solid red; */
        background-color: white;
        border-radius: 20px;
        /* background-color: #f8f8f8; */
        /* background-color: white; */
    }
    #myLike-footer {
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
    #myLike-title {
        /* border: 1px solid red; */
        width: 80%;
        height: 100%;
        margin: auto;
        border-bottom: 2px solid #8c8c8c;
    }
    #myLike-title>h4 {
        color: #202020;
        font-weight: normal;
        line-height: 6;
        /* border: 1px solid red; */
    }
    #myLike-title>h4>span {
        color: #202020;
        font-size: 15px;
    }
    .myLike-content {
        width: 80%;
        height: 200px;
        margin: auto;
        /*border: 1px solid red;*/
        border-bottom: 1px solid #ceccc0;
        padding-top: 10px;
        padding-bottom: 10px;
    }
    .myLike-content div {
        height: 100%;
        float: left;
    }
    .content-img {
        width: 30%;
        padding-right: 10px;
    }
    .content-img>a {
        width: 100%;
    }
    .content-img>a>img {
        width: 100%;
        height: 180px;
    }
    .content-img>a>img:hover {
        opacity: 0.7;
    }
    .content-text {
        width: 60%;
        padding-top: 10px;
    }
    .content-text>table {
    	line-height: 3;
    }
    .content-text button:hover {
    	opacity: 0.5;
    }
    .content-text p {
    	font-size: 12px;
        margin-bottom: 0;
    }
    .content-delete {
        width: 10%;
        text-align: right;
    }
    #like_btn {
        background-color: white;
        border: none;
    }
    #like_btn:hover {
    	cursor: pointer;
    	opacity: 0.7;
    }
    .paging-area>button {
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
    .paging-area {
        margin-top: 40px;
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
    /* //마이페이지 끝 */
</style>
</head>
<body>
    <%@ include file = "../common/header.jsp" %>
    
    <div class="background">

        <div class="outer">
    
            <%@ include file = "../common/myPageLogo.jsp" %>
    
            <div id="myLike-body">
                
				<%@ include file = "../common/myPageTap.jsp" %>

                <div id="right" class="float">
                    <div id="right-top">
                        <div id="myLike-title">
                            <h4>
                                마이라이크 <span>좋아요 목록 조회</span>
                            </h4>
                        </div>
                    </div>
                    
                    <div id="right-bottom">

						<% if(list.isEmpty()) { %>
						
							<br><br>
							<div align="center">좋아요 한 내역이 없습니다.</div>
							
						<% } else { %>
						
							<% for(ProductLike pl : list) { %>
						
                                <div class="myLike-content">

	                                 <div class="content-img">
	                                     <a href="<%= contextPath %>/detail.pr?pno=<%= pl.getProduct_no() %>"><img src="<%= pl.getTitleImg() %>"></a>
	                                 </div>
	                                 <div class="content-text">
	                                     <table>
	                                         <tr>
	                                             <th colspan="3">
	                                                 <h5><%= pl.getProductTitle() %></h5>
	                                             </th>
	                                         </tr>
	                                     </table>
	                                 </div>
                                            
									 <div class="content-delete">
									 	<form action="<%= contextPath %>/deleteMyLike.us" method="post">
									 		<input type="hidden" name="userNo" value="<%= loginMember.getUserNo() %>">
									 		<input type="hidden" name="productNo" value="<%= pl.getProduct_no() %>">
	                                   	 	<button type="submit" id="like_btn" onclick="return deleteLike();"><img style="width: 40px; height: 40px;" src="resource/이미지자료/류지완 샘플이미지/풀하트.png"></button>
									 	</form>
                                     </div>
			                            
                                </div>
	                        	
                        	<% } %>
                        
                       	<% } %>
                       	
                    	<script>
                                	
	                      	function deleteLike() {
	                      		
	                      		$(this).children().attr("src", "resource/이미지자료/류지완 샘플이미지/빈하트.png");
	                      		
	                      		return confirm("좋아요한 내역을 삭제하시겠습니까?");
	                      		
	                      	}
                               
                        </script>
                        
                        <div class="paging-area" align="center">
                        <% if(!list.isEmpty()) { %>
                            <% if(pi.getCurrentPage() != 1) { %>
				            	<button onclick="location.href='<%= contextPath %>/myLike.us?cpage=<%= pi.getCurrentPage() - 1 %>'">&lt;</button>
				            <% } %>
				            
				            <% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            	<% if(p == pi.getCurrentPage()) { %>
				            		<button disabled style="background-color: #cecece; color: #707070"><%= p %></button>
				            	<% } else { %>
				            		<button onclick="location.href='<%= contextPath %>/myLike.us?cpage=<%= p %>'"><%= p %></button>
				            	<% } %>
				            <% } %>
				            
				            <% if(pi.getCurrentPage() != pi.getMaxPage()) { %>
				            	<button onclick="location.href='<%= contextPath %>/myLike.us?cpage=<%= pi.getCurrentPage() + 1 %>'">&gt;</button>
				            <% } %>
				        <% } %>    
                        </div>

                    </div>

                </div>

            </div>

            <div id="myLike-footer"></div>
    
        </div>

    </div>

    <%@ include file = "../common/footer.jsp" %>
</body>
</html>