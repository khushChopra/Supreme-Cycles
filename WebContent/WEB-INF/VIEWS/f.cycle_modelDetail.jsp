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

<div class="container">

      <div class="row">

        <div class="col-lg-3">

          <h4 class="my-4 muted">${item.brand_name}</h4>
          <h1 class="my-4">${item.model_name}</h1>
          <h4 class="my-4 muted"></h4>
          <form class="p-2 text-dark" action="/Website_1/addCycletoCart/${item.model_code}" method="post">
				<input  type="number" style="display: inline; width:65px;" name="quantity" value="1">
				<input class="btn btn-outline-primary" type="Submit" value="Add to Cart"> 
			</form>
          
        </div>

        <div class="col-lg-9">

          <div class="card mt-4">
            <img class="card-img-top img-fluid" src="${item.image}" alt="">
            <div class="card-body text-center">
              <h3 class="card-title">Details</h3>
              <h4>&#8377-${item.price}</h4>
             			
				
              <div class="table-responsive">
              <table class="table table-striped table">
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
              </table>
             </div>
            </div>
          </div>
        </div>

      </div>

    </div>

	
	
	
	
	
	<br>
	

 
</body>
</html>
