<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="${ path }/js/jquery-3.6.3.js"></script>
</head>
<body>
	<h2>2. TB_CLASS 테이블에 데이터 추가 (과목 등록)</h2>

	<form id="enrollForm" action="${ path }/subject/enroll" method="POST">
		<label for="no">과목 번호 : </label>
		<input type="text" id="no" name="no" required/>
		
		<br><br>
		
		<label for="deptNo">학과 : </label>
	    <select name="deptNo" id="deptNo" required>
	        <option selected>------선택------</option>
	        <c:forEach var="department" items="${ departments }">
	        	<option value="${ department.no }">${ department.name }</option>
	        </c:forEach>
	    </select>
		
		<br><br>
			
		<label for="preattendingNo">선수 과목 : </label>
	    <select name="preattendingNo" id="preattendingNo">
	        <option selected value=''>------선택------</option>
	    </select>
		
		<br><br>
		
		<label for="name">과목 이름 : </label>
		<input type="text" id="name" name="name" required/>
		
		<br><br>
		
		<label for="type">과목 구분 : </label>
		<input type="text" id="type" name="type" list="classTypeList"/>
		
	    <datalist id="classTypeList">
	        <option value="전공필수">전공필수</option>
	        <option value="전공선택">전공선택</option>
	        <option value="논문지도">논문지도</option>
	    </datalist>
		
		<br><br>
		
		<security:csrfInput/>
		<input type="submit" value="개설">
		<input type="reset" value="취소">
	</form>
	
	<script>
		$(document).ready(() => {
			$('#enrollForm').on('submit', () => {
				if($('#preattendingNo').val() === '') {
					$('#preattendingNo').prop('disabled', true);					
				}
				if($('#type').val() === '') {
					$('#type').prop('disabled', true);					
				}
			});
			
			$('#deptNo').on('change', () => {
				let deptNo = $('#deptNo>option:selected').val();

				$.ajax({
					type: 'GET',
					url: '${ path }/subjects/' + deptNo,
					dataType: 'json',
					success: (subjects) => {
						console.log(subjects);
						
						$('#preattendingNo').empty();
						$('#preattendingNo').append('<option selected value="">------선택------</option>');
						
						for (let i = 0; i < subjects.length; i++) {
							$('#preattendingNo').append('<option value="' + subjects[i].no + '">' + subjects[i].name + '</option>');
						}
					}
				});
			});
		});
	</script>
</body>
</html>