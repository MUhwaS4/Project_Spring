<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 새로운 회원 정보를 추가하기 위한 JSP -->

<!-- 필요한 클래스 import -->
<%@ page import="com.example.demo.domain.MemberRepository" %>
<%@ page import="com.example.demo.domain.Member" %>

<!-- JSP에서 자바코드를 삽입하기 위한 태그 -->
<%
    MemberRepository repository = new MemberRepository();

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Member member = Member.builder()
                            .userId(username).password(password)
                            .build();

    Member newMember = repository.save(member);
%>

<!-- HTML 코드 상단에 사용하는 %% 태그는 로직을 입력하기 위함 -->

<!-- 서블릿과의 차이점: 서블릿은 자바 코드 내부에 HTML을 작성하지만, JSP는 JSP(HTML 유사)에 자바 코드를 삽입함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 위에서 저장된 회원 정보 출력 -->
	<!-- 여기서 %%를 사용하면 자바 코드를 입력할 수 있음 -->
	<%= newMember.getNo()%> 번째 <%= newMember.getUserId() %> 회원을 추가했습니다.

</body>
</html>