<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <style>
    body{
      font-family: 'Jua', sans-serif;
    }
     #list{
      display: flex;
      height: 60px;
    }
    #select1{
        border: none;
        display: block;
        width: 100px;
        height: 30px;
        border-radius: 5px;
        font-weight: bold;
        margin-right: 5px;
        margin-top: 19.920px;
    }
    #inputs{
      border-radius: 5px;
      border: none;
      width: 180px;
      height: 28px;
      margin-top: 19.920px;
    }
    #button1{
      border: none;
      margin-left: 5px;
      display: block;
      width: 70px;
      height: 30px;
      border-radius: 5px;
      font-weight: bold;
      margin-right: 5px;
      margin-top: 19.920px;
      cursor: pointer;
      line-height: 2.5;
    }
  </style>
</head>
<body>
  <div id="list">
    <h2 style="margin-right: 6px; margin-top: 30px; margin-left: 4px;">상품목록</h2>
    <select id="select1" style="margin-right: 442px; margin-top: 28px; font-family: 'Jua', sans-serif;">
      <option>전체</option>
      <option>영화</option>
      <option>전시</option>
      <option>공연</option>
    </select>
    <select id="select1" style="margin-top: 28px; font-family: 'Jua', sans-serif;">
      <option>상품번호</option>
      <option>상품이름</option>
      <option>지역</option>
    </select>
    <div>
      <input type="text" id="inputs" style="margin-top: 28px;">
    </div>
    <div>
      <button type="submit" id="button1" style="margin-top: 28px; font-family: 'Jua', sans-serif;">검색</button>
    </div>
  </div>
</body>
</html>