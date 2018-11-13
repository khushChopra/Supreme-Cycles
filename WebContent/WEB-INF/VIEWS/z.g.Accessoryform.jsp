<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">
	table, th, td {
	   border: 1px solid black;
	}
	img {
		width: 200px;
	}
	<jsp:include page="CSS/OwnerHeader.jsp" />
</style>

</head>
<body>

	<form class="form-control" action="/Website_1/owner/editAccessory/${item.model_code}" method="post" modelAttribute="accessory" >
		<p>model_code</p> <input readonly value="${item.model_code }" type="text" name="model_code">
		<p>model_name</p> <input value="${item.model_name }" type="text" name="model_name"> 
		<p>brand_name</p> <input value="${item.brand_name }" type="text" name="brand_name">
		<p>color</p> <input value="${item.color }" type="text" name="color"> 
		<p>type</p> <input value="${item.type }" type="text" name="type">
		<p>accessory_size</p> <input value="${item.accessory_size }" type="text" name="accessory_size">
		<p>price</p> <input value="${item.price }" type="number" name="price"> 
		<p>quantity</p> <input value="${item.quantity }" type="number" name="quantity">
		<p>image</p> <input value="${item.image }" type="text" name="image"> 
								
		<input type="submit" value="Submit">
	
	</form>
 
</body>
</html>