<%@page import="com.kh.semi01.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	String sKeyWord = (String)request.getAttribute("sKeyWord");
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
        
        /* 검색 분류 탭 */
        /* .search_tap{
            margin-top: 50px;
        }

        .search_tap>li{
            list-style: none;
            border: 1px solid lightgray;
            font-weight: bold;
            font-size: 20px;
            width: 33%;
            height: 48px;
            float: left;
            text-align: center;
            line-height: 48px;
        } */

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
            border: 1px solid lightgray;
        }

        .search_product_box{
            width: 1100px;
            height: 140px;
            margin-top: 30px;
            margin-left: 30px;
        }
        dt{float: left;}

        .search_product_box img{
            height: 130px;
            width: 110px;
            margin-right: 20px;
            float: left;
        }

        .search_product_box>button{
            float: right;
            margin-top: 50px;
        }

        .search_product_box2{
            width: 1000px;
            float: left;
        }

        .search_tap a{
            display: block;
        }
	
</style>
</head>
<body>
<%@ include file = "/views/common/header.jsp" %>

	<div class="outer">
	 
	  <div class="search">
            <p class="search_num"><em class="search_num_em"><%="'" + sKeyWord + "'" %></em>&nbsp;에 대한 검색결과는 총 <em class="search_num_em"><%= list.size() %></em>건 입니다.</p>

            <!-- 검색 분류 탭
            <ul class="search_tap">
                <li>
                    <a href="">영화</a>
                </li>
                <li>
                    <a href="">전시</a>
                </li>
                <li>
                    <a href="">공연</a>
                </li>
            </ul> -->
            <br><br>

            <!-- 검색 결과 -->

            <h2 class="search_result">티켓 검색결과</h3>
            <div class="search_filter">
            <select name="filter" id="">
                <option value="reset">정렬선택</option>
                <option value="end_late">종료일 늦은순</option>
                <option value="end_first">종료일 빠른순</option>
                <option value="price_down">가격 내림차순</option>
                <option value="price_up">가격 오름차순</option>
            </select>
            </div>  
            <br>
            <hr>


            <!-- 정보가 보이는 검색된 상품 -->

            <div class="search_product">
            
            <% for(Product p : list) { %>
                <div class="search_product_box">

                        <a href="<%= contextPath %>/detail.pr?pno=<%= p.getProductNo() %>" class="search_product_box2">
                            <span><img src="<%= p.getImagePath() %>/<%= p.getPosterName() %>"></span>
                            <strong><%= p.getProductTitle() %></strong>
                            <dl>
                                <dt>장소 : &nbsp;</dt>
                                <dd><%= p.getAddress() %></dd>
                                <dt>기간 : &nbsp;</dt>
                                <dd><%= p.getStartPeriod() %> ~ <%= p.getEndPeriod() %></dd>
                                <dt>관람가 : &nbsp;</dt>
                                <dd><%= p.getPrice() %>원</dd>
                            </dl>
                        </a>

                    <button type="button" class="btn btn-sm btn-danger" onclick="booking();">예매하기</button>
                
                </div>
                <hr>
                
            <% } %>
            
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

            </div>

            
        </div>
	 
	</div>

<%@ include file = "/views/common/footer.jsp" %>
</body>
</html>