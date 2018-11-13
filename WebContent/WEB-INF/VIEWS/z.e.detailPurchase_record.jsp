<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Purchase record</h2>
<h4>From ${pr.dis_num} </h5>
<hr>

<h3>Accessories</h3>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">purchase_id</th>
      <th scope="col">model_code</th>
      <th scope="col">quantity</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
  
  <tbody>

  <c:forEach items="${alist}" var="item">
	    <tr>
	    	  <td>${item.purchase_id}</td>
		      <td>${item.model_code}</td>
	   	      <td>${item.quantity}</td>
	          <td><c:if test = "${pr.closed == 0}">
	         	<a href="/Website_1/owner/purchase_record/${item.model_code}/${pr.id}/deleteAccessory">Delete</a>
	         </c:if>
	         <c:if test = "${pr.closed == 1}">
	         	Fixed
	         </c:if></td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>

<h3>Cycle frame</h3>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">purchase_id</th>
      <th scope="col">model_code</th>
      <th scope="col">frame_number</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
  <tbody>

  <c:forEach items="${clist}" var="item">
	    <tr>
	    	  <td>${item.purchase_id}</td>
		      <td>${item.model_code}</td>
	   	      <td>${item.frame_number}</td>
	          <td>
	         	<c:if test = "${pr.closed == 0}">
	        <a href="/Website_1/owner/purchase_record/${item.model_code}/${item.frame_number}/${pr.id}/deleteCycle">Delete</a>
	        </c:if>
	         <c:if test = "${pr.closed == 1}">
	         	Fixed
	         </c:if>
	        </th></td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>



<br><hr>

	  
	
	
	
	
 <c:if test = "${pr.closed == 0}">
      

<h3>Add cycles</h3>
	<div class="bound">
		<form class="form-control" action="/Website_1/owner/purchase_record/${pr.id}/addCycle" method="post">
			<p>Cycle model code</p>
			
	 <select name="model_code">
	 	<c:forEach items="${cmlist}" var="item">
		    <option value="${item.model_code}">${item.model_name} - ${item.model_code}</option>
		</c:forEach>
	</select> 
			<p>frame_number</p> <input type="text" name="frame_number">
									
			<input type="submit" value="add cycle">
		
		</form>
	</div>
	
	<h3>Add accessories</h3>
	<div class="bound">
		<form class="form-control" action="/Website_1/owner/purchase_record/${pr.id}/addAccessory" method="post">
			<p>Cycle model code</p>
			
	 <select name="model_code">
	 	<c:forEach items="${amlist}" var="item">
		    <option value="${item.model_code}">${item.model_name} - ${item.model_code}</option>
		</c:forEach>
	</select> 
			<p>quantity</p> <input type="number" name="quantity">
									
			<input type="submit" value="add accessory">
		
		</form>
	</div>
	
 <br>
 <a href="/Website_1/owner/purchase_record/${pr.id}/lock">Lock</a>
 
 
 </c:if>
 <br>
</body>
</html>