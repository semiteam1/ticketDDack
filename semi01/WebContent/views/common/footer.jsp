<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<style>
	/* 푸터 시작 */
    div{
        /* border: 1px solid pink; */
        box-sizing: border-box;
        
    }
    .footer{
        border-top: 1px solid #f8f8f8 ;
    }
    #footer>div{width: 100%;}


    #footer_1{
        width: 1120px;
        height: 30px;  
        border-top: 1px; 
        margin: auto; 
        margin-top: 10px;
        margin-left: 350px;
        /* border: 1px solid red; */
    } 
    #footer_1>a{
        text-decoration: none;
        color: black;
        font-size: 13px;
        font-weight: 500;
        margin: 15px; 
    }
    #footer_2{
        height: 80%;
        border-top: 2px solid rgba(212, 212, 212, 0.459);
        /* border: 1px solid red; */
    }
    
    #p1{
        width: 1120px; 
        height: 80%;
        /* margin: auto;  */
        padding: 5px 15px;
        /* background-color: #878d95; */
        margin-left: 350px;
    }
    
    #footer_2>p{
        /* width: 100%; */
        /* border: 1px solid blueviolet; */
        box-sizing: border-box;
        /* margin: auto; */
        font-size: 12px;
        /* color:rgb(58, 58, 58); */
        
    }
    #p2{
        height: 20%; 
        text-align: center; 
        padding-bottom: 15px;
        padding-top: 10px; 
        color: rgba(184, 184, 184, 0.747);
        font-weight: 800;
    }

   
    /* 푸터 끝 */
    /* top버튼 */
    #backToTopBtn {
    display: none;
    position: fixed;
    bottom: 20px;
    right: 200px;
    width: 60px;
    height: 40px;
    background-color: white;
    color: rgb(253, 103, 103);
    border: 1px solid rgba(206, 206, 206, 0.671);
    border-radius: 5px;
    font-size: 20px;
    font-weight: 600;
    cursor: pointer;
    border-radius: 38px;
    line-height: 0;
    
}
</style>
</head>
<body>
	<div class="footer">
        <div id="footer_1">
            <a href="#">이용약관</a>|
            <a href="#">개인정보취급방침</a>|
            <a href="#">인재채용</a>|
            <a href="#">고객센터</a>
        </div>
        <div id="footer_2">
            <P id="p1">
                <br>
                이눔식기 주식회사 <br><br>

                주소 :  서울특별시 강남구 테헤란로14길 6 남도빌딩 3F H-class | 대표이사 : 김시연 | 사업자등록번호 : 없떵<br>
                010-2646-7652 | @naver.com | 개발자코스 : 종일반 | 사업자정보확인 | 개인정보보호책임자 : 김시연
            </P>
            <p id="p2">
                Copyright © 1998-2023 KH Information Educational Institute All Right Reserved
            </p>
        </div>
        
        <!-- Back to top button -->
        <button id="backToTopBtn">Top</button>
        
        <!-- Anchor element representing the top of the page -->
        <a href="#top" id="topAnchor"></a>
        
        <!-- Your script files can go here -->
        
        <script>
            // When the page is fully loaded
            window.onload = function () {
                var backToTopBtn = document.getElementById("backToTopBtn");
                var topAnchor = document.getElementById("topAnchor");
                
                // Show/hide the back-to-top button based on scroll position
                window.onscroll = function () {
                    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                        backToTopBtn.style.display = "block";
                    } else {
                        backToTopBtn.style.display = "none";
                    }
                };
                
                // Scroll to the top when the button is clicked
                backToTopBtn.onclick = function () {
                    document.documentElement.scrollTop = 0;
                };
            };
        </script>
    
    </div>

</body>
</html>