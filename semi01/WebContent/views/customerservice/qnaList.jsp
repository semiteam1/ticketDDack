<%@page import="com.kh.semi01.qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
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
        
        /*qna 메뉴창 클릭시 css값*/
        #qnamenu>p{
            display: none;
            float:right;
        }
        /*바디의 오른쪽 메뉴*/
        .원하는데로_바꾸세요 .rightmenu{
            background-color: white;
            width: 880px;
            height:590px;
            margin-right: 23.8%;
            margin-top: 5px;
            float:right;
        }
        .Qna{
        font-size:17px;
        }
        .banner{
        position: absolute;
		
		bottom: 0px;
        }
        #advertise{
        width:880px;
        height:130px;
        }
       
       /*테이블영역*/
        .list-area{
        border: 1px solid black;
        width: 100%;
        text-align: center;
        }
        
        .Qna{
        font-size:17px;
        }
        .banner{
        position: absolute;
		
		bottom: 0px;
        }
        #advertise{
        width:880px;
        height:130px;
        }
       
        
        .Qna:hover{
    	background: gray;
    	cursor:pointer;
    	opacity:0.5;
        }
        .reply{
        display:none;
        }
        



        

        
        /* 바디 끝 */
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
	            <div onclick="location.href='<%=contextPath %>/customer.cu'" class="lm">고객센터 홈</div>
	            <div onclick="location.href='<%=contextPath %>/list.no';" class="lm">공지사항</div>
	            <div id="qnamenu" style="color:red" class="lm">Q&A </div>
	       
	        
	    </div>        
        <!-- 바디의 오른쪽메뉴-->
        <div class="rightmenu">
        	<!--  현재 로그인한 사용자가 관리자 일 경우 보여질 div -->
            <% if(loginMember !=null )  {%>
            <div align ="right" style="width: 870px;">
            
            <button onclick="location.href='<%=contextPath %>/enrollForm.qo'">Q&A글작성</button>
            </div>
        	<%} %>
        	<%if(loginMember !=null &&loginMember.getUserId().equals("admin")) {%>
        	<div align ="right" style="width: 870px;">
            
            <button onclick="location.href='<%=contextPath %>/answerEnrollForm.qo'">Q&A답변작성</button>
            </div>
        	<%} %>
            <table align="center" class="list-area">
                <thead>
                    <tr>
                        <th width="400">질문제목</th>
                        <th width="100">작성자</th>
                        <th width="100">등록일자</th>
                    </tr>
                </thead>
                <tbody>                
                    <!-- case1. 게시글이 없을 경우-->
                    <%if(list.isEmpty()){ %>
                    <tr>
                        <th colspan="4">조회된 게시글이 없습니다.</th>
                    </tr>
                    <%}else { %>
                    <!-- case2. 게시글이 있을 경우-->
                    <%for(Qna q:list){ %>
						<tr class="Qna">                   
	                        <td><%=q.getQnaTitle() %> <button onclick="location.href='<%=contextPath %>/detail.qo?num=<%=q.getQnaNo() %>'">상세정보</button></td>
							<td><%=q.getUser() %></td>
	                        <td><%=q.getQnaDate() %></td>
                    	</tr>
                    <tr class="reply">
                    	<th colspan="2"><%=q.getQnaReply() %><th>
                    </tr>
                    	<%} %>
                    <%} %>
                    
                    
                </tbody>
            </table>
            <div class="banner"><img src="resource/이미지자료/광고배너.jpg" id="advertise" alt=""></div>
        </div>
        
    </div>
</div>

 <script>
        $(function(){
            $(".leftmenu").hover().css("cursor","pointer");
            $(".Qna").click(function(){
            	const $r = $(this).next();
            	
            	if($r.css("display")=="none"){
            		 $(this).siblings("r").slideUp();
                     //보여지게끔
                     // $p.css("display","block");
                     $r.slideDown();
            		
            	}else {
                    $r.slideUp();
                }
            	//const num = $(this).children().eq(0).text()
            	
            	//location.href = '<%=contextPath%>/detail.qo?num=' + num;
            });
        })
    </script>

<%@ include file = "../common/footer.jsp" %>
</body>

</html>