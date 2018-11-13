<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">
	img {
		height: 120px;
	}
	
	<jsp:include page="CSS/Cust.jsp" />
</style>

</head>
<body>

<jsp:include page="CSS/CustHeader.jsp" />



	
    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">Your Cart</h1>






	<c:forEach items="${AccessoryCart}" var="item">
      <div class="row">
        <div class="col-md-5">
          <a href="accessory/${item.accessory_code}">
            <img class="img-fluid rounded mb-3 mb-md-0" style="height: 150px;" src="${am.get(item.accessory_code).getImage()}" alt="">
          </a>
        </div>
        <div class="col-md-7">
          <h4>${am.get(item.accessory_code).getBrand_name()}</h4>
          <h2>${am.get(item.accessory_code).getModel_name()}</h2>
          <p class="footer">Quantity - ${item.quantity }</p>
          <a  class="btn btn-outline-primary" href="/Website_1/deleteAccessoryFromCart/${item.accessory_code}">Delete from cart</a>
          
        </div>
      </div>
      <hr>

	 </c:forEach>





	<c:forEach items="${CycleCart}" var="item">
      <div class="row">
        <div class="col-md-5">
          <a href="cycle_model/${item.cycle_code}">
            <img class="img-fluid rounded mb-3 mb-md-0" style="height: 150px;" src="${cm.get(item.cycle_code).getImage()}" alt="">
          </a>
        </div>
        <div class="col-md-7">
          <h4>${cm.get(item.cycle_code).getBrand_name()}</h4>
          <h2>${cm.get(item.cycle_code).getModel_name()}</h2>
          <p class="footer">Quantity - ${item.quantity}</p>
          <a  class="btn btn-outline-primary" href="/Website_1/deleteCycleFromCart/${item.cycle_code}">Delete from cart</a>
          
        </div>
      </div>
      <hr>

	 </c:forEach>



      </div>
      <!-- /.row -->
			
			
			<c:if test = "${fixed}">
	 
	 <c:if test = "${total > 0}">
	<form action="/Website_1/carts" method="post" class="container">
			<div class="row">
			
			
			
              <div class="col-md-3 mb-3">
                <label for="transportservice_id">Select locality area</label>
                <select class="custom-select d-block w-100" id="transportservice_id" type="text" name="transportservice_id" required>
                  <c:forEach items="${tlist}" var="item">
					    <option value="${item.number}">${item.area}</option>
					</c:forEach>
                </select>
              </div>
              
              
              <div class="col-md-5 mb-3">
                <label for="temp_address">Address</label>
                <input class="custom-select d-block w-100" type="text" name="temp_address" id="temp_address" required value="${userObj.address}">       
           
              </div>
              
              
              <div class="col-md-2 mb-3">
                <label for="zip">Amount</label>
	<h5 class="custom-select d-block w-100" style="transform: translateY(-0x);">${total}</h5>       
           
              </div>
              
              <div class="col-md-2 mb-3">
                <label for="zip">Checkout</label>
			<input type="submit" value="Checkout" class="btn btn-outline-primary">       
           
              </div>
              
            </div>
          </form>
          
            </c:if>
	
      </c:if>

	
	
	

 
</body>
</html>