<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<link rel="stylesheet" href="${path }/resources/css/common_css/uglyFD-main.css">
<!-- uglyFD-figure / section 부분 script -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="/views/common/header.jsp" />

<style>
    section>div#board-write-container{width:600px; margin:0 auto; text-align:center;}
    section>div#board-write-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    div#comment-container button#btn-insert{width:60px;height:50px; color:white; background-color:#3300FF;position:relative;top:-20px;}
    
    /*댓글테이블*/
    table#tbl1-comment123{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl1-comment123 tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl1-comment123 tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl1-comment123 tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl1-comment123 button.btn-delete{display:none;}
    table#tbl1-comment123 tr:hover {background:lightgray;}
    table#tbl1-comment123 tr:hover button.btn-delete{display:inline;}
    table#tbl1-comment123 sub.comment-writer {color:navy; font-size:14px}
    table#tbl1-comment123 sub.comment-date {color:tomato; font-size:10px}
</style>
<section id="content">   
   <div id="board-write-container">
   <br><br>
      <h2>1대1 문의사항</h2>
      <table id="tbl-board">
         <tr>
            <th>글번호</th>
            <td>${ board.no }</td>
         </tr>
         <tr>
            <th>제 목</th>
            <td>${ board.title }</td>
         </tr>
         <tr>
            <th>작성자</th>
            <td>${ board.writerId }</td>
         </tr>
         <tr>
            <th>조회수</th>
            <td>${ board.readCount }</td>
         </tr>
         <tr>
            <th>첨부파일</th>
            <td>
               <c:if test="${ empty board.originalFileName }">
                  <span> - </span>
               </c:if>
               <c:if test="${ not empty board.originalFileName }">
                  <%-- 
                  <a href="javascript:" id="fileDown">
                     <span> ${ board.originalFileName } </span>
                  </a>
                  --%>
                  <a href="${ path }/resources/upload/board/${board.renamedFileName}">
                     <span> ${ board.originalFileName } </span>
                  </a>
               </c:if>
            </td>
         </tr>
         <tr>
            <th>내 용</th>
            <td>${ board.content }</td>
         </tr>
         <%--글작성자/관리자인경우 수정삭제 가능 --%>
         <tr>
            <th colspan="2">
               <c:if test="${ not empty loginMember && loginMember.id == board.writerId }">
                  <button type="button" onclick="location.href='${ path }/board/update?no=${ board.no }'">수정</button>
                  <button type="button" id="btnDelete">삭제</button>
               </c:if>
               <button type="button" onclick="location.href='${ path }//board/inquire'">목록으로</button>
            </th>
         </tr>
      </table>
      <br>
      <div id="comment-container">
          <div class="comment-editor">
             <form action="${ path }/board/reply" method="POST">
                <input type="hidden" name="boardNo" value="${ board.no }">
               <textarea name="content" id="replyContent" cols="55" rows="2" style="resize:none;"></textarea>
               <button type="submit" id="btn-insert">등록</button>                
             </form>
          </div>
       </div>
       <table id="tbl1-comment123">
          <c:forEach var="reply" items="${ board.replies }">
                <tr class="level1">
                <td>
                   <sub class="comment-writer">${ reply.writerId }</sub>
                   <sub class="comment-date">${ reply.createDate }</sub>
<!--                                       <sub class="comment-writer">aa</sub> -->
<!--                    <sub class="comment-date">123</sub> -->
                   <br>
                   <span>${ reply.content }</span>
<!--                    <span>123</span> -->
                </td>
                <td>
                   <c:if test="${ not empty loginMember && loginMember.id == reply.writerId }">
                      <button>삭제</button>
                   </c:if>
                </td>
             </tr>
          </c:forEach>
          <br>
       </table>
    </div>
</section>
<script>
   $(document).ready(() => {
      $('#btnDelete').on('click', () => {
         if(confirm('삭제 하시겠습니까?')) {
            location.replace('${ path }/board/delete?no=${ board.no }');
         }
      });
      
      $('#fileDown').on('click', () => {
         let oname = encodeURIComponent('${ board.originalFileName }');
         let rname = encodeURIComponent('${ board.renamedFileName }');
         
         location.assign('${ path }/board/fileDown?oname=' + oname + '&rname=' + rname);
      });
      
      $('#replyContent').on('focus', () => {
         if(${ empty loginMember}) {
            alert('로그인 후 이용해 주세요.')   ;
            
            $('#userId').focus();
         }
      });
   });
</script>
<jsp:include page="/views/common/footer.jsp" /> 