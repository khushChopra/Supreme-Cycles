<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>purchase_record</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">id</th>
      <th scope="col">creation</th>
      <th scope="col">owner_number</th>
      <th scope="col">dis_num</th>
      <th scope="col">amount</th>
      <th scope="col">Stocked</th>
    </tr>
  </thead>
  


  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td><a href="/Website_1/owner/purchase_record/${item.id}" >${item.id}</a></td>
		      <td>${item.creation}</td>
		      <td>${item.owner_number}</td>
		      <td>${item.dis_num}</td>
		      <td>${item.amount}</td>
		      <td><c:if test = "${item.closed == 0}">
	         	No
	         </c:if>
	         <c:if test = "${item.closed == 1}">
	         	Yes
	         </c:if></td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
<h2>Add purchase_record</h2>
	
	
	
	<form class="form-control"  action="/Website_1/owner/purchase_record" method="post">
		<p>distributor</p>
		
 <select name="dis_num">
 	<c:forEach items="${dlist}" var="item">
	    <option value="${item.number}">${item.name} - ${item.number}</option>
	</c:forEach>
</select> 
		<p>amount</p> <input type="number" name="amount">
								
		<input type="submit" value="Submit">
	
	</form>
	
 <br>
</body>
</html>