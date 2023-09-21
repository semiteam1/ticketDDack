<%@page import="com.kh.semi01.user.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Review r = (Review)request.getAttribute("r");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<style>
    /* 마이페이지 시작 */
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
    #myReview-body {
        width: 100%;
        height: 80%;
        /* border: 1px solid red; */
        background-color: white;
        border-radius: 20px;
        /* background-color: #f8f8f8; */
        /* background-color: white; */
    }
    #myReview-footer {
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
    #myReview-title {
        /* border: 1px solid red; */
        width: 80%;
        height: 100%;
        margin: auto;
        border-bottom: 2px solid #8c8c8c;
    }
    #myReview-title>h4 {
        color: #202020;
        font-weight: normal;
        line-height: 6;
        /* border: 1px solid red; */
    }
    #myReview-title>h4>span {
        color: #202020;
        font-size: 15px;
    }
    .myReview-content {
        width: 80%;
        height: 300px;
        margin: auto;
        padding-top: 10px;
        padding-bottom: 10px;
        margin-top: 20px;
        /* border: 1px solid red; */
    }
    #content-title {
        padding-top: 5px;
    }
    #content-text {
        padding-top: 20px;
    }
    #content-text>input {
        width: 100%;
        height: 100%;
        text-align: left;
        border: 1px solid #ceccc0;
    }
    .myReview-content button {
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
    .myReview-content button:hover {
        opacity: 0.7;
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
    
            <div id="myReview-body">
                
				<%@ include file = "../common/myPageTap.jsp" %>

                <div id="right" class="float">
                    <div id="right-top">
                        <div id="myReview-title">
                            <h4>
                                마이리뷰 <span>한줄평 수정</span>
                            </h4>
                        </div>
                    </div>
                    
                    <div id="right-bottom">

                        <div class="myReview-content" align="center">
                            
                            <form action="<%= contextPath %>/updateReview.us" method="post">
                            <input type="hidden" name="reviewNo" value="<%= r.getReviewNo() %>">

                                <div id="content-title">
                                    <h4><%= r.getBookedProduct() %></h4>
                                </div>
                                <div id="content-text">
                                    <input name="reviewContent" value="<%= r.getReviewContent() %>">
                                </div>
                                <div align="right">
                                	<button type="button" onclick="history.back();">돌아가기</button>
                                    <button type="submit">작성완료</button>
                                </div>

                            </form>
                            
                        </div>

                    </div>

                </div>

            </div>

            <div id="myReview-footer"></div>
    
        </div>

    </div>

    <%@ include file = "../common/footer.jsp" %>
</body>
</html>