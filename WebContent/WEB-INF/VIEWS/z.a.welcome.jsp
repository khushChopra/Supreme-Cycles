<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
body {background-image: url("https://i.imgur.com/N0lJPd6.jpg"); background-size: cover;}
h1   {color: blue;}
p    {color: red;}
<jsp:include page="CSS/welcome_style.jsp" />
</style>





</head>
<body class="text-center">

	
 
    <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <nav class="nav nav-masthead justify-content-center">
	
          </nav>
        </div>
      </header>

      <main role="main" class="inner cover">
      	<img src="https://i.imgur.com/QM1PISW.png">
        <h1 class="cover-heading">Supreme Cycle Co.</h1>
        <p class="lead">
        
        
        
        <div class="row">
        <div class="col-md-12 ">
		   <form action="/Website_1/owner/login" method="POST" name="params">            
            <div class="mb-3">
              <label for="cname">First name</label>
              <input type="text" name="cname" id="cname" class="form-control" placeholder="First name">
            </div>

            <div class="mb-3">
              <label for="cnumber">Number</label>
              <input type="text" name="cnumber" id="cnumber" class="form-control" placeholder="10-digit phone number">
            </div>
            
            <div class="mb-3">
              <label for="key">Key</label>
              <input type="password" name="key" id="key" class="form-control" value="GauravViwek#@1967">
            </div>
            
			<input class="btn btn-lg btn-secondary" type="submit" value="Login">
		  </form>
        </div>
      </div>
	
      </main>
      
      
      

      <footer class="mastfoot mt-auto">
        <div class="inner">
        </div>
      </footer>
    </div>
 
 
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/WebContent/WEB_INF/VIEWS/js1.js"></script>
    <script src="${pageContext.request.contextPath}/WebContent/WEB_INF/VIEWS/js2.js"></script>
 
</body>
</html>