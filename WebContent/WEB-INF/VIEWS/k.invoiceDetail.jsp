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
      <h3 class="my-4">Your Order on ${inv.creation }, for &#8377-${inv.amount } </h3>






	<c:forEach items="${alist}" var="item">
      <div class="row">
        <div class="col-md-5">
          <a href="/Website_1/accessory/${item.model_code}">
            <img class="img-fluid rounded mb-3 mb-md-0" style="height: 150px;" src="${am.get(item.model_code).getImage()}" alt="">
          </a>
        </div>
        <div class="col-md-7">
          <h4>${am.get(item.model_code).getBrand_name()}</h4>
          <h2>${am.get(item.model_code).getModel_name()}</h2>
          <p class="footer">Quantity - ${item.quantity }</p>
          
        </div>
      </div>
      <hr>

	 </c:forEach>





	<c:forEach items="${clist}" var="item">
      <div class="row">
        <div class="col-md-5">
          <a href="/Website_1/cycle_model/${item.model_code}">
            <img class="img-fluid rounded mb-3 mb-md-0" style="height: 150px;" src="${cm.get(item.model_code).getImage()}" alt="">
          </a>
        </div>
        <div class="col-md-7">
          <h4>${cm.get(item.model_code).getBrand_name()}</h4>
          <h2>${cm.get(item.model_code).getModel_name()}</h2>
          <p class="footer">Frame Number - ${item.frame_number}</p>
          
        </div>
      </div>
      <hr>

	 </c:forEach>



      </div>
      <!-- /.row -->
			
		
	
	
	

 
</body>
</html>