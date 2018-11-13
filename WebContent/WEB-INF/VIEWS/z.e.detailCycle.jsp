<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="CSS/OwnerHeader2.jsp" />
<br>
<h2>Cycle detail</h2>
<table class="table  table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Specs</th>
      <th scope="col">Details</th>
    </tr>
  </thead>
    
  <tbody>
		<tr>
			<th>Spec</th>
			<th>Detail</th>
		</tr>  
		 
	    <tr>      
	        <th>model_code</th>
	        <th>${item.model_code}</th>
	    </tr>
		
	    <tr>      
	        <th>model_name</th>
	        <th>${item.model_name}</th>
	    </tr>
	    
	    <tr>      
	        <th>brand_name</th>
	        <th>${item.brand_name}</th>
	    </tr>
	    
	    <tr>      
	        <th>color</th>
	        <th>${item.color}</th>
	    </tr>
	    
	    <tr>      
	        <th>type</th>
	        <th>${item.type}</th>
	    </tr>
	    
	    <tr>      
	        <th>kit_details</th>
	        <th>${item.kit_details}</th>
	    </tr>
	    
	    <tr>      
	        <th>frame_size</th>
	        <th>${item.frame_size}</th>
	    </tr>
	    
	    <tr>      
	        <th>weight</th>
	        <th>${item.weight}</th>
	    </tr>
	    
	    <tr>      
	        <th>material</th>
	        <th>${item.material}</th>
	    </tr>
	    
	    <tr>      
	        <th>price</th>
	        <th>${item.price}</th>
	    </tr>
	    
	    <tr>      
	        <th>image</th>
	        <th><img src="${item.image}"></th>
	    </tr>
	   
	</table>
	
	
	<a href="/Website_1/owner/editCycle/${item.model_code}">Edit</a>
<br>	<hr>

 
</body>
</html>