<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <title>HTML Калькулятор</title>
</head>
<body>
<form action="${s:mvcUrl('DC#reqCalculatorNew').build()}" method="post">
    <input type="text" name="operant1"  placeholder="1"><Br>
    <input type="text" name="operator"  placeholder="+"> <Br>
    <input type="text" name="operant2"  placeholder="-">
    <p><input type="submit"></p>
</form>
<div style="border:3px double black;margin:10px; padding:30px">
    ${answer}
</div>
</body>
</html>
