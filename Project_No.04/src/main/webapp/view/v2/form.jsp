<!-- 회원 등록 폼을 보여주는 JSP 파일 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 폼 데이터를 전송할 주소 설정 -->
	<!-- 절대경로: /v2/save, 상대경로: save -->
	<form action="/v2/save" method="post">
		이름: <input type="text" name="username">
		암호: <input type="text" name="password">
		<button type="submit">전송</button>
	</form>

</body>
</html>