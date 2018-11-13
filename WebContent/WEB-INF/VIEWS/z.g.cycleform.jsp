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

	
	<form class="form-control" action="/Website_1/owner/editCycle/${item.model_code}" method="post" modelAttribute="cycle_model" >
		<p>model_code</p> <input readonly value="${item.model_code }" type="text" name="model_code">
		<p>model_name</p> <input value="${item.model_name }" type="text" name="model_name"> 
		<p>brand_name</p> <input value="${item.brand_name }" type="text" name="brand_name">
		<p>color</p> <input value="${item.color }" type="text" name="color"> 
		<p>type</p> <input value="${item.type }" type="text" name="type">
		<p>kit_details</p> <input value="${item.kit_details }" type="text" name="kit_details">
		<p>frame_size</p> <input value="${item.frame_size }" type="text" name="frame_size">
		<p>weight</p> <input value="${item.weight }" type="text" name="weight">
		<p>material</p> <input value="${item.material }" type="text" name="material">
		<p>image</p> <input value="${item.image }" type="text" name="image">
		<p>price</p> <input value="${item.price }" type="number" name="price"> 
								
		<input type="submit" value="Submit">
	
	</form>
 
</body>
</html>