<%@page import="com.kh.semi01.user.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.semi01.common.model.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    /* 마이페이지 시작 */
    
    .float {
        float: left;
        height: 100%;
    }
    #left {
        width: 20%;
        padding-top: 40px;
        border-right: 2px solid #f8f8f8;
        /* border: 1px solid red; */
    }
    .tab {
        width: 100%;
        height: 10%;
        text-align: center;
        line-height: 5;
        font-size: 15px;
        font-weight: bold;
        color: #202020;
        /* border: 1px solid red; */
    }
    .tab:hover {
        cursor: pointer;
        opacity: 0.5;
    }
    .tab-inner {
        display: none;
        text-align: center;
        line-height: 2;
        font-size: 12px;
        color: #707070;
    }
    .tab-inner:hover {
        cursor: pointer;
        opacity: 0.5;
    }
    /* //마이페이지 끝 */
</style>
</head>
<body>
    
	<div id="left" class="float">

        <div class="tab">마이페이지</div>
        <div class="tab-inner" onclick="myMenu(1);">회원정보조회</div>
        <div class="tab">마이티켓</div>
        <div class="tab-inner" onclick="myMenu(2);">예매조회</div>
        <div class="tab">마이리뷰</div>
        <div class="tab-inner" onclick="myMenu(3);">한줄평조회</div>
        <div class="tab-inner" onclick="myMenu(4);">한줄평작성</div>
        <div class="tab">마이등급</div>
        <div class="tab-inner" onclick="myMenu(5);">등급조회</div>
        <div class="tab">마이라이크</div>
        <div class="tab-inner" onclick="myMenu(6);">좋아요조회</div>

    </div>

    <script>

        $(".tab").click(function() {
                    
            $(this).nextUntil(".tab").slideToggle();

        });

        function myMenu(num) {
        	
        	switch(num) {
        	case 1 :
        		location.href = "/semi01/myPage.us";
        		break;
        	case 2 :
        		location.href = "/semi01/myTicket.us?cpage=1";
        		break;
        	case 3 :
        		location.href = "/semi01/myReview.us?cpage=1";
        		break;
        	case 4 :
        		location.href = "/semi01/myTicketWithoutReview.us?cpage=1";
        		break;
        	case 5 :
        		location.href = "/semi01/myLevel.us";
        		break;
        	case 6 :
        		location.href = "/semi01/myLike.us?cpage=1";	
        	}

        }

    </script>
    
</body>
</html>