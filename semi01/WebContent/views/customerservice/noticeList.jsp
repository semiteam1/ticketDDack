<%@page import="com.kh.semi01.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            height: 99.3px;
            border: 0.3px solid gray;
        }
        
        .원하는데로_바꾸세요>.white{
        width:100%;
        height:0px;
        border: 1px solid gray;
        }
        #announce>p{
            display: none;
            float:right;
        }
        
        /*바디의 오른쪽 메뉴*/
        .원하는데로_바꾸세요 .rightmenu{
            background-color: white;
            width: 880px;
            height:600px;
            margin-right: 23.8%;
            margin-top: 5px;
            float:right;
        }
        .rightmain{
            width:100%
        }
        #event{
            width: 100%;
            height: 150px;
            /* border:  2px solid red; */
            /* margin-top: 10px; */
            border: 0;
            background-color: white;
        }
        .rightmain tbody>tr:hover{
        background:gray;
        cursor:pointer;
    	opacity:0.5;
        }
        .rightmain th{
            height:40px;
        }
        /*테이블 첫 번째 줄*/
        #tr1{
            background-color: lightblue;
            font-size: 20px;
            text-align: center;
            color:gray
        }

        /* 바디 끝 */
        /* 푸터 시작 */
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
            <div onclick="location.href='<%=contextPath %>/customer.cu'">고객센터 홈</div>
            <div id="announce" style="color:red" onclick="location.href='<%=contextPath %>/list.no';">공지사항 </div>
            <div onclick="location.href='<%=contextPath %>/list.qo'">Q&A</div>
        </div>


       
       
        <!-- 바디의 오른쪽메뉴-->
        <div class="rightmenu">
            <h2 align="center">공지사항</h2>
            <img id="event" src="resource/이미지자료/이벤트.png">
            
            
            <!--  현재 로그인한 사용자가 관리자 일 경우 보여질 div -->
            <% if(loginMember !=null && loginMember.getUserId().equals("admin"))  {%>
            <div align ="right" style="width: 870px;">
            
            <button onclick="location.href='<%=contextPath %>/enrollForm.no'">글작성</button>
        
        </div>
        <%} %>
            
            <table class="rightmain">
                <thead>
                <tr id="tr1">
                    <td>번호</td>
                    <td colspan="2">제목</td>
                    <td>조회수</td>
                </tr>
                </thead>
      
                <tbody>
      				<!--1. 공지글이 없는 경우-->
      				<%if(list.isEmpty()){ %>
      				
      				<tr>
      					<td colsapn="5">존재하는 공지사항이 없습니다.</td>
      				</tr>
      			   <%}else { %>
      			   	   <!-- 2. 공지글이 있을 경우 -->
      			   	   <%for(Notice n:list){ %>
      			   	   <tr>
      			   	   		<th><%=n.getNoticeNo() %></th>
      			   	   		<th colspan="2"><%=n.getNoticeTitle() %></th>
      			   	   		<th><%=n.getNoticeCount() %></th>
      			   	   </tr>
      			   	   <%} %>
      			   <%} %>       
                </tbody>
            </table>
        </div>
    </div>

</div>

<!-- 내용물 넣을 수 있는 구간 끝 -->
    <!-- 바디 끝 -->
    <script>
        $(function(){
            $(".leftmenu>.lm").hover().css("cursor","pointer");
            $(".rightmain>tbody>tr").hover().css("cursor","pointer");
            $(".rightmain>tbody>tr").click(function(){
            	const num = $(this).children().eq(0).text()
            	
            	location.href = '<%=contextPath%>/detail.no?num=' + num;
            });
           
        })
    </script>

<%@ include file = "../common/footer.jsp" %>
</body>
</html>