<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  로그인 화면 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓딱대 고객센터</title>
<style>
        /* 바디 시작 */
               /* 바디 메인 */
               .원하는데로_바꾸세요{
            border: 1px solid lightgray;
            background-color: #f8f9fa; 
            height: 900px;
            width: 100%;
        }

        /* body 고객센터*/
        .servicecenter{
            background-color:black;
            height: 100px;
            width: 1050px;
            margin:auto;
            margin-right: 23.8%;
            margin-top:50px;            
        }
        .servicecenter>h1{
            color:white;
            line-height:100px;
        } 

        /*body leftmenu*/
        .원하는데로_바꾸세요 .leftmenu{
            background-color: white;
            font-size: 19px;
            text-align:center;
            line-height: 100px;
            width: 160px;
            height: 300px;
            margin-left: 21%;
            margin-top: 5px;
            float:left;
        }
        .원하는데로_바꾸세요 .leftmenu div{
            width:100%;
            height: 33.3%;
            border: 1px solid gray;
        }
        /*바디의 오른쪽 메뉴*/
        .원하는데로_바꾸세요 .rightmenu{
            width: 880px;
            height:400px;
            margin-right: 23.8%;
            margin-top: 5px;
            float:right;
        }
        #bodyright{
            width: 100%;
            height:100%;
            /*width:50%;
            height:50%;
            float:left;
            margin:5px;*/
        }
        /* body 오른쪽 메뉴*/
        #bodyright>#son{
            background-color: white;
            border-radius: 20px;
            width:48%;
            height:46%;
            float:left;
            margin:1%;
            text-align:center;
            line-height: 200px;
        }
        /* body 오른쪽 메뉴 이미지*/
        #qnalogomain{
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }
        #reservelogomain{
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }
        #noticelogomain{
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }
        #questionlogomain{
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }
        .bottomfunction{
            width:880px;
            height:200px;
            margin-right:23.8%;
            margin-top: 5px;
            float:right;
        }
        /*body qna창*/
        #bson{
            border: 1px solid white;
            border-radius: 10px;
            width: 98%;
            height:90%;
            float:left;
            margin:1%;          
            font-size: 16px;
        }
        #bson>div{
        cursor:pointer;
        }
        #bson>p{
            box-sizing: border-box;
            display:none;
            color:red;
        }
        #bson>#topqna{
            border-bottom-style: solid;
            border-bottom-color: black;
        }
        #bson>#qnacontent{
            font-size: 15px;
        }
        #bson>div{
            border-bottom-style: solid;
            border-color: black;
            border-width: 1px;
        }
</style>
</head>
<body>
<%@ include file = "../common/header.jsp" %>

<!-- 내용 넣을 수 있는 구간 시작 -->

	<div class="원하는데로_바꾸세요">
	    <div class="servicecenter">
	        <h1 align="center">고객센터</h1>
	    </div>
	
	    <div class="servicefunction">
	        <!-- 바디의 왼쪽메뉴-->
	        <div class="leftmenu">
	            <div style="color:red" onclick="location.href='<%=contextPath %>/customer.cu';">고객센터 홈</div>
	            <div onclick="location.href='<%=contextPath %>/list.no';">공지사항</div>
	            <div onclick="location.href='<%=contextPath %>/list.qo';">Q&A</div>
	        </div>
	        
	        
	        <!-- 바디의 오른쪽메뉴-->
	        <div class="rightmenu">
	            <div id="bodyright"> 
	                <div id="son">
	                    <a href="<%=contextPath %>/list.no" class="noticelog"><img src="resource/이미지자료/고객센터/notice.png" id="noticelogomain" alt=""></a>
	                </div>
	                
	                <div id="son">
	                    <a href="#" class="reservelogo"><img src="resource/이미지자료/고객센터/reserve1.png" id="reservelogomain" alt=""></a>
	                </div>
	                <div id="son">
	                    <a href="<%=contextPath %>/list.qo" class="qnalogo"><img src="resource/이미지자료/고객센터/qna.png" id="qnalogomain" alt=""></a>
	                </div>
	                
	                <div id="son">
	                    <a href="#" class="questionlog"><img src="resource/이미지자료/고객센터/question.png" id="questionlogomain" alt=""></a>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <!-- 바디 아래메뉴-->
	    <div class="bottomfunction">
	        <div id="bson">
	            <h2 align="center">자주묻는 질문</h2>
	            <div>내 정보를 변경하고 싶어요</div>
	            <p>A. 마이페이지 기능에서 변경할 수 있습니다.</p>
	            <div>회원별 할인율은?</div>
	            <p>[회원할인] 브론즈 1% 할인<br>
				   [회원할인] 실버 5% 할인<br>
				   [회원할인] 골드 10% 할인<br>
	               [회원할인] 마스터 15% 할인</p> 
	        </div>
	        
	    </div>
	    <script>
	        $(function(){
	            $(".leftmenu").hover().css("cursor","pointer");
	            $("#bson>div").click(function(){
	                // $(this) : 클릭이벤트가 발생한 div 요소
	                // 우리는 그 요소의 뒤의 요소를 선택해야함.(같은 레벨에 있음)
	    
	                // $(this).next() : 클릭이벤트가 발생한 div 요소 뒤에 있는 메소드
	                // 보여지는 상태면 사라지게 , 안보이면 나타나게
	    
	                const $p = $(this).next(); // jQuery 방식으로 선택된 요소를 담아둘 때
	    
	                if($p.css("display")=="none"){
	                    
	                    // 기존꺼는 닫히면서 지금꺼만 열리게
	                    $(this).siblings("p").slideUp();
	                    //보여지게끔
	                    // $p.css("display","block");
	                    $p.slideDown();
	                }else {
	                    $p.slideUp();
	                }
	    
	            })
	        })
	    </script>
	</div>



<!-- 내용물 넣을 수 있는 구간 끝 -->
    <!-- 바디 끝 -->
    <%@ include file = "../common/footer.jsp" %>
</body>
</html>