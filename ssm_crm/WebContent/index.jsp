<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){

		$("#button").click(function(){
			
			/* $.post(
				"${pageContext.request.contextPath}/customer/edit.action",
				$("#form").serialize(),
				function(data){
					alert("成功");
				}
			); */
			alert($("#form").serializeArray()[0].cust_name);
			
		});
		
	});
	
</script>
</head>
<body>
	<form id="form" action="">
		<input type="text" name="cust_name"/>
		<input type="text" name="cust_source"/>
		
		<input type="button" id="button" value="点我"/>
		
	</form>
	
</body>
</html>