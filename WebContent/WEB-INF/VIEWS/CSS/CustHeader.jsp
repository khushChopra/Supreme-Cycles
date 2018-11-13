  <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
     <img class="my-0 mr-md-auto font-weight-normal" style="height: auto; width:auto; max-height:45px; transform: translateX(70px);" src="https://i.imgur.com/QM1PISW.png">
      <p class="my-0 mr-md-auto font-weight-normal p-2 text-dark" style="transform: translateX(-350px);">Welcome ${userObj.name}</p>
      <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/Website_1/shop">Home</a>
        <a class="p-2 text-dark" href="/Website_1/carts">Cart</a>
        <a class="p-2 text-dark" href="/Website_1/invoice">Invoices</a>
        <a class="p-2 text-dark" href="/Website_1/cycle_model">Cycles</a>
        <a class="p-2 text-dark" href="/Website_1/accessory">Accessories</a>
        <a class="p-2 text-dark" href="/Website_1/logout">Logout</a>
      	<form class="p-2 text-dark" style="display: inline;" action="/Website_1/search" method="post">
			<input type="text" placeholder="Search" name="query">
			<input class="btn btn-outline-primary" value="Search" type="Submit">
		</form>
        
      
      </nav>
    </div>