<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Customers</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">number</th>
      <th scope="col">name</th>
      <th scope="col">address</th>
      <th scope="col">email</th>
    </tr>
  </thead>
  
 
  
  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td>${item.number}</a></td>
		      <td>${item.name}</td>
		      <td>${item.address}</td>
		      <td>${item.email}</td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
 
</body>
</html>