<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="static/layui/css/layui.css">
<script src="static/layui/layui.js"></script>
</head>
<body>
	<h3>layui</h3>
	<script>
		//一般直接写在一个js文件中
		layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, form = layui.form;
			layer.msg('Hello World');
		});
	</script>
</body>
</html>