<%@page import="com.kh.semi01.product.model.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctype = (String)request.getAttribute("ctype");

	ArrayList<Product> lolist = (ArrayList<Product>)request.getAttribute("lolist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<link href="resource/image/logo2.png" rel="shortcut icon"
	type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<style>
.page_heading {
	/* border: 1px solid red; */
	/* margin: auto; */
	width: 1120px;
	height: 65px;
	margin-top: 20px;
	margin-bottom: 20px;
}

.page_heading>* {
	float: left;
	height: 100%;
	box-sizing: border-box;
	/* border: 1px solid red; */
}

.page_title {
	/* border: 2px solid pink; */
	width: 20%;
	flex: none;
	background: none;
	font-size: 40px;
	font-weight: 700;
	line-height: 40px;
	letter-spacing: -0.05em;
	color: #242428;
	display: flex;
	justify-content: left;
	align-items: center;
}
/* 바디 기본 */
/* 버튼 */
.common_tab_list {
	width: 700px;
	/* border: 1px solid red; */
}

.common_tab_list * {
	float: left;
	list-style: none;
}

.common_tab.type_underline, .common_tab_btn {
	position: relative;
	padding: 7px 10px;
	min-height: 40px;
	font-size: 20px;
	font-weight: 500;
	line-height: 26px;
	color: #878d95;
	background-color: white;
	font-weight: 800;
	border: 0;
	/* border: 1px solid red; */
}

.common_tab.type_underline, .common_tab_btn[aria-selected="true"]::before
	{
	position: absolute;
	bottom: 4px;
	left: 10px;
	right: 10px;
	height: 2px;
	background: #242428;
	content: '';
}

.common_tab_btn[aria-selected="false"]:hover {
	color: black;
	cursor: pointer;
	font-size: 22px;
}

.common_tab.type_underline, .common_tab_btn[aria-selected="true"] {
	color: #242428;
}

.common_tab_area {
	width: 40%;
	height: 70%;
	margin-top: 20px;
	float: right;
	/* border: 1px solid red; */
}

.common_tab_area * {
	float: right;
}
/* 버튼 끝 */
/* 바디 메인 */

/* 윤관현_시작 */
.yoontarget {
	/* border: 1px solid red; */
	/* background-color: lightgray; */
	height: 100%;
	width: 63%;
	margin: auto;
}

.yoontarget>div {
	/* border: 1px solid red; */
	width: 100%;
}

#demo {
	height: 15%;
	/* border: 1px solid blue; */
}

.carousel-inner {
	width: 100%;
	height: 400px;
}

.carousel-item {
	width: 100%;
	height: 100%;
}

.carousel-item>img {
	width: 100%;
	height: 100%;
}

.col-md-4 {
	width: 25%;
	height: 530px;
}

.yoontarget img {
	border-radius: 10px;
	border: 1px solid rgb(156, 152, 152);
}

.col-md-4 a {
	height: 100px;
}

.col-md-4 img {
	height: 400px;
}

.thumbnail {
	height: 500px;
}

.movieHead {
	font-weight: bold;
	font-size: 25px;
	/* border: 1px solid red; */
}

.movieHead>a {
	color: black;
}

.movieHead>a:hover {
	color: darkgray;
}

#ranking {
	padding-left: 10px;
}

.caption {
	height: 100px;
}

.caption>p {
	font-size: 17px;
	color: black;
	font-weight: bold;
	margin: 10px;
	height: 15%;
}

.caption>pre {
	font-size: 13px;
	color: rgb(50, 50, 50);
	height: 40%;
	padding-left: 10px;
}

.col-md-5 {
	width: 20%;
	height: 400px;
}

.col-md-5>.thumbnail {
	height: 100%;
}

.col-md-5 a {
	height: 100px;
}

.col-md-5>div {
	height: 400px;
}

.col-md-5 img {
	height: 300px;
}

#ad {
	border: 1px solid rgb(156, 152, 152);
	height: 330px;
	border-radius: 10px;
}

#ad img {
	box-sizing: border-box;
	width: 100%;
	height: 100%;
}

img {
	cursor: pointer;
}

.d-block{
	width: 100%;
	height: 100%;
}

/* 윤관현_끝 */

/* 바디 메인 */

/* 바디 끝 */
</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<!-- 내용 넣을 수 있는 구간 시작 -->

	<!-- 윤관현_시작 -->
	<div class="yoontarget">

		<div class="page_heading">
			<h1 class="page_title">
				<%= ctype %>
			</h1>
			<div class="common_tab_area">
				<% if(ctype.equals("지역") || ctype.equals("서울") || ctype.equals("경기") || ctype.equals("충청") || ctype.equals("전라") || ctype.equals("경상") || ctype.equals("제주")){  %>
				<ul class="common_tab_list" role="tablist">
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=제주" id="제주"
						class="common_tab_btn" role="tab" aria-selected="false">제주</a></li>
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=경상" id="경상"
						class="common_tab_btn" role="tab" aria-selected="false">경상</a></li>
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=전라" id="전라"
						class="common_tab_btn" role="tab" aria-selected="false">전라</a></li>
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=충청" id="충청"
						class="common_tab_btn" role="tab" aria-selected="false">충청/강원</a></li>
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=경기" id="경기"
						class="common_tab_btn" role="tab" aria-selected="true">경기/이천</a></li>
					<li class="common_tab_item" role="none"><a
						href="<%= contextPath %>/lolist.pr?ctype=서울" id="서울"
						class="common_tab_btn" role="tab" aria-selected="true">서울</a></li>
				</ul>

				<% } %>
			</div>

		</div>
		<!-- 버튼 끝 -->

		<!-- 메인배너 시작 -->
		<div id="demo" class="carousel slide" data-bs-ride="carousel">

			<!-- 하단 버튼 시작 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
			</div>
			<!-- //하단 버튼 끝 -->

			<!-- 이미지 시작 -->
			<% if(ctype.equals("서울")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=20">
						<img src="resource/배너/배너_그림전시_라울뒤피.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=99">
						<img src="resource/배너/배너_클래식공연_디즈니.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=100">
						<img src="resource/배너/배너_액션영화_슬램덩크.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=97">
						<img src="resource/배너/배너_클래식공연_지브리.jpg" class="d-block">
					</a>
				</div>
			</div>
			<% }else if(ctype.equals("경기")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=132">
						<img src="resource/배너/배너_체험전시_이세계.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=30">
						<img src="resource/배너/배너_로멘스영화_알라딘.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=81">
						<img src="resource/배너/배너_코디디영화_엑시트.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=98">
						<img src="resource/배너/배너_코미디영화_극한직업.png" class="d-block">
					</a>
				</div>
			</div>
			<% }else if(ctype.equals("충청")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=102">
						<img src="resource/배너/배너_클래식공연_폴포츠.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=36">
						<img src="resource/배너/배너_로멘스영화_아바타.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=101">
						<img src="resource/배너/배너_액션영화_비공식작전.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=83">
						<img src="resource/배너/배너_콘서트공연_전율.png" class="d-block">
					</a>
				</div>
			</div>
			<% }else if(ctype.equals("전라")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=27">
						<img src="resource/배너/배너_그림전시_브리티쉬.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=97">
						<img src="resource/배너/배너_클래식공연_지브리.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=87">
						<img src="resource/배너/배너_콘서트공연_어스어스패스티발.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=132">
						<img src="resource/배너/배너_체험전시_이세계.jpg" class="d-block">
					</a>
				</div>
			</div>
			<% }else if(ctype.equals("경상")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=58">
						<img src="resource/배너/배너_액션스릴러영화_범죄도시2.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=92">
						<img src="resource/배너/배너_코미디영화_조이라이드.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=99">
						<img src="resource/배너/배너_클래식공연_디즈니.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=69">
						<img src="resource/배너/배너_콘서트공연_미모리스즈코.png" class="d-block">
					</a>
				</div>
			</div>
			<% }else if(ctype.equals("제주")){ %>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="<%= contextPath %>/detail.pr?pno=57">
						<img src="resource/배너/배너_뮤직컬공연_사칠.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=18">
						<img src="resource/배너/배너_그림전시_영국내셔널갤러리.jpg" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=92">
						<img src="resource/배너/배너_코미디영화_조이라이드.png" class="d-block">
					</a>
				</div>
				<div class="carousel-item">
					<a href="<%= contextPath %>/detail.pr?pno=28">
						<img src="resource/배너/배너_로멘스영화_왕의남자.png" class="d-block">
					</a>
				</div>
			</div>
			<% }%>


			<!-- //이미지 끝 -->

			<!-- 좌우 버튼 시작 -->
			<button class="carousel-control-prev" type="button"
				data-bs-target="#demo" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#demo" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
			<!-- //좌우 버튼 끝 -->

		</div>
		<br>
		<br>
		<!-- //메인배너 끝 -->
		<!-- //랭킹 끝 -->

		<!-- 현재 상영작 시작 -->
		<div class="container">

			<!-- 전체 영화 헤드 태그 시작 -->
			<h1 class="movieHead">
				<a href="">현재 상영작</a>
			</h1>
			<hr>
			<!-- //전체 영화 헤드 태그 끝 -->

			<!-- 전체 포스터 시작 -->
			<div class="row">
				<% if(ctype.equals("서울") || ctype.equals("경기") || ctype.equals("충청") || ctype.equals("전라") || ctype.equals("경상") || ctype.equals("제주")){ %>
				<% for(int i=0; i<lolist.size(); i++){ %>
				<!-- 포스터, 설명글  시작 -->
				<div class="col-md-4">
					<div class="thumbnail">
						<a
							href="<%= contextPath %>/detail.pr?pno=<%= lolist.get(i).getProductNo() %>">
							<img
							src="<%= lolist.get(i).getImagePath() %>/<%= lolist.get(i).getPosterName() %>"
							alt="Lights" style="width: 100%">
							<div class="caption">
								<p><%= lolist.get(i).getProductTitle() %></p><br>
								<pre><%= lolist.get(i).getStartPeriod() %>~<%= lolist.get(i).getEndPeriod() %></pre>
							</div>
						</a>
					</div>
				</div>
				<!-- //포스터, 설명글  끝 -->
				<% } %>
				<% } %>
			</div>
			<!-- //전체 포스터 끝 -->

		</div>
		<!-- //현재 상영작 끝 -->

		<!-- 광고 배너 시작 -->
		<div id="ad">
			<a href="#"><img src="resource/이미지자료/광고배너.jpg"></a>
		</div>
		<!-- //광고 배너 끝 -->

	</div>
	<!-- //윤관현 끝 -->

	<script>
                
   	$(function(){
                 	
	   	let ctype = "<%=ctype%>"
	
		$(".common_tab_btn").attr("aria-selected", "false");
		$("#" + ctype).attr("aria-selected", "true");
	
		$(".minCategory").css("color", "black");

	})
	</script>
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

	<%@ include file="../common/footer.jsp"%>
</body>
</html>