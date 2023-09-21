<%@page import="com.kh.semi01.product.model.vo.Editor"%>
<%@page import="com.kh.semi01.product.model.vo.ProductLike"%>
<%@page import="com.kh.semi01.product.model.vo.ScreeningInfo"%>
<%@page import="java.sql.Date"%>
<%@page import="com.kh.semi01.product.model.vo.ProductIMG"%>
<%@page import="com.kh.semi01.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   Product p = (Product)request.getAttribute("p");
   ProductIMG pi = (ProductIMG)request.getAttribute("pi");
   ScreeningInfo si = (ScreeningInfo)request.getAttribute("si");
   ProductLike pl = (ProductLike)request.getAttribute("pl");
   
   ArrayList<ProductIMG> ilist = (ArrayList<ProductIMG>)request.getAttribute("ilist");
   ArrayList<Product> plist = (ArrayList<Product>)request.getAttribute("plist");
   ArrayList<Review> relist = (ArrayList<Review>)request.getAttribute("relist");
   ArrayList<Editor> llist = (ArrayList<Editor>)request.getAttribute("llist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dbb5ff76fc35c0a9a7090c83b37365f7"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dbb5ff76fc35c0a9a7090c83b37365f7&libraries=LIBRARY"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dbb5ff76fc35c0a9a7090c83b37365f7&libraries=services"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dbb5ff76fc35c0a9a7090c83b37365f7&libraries=services,clusterer,drawing"></script>

<title>티켓딱대 상품 상세페이지</title>
<style>


      .outer{
         width: 1180px;
           margin: auto;
           /* background-color: skyblue; */
           padding-bottom: 10px;
         margin-top: 20px;
      }
      
      .recommend_img{
         height: 
      }
   
      .div_img{
               width: 20%;
               height: 390px;
               float: left;
               padding-left: 10px;
               padding-right: 10px;
               padding-bottom: 30px;
           }
           
        .div_img img {
            border-radius: 10px;
            height: 307px;
        }
   
   

      .product_img_info{
               /* border: 2px solid blue; */
               width: 100%;
               height: 600px;
               padding: 40px 30px;
           }

        #product_img{
            /* border: 2px solid red; */
            width: 405px;
            height: 500px;
            float: left;
        }

        #product_img>img{
            width: 405px;
            height: 500px;
            border-radius: 10px;
        }

        #product_info{
            /* border: 2px solid white; */
            width: 675px;
            height: 500px;
            padding-left: 20px;
            padding-top: 20px;
            float: right;
        }

        #product_info_ul{
            padding: 20px 0px 20px 0px;
            font-weight: bold;
            list-style: none;
        }

        #product_info_li{
            padding: 7px 0px 6px;
            width: 300px;
            float: left;
        }
        #product_info_li_span1{
            size: 40px;
            padding-right: 30px;
            float: left;
            font-size: 15px;
        }

        #product_info_li>div{
            width: 300px;
        }

        #product_info_2, #product_info_2_1{
            list-style: none;
        }

        #product_info_2_span{
            size: 40px;
            padding-right: 30px;
            float: left;
            height: 200px;
            font-weight: bold;
        }

        #product_info_2_1>li{
            font-weight: bold;
        }

        #product_info_2>li{
            height: 130px;
            width: 300px;
            line-height: 30px;
            float: left;
        }
        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 예매파트 시작 */
        .booked{
            border: 1px solid black;
            width: 1180px;
            height: 300px;
            border-radius: 10px;

        }
        .booked_part1{
            /* border: 5px solid; */
            height: 100%;
            width: 37%;
            float: left;
        }

        .booked_part2{
            border-left: 1px solid lightgray;
            height: 100%;
            width: 37%;
            float: left;
        }

        .booked_part3{
            /* border: 1px solid yellow; */
            background-color: rgb(243, 236, 236);
            height: 100%;
            width: 25%;
            padding-left: 10px;
            float: right;
            border-radius: 0px 10px 10px 0px;
            border-left: 1px solid lightgray;
        }

        #step{
            color: red;
            font-weight: bolder;
            font-size: 15px;
        }


        .booked_btn_form{
            /* border: 1px solid red; */
            width: 100%;
            height: 90px;
            float: left;
        }

        .booked_btn{
            background-color: red;
            color: white;
            width: 250px;
            height: 50px;
            margin-top: 15px;
            margin-right: 30px;
            font-weight: bolder;
            float: right;
            border-radius: 10px;
            border: 0px;
            cursor: pointer;
        }

      .booked_btn:hover{
         background-color: darkred;
      }

        .booked_part1_calender1{
            /* border: 5px solid blue; */
            height: 100%;
            width: 20%;
            float: left;
            font-size: 15px;
            font-weight: 900;
            padding-left: 20px;
         margin-right: 50px;
        }
        
        .booked_part1_calender2{
            height: 100%;
            width: 29%;
            float: left;
         padding-top: 40px;

        }

        .booked_part1_calender3{
            /* border: 1px solid red; */
            height: 100%;
            width: 70%;
            float: right;
        }

        .booked_part3_b{
            padding-right: 10px;
            float: right;
        }

        
        .booked_part2_ampm1{
            width: 25%;
            height: 100%;
            float: left;
            font-weight: bolder;
            font-size: 15px;
            padding-left: 20px;
        }
        
        .booked_part2_ampm2{
            width: 74%;
            height: 100%;
            padding-top: 30px;
            float: right;
        }

        .booked_part2_ampm{
            border: 1px solid black;
            background-color: white;
            font-weight: bold;
            font-size: 20px;
            width: 280px;
            height: 70px;
            border-radius: 10px;
            margin-bottom: 15px;
            padding-right: 120px;
            cursor: pointer;
        }

      .click{
         background-color: black;
         color: white;
      }
        


        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 탭메뉴 파트 시작 */

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .tab-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            width: 1180px;
        }

        .tab-button {
            background-color: white;
            border: 1px solid lightgray;
            border-bottom: 1px solid black;
            padding: 10px 15px;
            width: 20%;
            font-size: 20px;
            color: #333;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s, border 0.3s, color 0.3s;
        }

        .tab-button:hover {
            background-color: white;
        }

            .active.tab-button {
            border: 1px solid black;
            border-bottom: white;
            font-weight: bolder;
        }

        .tab-content {
            display: none;
            /* background-color: gray; */
            margin-top: 20px;
         margin: auto;
        }

      .tab-content>img{
         width: 1180px;
         margin: auto;
         padding-top: 40px;
      }

        .active {
            display: block;
        }

        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 리뷰파트 시작 */
        .review{
            width: 100%;
            height: 50px;
            padding-top: 10px;
            color: black;
        }

        .review_btn{
            float: right;
            width: 70px;
            height: 50px;
            border-radius: 10%;
            border: 0;
            cursor: pointer;
        }

        .review_form{
            height: 270px;
        }


        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 추천상품 */

        .div_img{
            width: 20%;
            float: left;
            padding-left: 10px;
            padding-right: 10px;
            padding-bottom: 30px;
        }

        .div_img img {
            border-radius: 20px;
        }

        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 상품상세정보 시작 */

        .product_detail{
            /* border: 5px solid; */
            width: 100%;
        }

        .product_detail>img{
            width: 1180px;
            display: block;
            margin: auto;
        }

        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        /* 좋아요 */
        .like_btn{
            border: 0;
            background-color: white;
         cursor: pointer;
        }
        

</style>
</head>
<body>
   <%@ include file = "/views/common/header.jsp" %>
   <div class="outer">

      <div class="product_img_info">
         <div id="product_img"><img src="<%= p.getImagePath() %>/<%= p.getPosterName() %>" ></div>
         <% System.out.println("p : " + p); %>
         
         <form action="<%= contextPath %>/book.bo?pno=<%= p.getProductNo() %>" method="post">
         
         <div id="product_info">
            <div>
               <h1 style="width: 600px; float: left"><%= p.getProductTitle() %></h1>
               
               <% if(pl != null) { %>
                  <button type="button" class="like_btn"><img style="width: 40px; height: 40px;" src="resource/이미지자료/류지완 샘플이미지/풀하트.png"></button>
               <% } else { %>
                  <button type="button" class="like_btn"><img style="width: 40px; height: 40px;" src="resource/이미지자료/류지완 샘플이미지/빈하트.png"></button>
               <% } %>
               
            </div>

            <script>
            
               $(function() {
                  
                  $(".like_btn").click(function() {
                     
                     <% if(loginMember == null) { %>
                     
                        if(confirm("로그인 후에 이용 가능한 서비스입니다. 로그인 하시겠습니까?")) {
                           
                           location.href = "<%= contextPath %>/login.ur";
                           
                        }
                        
                        return false;
                     
                     <% } else {%>
                     
                        if($(this).children("img").attr("src") == "resource/이미지자료/류지완 샘플이미지/빈하트.png" ) {
                           
                           $.ajax({
                              
                              url:"insertLike.pr",
                              data:{
                                 userNo:"<%= loginMember.getUserNo() %>",
                                 productNo:"<%= p.getProductNo() %>"
                              },
                              type:"post",
                              success:function(result) {
                                 
                                 if(result > 0) {
                                    
                                    $(".like_btn").children("img").attr("src", "resource/이미지자료/류지완 샘플이미지/풀하트.png");
                                 
                                 }
                              },
                              error:function() {
                                 console.log("좋아요 등록용 ajax 통신 실패");
                              }
                              
                           });
                        
                        }
                        else {
                           
                              $.ajax({
                              
                              url:"deleteLike.pr",
                              data:{
                                 userNo:"<%= loginMember.getUserNo() %>",
                                 productNo:"<%= p.getProductNo() %>"
                              },
                              type:"post",
                              success:function(result) {
                                 
                                 if(result > 0) {
                                    
                                    $(".like_btn").children("img").attr("src", "resource/이미지자료/류지완 샘플이미지/빈하트.png");
                                 
                                 }
                              },
                              error:function() {
                                 console.log("좋아요 삭제용 ajax 통신 실패");
                              }
                              
                           });
                           
                        
                        }
                  
                     <% } %>
                     
                  });
                  
               })
               
            </script>

            <br><br>
            <hr style="border: 1px solid black;">
            <ul id="product_info_ul">
               <li id="product_info_li">
                  <span id="product_info_li_span1">장소</span>
                  <div><%= p.getAddress() %></div>
               </li>
               <li id="product_info_li">
                  <span id="product_info_li_span1">관람시간</span>
                  <div><%= p.getRunTime() %>분</div>
               </li>
               <li id="product_info_li">
                  <span id="product_info_li_span1">기간</span>
                  <div><%= p.getStartPeriod() %> ~ <%= p.getEndPeriod() %></div>
               </li>
               <li id="product_info_li">
                  <span id="product_info_li_span1">관람등급</span>
                  <div><%= p.getLevelName() %></div>
               </li>
            <br>
            </ul>

            <br><br>
            <hr>
            <br>
            <ul id="product_info_2">
               <li>
                  <span id="product_info_2_span">가격</span>
                  <div>
                     <ul id="product_info_2_1" >
                        <li><em><%= p.getPrice() %></em>원</li>
                     </ul>
                  </div>
               </li>
               <li>
                  <span id="product_info_2_span">&nbsp;할인</span>
                  <div>
                     <ul id="product_info_2_1">
                        <li>[회원할인] 브론즈 1% 할인</li>
                        <li>[회원할인] 실버 5% 할인</li>
                        <li>[회원할인] 골드 10% 할인</li>
                        <li>[회원할인] 마스터 15% 할인</li>
                        <!-- <li>[카드할인] 현대카드 10% 할인</li>
                        <li>[카드할인] 롯데카드 5% 할인</li> -->
                     </ul>
                  </div>
               </li>
            </ul>
         </div>
      </div>

      <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
      <!-- 예매 파트 -->
         <div class="booked">
            <div class="booked_part1">
               <div class="booked_part1_calender1">
                  <br><br>
                  <p id="step">step 1</p><br>
                  날짜 선택

               </div>

               <div class="booked_part1_calender2">
                  <input type="date" id="dateInput" name="bookedDate" required>
                        <script>
                        const startPeriodString = "<%= p.getStartPeriod() %>";
                        const endPeriodString = "<%= p.getEndPeriod() %>";
   
                        const startPeriodDate = new Date(startPeriodString);
                        const endPeriodDate = new Date(endPeriodString);
   
                        const minDate = new Date(startPeriodDate);
                        minDate.setDate(minDate.getDate() + 1);
   
                        const maxDate = new Date(endPeriodDate);
                        maxDate.setDate(maxDate.getDate() + 1);
   
                        const dateInput = document.getElementById("dateInput");
                        dateInput.min = minDate.toISOString().split('T')[0];
                        dateInput.max = maxDate.toISOString().split('T')[0];
                        </script>
               </div>
            </div>
            <div class="booked_part2">
                  <div class="booked_part2_ampm1">
                     <br><br>
                     <p id="step">step 2</p><br>
                     회차 선택
                  </div>
                  <div class="booked_part2_ampm2" align="center">
                     <input disabled type="button" class="booked_part2_ampm non_click" id="dayTime" name="dayTime" value="11:00">
                     <input disabled type="button" class="booked_part2_ampm non_click" id="nightTime" name="nightTime" value="18:00">
                     <input type="hidden" id="screenTime" name="screenTime">
                     <input type="hidden" id="spareSeat" name="spareSeat">
                  </div>

               </div>
               <div class="booked_part3">
                  <br><br>
                  <b>예매 가능 좌석</b>
                  <br><br><br><br>
                  <b class="booked_part3_b" id="seatCount"></b>

               </div>
            </div>
                  <script>
                  
                     $(function() {
                        
                        $("#dateInput").change(function() {
                           
                           $(".non_click").attr("disabled", false);
                           
                        });
                        
                        $(".non_click").click(function() {
                           
                           $("#screenTime").val($(this).val());
                           
                           $.ajax({
                                 
                                 url:"selectSeat.pr",
                                 data:{
                                    productNo:"<%= p.getProductNo() %>",
                                    screeningDate:$("#dateInput").val(),
                                    time:$(this).val()
                                 },
                                 success:function(seatCount) {
                                    
                                    if(seatCount > 0) {
                                       
                                       $("#seatCount").text(seatCount + "석");
                                       
                                    }
                                    else {
                                       
                                       $("#seatCount").text("매진");

                                    }
                                    
                                    $("#spareSeat").val(seatCount);
                                    
                                 },
                                 error:function() {
                                    console.log("좌석 조회용 ajax 통신 실패");
                                 }
                                 
                              });
                              
                        });
                        
                     });
                     
   
                     const nonClick = document.querySelectorAll(".non_click");
   
                     function handleClick(event) {
                     // div에서 모든 "click" 클래스 제거
                     nonClick.forEach((e) => {
                        e.classList.remove("click");
                     });
                     // 클릭한 div만 "click"클래스 추가
                     event.target.classList.add("click");
                     }
   
                     nonClick.forEach((e) => {
                     e.addEventListener("click", handleClick);
                     });
                     
                  </script>
         
         <div class="booked_btn_form">
            <button type="submit" class="booked_btn" onclick="return checkBook();">예매하기</button>
         </div>
      </form>
      
      <script>
      
         function checkBook() {
            
            console.log("날짜 : " + $("#dateInput").val());
            console.log("관람시간 : " + $("#screenTime").val());
            console.log("controller로 넘어가는 잔여좌석 : " + $("#spareSeat").val());
            console.log("ajax로 불러온 잔여좌석 : " + $("#seatCount").text())
            
            <% if(loginMember != null) { %>
               
               if(($("#spareSeat").val() > 0) && ($("#screenTime").val() != "")) {
                  
                  return confirm("관람날짜와 시간을 모두 선택하셨습니다. 예매창으로 이동하시겠습니까?");
                  
               }
               else if($("#dateInput").val() != "" && $("#seatCount").text() == "매진") {
            	   
           	      alert("해당 좌석은 매진입니다. 다른 좌석을 선택해 주세요.")
           	   
                  return false;

               }
               else {
                  
                  alert("올바른 관람날짜와 관람시간을 선택해 주세요.")
                  
                  return false;
                  
               }
               
            <% } else { %>
               
               
               if(confirm("로그인 후에 이용 가능한 서비스입니다. 로그인 하시겠습니까?")) {
                  
                  location.href = "<%= contextPath %>/login.ur";
                  
               }
               
               return false;
               
            <% } %>
            
         }
      
      </script>

      
      <br><br><br><br>
      
      <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
      <!-- 탭메뉴 파트 -->
      <div class="tab-container">
         <button class="tab-button" onclick="openTab(event, 'tab1')">상세정보</button>
         <button class="tab-button" onclick="openTab(event, 'tab2')">관람후기</button>
         <button class="tab-button" onclick="openTab(event, 'tab3')">에디터 한줄평</button>
         <button class="tab-button" onclick="openTab(event, 'tab4')">장소정보</button>
         <button class="tab-button" onclick="openTab(event, 'tab5')">예매/취소안내</button>
      </div>

      <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
      <!-- 상품관련정보 -->
      <div id="tab1" class="tab-content">


      
      <img src="<%= pi.getImagePath() %>/<%= pi.getDetail1Name() %>">
      <img src="<%= pi.getImagePath() %>/<%= pi.getDetail2Name() %>">
      <img src="<%= pi.getImagePath() %>/<%= pi.getDetail3Name() %>">
      <img src="<%= pi.getImagePath() %>/<%= pi.getDetail4Name() %>">
      <img src="<%= pi.getImagePath() %>/<%= pi.getDetail5Name() %>">
      
      </div>
        
      <div id="tab2" class="tab-content">
         <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
         <!-- 리뷰 파트 -->
         <h1 style="padding-top: 20px;" align="left">관람후기</h1>
         <br>
         <hr style="border: 1px solid black;">
         <div class="review" align="left">
            <h4>게시판 운영규정에 맞지 않는 글은 사전 통보없이 삭제될 수 있습니다.</h4>
         </div>
         <hr>
            <% for(int i=0; i<relist.size(); i++) { %>
            <div class="review_content">
               <div style="width: 100%; height: 60px; border-radius: 10px; padding: 15px; font-weight: bold; font-size: 15px;" >
                  <%=relist.get(i).getReviewContent() %>
               </div>
               <div style="width: 100%; height: 30px; padding-left: 15px;"><em><%= relist.get(i).getUserId() %></em> <%=relist.get(i).getReviewDate() %></div>
            </div>
            <hr><br><br>
            <% } %>
            <br><br>
      </div>

      <div id="tab3" class="tab-content">
         <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
         <!-- 기대평 파트 -->
         <h1 style="padding-top: 20px;" align="left">에디터 한줄평</h1>
         <br>
         <hr style="border: 1px solid black;">
         <br>
         <% for(int i=0; i<llist.size(); i++) {%>
         <div class="review_content">
            <div style="width: 100%; height: 60px; border-radius: 10px; padding: 15px; font-weight: bold; font-size: 15px;" >
               <%= llist.get(i).getDeitComment() %>
            </div>
            <div style="width: 100%; height: 30px; padding-left: 15px;"><em><%= llist.get(i).getEditor() %></em></div>
         </div>
         <hr><br><br>
         <% } %>
      </div>

        <div id="tab4" class="tab-content">
         <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
         <!-- 장소 정보 파트 -->
         <h1 style="padding-top: 20px;" align="left">공연장 정보</h1>
         <br>
         <hr style="border: 1px solid black;">
         <br> <img src="resource/이미지자료/류지완 샘플이미지/공연장정보 샘플.PNG">
      </div>
      
      <div id="tab5" class="tab-content">
         <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
         <!-- 예매/취소안내 파트 -->
         <h1 style="padding-top: 20px;" align="left">예매/취소안내</h1>
         <br>
         <hr style="border: 1px solid black;">
         <br>
         <img src="resource/이미지자료/류지완 샘플이미지/예매,취소안내 이미지1.PNG" alt="">
         <img src="resource/이미지자료/류지완 샘플이미지/예매,취소안내 이미지2.PNG" alt="">
        </div>
        
        <script>
        function openTab(event, tabName) {
         const tabContents = document.getElementsByClassName("tab-content");
         for (const content of tabContents) {
           content.style.display = "none";
         }
        
         const tabButtons = document.getElementsByClassName("tab-button");
         for (const button of tabButtons) {
           button.classList.remove("active");
         }
        
         document.getElementById(tabName).style.display = "block";
         event.currentTarget.classList.add("active");
        }
        
        document.getElementById("tab1").style.display = "block";
        document.getElementsByClassName("tab-button")[0].classList.add("active");
        </script>



      <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
      <!-- 제일 하단 추천상품 -->

      <div class="recommend_img">

           <span style="font-weight: bold; font-size: 25px;">랭킹 딱대</span>
           <br>
           <hr>
           <br>
         <% for(int i=0; i<plist.size(); i++) {%>
         <div class="div_img">
            <a
               href="<%= contextPath %>/detail.pr?pno=<%= plist.get(i).getProductNo() %>">
               <img
               src="<%= ilist.get(i).getImagePath() %>/<%= ilist.get(i).getPosterName() %>"
               alt="Fjords" style="width: 100%">
               <div class="caption">
                  <p class="caption1" style="color: black; font-weight: bold;"><%= plist.get(i).getProductTitle() %></p><br>
                  <p class="caption2" style="color: gray; font-size: 12px;"><%= plist.get(i).getStartPeriod() %>
                     ~
                     <%= plist.get(i).getEndPeriod() %></p>
               </div>
            </a>
         </div>

         <% } %>

        </div>
               <hr>
               <br><br>
               
               <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
               <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
               <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
               <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
               <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
               
               <!-- 상세페이지 끝 -->
               <!-- 류지완 끝 -->
               
            </div>
         </div>

   
   <%@ include file = "/views/common/footer.jsp" %>
</body>
</html>