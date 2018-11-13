<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Invoices</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">id</th>
      <th scope="col">creation</th>
      <th scope="col">customer_number</th>
      <th scope="col">address</th>
      <th scope="col">amount</th>
      <th scope="col">transportservice_id</th>
    </tr>
  </thead>
    
  <tbody>

  <c:forEach items="${list}" var="item">
	    <tr>
	    	  <td><a href="/Website_1/owner/invoice/${item.id}" >${item.id}</a></td>
		      <td>${item.creation}</td>
		      <td>${item.customer_number}</td>
		      <td>${item.address}</td>
		      <td>${item.amount}</td>
	   	      <td>${item.transportservice_id}</td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
 
</body>
</html>