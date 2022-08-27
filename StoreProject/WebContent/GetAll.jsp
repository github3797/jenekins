	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.slokam.pojo.StorePojo" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
function getall()
{
	document.forms[0].action="getall.do";
	document.forms[0].submit();
}
</script>
<body>
<form>
<input type="button" onclick="getall()" value="GetAll">
</form>
<body>
 <h2>All Person Details</h2>
 
<table border="2">
        <tr>
            <th>StoreId</th>
            <th>StoreName</th>
            <th>StoreAddress</th>
            <th>StoreOwener</th>
        </tr>
       
<c:forEach var="user" items="${users}">
<tr>
   <td> <a href="getiddata.do?id=${user.storeid}">${user.storeid}</a></td>
  <td><a href="getiddata.do?id=${user.storeid}">${user.storename}</a></td>
  <td> ${user.address}</td>
  <td> ${user.storeowener}</td>
 </tr>
</c:forEach>  
</table>     
</body>
</html>