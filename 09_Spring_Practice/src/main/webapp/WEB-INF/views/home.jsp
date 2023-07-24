<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }" />

<html>
<head>
	<title>Home</title>
	<script src="${ path }/js/jquery-3.6.3.js"></script>
</head>
<body>
<h1>
	스프링 MVC 실습 
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ul>
	<li><a href="${ path }/subject/enroll">2. 과목 등록</a></li>
	<li><a href="${ path }/subject/join">3. 과목 담당 교수 지정</a></li>
</ul>

<h2>1. TB_PROFESSOR 테이블에서 데이터 조회 및 출력 (비동기 통신)</h2>

<label for="professorNo">교수 번호 : </label>
<input type="text" id="professorNo" name="professorNo">
<button id="btn1">조회</button>

<p id="result1"></p>

<script>
	$(document).ready(() => {
		$('#btn1').on('click', () => {
			let professorNo = $('#professorNo').val();
			
			$.ajax({
				type: 'GET',
				url: '${ path }/professor',
				dataType: 'json',
				data: {
					professorNo
				},
				success: (obj) => {
					let result = '';
					
					console.log(obj);
					
					if(obj !== null) {
						result = '교수 번호 : ' + obj.no + 
								 '<br>이름 : ' + obj.name + 
								 '<br>주소 : ' + obj.address + 
								 '<br>주민 번호 : ' + obj.ssn;
						
						if(obj.department !== null) {
							result += '<br>학과 번호 : ' + obj.department.no +
									  '<br>학과 이름: ' + obj.department.name +
									  '<br>계열: ' + obj.department.category +
									  '<br>개설 여부: ' + obj.department.openYn +
									  '<br>정원: ' + obj.department.capacity;
						} else {
							result += '<br>학과 : 없음';
						}
					} else {
						result = '교수 정보가 없습니다.';
					}
					
					$('#result1').html(result);
				}
			});
		});
	});
</script>
</body>
</html>
