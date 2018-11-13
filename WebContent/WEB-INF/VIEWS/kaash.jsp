<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Kaash</h1>
	<h1>${hua }</h1>
 <table>
  <c:forEach items="${list}" var="item">
    <tr>
      <td>${item}</td>
    </tr>
  </c:forEach>
</table>
	
 
</body>
</html>