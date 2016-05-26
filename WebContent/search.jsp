<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询吉他</title>
</head>
<body>
<h2>请选择吉他制造商</h2>
<form action="search.do" method="post">

<select name="builder">  
 	<option value ="rosen">rosen</option>  
 	<option value ="Lankro">Lankro</option>  
 	<option value="Kepma">Kepma</option>  
 	<option value="Geek">Geek</option>  
 	<option value ="Matilda">Matilda</option>  
 	<option value ="Hailun">Hailun</option>  
 	<option value ="Califor">Califor</option>  
 	<option value ="Aidy Music">Aidy Music</option>  
 	<option value="enya">enya</option>  
 	<option value="Minsine">Minsine</option>
</select> 
<input type="submit"  value="查询" />

</form>
</body>
</html>