<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Employee</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">number</th>
      <th scope="col">name</th>
      <th scope="col">address</th>
      <th scope="col">edit</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
  
 
  
  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td>${item.number}</a></td>
		      <td>${item.name}</td>
		      <td>${item.address}</td>
		      <td><a href="/Website_1/owner/employee/${item.number}">Edit</a></td>
		      <td><a href="/Website_1/owner/employee/${item.number}/del">Delete</a></td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
<h2>Add Employee</h2>
	  
	<form class="form-control" action="/Website_1/owner/employee" method="post">
		<p>name</p> <input type="text" name="name">
		<p>Address</p> <input type="text" name="address"> 
		<p>number</p> <input type="text" name="number">
								
		<input type="submit" value="Submit">
	
	</form>
 
</body>
</html>