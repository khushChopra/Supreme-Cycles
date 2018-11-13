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

<div class="table-responsive">
            <table class="table table-striped table">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Date and time</th>
                  <th>Address</th>
                  <th>Amount</th>
                  <th>Details</th>
                </tr>
              </thead>
              <tbody>
              
                <c:forEach items="${list}" var="item">
	    
			    <tr>      
			     <td>${item.id}</td> 
			     <td>${item.creation}</td>    
			     <td>${item.address}</td>    
			     <td>${item.amount}</td>   
			     <td><a href="invoice/${item.id}">Details</a>   </td>
			      
			   </tr>
			    
			    </c:forEach>
                
                
              </tbody>
            </table>
          </div>
</body>
</html>