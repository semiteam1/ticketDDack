<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <title>Document</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <style>
      div{box-sizing: border-box;}
      body{
      font-family: 'Jua', sans-serif;
      }
      #tb1{
        width: 100%;
        table-layout: fixed; /* 테이블 레이아웃을 고정으로 설정 */
        width: 100%; /* 테이블 전체 너비 설정 */
      }
      td {
        max-height: 1.5em;
        overflow: hidden;
        white-space: nowrap; /* 텍스트 줄 바꿈 방지 */
        text-overflow: ellipsis; /* ...으로 텍스트 표시 */
      }
      #tb1 tr:last-child{
        border-bottom: none;
      }
      #tb1 tr{
        text-align: center;
        display: block;
        border-bottom: 2px solid #ABBBC7;
        width: 100%;
        display: flex;
      }
      #tb1 tr:not(:first-child){
        cursor: pointer;
      }
      #tb1 tr th:not(:last-child){
        border-right: 2px solid #ABBBC7;
        display: block;
      }
      #tb1 tr td:not(:last-child){
        border-right: 2px solid #ABBBC7;
        display: block;
      }
      #td1{
        width: 10%;
      }
      #td2{
        width: 39%;
      }
      #td3{
        width: 13%;
      }
      #td4{
        width: 13%;
      }
      #td5{
        width: 10%;
        border-right: none;
      }
      #td6{
        width: 8%;
      }
      #td7{
        width: 5%;
      }
      #td8{
        width: 5%;
      }
      #buttondiv{
        width: 396px;
        margin: auto;
        margin-top: 28px;
        display: flex;
      }
      #buttondiv>.btn2{
        width: 31px;
        height: 31px;
        display: block;
        margin-right: 2px;
        border-radius: 5px;
        border: none;
        background-color: #ABBBC7;
        font-weight: bold;
        cursor: pointer;
      }
      #buttondiv>.btn2:hover{
        background-color: darkgray;
      }
      #tb1 tr:not(:first-child):hover{
        background-color: darkgray;
        font-weight: bold;
      }
      #tb1 button{
        border: none;
        border-radius: 5px;
        width: 100%;
        height: 100%;
      }
      #tb1 button:hover{
        cursor: pointer;
        background-color: darkgray;
        font-weight: bold;
        color: black;
      }
      .modal {
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.4);
      align-items: center;
      justify-content: center;
    }
    .modal1{
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.4);
      align-items: center;
      justify-content: center;
    }
    .modal2{
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.4);
      align-items: center;
      justify-content: center;
    }
    .modal-content {
    background-color: #C9D9E6;
    padding: 5px;
    border: 1px solid #888;
    width: 658px;
    height: 657px;
    margin: auto;
    margin-top: 4px;
    border-radius: 10px;
    }
    .modal-content1{
      background-color: #C9D9E6;
      padding: 5px;
      border: 1px solid #888;
      width: 750px;
      height: 657px;
      margin: auto;
      margin-top: 4px;
      border-radius: 10px;
    }
    .modal-content2{
      background-color: #C9D9E6;
      padding: 5px;
      border: 1px solid #888;
      width: 647px;
      height: 577px;
      margin: auto;
      margin-top: 39px;
      border-radius: 10px;
    }
    .close {
    color: black;
    font-size: 28px;
    font-weight: bold;
    display: block;
    width: 20px;
    height: 29px;
    text-align: center;
    margin-left: 625px;
    margin-top: -7px;
    margin-bottom: 2px;
    }
    .close1{
      color: black;
      font-size: 28px;
      font-weight: bold;
      display: block;
      width: 20px;
      height: 29px;
      text-align: center;
      margin-left: 716px;
      margin-top: -7px;
      margin-bottom: 2px;
    }
    .close2{
      color: black;
      font-size: 28px;
      font-weight: bold;
      display: block;
      width: 20px;
      height: 29px;
      text-align: center;
      margin-left: 615px;
      margin-top: -7px;
      margin-bottom: 6px;
    }
  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
  .close1:hover,
  .close1:focus{
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
  .close2:hover,
  .close2:focus{
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
  #table2{
    font-weight: bold;
  }
  #table2 .god1{
    border: none;
    border-radius: 5px;
    height: 23px;
    width: 250px;
  }
  .tb2-btn{
    font-weight: bold;
    border: none;
    background-color: white;
    border-radius: 5px;
    width: 71px;
    height: 26px;
    cursor: pointer;
  }
  .tb2-btn:hover{
    background-color: darkgray;
  }
  #table2 tr{
    height: 32px;
  }
  .gta1{
    border: none;
    border-radius: 5px;
    width: 64px;
    height: 26px;
    margin-top: 3px;
    cursor: pointer;
    font-weight: bold;
    background-color: white;
  }
  .gta1:hover{
    background-color: darkgray;
  }
  #table2{
  font-weight: bold;
  }
  #table2 .god1{
  border: none;
  border-radius: 5px;
  height: 23px;
  width: 250px;
  }
  .tb2-btn{
  font-weight: bold;
  border: none;
  background-color: white;
  border-radius: 5px;
  width: 71px;
  height: 26px;
  cursor: pointer;
  }
  .tb2-btn:hover{
  background-color: darkgray;
  }
  #table2 tr{
  height: 32px;
  }
  .gta1{
  border: none;
  border-radius: 5px;
  width: 64px;
  height: 26px;
  margin-top: 3px;
  cursor: pointer;
  font-weight: bold;
  background-color: white;
  }
  .gta1:hover{
  background-color: darkgray;
  }
  .custom-file-input {
      visibility: hidden; /* 기본 파일 선택 버튼 숨김 */
      display: none;
      width: 0;
      height: 0;
  }
  .custom-file-label {
      background-color:#ABBBC7;
      display: block;
      width: 50px;
      border:none;
      padding: 6px 12px;
      cursor: pointer;
      font-weight: bold;
      border-radius: 5px;
      margin-top: 2px;
      height: 21px;
      text-align: center;
      line-height: 1.5;
  }
  #table3 input[type="text"]{
      border: none;
      border-radius: 5px;
      height: 30px;
      margin-top: 2px;
      margin-left: 10px;
  }
  #table2 input{
    font-weight: bold;
  }
  #table2 select{
    font-weight: bold;
  }
  #table3 input{
    font-weight: bold;
  }
  .popup {
    width: 100%;
    height: 100%;
    background-color: darkgray;
    padding: 20px;
    text-align: center;
    box-sizing: border-box;
  }
  #selectbox1{
      border: none;
      height: 25px;
      border-radius: 5px;
      font-weight: bold;
      margin-right: 4px;
    }
    #searchArea1{
      border: none;
      height: 23px;
      border-radius: 5px;
      margin-right: 4px;
    }
    #searchBtn1{
      border: none;
      border-radius: 5px;
      height: 25px;
      font-weight: bold;
    }
    #searchBtn1:hover{
      background-color: darkgray;
      cursor: pointer;
    }
    #textarea1{
      width: 600px;
      border: none;
      border-bottom: 2px solid darkgray;
      border-radius: 5px;
    }
    #tables4{
      font-weight: bold;
      text-align: left;
    }
    #delBtn1{
      border: none;
      border-radius: 5px;
      font-weight: bold;
      height: 25px;
      background-color: white;
    }
    #delBtn1:hover{
      cursor: pointer;
      background-color: darkgray;
    }
    #tables4 tr{
      width: 400px;
    }
    #tables5{
      font-weight: bold;
      text-align: left;
      width: 600px;
    }
    #tables5 tr{
      display: flex;
    }
    #tables4Div{
      width: 635px;
      height: 417px;
      overflow: auto;
    }
    #buttondiv{
      width: 396px;
      margin: auto;
      margin-top: 24px;
      display: flex;
    }
    #buttondiv>.btn2{
      width: 31px;
      height: 31px;
      display: block;
      margin-right: 2px;
      border-radius: 5px;
      border: none;
      background-color: #ABBBC7;
      font-weight: bold;
      cursor: pointer;
    }
    #buttondiv>.btn2:hover{
      background-color: darkgray;
    }
  </style>
</head>
<body>
  <div class="outer">
    <table id="tb1">
      <tr>
        <th style="width: 101px;">상품번호</th>
        <th style="width: 392px;">상품이름</th>
        <th style="width: 131px;">시작날짜</th>
        <th style="width: 131px;">종료날짜</th>
        <th style="width: 100px;">지역</th>
        <th style="border-right: none;"></th>
        <th></th>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
      <tr>
        <td id="td1" class="modal-trigger">10231</td>
        <td id="td2" class="modal-trigger">분노의질주</td>
        <td id="td3" class="modal-trigger">2023/07/02</td>
        <td id="td4" class="modal-trigger">2023/09/03</td>
        <td id="td5" class="modal-trigger">경기/인천</td>
        <td id="td6"><button class="reviewbtn" style="font-family: 'Jua', sans-serif;">리뷰보기</button></td>
        <td id="td7"><button style="font-family: 'Jua', sans-serif;">삭제</button></td>
      </tr>
    </table>
    <div id="buttondiv" style="margin-top: 10px;">
      <button class="btn2" style="font-family: 'Jua', sans-serif;"><</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">1</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">2</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">3</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">4</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">5</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">6</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">7</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">8</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">9</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">10</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">></button>
    </div>
  </div>
  <div class="modal" id="modal" style="width: 1016px; height: 674.391px; position: absolute; box-sizing: border-box; left: 0; top: 0;">
    <div class="modal-content">
      <div class="close" id="closeButton" style="border:none;">
        &times;
      </div>
      <p id="modalText" style="margin-top: 0;"></p>
    </div>
  </div>
  <div class="modal1" id="modal1" style="width: 1016px; height: 674.391px; position: absolute; box-sizing: border-box; left: 0; top: 0;">
    <div class="modal-content1">
      <div class="close1" id="closeButton1">
        &times;
      </div>
      <p id="modalText1" style="margin-top: 0;"></p>
    </div>
  </div>
  <div class="modal2" id="modal2" style="width: 1016px; height: 674.391px; position: absolute; box-sizing: border-box; left: 0; top: 0;">
    <div class="modal-content2">
      <div class="close2" id="closeButton2">
        &times;
      </div>
      <p id="modalText2" style="margin-top: 0;"></p>
    </div>
  </div>

  <script>
    $(function(){
      $("#tb1 tr:not(:first-child)").hover(function(){
        $(this).css("background-color", "darkgray");
        $(this).find("td:not(:last-child)").css("border-right", "2px solid darkgray");
        $(this).css("font-weight", "bold");
      },
      function(){
        $(this).css("background-color", "#EDEDED");
        $(this).find("td:not(:last-child)").css("border-right", "2px solid #ABBBC7");
        $(this).css("font-weight", "normal");
      });
    });

    const modalTriggerElements = document.querySelectorAll(".modal-trigger");
    const modal = document.getElementById("modal");
    const closeButton = document.getElementById("closeButton");
    const modalText = document.getElementById("modalText");

    const modal1 = document.getElementById("modal1");
    const closeButton1 = document.getElementById("closeButton1");
    const modalText1 = document.getElementById("modalText1");

    const modal2 = document.getElementById("modal2");
    const closeButton2 = document.getElementById("closeButton2");
    const modalText2 = document.getElementById("modalText2");

    modalTriggerElements.forEach(function(triggerElement) {
      triggerElement.addEventListener("click", function() {
        modal.style.display = "block";
        modalText.innerHTML = `
        <div style="display: flex;">
    <div class="outer" style="margin-left: 115px;">
      <table id="table2" align="center">
        <tr>
          <td>상품번호</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>카테고리</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>상품명</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>지역</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>상세장소</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>시작날짜</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>종료날짜</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>관람등급</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>상영시간</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>가격</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
        <tr>
          <td>오전</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>오후</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
        <tr>
          <td>오전 좌석수</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>오후 좌석수</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
        <tr>
          <td colspan="4" align="center">
            <button id="modbtn1" class="tb2-btn" style="margin-left: 75px; font-family: 'Jua', sans-serif;" onclick="funx1();">수정</button>
            <button class="tb2-btn" onclick="canc();" style="font-family: 'Jua', sans-serif;">취소</button>
          </td>
        </tr>
      </table>
    </div>
    <div>
      <table id="table3">
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">포스터</button></td>
        </tr>
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">상세1</button></td>
        </tr>
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">상세2</button></td>
        </tr>
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">상세3</button></td>
        </tr>
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">상세4</button></td>
        </tr>
        <tr>
          <td><button class="gta1 poster" style="font-family: 'Jua', sans-serif;">상세5</button></td>
        </tr>
      </table>
    </div>
  </div>`;
  funcx3();
      });
    });

    closeButton.addEventListener("click", function() {
      modal.style.display = "none";
    });

    window.addEventListener("click", function(event) {
      if (event.target === modal) {
        modal.style.display = "none";
      }
    });

    closeButton1.addEventListener("click", function() {
      modal1.style.display = "none";
    });

    window.addEventListener("click", function(event) {
      if (event.target === modal1) {
        modal1.style.display = "none";
      }
    });
    
    // 페이지 로딩 후 모달을 숨기는 부분 추가
    modal.style.display = "none";

    function funx1(){
      modal.style.display = "none";
      modal1.style.display = "block";
      modalText1.innerHTML = `
      <div style="display: flex;">
    <div class="outer" style="margin-left: 44px;">
      <table id="table2" align="center">
        <tr>
          <td>상품번호</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>카테고리</td>
          <td colspan="3" style="display: flex;">
            <select class="god1" style="width: 48.5%; height: 26px; margin-right: 5px; margin-top: 2.5px; font-family: 'Jua', sans-serif;">
              <option>영화</option>
              <option>전시</option>
              <option>공연</option>
            </select>
            <select class="god1" style="width: 49%; height: 26px; margin-top: 2.5px; font-family: 'Jua', sans-serif;">
              <option>로맨스</option>
              <option>액션</option>
              <option>공포</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>상품명</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>지역</td>
          <td colspan="3">
            <select class="god1" style="width: 254px; height: 26px; font-family: 'Jua', sans-serif;">
              <option value="all">서울</option>
              <option value="seven">경기/인천</option>
              <option value="twelve">충청/강원</option>
              <option value="fifteen">대구/경북</option>
              <option value="eighteen">부산/경남</option>
              <option value="eighteen">광주/전라</option>
              <option value="eighteen">제주</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>상세장소</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>시작날짜</td>
          <td colspan="3"><input type="date" class="god1" style="width: 254px; height: 26px; font-family: 'Jua', sans-serif;"></td>
        </tr>
        <tr>
          <td>종료날짜</td>
          <td colspan="3"><input type="date" class="god1" style="width: 254px; height: 26px; font-family: 'Jua', sans-serif;"></td>
        </tr>
        <tr>
          <td>관람등급</td>
          <td colspan="3">
            <select class="god1" style="width: 254px; height: 26px; font-family: 'Jua', sans-serif;">
              <option value="all">전체</option>
              <option value="seven">7</option>
              <option value="twelve">12</option>
              <option value="fifteen">15</option>
              <option value="eighteen">18</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>상영시간(분)</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>가격</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
        <tr>
          <td>오전</td>
          <td colspan="3">
            <label for="before">Y</label>
            <input type="checkbox" id="before" value="before">
            <label for="after">N</label>
            <input type="checkbox" id="after" value="after">
          </td>
        </tr>
        <tr>
          <td>오후</td>
          <td colspan="3">
            <label for="before">Y</label>
            <input type="checkbox" id="before" value="before">
            <label for="after">N</label>
            <input type="checkbox" id="after" value="after">
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
        <tr>
          <td>오전 좌석수</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td>오후 좌석수</td>
          <td colspan="3"><input type="text" class="god1"></td>
        </tr>
        <tr>
          <td colspan="4">
            <hr>
          </td>
        </tr>
      </table>
    </div>
    <div>
      <table id="table3">
        <tr>
          <td>
            <div style="display: flex;">
                <label class="custom-file-label" for="customFile1" style="margin-left: 1px;">
                    포스터
                </label>
                <input type="file" id="customFile1" class="custom-file-input">
                <input type="text" id="filePath1" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div style="display: flex; margin-top: 0px;">
                <label class="custom-file-label" for="customFile2" style="margin-left: 1px;">
                    상세1
                </label>
                <input type="file" id="customFile2" class="custom-file-input">
                <input type="text" id="filePath2" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div style="display: flex; margin-top: 0px;">
                <label class="custom-file-label" for="customFile3" style="margin-left: 1px;">
                    상세2
                </label>
                <input type="file" id="customFile3" class="custom-file-input">
                <input type="text" id="filePath3" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div style="display: flex; margin-top: 0px;">
                <label class="custom-file-label" for="customFile4" style="margin-left: 1px;">
                    상세3
                </label>
                <input type="file" id="customFile4" class="custom-file-input">
                <input type="text" id="filePath4" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div style="display: flex; margin-top: 0px;">
                <label class="custom-file-label" for="customFile5" style="margin-left: 1px;">
                    상세4
                </label>
                <input type="file" id="customFile5" class="custom-file-input">
                <input type="text" id="filePath5" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div style="display: flex; margin-top: 0px;">
                <label class="custom-file-label" for="customFile6" style="margin-left: 1px;">
                    상세5
                </label>
                <input type="file" id="customFile6" class="custom-file-input">
                <input type="text" id="filePath6" placeholder="사진을 선택하시오" style="width: 200px; font-family: 'Jua', sans-serif;">
            </div>
          </td>
        </tr>
      </table>
    </div>
</div>
<div align="center">
  <button class="tb2-btn" style="font-family: 'Jua', sans-serif; line-height: 2">수정완료</button>
  <button class="tb2-btn" style="font-family: 'Jua', sans-serif; line-height: 2">취소</button>
</div>
`;
funcx2();
}
function funcx2(){
  
  const imageInput1 = document.getElementById('customFile1');
    const imagePathInput1 = document.getElementById('filePath1');

    imageInput1.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput1.value = fileName; // 입력란에 경로 설정
        }
    });

    const imageInput2 = document.getElementById('customFile2');
    const imagePathInput2 = document.getElementById('filePath2');

    imageInput2.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput2.value = fileName; // 입력란에 경로 설정
        }
    });

    const imageInput3 = document.getElementById('customFile3');
    const imagePathInput3 = document.getElementById('filePath3');

    imageInput3.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput3.value = fileName; // 입력란에 경로 설정
        }
    });

    const imageInput4 = document.getElementById('customFile4');
    const imagePathInput4 = document.getElementById('filePath4');

    imageInput4.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput4.value = fileName; // 입력란에 경로 설정
        }
    });

    const imageInput5 = document.getElementById('customFile5');
    const imagePathInput5 = document.getElementById('filePath5');

    imageInput5.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput5.value = fileName; // 입력란에 경로 설정
        }
    });

    const imageInput6 = document.getElementById('customFile6');
    const imagePathInput6 = document.getElementById('filePath6');

    imageInput6.addEventListener('change', function(event) {
    const selectedFile = event.target.files[0]; // 선택한 파일의 정보 가져오기
        if (selectedFile) {
            const fileName = selectedFile.name;
            imagePathInput6.value = fileName; // 입력란에 경로 설정
        }
    });
  }

  function funcx3(){
    var openButtons = document.getElementsByClassName("poster");

    for (var i = 0; i < openButtons.length; i++) {
      openButtons[i].addEventListener("click", function() {

        // 새 창을 전체 화면으로 열기 위한 옵션 설정
        var windowOptions = "fullscreen=yes";

        // 새 창 열기
        var popupWindow = window.open("", "_blank", windowOptions);

        // 새로 열린 창에 콘텐츠 추가 (DIV와 이미지)
        if (popupWindow) {
          popupWindow.document.title = "상품사진";
          var popupContent = document.createElement("div");
          popupContent.className = "popup";
          popupContent.style.display = "flex";
          popupContent.style.justifyContent = "center";
          popupContent.style.alignItems = "center";
          popupContent.style.padding = "20px";
          popupContent.style.textAlign = "center";
          popupContent.style.boxSizing = "border-box";
          popupContent.style.width = "100%";
          popupContent.style.height = "100%";

          var image = document.createElement("img");
          image.src = "/resources/그린국악 상세정보.jpg"; // 이미지 파일 경로를 적절히 수정해야 합니다.

          popupContent.appendChild(image);
          popupWindow.document.body.appendChild(popupContent);

          popupWindow.scrollTo(0, 0);
        } else {
          alert("팝업 창이 차단되었거나 열 수 없습니다.");
        }
      });
    }
  }

  function canc(){
    modal.style.display = "none";
  }

  var reviewbtn = document.querySelectorAll(".reviewbtn");

  reviewbtn.forEach(function(button) {
    button.addEventListener("click", function() {
      modal2.style.display = "block";
      modalText2.innerHTML = `
      <div style="display: flex;">
    <select id="selectbox1" style="margin-left: 309px; font-family: 'Jua', sans-serif;">
      <option>리뷰번호</option>
      <option>작성자</option>
      <option>리뷰작성날짜</option>
    </select>
    <input type="text" id="searchArea1">
    <button id="searchBtn1" style="font-family: 'Jua', sans-serif;">검색</button>
  </div>
  <hr>
  <div>
    <table id="tables5">
      <tr style="width: 600px;">
        <td style="width: 150px;">리뷰번호</td>
        <td style="width: 150px;">회원번호</td>
        <td style="width: 150px;">작성날짜</td>
        <td></td>
      </tr>
    </table>
    <div id="tables4Div" style="background-color: #EDEDED;">
      <table id="tables4">
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
        <tr style="width: 600px;">
          <td style="width: 150px;">101</td>
          <td style="width: 150px;">20213</td>
          <td style="width: 150px;">2023/01/23</td>
          <td style="width: 150px;">
            <button id="delBtn1" style="margin-left: 103px; font-family: 'Jua', sans-serif;">삭제</button>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea cols="30" rows="5" style="resize: none;" id="textarea1"></textarea>
          </td>
        </tr>
      </table>
    </div>
    <div id="buttondiv" style="margin-left: 201px; margin-top: 13px;">
      <button class="btn2" style="font-family: 'Jua', sans-serif;"><</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">1</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">2</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">3</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">4</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">5</button>
      <button class="btn2" style="font-family: 'Jua', sans-serif;">></button>
    </div>
  </div>
      `;
    });
  });

  closeButton2.addEventListener("click", function() {
      modal2.style.display = "none";
    });

  window.addEventListener("click", function(event) {
    if (event.target === modal2) {
      modal2.style.display = "none";
    }
  });

  </script>
</body>
</html>