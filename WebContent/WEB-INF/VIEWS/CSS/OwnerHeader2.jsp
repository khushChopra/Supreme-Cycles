<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
<jsp:include page="OwnerHeader.jsp" />
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    height: 100%;
    width: 200px;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    padding-top: 20px;
}

.sidenav a {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 18px;
    color: #818181;
    display: block;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.main {
    margin-left: 200px; /* Same as the width of the sidenav */
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
    .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div class="sidenav">'

<img style="height: auto; width:auto;" src="https://i.imgur.com/QM1PISW.png">
    <a href="/Website_1/owner/distributor">Distributor</a><br>
	<a href="/Website_1/owner/employee">Employee</a><br>
	<a href="/Website_1/owner/customer">Customer</a><br>
	<a href="/Website_1/owner/transporter">Transporter</a><br>
	<a href="/Website_1/owner/salary">Salary</a><br>
	<a href="/Website_1/owner/transaction_log">Transaction log</a><br>
	<a href="/Website_1/owner/purchase_record">Purchase record</a><br>
	<a href="/Website_1/owner/invoice">Invoice</a><br>
	<a href="/Website_1/owner/cycle">Cycle Models</a><br>
	<a href="/Website_1/owner/accessory">Accessory</a><br>
	<a href="/Website_1/owner/logout">Logout</a><br>
</div>

<div class="main">