<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="${ path }/js/jquery-3.6.3.js"></script>
</head>
<body>
	<h2>3. TB_CLASS_PROFESSOR 테이블에 데이터 추가 (과목 담당 교수 지정)</h2>
	
	<form id="joinForm" action="${ path }/subject/join" method="POST">		
		<label for="deptNo">학과 : </label>
	    <select name="deptNo" id="deptNo" required>
	        <option selected>------선택------</option>
	        <c:forEach var="department" items="${departments}">
	        	<option value="${ department.no }"><c:out value="${ department.name }" /></option>
	        </c:forEach>
	    </select>
		
		<br><br>
			
		<label for="classNo">과목 : </label>
	    <select name="classNo" id="classNo">
	        <option selected value=''>------선택------</option>
	    </select>
		
		<br><br>
		
		<label for="professorNo">교수 : </label>
	    <select name="professorNo" id="professorNo">
	        <option selected value=''>------선택------</option>
	    </select>
		
		<br><br>
		
		<security:csrfInput/>
		<input type="submit" value="지정">
		<input type="reset" value="취소">
	</form>
	<script>
		$(document).ready(() => {
		    $("#joinForm").on("submit", () => {
	        	$('#deptNo').prop('disabled', true);
		    });
		    
			$('#deptNo').on('change', () => {
				let deptNo = $('#deptNo>option:selected').val();
				
				$.ajax({
					type: 'GET',
					url: '${ path }/subjects/' + deptNo,
					dataType: 'json',
					success: (subjects) => {
						console.log(subjects);
						
						$('#classNo').empty();
						$('#classNo').append('<option selected value="">------선택------</option>');
						
						for(let i = 0; i < subjects.length; i++){                
			                $('#classNo').append('<option value="' + subjects[i].no + '">' + subjects[i].name + '</option>');
			            }
					}
				});
				
				$.ajax({
					type: 'GET',
					url: '${ path }/professors/' + deptNo,
					dataType: 'json',
					success: (professors) => {
						console.log(professors);
						
						$('#professorNo').empty();
						$('#professorNo').append('<option selected value="">------선택------</option>');
						
						for(let i = 0; i < professors.length; i++){                
			                $('#professorNo').append('<option value="' + professors[i].no + '">' + professors[i].name + '</option>');
			            }
					}
				});
			});
		});
	</script>
</body>
</html>