<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
    String alertMsg =(String)session.getAttribute("alertMsg");
%>
<!--  회원가입 화면 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓딱대 회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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
            /* border: 1px solid; */
            width: 674px;
            height: 860px;
            margin: auto;
            margin-top: 35px;
        }
        .id_pwd_input{
            width: 100%;
            height: 150px;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 10px;
        }
        .id_pwd_input>div{
            width: 100%;
            height: 50px;
        }
        .line{
            border-top: 1px solid rgba(128, 128, 128, 0.603);
            border-bottom: 1px solid rgba(128, 128, 128, 0.603);
        }
        #newMember_img{width: 20px;height: 20px; margin-top: 15px; margin-left: 13px; float: left;}
        #new_user{border: none; height: 19px;  width: 342px; margin-top: 16px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}
        #new_user_pwd{border: none; height: 19px;  width: 342px; margin-top: 16px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}
        .message{
            width: 100%;
            height: 30px;
            /* border: 1px solid; */
        }
        .message_output{
            /* border: 1px solid; */
            /* width: 100%; */
            /* height: 60%; */
            line-height: 30px;
            color: red;
            font-weight: 900;
            font-size: 16px;
            margin: 0;
            
        }
        .info_input{
            width: 100%;
            height: 340px;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 10px;
        }
        .info_input>div{
            width: 100%;
            height: 50px;
        }
        .interest{color: rgba(66, 66, 66, 0.973); font-weight: 700; margin-top: 15px; margin-left: 15px;}
        .interest_box{width: 100%;  line-height: 0px;
            border-top: 2px solid rgba(87, 87, 87, 0.781);
            border-bottom: 1px solid rgba(128, 128, 128, 0.603);
         }
         .tag{line-height: 50px; margin-left: 40px; font-weight: 600; color: rgba(66, 66, 66, 0.973); }
         .choice_box{
            /* border-top:  1px solid rgba(128, 128, 128, 0.603); */
            /* border-bottom: 1px solid rgba(128, 128, 128, 0.603); */
            /* border-left: 1px solid rgba(128, 128, 128, 0.603); */
            width: 120px;
            height: 35px;
            margin-top: 7px ;
            border-radius: 2px;
         }


         #int{
            height: 50px;}
         #int>div{
            float: left;
         }
         #fst{
            margin-left: 40px;
            border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
            
         }
         #last{
            /* border-right:  1px solid rgba(128, 128, 128, 0.603); */
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
         }
        .int_btn_movie{
            width: 100%;height: 100%;
            background-color: white;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 5px;
        }
        .int_btn_display{
            width: 100%;height: 100%;
            background-color: white;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 5px;
        }
        .int_btn_show{
            width: 100%;height: 100%;
            background-color: white;
            border: 1px solid rgba(128, 128, 128, 0.603);
            border-radius: 5px;
        }


        .active {
            border-color: red; /* 빨간색 테두리 */
        }
        button:hover{
            cursor: pointer;
        }
        .submit_box{
            /* border: 1px solid rebeccapurple; */
            border-radius: 5px;
            background-color: red;
            color: white;
            width: 460px;
            height: 50px;
            margin: auto;
            margin-top: 100px;

        }
        .submit_btn{
            width: 100%;
            height: 100%;
            border-radius: 5px;
            background-color: red;
            color: white;
            font-weight: 900;
            font-size: 20px;
            border: none;
            
        }
        .id_input{
            box-sizing: border-box;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
    </style>
</head>
<body>
    <% if(alertMsg != null) { %> 
		
		<script>
			alert("<%= alertMsg %>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
		
	<% } %>
    <div class="logo_div">
        <a href="<%=contextPath %>"><img src="resource/logo/logo.png" id="logo" alt=""></a>
    </div>
    <form action="<%=contextPath %>/insert.ur" method="post">
        <div class="outer">
            <div class="id_pwd_input">
                <div class="id_input">
                    <img src="resource/이미지자료/로그인.png" id="newMember_img">
                        <input type="text" id="new_user" class="new_userId" name="new_userId" placeholder="아이디" required>
                </div>
                <div class="line">
                    <img src="resource/이미지자료/비밀번호.png" id="newMember_img">
                        <input type="password" id="new_user" class="new_userPwd" name="new_userPwd" placeholder="비밀번호" required>
                </div>
                <div class="email_input">
                    <img src="resource/이미지자료/이메일2.png" id="newMember_img">
                    <input type="email" id="new_user" name="new_userEmail" placeholder="[선택] 이메일">
                </div>
            </div>
            <div class="message">
                    <p class="message_output"></p>
            </div>
            <div class="info_input">
                <div class="name_input">
                    <img src="resource/이미지자료/로그인.png" id="newMember_img">
                        <input type="text" id="new_user" class="new_user_name" name="new_userName" placeholder="이름" required>
                </div>
                <div class="line">
                    <img src="resource/이미지자료/달력3.PNG" id="newMember_img">
                        <input type="text" id="new_user_pwd" name="new_userBday" placeholder="생년월일 8자리 [ex)230824]" required>
                </div>
                <div class="phone_input">
                    <img src="resource/이미지자료/phone.jpg" id="newMember_img">
                        <input type="text" id="new_user" class="new_user_phone" name="new_userPhone" placeholder="휴대폰 번호 [010-1234-5678]" required>
                </div>
                <div class="interest_box" style="height: 30px;">
                    <p class="interest">[필수] 관심 카테고리</p>
                </div>


                <div class="int_box" >
                    <div class="int_movie" id="int">
                        <div class="tag">영화</div>
                        <div class="choice_box" id="fst"><button type="button" class="int_btn_movie" id="movie" onclick="selectMovie('1');">로맨스</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_movie" id="movie" onclick="selectMovie('2');">공포/스릴러</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_movie" id="movie" onclick="selectMovie('3');">코미디</button></div>
                        <div class="choice_box" id="last"><button type="button" class="int_btn_movie" id="movie" onclick="selectMovie('4');">액션</button></div>
                    </div>
                    <div class="line" id="int">
                        <div class="tag">전시</div>
                        <div class="choice_box" id="fst"><button type="button" class="int_btn_display" id="paint" onclick="selectDisplay('5');">그림전시</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_display" id="composition" onclick="selectDisplay('6');">작품전시</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_display" id="photo" onclick="selectDisplay('7');">사진전시</button></div>
                        <div class="choice_box" id="last"><button type="button" class="int_btn_display" id="experience" onclick="selectDisplay('8');">체험전시</button></div>
                    </div>
                    <div class="int_movie" id="int">
                        <div class="tag">공연</div>
                        <div class="choice_box" id="fst"><button type="button" class="int_btn_show" id="musical" onclick="selectShow('9');" >뮤지컬</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_show" id="act" onclick="selectShow('10');" >연극</button></div>
                        <div class="choice_box"><button type="button" class="int_btn_show" id="classical" onclick="selectShow('11');" >클래식</button></div>
                        <div class="choice_box" id="last"><button type="button" class="int_btn_show" id="concert" onclick="selectShow('12');" >콘서트</button></div>
                    </div> 
                    <input type="hidden" name="select_movie_hidden" id="select_movie_hidden">
                    <input type="hidden" name="select_display_hidden" id="select_display_hidden">
                    <input type="hidden" name="select_show_hidden" id="select_show_hidden">
                </div>
            </div>
            <div class="submit_box">
                <button class="submit_btn" type="submit" onclick="test4();">회원 가입</button>
            </div>

            </div>
           
        </div>
      
    </form>

    <script>
        function selectMovie(value){
            $("#select_movie_hidden").attr("value", value);
        }
        function selectDisplay(value){
            $("#select_display_hidden").attr("value", value);
        }
        function selectShow(value){
            $("#select_show_hidden").attr("value", value);
        }

        $(document).ready(function() {

            $(".int_btn_movie").click(function() {
                // 모든 버튼의 테두리 색상을 원래대로 되돌립니다.
                $(".int_btn_movie").css("border-color", "rgba(128, 128, 128, 0.603)");
                $(".int_btn_movie").css("color", "gray");
                // 클릭한 버튼의 테두리 색상을 빨간색으로 변경합니다.
                $(this).css("border-color", "red");
                $(this).css("color", "red");
            });
            $(".int_btn_display").click(function() {
                // 모든 버튼의 테두리 색상을 원래대로 되돌립니다.
                $(".int_btn_display").css("border-color", "rgba(128, 128, 128, 0.603)");
                $(".int_btn_display").css("color", "gray");
                // 클릭한 버튼의 테두리 색상을 빨간색으로 변경합니다.
                $(this).css("border-color", "red");
                $(this).css("color", "red");
            });
              $(".int_btn_show").click(function() {
                // 모든 버튼의 테두리 색상을 원래대로 되돌립니다.
                $(".int_btn_show").css("border-color", "rgba(128, 128, 128, 0.603)");
                $(".int_btn_show").css("color", "gray");
                // 클릭한 버튼의 테두리 색상을 빨간색으로 변경합니다.
                $(this).css("border-color", "red");
                $(this).css("color", "red");
            });
        });
        
    </script>

     <script>
        function test4() {
            // 사용자가 입력한 생년월일 값
            const value = document.getElementById("new_user_pwd").value;
           
            var phone = $(".new_user_phone").val();

            var regPhone= /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            
            
            let regExp = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;

            var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;

            let PwdReg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/
            
            var nameReg = /^[a-zA-Z가-힣]{2,15}$/

            if($(".submit_btn").attr("type") == "button" ){
                alert("아이디를 확인해주세요.");
            }else{

                if( !idReg.test( $(".new_userId").val() ) ) { // 아이디 안맞다
                    $(".submit_btn").attr("type","button"); 
                    alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
                    $(".message_output").text("* 입력하신 아이디가 잘못되었습니다.");
                    
                }else{ // 아이디 맞다 
                    $(".message_output").text(" ");

                    if(!PwdReg.test( $(".new_userPwd").val() )){ // 비번 틀리다
                        $(".submit_btn").attr("type","button"); 
                        alert("비밀번호는 영문 숫자 특수기호 조합 8자리 이상이어야 합니다.")
                        $(".message_output").text("* 입력하신 비밀번호가 잘못되었습니다.");
                    }else { // 비번맞다

                        if(!nameReg.test($(".new_user_name").val() )){ // 이름 틀리다
                            $(".submit_btn").attr("type","button"); 
                            alert("이름은 영어나 한글로 2~15자 이어야 합니다.")
                            $(".message_output").text("* 입력하신 이름이 잘못되었습니다.");
                        
                        }else{ // 이름맞다
                            
                        
                        
                            if(regExp.test(value)){ // 생년월일 맞다
                                $(".message_output").text(" ");

                                if (regPhone.test(phone) == true) { // 전번 체크 함

                                    if($("#select_movie_hidden").val() == "" ){ // 영화 안함
                                        $(".submit_btn").attr("type","button"); 
                                        alert("관심 카테고리 (영화)를 선택해 주세요.")
                                        $(".message_output").text("* 관심 카테고리 (영화)를 선택해 주세요.");

                                    }else{ // 영화 체크함

                                        if($("#select_display_hidden").val() == "" ){ // 전시 체크 암함
                                            $(".submit_btn").attr("type","button"); 
                                            alert("관심 카테고리 (전시)를 선택해 주세요.")
                                            $(".message_output").text("* 관심 카테고리 (전시)를 선택해 주세요.");
                                        }else{ // 전시 체크함

                                            if($("#select_show_hidden").val() == "" ){ // 공연 체크 안함
                                                $(".submit_btn").attr("type","button"); 
                                                alert("관심 카테고리 (공연)를 선택해 주세요.")
                                                $(".message_output").text("* 관심 카테고리 (공연)를 선택해 주세요.");
                                            }else{ // 공연 체크함
                                                $(".submit_btn").attr("type","submit"); 

                                            
                                            }
                                        }
                                    }
                                }else {// 전번 체크 안함
                                    $(".submit_btn").attr("type","button"); 
                                    alert("휴대폰 번호를 확인해주세요.")
                                    $(".message_output").text("* 입력하신 전화번호가 잘못되었습니다.");
                                }
                                
                            }else {  // 생년월일 틀림
                                alert("생년월일이 잘못되었습니다.")
                                $(".submit_btn").attr("type","button"); 
                                $(".message_output").text("* 입력하신 생년월일이 잘못되었습니다.");
                            }
                        }
                    }

                }

            }   
        }
    </script>
    <script>
    var idReg = /^[a-z]+[a-z0-9]{5,19}$/;

    var $newUserId = $(".new_userId");
    var $idInput = $(".id_input");
    var $messageOutput = $(".message_output");
    var $submitBtn = $(".submit_btn");

    $newUserId.keyup(function() {
        var userId = $newUserId.val();
        
        if (!idReg.test(userId)) { // 아이디 체크 불합격
            $idInput.css("border", "2px solid red");
            $messageOutput.text("* 아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
            $submitBtn.attr("type", "button");
        } else { // 합격
            $idInput.css("border", "none");
            $messageOutput.text("");

            $.ajax({
                url: "idCheck.ur",
                data: { checkId: userId },
                success: function(result) {
                    console.log(result);
                    if (result === "NNNNY") { // 사용가능
                        $idInput.css("border", "none");
                        $messageOutput.text("* 사용 가능한 아이디 입니다.");
                        $submitBtn.attr("type", "submit");
                    } else if (result === "NNNNN") { // 사용불가능
                        $idInput.css("border", "2px solid red");
                        console.log($submitBtn.attr("type"));
                        $submitBtn.attr("type", "button");
                        $messageOutput.text("* 이미 존재하거나 탈퇴한 회원의 아이디입니다.");
                    } else {
                        console.log(result);
                        alert("오류발생");
                    }
                },
                error: function() {
                    console.log("아이디 중복체크 통신 실패!");
                    alert("아이디 중복체크 통신 실패!");
                }
            });
        }
    });
</script>

</body>
</html>