<%@page import="java.util.Locale"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.kh.semi01.user.model.vo.Grade"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.kh.semi01.book.model.vo.BookNPayment"%>
<%@page import="com.kh.semi01.book.model.dao.BookNPaymentDao"%>
<%@page import="com.kh.semi01.user.model.vo.User"%>
<%@page import="com.kh.semi01.product.model.vo.Product"%>
<%@page import="com.kh.semi01.user.model.service.UserService"%>
<%@page import="com.kh.semi01.user.model.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	User loginMember = (User)request.getAttribute("loginMember");
	
	String grade_name = loginMember.getGrade();
	
	//Grade g = (Grade)request.getAttribute("g");
	
	double grade_discount = (grade_name.equals("아이언"))? 0 : (grade_name.equals("브론즈"))? 0.01 : (grade_name.equals("실버"))? 0.05 : (grade_name.equals("골드"))? 0.1 : 0.15; 
	
	//double grade_discount = g.getGradeDiscount();
	
	String discountPer = (int)(grade_discount * 100) + "%";
	
	Product p = (Product)request.getAttribute("p");
	
	DecimalFormat df = new DecimalFormat("###,###,###");
	
	String originPrice = df.format(p.getPrice());
	
	String bookPrice = df.format(p.getPrice() - ((int)p.getPrice() * grade_discount));
	
	BookNPayment bp = (BookNPayment)request.getAttribute("bp");
	
	StringTokenizer st = new StringTokenizer(bp.getBookedDate(), "-");
	
	ArrayList<String> list = new ArrayList<>();
	
	while(st.hasMoreTokens()) {
		list.add(st.nextToken());
	}
	
	LocalDate date = LocalDate.of(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
	
	String day = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티켓딱대</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	div {
		/* border: 1px solid red; */
	}
	.outer {
		height: 900px;
	}
	.outer>div {
		width: 100%;
	}
	#logo {
		height: 12%;
	}
	#book-info {
		height: 28%;
		line-height: 2;
		border-bottom: 1px solid #cecece;
		padding-bottom: 20px;
	}
	#product-info {
		height: 20%;
		line-height: 2;
		border-bottom: 1px solid #cecece;
		padding-bottom: 20px;
	} 
	h6 {
		margin: 20px;
		font-weight: bold;
	}
	th {
		width: 150px;
		text-align: center;
	}
	#user-info {
		height: 50%;
		line-height: 2;
	}
	#payBtn {
		width: 100%;
		margin-top: 20px;
	}
	#payBtn>button {
		margin: 10px;
        display: block;
        height: 35px;
        padding: 0 12px;
        line-height: 32px;
        border-radius: 3px;
        border: 1px solid #bbb;
        box-sizing: border-box;
        background-color: #f9f9f9;
        text-decoration: none;
        text-align: center;
        font-size: 13px;
        color: #202020;
	}
	#payBtn>button:hover {
		cursor: pointer;
		opacity: 0.7;
	}
	#credit {
		display: none;
	}
	th, td {
		border: 1px  solid #cecece;
	}
</style>
</head>
<body>
	<div class="outer" align="center">
		<div id="logo" align="center">
			<img width="200" height="100" src="resource/logo/logo.png">
		</div>
		<form action="<%= contextPath %>/payment.bo" method="post">
		
			<input type="hidden" name="userNo" value="<%= loginMember.getUserNo() %>">
			<input type="hidden" name="productNo" value="<%= p.getProductNo() %>">
			<input type="hidden" name="screenDate" value="<%= bp.getBookedDate() %>">
			<input type="hidden" name="screenTime" value="<%= bp.getScreenTime() %>">
			
			<input type="hidden" name="userName" value="<%= loginMember.getUserName() %>">
			<input type="hidden" id="price" name="price" value="<%= bookPrice %>">
			
			<div id="book-info">
				<h6>예매 정보 확인</h6>
				<table>
					<tr>
						<th>관람 인원수</th>
						<td colspan="2">
							<select name="audience" id="audience" onchange="chooseAudience(this.value);">
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>결제수단</th>
						<td>
							<select name="payment" id="payment" onchange="payTool(this.value);">
								<option value="10">계좌이체</option>
								<option value="20">신용카드</option>
							</select>
						</td>
						<td id="credit">
							<select disabled name="card" id="card">
								<option value="10">카드종류를 선택하세요</option>
								<option value="21">국민카드</option>
								<option value="22">신한카드</option>
								<option value="23">우리카드</option>
								<option value="24">하나카드</option>
								<option value="25">현대카드</option>
								<option value="26">삼성카드</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>할인</th>
						<td colspan="2">
							<b style="color: red;"><u><%= grade_name %></u></b>등급 할인 <b style="color: red;"><u><%= discountPer %></u></b> 적용
						</td>
					</tr>
					<tr>
						<th>티켓 수령방법</th>
						<td colspan="2">현장수령</td>
					</tr>
				</table>
			</div>
			<div id="product-info">
				<h6>공연 정보 확인</h6>
				<table>
					<tr>
						<th>공연 제목</th>
						<td><%= p.getProductTitle() %></td>
					</tr>
					<tr>
						<th>공연 장소</th>
						<td><%= p.getAddress() %></td>
					</tr>
					<tr>
						<th>공연 일시</th>
						<td><%= bp.getBookedDate() %>(<%= day %>) <%= bp.getScreenTime() %></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><span id="bookPrice"><%= bookPrice %></span>원 (<span id="originPrice"><%= originPrice %></span>원 - <b style="color: red;"><u><%= grade_name %></u></b> 등급 <b style="color: red;"><u><%= discountPer %></u></b> 할인 금액)</td>
					</tr>
				</table>
			</div>
			<div id="user-info">
				<h6>주문자 정보 확인</h6>
				<table>
					<tr>
						<th>이름</th>
						<td><%= loginMember.getUserName() %></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="date" name="inputBirth" required></td>
						<input type="hidden" name="userBirth" value="<%= loginMember.getUserBirth() %>">
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%= loginMember.getPhone() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= (loginMember.getEmail() == null)? "" : loginMember.getEmail() %></td>
					</tr>
				</table>
			</div>
			<div id="payBtn" align="center">
				<button type="submit" onclick="return checkInfo();">결제하기</button>
			</div>
		</form>

		<script>

			function payTool(value) {

				if(value == 20) {
					$("#credit").css("display", "block");
					alert("죄송합니다. 현재는 계좌이체로만 결제가 가능합니다.");
				}
				else {
					$("#credit").css("display", "none");
				}

			}
			
			function chooseAudience(num) {
				
				let audience = num;
				const price = <%= p.getPrice() %>;
				const discount = <%= grade_discount %>;
				
				$("#originPrice").text((price * audience).toLocaleString());
				
				$("#bookPrice").text(((price * audience) * (1 - discount)).toLocaleString());
				
				$("#price").val(((price * audience) * (1 - discount)).toLocaleString());
				
			}

			function checkInfo() {
				
				if($("input[name=inputBirth]").val() == $("input[name=userBirth]").val()) {
					
					return confirm("예매 관련 정보를 모두 확인하셨나요?");
					
				}
				else {
					
					alert("생년월일을 잘못 입력하셨습니다.");
					
					$("input[name=userBirth]").focus();
					
					return false;
					
				}

			}

		</script>

	</div>
	
	<!-- <iframe
		id="inlineFrameExample"
		title="Inline Frame Example"
		width="300"
		height="200"
		src="https://www.openstreetmap.org/export/embed.html?bbox=-0.004017949104309083%2C51.47612752641776%2C0.00030577182769775396%2C51.478569861898606&layer=mapnik"
		>
	</iframe> -->
</body>
</html>