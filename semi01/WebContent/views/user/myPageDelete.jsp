<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    #myPage-body {
        width: 100%;
        height: 80%;
        background-color: white;
        border-radius: 20px;
    }
    #myPage-footer {
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
    #myPage-title {
        /* border: 1px solid red; */
        width: 80%;
        height: 100%;
        margin: auto;
        border-bottom: 2px solid #8c8c8c;
    }
    #myPage-title>h4 {
        color: #202020;
        font-weight: normal;
        line-height: 6;
        /* border: 1px solid red; */
    }
    #myPage-title>h4>span {
        color: #202020;
        font-size: 15px;
    }
    #myPage-content {
        width: 80%;
        height: 100%;
        margin: auto;
        /* border: 1px solid red; */
        line-height: 3;
        margin-top: 10px;
    }
    #myPage-content button {
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
    #myPage-content button:hover {
        opacity: 0.7;
    }
    .form-title {
        color: #707070;
        font-size: 15px;
    }
    .form-content>input {
        color: #202020;
        font-size: 14px;
        /* border-style: none; */
    }
    button {
        background-color: #f8f8f8;
        color: #8c8c8c;
        border-color: #f8f8f8;
        border-radius: 5px;
    }
    .modal-body div {
        text-align: right;
    }
    /* //마이페이지 끝 */
</style>
</head>
<body>
    <%@ include file = "../common/header.jsp" %>
    
    <div class="background">

        <div class="outer">
    
            <%@ include file = "../common/myPageLogo.jsp" %>
    
            <div id="myPage-body">
                
                <%@ include file = "../common/myPageTap.jsp" %>

                <div id="right" class="float">
                    <div id="right-top">
                        <div id="myPage-title">
                            <h4>
                                마이페이지 <span>회원탈퇴</span>
                            </h4>
                        </div>
                    </div>
                    
                    <div id="right-bottom">
                        <div id="myPage-content">
                            <form action="<%= contextPath %>/deleteUserWithPwd.us" method="post">
                            	<input type="hidden" name="userNo" value="<%= loginMember.getUserNo() %>">
                                
                                <input type="password" name="userPwd" size="50" placeholder="비밀번호를 입력해주세요.">
                                
                                <button type="submit" onclick="return checkPwd();">회원탈퇴</button>
                                <button type="button" onclick="history.back();">돌아가기</button>

                            </form>
                        </div>
                    </div>
                    
                </div>

            </div>

            <div id="myPage-footer"></div>
    
        </div>

    </div>

    <script>

        function checkPwd() {

            if("<%= loginMember.getUserPwd() %>" == $("input[name=userPwd]").val()) {
            	
            	alert("그동안 이용해주셔서 감사합니다. 안녕히 가십시오.");
            	
            	return true;
            	
            }
            else {
            	
            	alert("틀린 비밀번호입니다. 다시 입력해 주십시오.");
            	
            	$("input[name=userPwd]").val("");
            	
            	$("input[name=userPwd]").focus();
            	
            	return false;
            	
            }

        }

    </script>

    <%@ include file = "../common/footer.jsp" %>
</body>
</html>