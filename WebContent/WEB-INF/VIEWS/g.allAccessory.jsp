<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">
	
	img {
		width: 200px;
	}
	
	<jsp:include page="CSS/Cust.jsp" />
</style>

</head>
<body>


<jsp:include page="CSS/CustHeader.jsp" />

    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
      <h4 class="display-4">Accessories</h4>
    </div>

    <div class="container"> 
      <div class="card-deck mb-6 text-center">   
      
      <c:forEach items="${list}" var="item">
          
        <div class="card mb-4 box-shadow">
          <div class="card-header">
          
            <h6 class="my-0 font-weight-normal text-muted">${item.brand_name}</h6>
            <h4 class="my-0 font-weight-normal">${item.model_name}</h4>
            
          </div>
          <div class="card-body">
            <h1 class="card-title pricing-card-title"><img src="${item.image}"></h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>${item.type}</li>
              <li>${item.color}</li>
              <li>${item.accessory_size}</li>
              <li>&#8377-${item.price}</li>
            </ul>
            <a type="button" class="btn btn-lg btn-block btn-primary" href="accessory/${item.model_code}">Add to cart</a>
          </div>
        </div>
        
        </c:forEach>
        
      </div>
     </div>
    
	
	
	
	<br>
	<hr>
	

 
</body>
</html>