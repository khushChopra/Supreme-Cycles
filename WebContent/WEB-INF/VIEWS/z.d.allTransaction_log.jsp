<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Transaction_log</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">id</th>
      <th scope="col">creation</th>
      <th scope="col">details</th>
      <th scope="col">type</th>
      <th scope="col">amount</th>
    </tr>
  </thead>
	
  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td>${item.id}</td>
		      <td>${item.creation}</td>
		      <td>${item.details}</td>
		      <td>${item.type}</td>
		      <td>${item.amount}</td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
<h2>Add Transaction_log</h2>
	
	
	<form class="form-control" action="/Website_1/owner/transaction_log" method="post">
		<p>details</p> <input type="text" name="details">
		<p>type</p>
 <select name="type">
  <option value="Debit">Debit</option>
  <option value="Credit">Credit</option>
</select> 
		<p>amount</p> <input type="number" name="amount">
								
		<input type="submit" value="Submit">	
	
	</form>
 <br>
</body>
</html>
