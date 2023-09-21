<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
    String alertMsg =(String)session.getAttribute("alertMsg");
%>
<!--  로그인 화면 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓딱대 로그인</title>
    <style>
        .head_logo{
            /* border: 1px solid; */
            width: 458px;
            height: 70px;
            margin: auto;
            margin-top: 100px;
        }
        .logo{width: 155px;height: 100%;margin: auto;}
        .logo *{width: 100%;height: 100%;}
        .body{width: 458px;height: 300px; margin: auto; margin-top: 40px; border: 1px solid rgba(128, 128, 128, 0.603); border-radius: 8px;}
        .body_input{
            border: 1px solid rgba(128, 128, 128, 0.603);
            width: 402px;
            height: 95px;
            margin: auto;
            margin-top: 25px;
            border-radius: 5px;
        }
        .body_input>div{width: 100%;height: 50%;}
        .pass{border-top: 1px solid rgba(128, 128, 128, 0.603);}
        #login_img{width: 20px;height: 20px; margin-top: 13px; margin-left: 13px; float: left;}
        #userId{border: 0; height: 19px;  width: 342px; margin-top: 14px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}
        #userId::placeholder {
            opacity: 0.5; /* 흐리게 만들기 */
        }
        #login{
            width: 402px;
            height: 52px;
            margin-left: 28px;
            margin-top: 45px;
            border-radius: 10px;
            border: 0;
            background-color: rgba(252, 27, 27, 0.897);
            color: white;
            font-weight: 900;
            font-size: 20px;
        }
        #login:hover{
            cursor: pointer;
        }
        .find_id_pwd{
            /* border: 1px solid; */
            width: 300px;
            height: 30px;
            margin-left: 82px;
            margin-top: 20px;
        }
        .find_id_pwd div{float: left;}
        .blank{border: 1px solid gray; width: 0px;height: 60%;margin-left: 10px; margin-top: 7px; margin-right: 10px;}
        .find{margin-top: 5px; float: left;}
        .find_id_pwd a{text-decoration: none; color: gray; font-size: 14px;}
        .etc{width: 460px; height: 300px;  margin: auto; margin-top: 70px; }
        .event{width: 460px;height: 176px;}
        #event_img{width: 100%;height: 100%;}
        #event_img:hover{cursor: pointer;}
        #etc{margin-left: 10px; margin-top: 40px; font-size: 13px; color: rgba(128, 128, 128, 0.658); }
    </style>
</head>
<body>
    <% if(alertMsg != null) { %> 
		
		<script>
			alert("<%= alertMsg %>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
		
	<% } %>
    <head>
        <div class="head_logo">
            <div class="logo"><a href="<%=contextPath %>"><img src="resource/logo/logo.png" alt=""></a></div>
        </div>
    </head>
    <body>
        <form action="<%=contextPath%>/login.me">
            <div class="body">
                <div class="body_input">
                    <div class="id">
                        <img src="resource/이미지자료/로그인.png" id="login_img">
                        <div class="userId_box">
                            <input type="text" id="userId" name="userId" placeholder="아이디" required>
                        </div>
                    </div>
                    <div class="pass">
                        <img src="resource/이미지자료/비밀번호.png" id="login_img">
                        <div class="userId_box">
                            <input type="password" id="userId" name="userPwd" placeholder="비밀번호" required>
                        </div>
                    </div>
                </div>
                <button id="login">로그인</button>
                <div class="find_id_pwd">
                    <div class="find"><a href="<%=contextPath %>/findPwd.ur">비밀번호 찾기</a></div>
                    <div class="blank"></div>
                    <div class="find"><a href="<%=contextPath %>/findId.ur">아이디 찾기</a></div>
                    <div class="blank"></div> 
                    <div class="find"><a href="<%=contextPath %>/newUser.ur">회원가입</a></div>
                </div>
            </div>
        </form>
        <div class="etc">
            <div class="event">
                <img src="resource/이미지자료/이벤트.png" alt="" id="event_img" onclick="hing();">
            </div>
            <div id="etc">
                이용약관 | 개인정보처리방침 | 책임의 한계와 법적고지 | 회원정보 고객센터
            </div>

        </div>
    </body>
    <script>
        function hing() {
            alert("힝~ 속았지? >.<");
        }
    </script>

</body>
</html>