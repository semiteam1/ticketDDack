<%@page import="com.kh.semi01.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctype = (String)request.getAttribute("ctype");
	ArrayList<Product> prclist = (ArrayList<Product>)request.getAttribute("prclist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
	.outer {
        width: 1180px;
		height: 100%;
        margin: auto;
	}
	
	        /* 검색창 폼 전체 */
        .search{
            width: 100%;
            height: 100%;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        
        .search a{
            color: black;
        }

        /* 검색된 갯수 */
        .search_num{
            font-weight: bold;
            font-size: 18px;
        }
        .search_num_em{
            font-style: normal;
            color: red;
        }

        /* 검색 결과 상품 */
        .search_result{
            width: 1070px;
            float: left;
            font-size: 30px;
            font-weight: bold;
        }

        .search_filter{
            width: 100px;
            float: left;
        }

        .search_product{
            width: 100%;
        }

        .search_product_box{
            width: 1100px;
            height: 140px;
            margin-top: 30px;
            margin-left: 10px;
        }
        dt{float: left;}

        .search_product_box img{
            height: 130px;
            width: 110px;
            margin-right: 20px;
            float: left;
			border-radius: 10px;
        }

        .search_product_box>button{
            float: right;
            margin-top: 50px;
        }

        .search_product_box2{
            width: 800px;
			float: left;
            
        }

        .search_tap a{
            display: block;
        }
        
        .rank{
        	width: 120px;
			height: 130px;
        	font-size: 30px;
			font-weight: bold;
			float: left;
			text-align: center;
			line-height: 130px;
        }
		
		.info{
			float: left;
			height: 20px;
			line-height: 20px;
			font-weight: bold;
			font-size: 20px;
			text-align: center;
		}
	
</style>
</head>
<body>
<%@ include file = "/views/common/header.jsp" %>

	<div class="outer">
	 
	  <div class="search">
            <h2 class="search_result">랭킹 TOP 10 딱! 대!</h3>

            <br><br>
            <hr>


            <!-- 정보가 보이는 검색된 상품 -->

			<div class="search_product_box" style="height: 20px; margin: 0px;">
				<div class="info" style="width: 120px;">순위</div>
				<div class="info" style="width: 860px;">공연정보</div>
				<div class="info" style="width: 120px;">예매하기</div>
			</div>
			<hr style="border: 1px solid black;">
            <div class="search_product">
            
            <% for(int i=1; i<prclist.size(); i++) { %>
				<div class="search_product_box">
					<div class="rank"><%= i %></div>

                        <a href="<%= contextPath %>/detail.pr?pno=<%= prclist.get(i).getProductNo() %>" class="search_product_box2">
                            <span><img src="<%= prclist.get(i).getImagePath() %>/<%= prclist.get(i).getPosterName() %>"></span>
                            <strong><%= prclist.get(i).getProductTitle() %></strong>
                            <dl>
                                <dt>장소 : &nbsp;</dt>
                                <dd><%= prclist.get(i).getAddress() %></dd>
                                <dt>기간 : &nbsp;</dt>
                                <dd><%= prclist.get(i).getStartPeriod() %> ~ <%= prclist.get(i).getEndPeriod() %></dd>
                                <dt>관람가 : &nbsp;</dt>
                                <dd><%= prclist.get(i).getPrice() %>원</dd>
                            </dl>
                        </a>

                    <button type="button" class="btn btn-sm btn-danger" onclick="booking();">예매하기</button>
                </div>
                <hr>
                
            <script>

				function booking() {
					
					<% if(loginMember == null) { %>
						
						if(confirm("로그인 후에 이용 가능한 서비스입니다. 로그인 하시겠습니까?")) {
							
							location.href = "<%= contextPath %>/login.ur";
							
						}	
						
						
						
					<% } else { %>
						
						console.log("dd");
						
						alert("관람하실 날짜와 시간을 선택하기 위해 상세 페이지로 이동합니다.");
					
						location.href = $(".search_product_box>a").attr("href");
					
				    <% } %>
				    
				}    

			</script>
		
                
            <% } %>

            </div>

            
        </div>
	 
	</div>
<script>
                
	    $(function(){
	    	
	    	let ctype = "<%= ctype %>"
	    	
	    	console.log(ctype)
	    	$(".common_tab_btn").attr("aria-selected","false");
	    	$("#" + ctype).attr("aria-selected","true");
	
	        $("#홈").attr("main-selected","false");
	   
	
			if(ctype == '영화' || ctype == '로맨스' || ctype == '공포스릴러' || ctype == '코미디' || ctype == '액션' ){
				$("#영화").attr("main-selected","true");
			}else if(ctype == '전시' || ctype == '그림전시' || ctype == '사진전시' || ctype == '작품전시' || ctype == '체험전시' ){
				$("#전시").attr("main-selected","true");
			}else if(ctype == '공연' || ctype == '콘서트' || ctype == '연극' || ctype == '클래식' || ctype == '뮤직컬' ){
				$("#공연").attr("main-selected","true");
			}else if(ctype == '랭킹' ){
				$("#랭킹").attr("main-selected","true");
			}else if(ctype == '서울' || ctype == '경기' || ctype == '충청' || ctype == '전라' || ctype == '경상'  || ctype == '제주'){
				$("#지역").attr("main-selected","true");
			}
		
	    })
	    
	</script>
<%@ include file = "/views/common/footer.jsp" %>
</body>
</html>