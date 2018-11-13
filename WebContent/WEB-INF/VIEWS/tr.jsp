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
</style>

</head>
<body>
	<h1>fdgsdf</h1>
	<h6>${userObj }</h6>
	<table>
		<tr>
			<th>Ascessory cart</th>
			<th>q</th>
		</tr>
		<c:forEach items="${AccessoryCart}" var="item">
	    
	    <tr>      
	        <th><a href="accessory/${item.accessory_code}">${item}</a></th>
	        <th>${item.quantity }</th>
	    </tr>
	    
	    </c:forEach>
    
	</table>
	<br>
	<table>
		<tr>
			<th>Cycle cart</th>
			<th>q</th>
		</tr>
		<c:forEach items="${CycleCart}" var="item">
	    <tr>      
	        <th><a href="cycle_model/${item.cycle_code}">${item}</a></th>
	        <th>${item.quantity }</th>
	    </tr>
	    </c:forEach>
    
	</table>

 
</body>
</html>