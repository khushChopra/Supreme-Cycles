<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Purchase record</h2>
<h4>From ${inv.customer_number} </h5>
<hr>

<h3>Accessories</h3>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">invoice_id</th>
      <th scope="col">model_code</th>
      <th scope="col">quantity</th>
    </tr>
  </thead>
  <tbody>

  <c:forEach items="${alist}" var="item">
	    <tr>
	    	  <td>${item.invoice_id}</td>
		      <td>${item.model_code}</td>
	   	      <td>${item.quantity}</td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>

<h3>Cycle frame</h3>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">invoice_id</th>
      <th scope="col">model_code</th>
      <th scope="col">frame_number</th>
    </tr>
  </thead>
  <tbody>

  <c:forEach items="${clist}" var="item">
	    <tr>
	    	  <td>${item.invoice_id}</td>
		      <td>${item.model_code}</td>
	   	      <td>${item.frame_number}</td>
	          
	    </tr>
  </c:forEach>
  
  </tbody>
</table><br><hr>

&#8377- ${inv.amount}

<br><hr>

	
	
	

 
</body>
</html>