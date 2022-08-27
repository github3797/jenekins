<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
function save(){
	document.forms[0].action="register.do";
	document.forms[0].submit();
}
function update(){
	document.forms[0].action="update.do";
	document.forms[0].submit();
}
function delete1()
{
	document.forms[0].action="delete.do";
	document.forms[0].submit();
}
function getall()
{
	document.forms[0].action="getall.do";
	document.forms[0].submit();
}
function byid()
{
	document.forms[0].action="byid.do";
	document.forms[0].submit();
}
function byname()
{
	document.forms[0].action="byname.do";
	document.forms[0].submit();
}
</script>
<body><%=request.getAttribute("emp") %>
<form:form commandName="emp">
<form>
 <fieldset>
 StoreId::<form:input type="text" path="storeid"/> <br><br>
      
StoreName:<form:input type="name" path="storename"/> <br><br>
      
 StoreAddress:<form:input type="text" path="address"/> <br><br>
      
 StoreOwener<form:input type="text" path="storeowener"/><br><br>
 
 <input type="button" value="Register" onclick="save()"> 
 <input type="button" onclick="update()" value="update">
 <input type="button" onclick="delete1()" value="Delete">
 <input type="button" onclick="getall()" value="GetAll">
 
  </form:form>
  </fieldset>
  </form>
</body>
</html>