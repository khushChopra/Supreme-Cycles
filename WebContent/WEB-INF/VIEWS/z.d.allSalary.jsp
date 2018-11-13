<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Salary</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">id</th>
      <th scope="col">creation</th>
      <th scope="col">owner_number</th>
      <th scope="col">emp_num</th>
      <th scope="col">amount</th>
    </tr>
  </thead>
  
  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td>${item.id}</a></td>
		      <td>${item.creation}</td>
		      <td>${item.owner_number}</td>
		      <td>${item.emp_num}</td>
		      <td>${item.amount}</td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
<h2>Add Salary</h2>
	
	
	<form class="form-control" action="/Website_1/owner/salary" method="post">
		<p>Employee</p>
		
 <select name="emp_num">
 	<c:forEach items="${elist}" var="item">
	    <option value="${item.number}">${item.name} - ${item.number}</option>
	</c:forEach>
</select> 
		<p>amount</p> <input type="number" name="amount">
								
<input type="submit" value="Submit">	
	</form>
 
</body>
</html>
	