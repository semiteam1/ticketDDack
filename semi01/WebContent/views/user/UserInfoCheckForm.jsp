<%@page import="com.kh.semi01.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	int type = (int)request.getAttribute("type");
	User u = (User)request.getAttribute("u");
%>
<!--  아이디 보여주거나 비번 변경 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <title>티켓딱대 아이디 찾기 및 비밀번호 변경</title>
    <style>
        .logo_div{
            /* border: 1px solid; */
            width: 500px;
            height: 100px;
            margin: auto;
        }
        #logo{width: 95px;height: 40px;
               margin-top: 30px;}
        .outer{
            border: 1px solid  rgba(128, 128, 128, 0.603);
            border-radius: 5px;
            width: 500px;
            height: 550px;
            margin: auto;
            margin-top: 50px;
        }
        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 탭메뉴 파트 시작 */

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        

        .tab-content {
            
            padding: 20px;
            /* background-color: gray; */
            margin-top: 200px;
        }

       
        /* 이메일로 찾아라 */

        .tab-content {
            width: 300px;
            margin: auto;
            height: 250px;
            border: 1px solid red;
            border-radius: 10px;
            margin-top: 50px;
            /* display: none; */
            /* padding: 20px; */
            
            
        }

        .id_pwd_input{
            width: 100%;
            height: 100px;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 10px;
            margin-top: 20px;
        }
        .id_pwd_input>div{
            width: 100%;
            height: 50px;
        }
        #new_user{border: none; height: 19px;  width: 80%; margin-top: 16px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}
        #newMember_img{width: 20px;height: 20px; margin-top: 15px; margin-left: 13px; float: left;}
        .id_pwd_input>div{
            width: 100%;
            height: 50px;
        }
        .id_pwd_input{
            width: 100%;
            height: 150px;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 10px;
        }
        input{
            float: left;
        }
        .line{
            border-bottom: 1px solid rgba(128, 128, 128, 0.603);
        }

        #btn_email{
            border: none;
            background-color: red;
            border-radius: 5px;
            width: 256px;
            height: 50px;
            margin-top: 30px;
            color: white;
            font-weight: 900;
            font-size: 15px;
        }
        .find_id_pwd{
            /* border: 1px solid; */
            width: 270px;
            height: 30px;
            margin: auto;
            margin-top: 10px;
        }
        #btn_email:hover{
            cursor: pointer;
            opacity: 0.7;
        }
        .find_id_pwd div{float: left;}
        .blank{border: 1px solid gray; width: 0px;height: 60%;margin-left: 10px; margin-top: 7px; margin-right: 10px;}
        .find{margin-top: 5px; float: left;}
        .find_id_pwd a{text-decoration: none; color: gray; font-size: 14px;}
        .bener{
            /* border: 1px solid rgba(128, 128, 128, 0.603); */
            width: 300px;
            height: 120px;
            margin: auto;
            margin-top: 15px;
        }
        .bener>img{
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 10px;
            width: 100%;
            height: 100%;
        }
        .ur_id_ment{
            /* border: 1px solid; */
            font-weight: 900;
            font-size: 14px;
            margin-top: 0px;
        }
        .ur_id_ment1{
            /* border: 1px solid; */
            font-weight: 900;
            font-size: 14px;
            margin-top: 20px;
        }
        .ur_id_info{
            border: 2px solid red;
            height: 50px;
            margin-top: 30px;
            border-radius: 5px;
        }
        .ur_id{
            /* border: 1px solid; */
            width: 80%;
            height: 23px;
            margin: auto;
            margin-top: 13px;
            font-weight: 900;
            font-size: 15px;
        }
    </style>
</head>
<body>
    <div class="logo_div">
        <a href="<%=contextPath %>"><img src="resource/logo/logo.png" id="logo" alt=""></a>
    </div>
    <form action="<%=contextPath %>/login.ur" method="post">
        <div class="outer">

              <%if(type == 1 || type == 2){ %>
               <div id="tab1" class="tab-content">
                <div class="ur_id_ment1">
                    고객님의 정보와 일치하는 아이디입니다.
                </div>                
                <div class="ur_id_info">
                    <div class="ur_id">
                        <%=u.getUserId() %>
                    </div>
                </div>
                <button type="submit" id="btn_email">로그인하기</button>
              </div> 
              <%}else { %>
    </form>
    <form action="<%=contextPath %>/Changepwd.ur" method="post">

              <div id="tab1" class="tab-content">
                <div class="ur_id_ment">
                    변경하실 비밀번호를 입력해주세요
                </div>         
                <div class="id_pwd_input" style="height: 100px;" >      
                    <div class="line">
                        <img src="resource/이미지자료/비밀번호.png" id="newMember_img">
                            <input type="password" id="new_user"class="userPwd" name="fine_pwd" placeholder="비밀번호" required>
                    </div>
                    <div class="email_input">
                        <img src="resource/이미지자료/비밀번호.png" id="newMember_img">
                        <input type="password" id="new_user" class="userPwdCheck" placeholder="비밀번호 확인" required>
                    </div>
                </div> 
                <input type="hidden" name="userNo" value="<%=u.getUserNo()%>">
                <input type="hidden" name="userId" value="<%=u.getUserId()%>">
                <input type="hidden" name="userPwd" value="<%=u.getUserPwd()%>">
                <button type="button" id="btn_email" class="btn_pwd" onclick="check();">로그인하기</button>
              </div>
				<%} %>

    </form>         

              
                <div class="find_id_pwd" >
                    <div class="find"><a href="<%=contextPath %>/findPwd.ur">비밀번호 찾기</a></div>
                    <div class="blank"></div>
                    <div class="find"><a href="<%=contextPath %>/findId.ur">아이디 찾기</a></div>
                    <div class="blank"></div> 
                    <div class="find"><a href="<%=contextPath %>/newUser.ur">회원가입</a></div>
                </div>

                <div class="bener">
                    <img src="resource/이미지자료/배너2.png">
                </div>

            
            <script>
                
                function check(){

                    let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/
                    var password = $(".userPwd").val();
                    var passwordcheck = $(".userPwdCheck").val();
                  
                    if(!reg.test( $(".userPwd").val() )){ // 비번 틀리다
                        $(".btn_pwd").attr("type","button"); 
                        alert("비밀번호는 영문 숫자 특수기호 조합 8자리 이상이어야 합니다.")
                        $(".userPwd").select()
                      
                    }else { // 비번맞다
                        if(password === passwordcheck){ // 일치
                            $(".btn_pwd").attr("type","submit"); 
                        }else{
                            $(".btn_pwd").attr("type","button"); 
                            alert("비밀번호와 비밀밀번호 확인이 일치하지 않습니다.")
                            passwordcheck.select();
                        }
                    }
                    
                }


            </script>

            

             
              
        </div>
    
</body>
</html>