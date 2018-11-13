<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Cycles</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">model_code</th>
      <th scope="col">model_name</th>
      <th scope="col">brand_name</th>
      <th scope="col">type</th>
      <th scope="col">price</th>
      <th scope="col">quantity</th>
      <th scope="col">delete</th>
    </tr>
  </thead>
  
 
  
  <tbody>

  <c:forEach items="${clist}" var="item">
	    <tr>
	    	  <td><a href="/Website_1/owner/cycle/${item.model_code}">${item.model_code}</a></td>
		      <td>${item.model_name}</td>
		      <td>${item.brand_name}</td>
		      <td>${item.type}</td>
		      <td>${item.price}</td>
	   	      <td>${stock.get(item.model_code)}</td>
	          <td><a href="/Website_1/owner/cycle/${item.model_code}/delete">Delete</a></td>
	    </tr>
  </c:forEach>
  
  </tbody>
</table>
<br><hr>
<h2>Add cycles</h2>
	  
	
	<form class="form-control" action="/Website_1/owner/cycle" method="post" modelAttribute="cycle_model" >
		<p>model_code</p> <input type="text" name="model_code">
		<p>model_name</p> <input type="text" name="model_name"> 
		<p>brand_name</p> <input type="text" name="brand_name">
		<p>color</p> <input type="text" name="color"> 
		<p>type</p> <input type="text" name="type">
		<p>kit_details</p> <input type="text" name="kit_details">
		<p>frame_size</p> <input type="text" name="frame_size">
		<p>weight</p> <input type="text" name="weight">
		<p>material</p> <input type="text" name="material">
		<p>image</p> <input type="text" name="image">
		<p>price</p> <input type="number" name="price"> 
								
		<input type="submit" value="Submit">
	
	</form>
 
</body>
</html>
	   