<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<title>JSONTest3</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>  
<script>
  $(function() {
      $("#checkJson").click(function() {
      	var member = {id:"s", 
      			pwd:"1",
      			name:"ㅊ", 
      			email:"s"
	              };
  
  	$.ajax({
  	/*  type:"POST",
      url:"${contextPath}/boards3", */
       type:"PUT",
        url:"${contextPath}/boards3/114", 
        /* type:"DELETE",
        url:"${contextPath}/boards3/1234", */
        contentType: "application/json",
        data :JSON.stringify(member),
      success:function (data,textStatus){
          alert(data);
      },
      error:function(data,textStatus){
        alert("에러가 발생했습니다.");ㅣ // 자바스크립트의 경고창에 서버로부터 응답 받은 메시지 전달
      },
      complete:function(data,textStatus){
      }
   });  //end ajax	

   });
});
</script>
</head>
<body>
  <input type="button" id="checkJson" value="새글 쓰기"/><br><br>
  <div id="output"></div>
</body>
</html>