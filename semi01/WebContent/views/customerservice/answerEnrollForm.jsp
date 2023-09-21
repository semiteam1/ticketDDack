<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background-color: #f8f9fa; 
        border-radius: 30px;
        color: black;
        width:1000px;
        height: 500px;
        margin: auto;
        margin-top : 50px;
    } /*쓰기 귀찮으면 메뉴바에 추가하면됨*/

    /*#enroll-form table{border: 1px solid white;}*/
    #enroll-form input, #enroll-form textarea{
        width: 100%;
        box-sizing: border-box;
    }
</style>
</head>
<body>
	<%@ include file = "../common/header.jsp" %>
		<div class="outer" align="center">
        <br>
        <h2 align="center">Q&A 작성하기</h2>
        <br>

        <form action="<%= contextPath %>/insert.ao" id="enroll-form" method="post">
            <table>
                <tr>
                    <th width="60">Q&A번호</th>
                    <td width="440"><input type="text" name="qnano" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea name="content" rows="10" style="resize: none;" required></textarea>
                    </td>
                </tr>
            </table>

            <br><br>
            
            
            <div>
            <button type="submit">등록하기</button>
            <button type="reset">초기화</button>
            <button type="button" onclick="history.back();">뒤로가기</button>
            </div>
        
        </form>


    </div>
	
	
	
	
	<%@ include file = "../common/footer.jsp" %>
</body>
</html>